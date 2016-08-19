package com.qylm.common.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.qylm.constants.Constants;

/**
 * 下载相关工具类
 * 
 * @author
 */
public final class DownloadUtil {

	/**
	 * 设置response的头
	 * 
	 * @param response
	 * @param fileName 文件名
	 * @param isExcel 是否是excel
	 * @throws UnsupportedEncodingException 
	 */
	public static void setResponseHeader(HttpServletResponse response,
			String fileName, boolean isExcel) throws UnsupportedEncodingException {
		if (isExcel) {
			response.setContentType("application/x-msdownload;charset=UTF-8");
		} else {
			response.setContentType("application/octet-stream;charset=UTF-8");
		}
		// response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, Constants.UTF8));// 直接打开
		response.setHeader("Content-disposition", "online;filename=" + URLEncoder.encode(fileName, Constants.UTF_8));
		response.setHeader("Cache-Control", "max-age=5");
	}

	/**
	 * 让浏览器下载模板文件
	 * @param bytes 模板文件的字节
	 * @param fileName
	 */
	public static void downloadFile(byte[] bytes, String fileName) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		ServletOutputStream os = null;
		try {
			setResponseHeader(response, fileName, true);
			os = response.getOutputStream();
			os.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IOUtils.closeQuietly(os);
		}
		facesContext.responseComplete();
	}
	
	/**
	 * 让浏览器下载excel
	 * @param workbook
	 * @param fileName
	 */
	public static void downloadExcel(HSSFWorkbook workbook, String fileName) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext()
				.getResponse();
		try {
			setResponseHeader(response, fileName, true);
			ServletOutputStream os = response.getOutputStream();
			workbook.write(os);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		facesContext.responseComplete();
	}

	/**
	 * 让浏览器下载文件
	 * @param url文件路径
	 * @param fileName文件名
	 */
	public static void loadAndOutFile(String url, String fileName) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		ServletOutputStream os = null;
		InputStream is = null;
		try {
			setResponseHeader(response, fileName, false);
			os = response.getOutputStream();
			is = new BufferedInputStream(FileUtils.openInputStream(new File(url)));
			IOUtils.copy(is, os);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
		facesContext.responseComplete();
	}

	public static void download(HttpServletRequest request, HttpServletResponse response, String filePath) throws IOException {
		download(request, response, filePath, "");
	}

	public static void download(HttpServletRequest request,
			HttpServletResponse response, String filePath, String displayName)
			throws IOException {
		File file = new File(filePath);
		if (!file.exists() || !file.canRead()) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("您下载的文件不存在！");
			return;
		}
		displayName = StringUtils.isEmpty(displayName)?file.getName():displayName;
		initResponse(request, response, displayName, (int)file.length());
		BufferedInputStream is = null;
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			is = new BufferedInputStream(new FileInputStream(file));
			IOUtils.copy(is, os);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(is);
			//IOUtils.closeQuietly(os);
		}
	}

	public static void download(HttpServletRequest request,
			HttpServletResponse response, String displayName, byte[] bytes)
			throws IOException {
		if (ArrayUtils.isEmpty(bytes)) {
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("您下载的文件不存在！");
			return;
		}
		initResponse(request, response, displayName, bytes.length);
		BufferedInputStream is = null;
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			is = new BufferedInputStream(new ByteArrayInputStream(bytes));
			IOUtils.copy(is, os);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(is);
			//IOUtils.closeQuietly(os);
		}
	}
	
	public static void downloadDecryptFile(HttpServletRequest request,
			HttpServletResponse response, String filePath, String displayName, String encryptionPass)
			throws IOException {
		File file = new File(filePath);
		if (!file.exists() || !file.canRead()) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("您下载的文件不存在！");
			return;
		}
		displayName = StringUtils.isEmpty(displayName)?file.getName():displayName;
		initResponse(request, response, displayName, (int)file.length());
		BufferedInputStream is = null;
		OutputStream os = response.getOutputStream();
		try {
			//os = CipherUtil.DESFileDecrypt(response.getOutputStream(), CipherUtil.generateDESKey("SANLI_ZJBY"));
			is = new BufferedInputStream(new FileInputStream(file));
			System.out.println(encryptionPass.equals(Constants.PRIVATE_KEY));
			//IOUtils.copy(is, os);
			CipherUtil.RESFileDecryptByPrivteKey(is, os, encryptionPass);//Constants.PRIVATE_KEY
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Error e){
			e.printStackTrace();
			IOUtils.copy(is, os);
		}finally {
			IOUtils.closeQuietly(is);
			//IOUtils.closeQuietly(os);
		}
	}
	
	private static void initResponse(HttpServletRequest request, HttpServletResponse response, String displayName, int length) throws UnsupportedEncodingException{
		String userAgent = request.getHeader("User-Agent");
		boolean isIE = (userAgent != null)
				&& (userAgent.toLowerCase().indexOf("msie") != -1);
		response.reset();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "must-revalidate, no-transform");
		response.setDateHeader("Expires", 0L);
		response.setContentType("application/x-download");
		response.setContentLength(length);
		String displayFilename = displayName.substring(displayName
				.lastIndexOf("_") + 1);
		displayFilename = displayFilename.replace(" ", "_");
		if (isIE) {
			displayFilename = URLEncoder.encode(displayFilename, Constants.UTF_8);
			response.setHeader("Content-Disposition", "attachment;filename=\""
					+ displayFilename + "\"");
		} else {
			displayFilename = new String(displayFilename.getBytes(Constants.UTF_8),Constants.ISO8859_1);
			response.setHeader("Content-Disposition", "attachment;filename=" + displayFilename);
		}
	}
	
	/**
	 * response文件流
	 * @param path 文件路径
	 * @param fileName 文件名
	 */
	public static void loadAndOutFile(ServletOutputStream sos, String path, String fileName)
			throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(findFile(path, fileName)));
		IOUtils.copy(is, sos);
		sos.close();
		is.close();
	}
	
	/**
	 * 找到文件
	 * @param path 文件路径
	 * @param fileName 文件名
	 * @return 文件
	 */
	public static File findFile(String path, String fileName){
		return new File(path + File.separatorChar + fileName);
	} 
	
}

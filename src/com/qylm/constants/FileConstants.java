package com.qylm.constants;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.qylm.common.utils.ExcelUtil;

public final class FileConstants {
	
	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(FileConstants.class);
	
	/**
	 * 访问地址
	 */
	public static String VISIT_ADDRESS;
	
	/**
	 * 文件模板绝对路径
	 */
	public static String TEMPLET_FILE_PATH;
	
	/**
	 * 模板下载绝对路径
	 */
	public static String TEMPLET_DOWNLOAD_FILE_PATH;
	
	/**
	 * 模板导出绝对路径
	 */
	public static String TEMPLET_EXPORT_FILE_PATH;
	
	/**
	 * 模板Report绝对路径
	 */
	public static String TEMPLET_REPORT_FILE_PATH;
	
	/**
	 * 文件模板根目录
	 */
	public static final String TEMPLET_PATH = "com" + File.separatorChar + "qylm" + File.separatorChar + "resources" + File.separatorChar;
	
	/**
	 * 模板下载路径管理
	 */
	public static final String TEMPLET_DOWNLOAD_PATH = TEMPLET_PATH + "download" + File.separatorChar;
	
	/**
	 * 模板导出路径管理
	 */
	public static final String TEMPLET_EXPORT_PATH = TEMPLET_PATH + "export" + File.separatorChar;
	
	/**
	 * 订单套打模板路径
	 */
	public static final String ORDER_PATH = TEMPLET_PATH + "print" + File.separatorChar;
	
	/**
	 * JRE下载
	 */
	public static final String DOWNLOAD_JRE_6U45 = "jre-6u45-windows-i586.rar";
	
	/**
	 * web文件存储名称
	 */
	public static final String FILE_UPLOAD = "fileUpload";
	
	/**
	 * web文件导入名称
	 */
	public static final String FILE_EXPORT = "fileExport";
	
	/**
	 * excel文件的扩展名
	 */
	public static final String XLS = "xls";
	
	/**
	 * excel文件的扩展名，前面有"."
	 */
	public static final String EX_NAME_XLS = ".xls";
	
	/**
	 * 保存到硬盘上的文件统一扩展名
	 */
	public static final String FILE_NAME_EXTENSION = ".tmp";
	
	/**
	 * 打印插件路径
	 */
	public static String PRINT_PATH;
	
	static {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			ExternalContext externalContext = context.getExternalContext();
			if (externalContext != null) {
				HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
				VISIT_ADDRESS = Constants.fileStorePath + File.separator;
				LOG.info("VISIT_ADDRESS=="+VISIT_ADDRESS);
				LOG.info("FILE_PATH=="+Constants.fileStorePath);
				PRINT_PATH = request.getContextPath();
				LOG.info("PRINT_PATH=="+PRINT_PATH);
			}
		}
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource("com" + File.separatorChar + "qylm" + File.separatorChar + "resources");
		//模板绝对路径
		try {
			TEMPLET_FILE_PATH = resource.getFile().toString();//com/qylm/resources
			//模板下载绝对路径
			TEMPLET_DOWNLOAD_FILE_PATH = TEMPLET_FILE_PATH + File.separatorChar + "download"+ File.separatorChar;
			//模板导出绝对路径
			TEMPLET_EXPORT_FILE_PATH = TEMPLET_FILE_PATH + File.separatorChar + "export"+ File.separatorChar;
			//模板打印绝对路径
			TEMPLET_REPORT_FILE_PATH = TEMPLET_FILE_PATH + File.separatorChar + "reports"+ File.separatorChar;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据文件路径，将文件解析成二进制数组。
	 * @param url
	 * @return
	 */
	public static byte[] analyticExcel(String url) {
		byte[] staffInfoUp = null;
		ClassLoader classLoader = ExcelUtil.class.getClassLoader();
	    URL resUrl;
		InputStream is;
		try {
			resUrl = classLoader.getResource(url);
			is = new BufferedInputStream(resUrl.openStream());
			staffInfoUp = IOUtils.toByteArray(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return staffInfoUp;
	}
	
}

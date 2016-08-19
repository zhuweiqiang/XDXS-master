package com.qylm.common;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qylm.common.utils.DownloadUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;

/**
 * 主要用于照片显示
 * @author 陈祥飞
 */
public class ImageServlet extends HttpServlet {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -9047374020174606532L;
	
	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ImageServlet.class);
	
	private byte[] nophoto;
	
	public static final String IMAGE_SERVLET = "/imageServlet";
	
	public static final String PATH = "path";
	
	public static final String FILE_NAME = "fileName";
	
	@Override
	public void init() throws ServletException {
		super.init();
		ClassLoader classLoader = ImageServlet.class.getClassLoader();
        URL resUrl = classLoader.getResource("nophoto.gif");
        try {
        	InputStream is = new BufferedInputStream(resUrl.openStream());
			nophoto = IOUtils.toByteArray(is);
		} catch (IOException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(Constants.UTF_8);
		String fileName = request.getParameter(FILE_NAME);
		String path = request.getParameter(PATH);
		boolean blank = StringUtil.isBlank(fileName) || StringUtil.isBlank(path);
		if(blank){
			fileName = "nophoto";
		} 
//		else {
//			fileName = URLDecoder.decode(fileName, Constants.UTF8);
//			path = URLDecoder.decode(path, Constants.UTF8);
//		}
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
        response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
	    response.setContentType("image/*");
        StringBuilder contentDisposition = new StringBuilder(32);
        contentDisposition.append("attachment;");
        contentDisposition.append("filename=\"");
        contentDisposition.append(fileName);
        contentDisposition.append("\"");
        response.setHeader ("Content-Disposition", contentDisposition.toString());
        if (blank) {
			response.getOutputStream().write(nophoto);
		} else {
			try {
				DownloadUtil.loadAndOutFile(response.getOutputStream(), path, fileName);
			} catch (IOException e) {
				response.getOutputStream().write(nophoto);
				if (LOG.isErrorEnabled()) {
					LOG.error(Message.GENERAL_FILE_FETCH_ERROR, e);
				}
			}
		}
	}

}

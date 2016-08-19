package com.qylm.common;

import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;

public class PathUtil {

	/**
	 * 获取图片路径，用于页面显示
	 * @param url 文件路径
	 * @param name 文件名称
	 * @return
	 */
	public static String getStaffPhotoPath(String url, String name) {
		StringBuilder sb = new StringBuilder(128);
		sb.append(ImageServlet.IMAGE_SERVLET);
		if (StringUtil.isNotBlank(url)) {
			sb.append(Constants.QUESTION_MARK);
			sb.append(ImageServlet.FILE_NAME);
			sb.append(Constants.EQUAL);
			sb.append(name);
			sb.append(Constants.AMD_MARK);
			sb.append(ImageServlet.PATH);
			sb.append(Constants.EQUAL);
			sb.append(Constants.fileStorePath);
			sb.append(url);
		}
		return sb.toString();
	}
	
}

package com.qylm.constants;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.qylm.common.utils.PropertiesUtil;
import com.qylm.common.utils.StringUtil;

public final class ConfigConstants {
	
	//页面调用必须有该构造函数
	private ConfigConstants(){}
	
	/**
	 *  编号生成位数
	 */
	public static int 	DIGIT_NUMBER;
	
	/**
	 *  编号生成位数
	 */
	public static int 	TWO_DIGIT_NUMBER;
	
	/**
	 * 邮件发送协议
	 */
	public static String MAIL_SERVER_PROTOCOL;
	
	/**
	 *  邮件HOST
	 */
	public static String MAIL_SERVER_HOST;
	
	/**
	 *  邮件端口
	 */
	public static String MAIL_SERVER_PORT;
	
	/**
	 *  邮件账号
	 */
	public static String MAIL_SERVER_USERNAME;
	
	/**
	 *  邮件密码
	 */
	public static String MAIL_SERVER_PASSWORD;
	
	/**
	 * lucene 索引存放位置
	 */
	public static String LUCENE_INDEXES;
	
	/**
	 * 系统配置
	 */
	public static final String RESOURCE_SYS_FILE = "com" + File.separatorChar + "qylm" + File.separatorChar + "resources" + File.separatorChar + "mailConfig.properties";
	
	static{
		InputStream is = null;
		try {
			Properties properties = PropertiesUtil.loadProperties(RESOURCE_SYS_FILE);
			String digit_number  = properties.getProperty("digit.number");
			DIGIT_NUMBER = StringUtil.isNotBlank(digit_number)?Integer.parseInt(digit_number):5;//默认5位
			String two_digit_number  = properties.getProperty("two.digit.number");
			TWO_DIGIT_NUMBER = StringUtil.isNotBlank(two_digit_number)?Integer.parseInt(digit_number):7;//默认7位
			MAIL_SERVER_PROTOCOL = properties.getProperty("mail.server.protocol");
			MAIL_SERVER_PROTOCOL = StringUtil.isBlank(MAIL_SERVER_PROTOCOL)?Constants.PROTOCOL_SMTP:MAIL_SERVER_PROTOCOL;
			MAIL_SERVER_HOST = properties.getProperty("mail.server.host");
			MAIL_SERVER_PORT = properties.getProperty("mail.server.port");
			MAIL_SERVER_USERNAME = properties.getProperty("mail.server.username");
			MAIL_SERVER_PASSWORD = properties.getProperty("mail.server.password");
			ResourceLoader resourceLoader = new DefaultResourceLoader();
			Resource resource = resourceLoader.getResource("com" + File.separatorChar + "sanli" + File.separatorChar + "resources" + File.separatorChar + "indexes");
			try {
				LUCENE_INDEXES = resource.getFile().toString();
			} catch (IOException e) {
				
			} finally {
				properties.clear();
				properties = null;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IOUtils.closeQuietly(is);
		} 
		
	}
}

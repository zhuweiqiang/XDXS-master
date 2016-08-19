package com.qylm.constants;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Properties;

import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qylm.common.Message;

public final class Constants {
	
	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(Constants.class);
	
	//页面调用必须有该构造函数
	private Constants(){}
	
	/**
	 * 保存文件的根文件夹
	 */
	public static String fileStorePath;
	
	/**
	 * 一次性从数据库中取的最大数据条数
	 */
	public static int fetchSize;
	
	/**
	 * 上传文件最大行数
	 */
	public static int maxUpfileRowNum;
	
	/**
	 * 管理类画面每个画面显示多少条数据
	 */
	public static int onePageCount;
	
	/**
	 * 用来判断session超时的常量
	 */
	public static final String SESSION_TIME_OUT = "SESSION_TIME_OUT";
	
	/**
	 * 用来判断用户没有登陆的常量
	 */
	public static final String NOT_LOGIN = "NOT_LOGIN";
	
	/**
	 * 邮件协议
	 */
	public static final String PROTOCOL_SMTP = "smtp";
	
	/**
	 * 资源文件
	 */
	public static final String RESOURCE_FILE = "com.qylm.resources.messages";
	
	/**
	 * 管理员权限
	 */
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	
	/**
	 * 通用权限
	 */
	public static final String ROLE_USER = "ROLE_USER";
	
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * yyyy-MM-dd HH:mm:ss SSS
	 */
	public static final String YYYY_MM_DD_HH_MM_SS_SSS_ = "yyyy-MM-dd HH:mm:ss SSS";

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	
	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
	
	/**
	 * yyyyMMddHHmmssSSS
	 */
	public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyyMMddHHmmssSSS";

	/**
	 * yyyy-MM
	 */
	public static final String YYYY_MM = "yyyy-MM";
	
	/**
	 * MM-dd
	 */
	public static final String MM_DD = "MM-dd";

	/**
	 * HH:mm:ss
	 */
	public static final String HH_MM_SS = "HH:mm:ss";

	/**
	 * HH:mm
	 */
	public static final String HH_MM = "HH:mm";

	/**
	 * mm（分）
	 */
	public static final String MM = "mm";

	/**
	 * E（星期）
	 */
	public static final String E = "E";

	/**
	 * yyyy-MM-dd
	 */
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	/**
	 * yyyyMMdd
	 */
	public static final String YYYYMMDD = "yyyyMMdd";

	/**
	 * HH
	 */
	public static final String HH = "HH";

	/**
	 * yyyy
	 */
	public static final String YYYY = "yyyy";

	/**
	 * MM（月）
	 */
	public static final String MM_MONTH = "MM";

	/**
	 * MM
	 */
	public static final String DD = "dd";

	/**
	 * yyyy年MM月dd日
	 */
	public static final String YYYY_MM_DD_C = "yyyy年MM月dd日";

	/**
	 * yyyy年MM月dd日HH点
	 */
	public static final String YYYY_MM_DD_HH_C = "yyyy年MM月dd日HH点";

	/**
	 * 现在时间：yyyy年MM月dd日 HH时mm分ss秒
	 */
	public static final String TITLE_TIME = "现在时间：yyyy年MM月dd日 HH时mm分ss秒";

	/**
	 * excel最大数据列数
	 */
	public static final int EXCEL_MAX_ROW = 65536;

	/**
	 * 下拉框（未选择）
	 */
	public static final String UN_SELECT = "-1";

	/**
	 * 下拉框（未选择）
	 */
	public static final SelectItem UN_SELECT_ITEM = new SelectItem(UN_SELECT, "未选择");

	/**
	 * 空格
	 */
	public static final String BLANK = " ";

	/**
	 * 冒号：，时间按转换用【hh:mm】中间的：
	 */
	public static final String COLON = ":";

	/**
	 * 模糊查询符
	 */
	public static final String SELECT_BLUR = "%";

	/**
	 * 共通分隔符","（逗号）
	 */
	public static final String COMMA = ",";

	/**
	 * Menu组件用分隔符"_"（下划线）
	 */
	public static final String UNDERLINE = "_";

	/**
	 * ～号
	 */
	public static final String WAVE = "～";
	
	/**
	 * *号
	 */
	public static final String ASTERISK = "*";
	
	/**
	 * 等号
	 */
	public static final String EQUAL = "=";

	/**
	 * 横线
	 */
	public static final String HORIZONTAL_LINE = "-";

	/**
	 * 系统字符集utf-8
	 */
	public static final String UTF_8 = "UTF-8";
	
	/**
	 * 系统字符集ISO8859-1
	 */
	public static final String ISO8859_1 = "ISO8859-1";
	
	/**
	 * excel文件的扩展名，前面有"."
	 */
	public static final String EX_NAME_XLS = ".xls";

	/**
	 * 文件名最大长度
	 */
	public static final int FILE_NAME_MAX_LENGTH = 100;

	/**
	 * 换行符
	 */
	public static final String NEW_LINE = "\r\n";
	
	/**
	 * .
	 */
	public static final String DOT = ".";
	
	/**
	 * =
	 */
	public static final String EQUALS_SIGN = "=";
	
	/**
	 * #
	 */
	public static final String SIREN_SIGN = "#";
	
	/**
	 * ?
	 */
	public static final String QUESTION_MARK = "?";
	
	/**
	 * &amp;
	 */
	public static final String AMD_MARK = "&amp;";
	
	/**
	 * 提前提醒天数
	 */
	public static final Integer REMIND_DAY = 7;
	
	/**
	 * BigDecimal的0.0
	 */
	public static final BigDecimal BIGDECIMAL_1_ZERO = new BigDecimal("0.0");
	
	/**
	 * BigDecimal的0.00
	 */
	public static final BigDecimal BIGDECIMAL_ZERO = new BigDecimal("0.00");
	
	/**
	 * BigDecimal的0.0000
	 */
	public static final BigDecimal BIGDECIMAL_4_ZERO = new BigDecimal("0.0000");
	
	/**
	 * BigDecimal的0.000000
	 */
	public static final BigDecimal BIGDECIMAL_6_ZERO = new BigDecimal("0.000000");
	
	/**
	 * BigDecimal的100
	 */
	public static final BigDecimal BIGDECIMAL_HUNDRED = new BigDecimal("100");
	
	/**
	 * BigDecimal的最大值999999999.99
	 */
	public static final BigDecimal BIGDECIMAL_MAX = new BigDecimal("999999999.99");
	
	/**
	 * scale的0
	 */
	public static final int SCALE_0 = 0;
	
	/**
	 * scale的1
	 */
	public static final int SCALE_1 = 1;
	
	/**
	 * 系统所有BigDecimalConverter用的scale
	 */
	public static final int SCALE = 2;
	
	/**
	 * scale的3
	 */
	public static final int SCALE_3 = 3;
	
	/**
	 * scale的4
	 */
	public static final int SCALE_4 = 4;
	
	/**
	 * scale的5
	 */
	public static final int SCALE_5 = 5;
	
	/**
	 * scale的6
	 */
	public static final int SCALE_6 = 6;
	
	/**
	 * \\.（因为.不能被正则表达式解析，所以之前加\\）
	 */
	public static final String REGEX_DOT = "\\.";
	
	/**
	 * Menu组件用子UL后缀
	 */
	public static final String CHILDREN = "_children";
	
	/**
	 * Menu组件用事件ID后缀
	 */
	public static final String ACTION = "_action";
	
	/**
	 * 通用密码
	 */
	public static final String COMMON_KEY = "QYLM_FHJJ";
	
	/**
	 * 公钥
	 */
	public static final String PUBLIC_KEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAOcqhsWMYLV5jPbCEAQX2t0Pu9cX9msePlZMffOvtS0NYzGdOYYl/jtvELyonTBeTEWyCdpccBgIyla8H+0Z0MsCAwEAAQ==";
	
	/**
	 * 私钥
	 */
	public static final String PRIVATE_KEY = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEA5yqGxYxgtXmM9sIQBBfa3Q+71xf2ax4+Vkx986+1LQ1jMZ05hiX+O28QvKidMF5MRbIJ2lxwGAjKVrwf7RnQywIDAQABAkEAiVLGBQzDVosCpoPaJ9RT/Aagu8JMbI3m0jVWjTDQHBY6ve2mZCbcSCchtPAwhOqhMGcZcM/tbVdl36hmEAOoIQIhAPlHt+34Mi9/PylODYpWIMaOq+H4biGzH6Ww0ubfQsj9AiEA7WXNmD11jcZlcXdF5bXlbBObLB4nckMbW/6I5IQOr2cCIHt4b3z6O3lVMKa313MWuANBNZemon4kp9881ymtmfnNAiBl+tqT8KrkCXsggAVFxZrVj6KUFCwL2KoTHce+qsAINwIgBvuikz9HHgTPjDRJUv55PJBsJSwjIDLCcpHO/C3ubiI=";
	
	/**
	 * 系统配置路径及文件名称
	 */
	public static final String RESOURCE_SYS_FILE = "com" + File.separatorChar + "qylm" + File.separatorChar + "resources" + File.separatorChar + "systemConfig.properties";
	
	static{
		InputStream is;
		try {
			ClassLoader classLoader = Constants.class.getClassLoader();
	        URL resUrl = classLoader.getResource(RESOURCE_SYS_FILE);
			is = new BufferedInputStream(resUrl.openStream());
//			is = ClassLoader.getSystemResourceAsStream("systemConfig.properties");
			Properties properties = new Properties();
			properties.load(is);
			fetchSize = Integer.parseInt(properties.getProperty("fetchSize"));
			fileStorePath = properties.getProperty("fileStorePath");
			maxUpfileRowNum = Integer.parseInt(properties.getProperty("maxUpfileRowNum"));
			onePageCount = Integer.parseInt(properties.getProperty("onePageCount"));
			properties.clear();
			properties = null;
			is.close();
		} catch (FileNotFoundException e) {
			if(LOG.isErrorEnabled()){
				LOG.error(Message.GENERAL_ERROR, e);
			}
		} catch (IOException e) {
			if(LOG.isErrorEnabled()){
				LOG.error(Message.GENERAL_ERROR, e);
			}
		} 
		
	}
}

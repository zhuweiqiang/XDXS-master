package com.qylm.common.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import sun.misc.BASE64Decoder;

import com.qylm.constants.Constants;

/**
 * 字符串工具类。提供各种针对字符串的共通方法， 附带也提供一些关于对象判断的方法
 * 
 * @author 盛民军
 * 
 */
public final class StringUtil extends StringUtils {
	
	 /**
     * 指定验证码范围  
     */
    public static final String VERIFY_CODES = "0123456789";
    
	/**
	 * 判断两个字符串的相似性
	 * 
	 * @param oneStr
	 * @param twoStr
	 * @return 相差的字符数，越多代表相差的越大
	 */
	public static int similarity(String oneStr, String twoStr) {
		// 用来计算结果的矩阵
		int d[][]; // matrix
		// 迭代用
		int i; // iterates through s
		int j; // iterates through t
		char one; // ith character of s
		char twoChar; // jth character of t
		int cost; // cost

		// Step 1
		int oneLength = oneStr.length();
		int twoLength = twoStr.length();
		if (oneLength == 0) {
			return twoLength;
		}
		if (twoLength == 0) {
			return oneLength;
		}
		d = new int[oneLength + 1][twoLength + 1];

		// Step 2
		for (i = 0; i <= oneLength; i++) {
			d[i][0] = i;
		}

		for (j = 0; j <= twoLength; j++) {
			d[0][j] = j;
		}

		// Step 3
		for (i = 1; i <= oneLength; i++) {

			one = oneStr.charAt(i - 1);

			// Step 4
			for (j = 1; j <= twoLength; j++) {

				twoChar = twoStr.charAt(j - 1);

				// Step 5
				if (one == twoChar) {
					cost = 0;
				} else {
					cost = 1;
				}

				// Step 6
				d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1]
						+ cost);

			}

		}
		// Step 7
		return d[oneLength][twoLength];
	}

	/**
	 * 取最小的一个值
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static int min(int a, int b, int c) {
		int mi = a;
		if (b < mi) {
			mi = b;
		}
		if (c < mi) {
			mi = c;
		}
		return mi;
	}

	/**
	 * 把空白的字符串转换为Null，如果字符串不为空白，则不转换
	 * 
	 * @param value
	 * @return
	 */
	public static String blank2Null(String value) {
		return isBlank(value) ? null : value;
	}

	/**
	 * 判断两个对象是否相等
	 * 
	 * @param one
	 * @param another
	 * @return
	 */
	public static boolean isEquals(Object one, Object another) {
		if (one == null) {
			if (another == null) {
				return true;
			}
			return false;
		}
		if (another == null) {
			return false;
		}
		return one.equals(another);
	}

	/**
	 * 判断两个对象是否都为Null
	 * 
	 * @param one
	 * @param another
	 * @return 都为null返回true，其他情况返回false
	 */
	public static boolean isNullEquals(Object one, Object another) {
		if (one == null || another == null) {
			return false;
		}
		return true;
	}

	/**
	 * 取得对象的hashCode
	 * 
	 * @param obj
	 * @return
	 */
	public static int getHashCode(Object obj) {
		if (obj == null) {
			return 0;
		}
		return obj.hashCode();
	}

	/**
	 * 把字符串转换为Integer，如果字符串为空，则转换为null
	 * 
	 * @param str
	 * @return
	 */
	public static Integer toIngeter(String str) {
		if (isBlank(str)) {
			return null;
		}
		return Integer.valueOf(str);
	}

	/**
	 * 把对象转化为字符串
	 * 
	 * @param obj
	 *            对象
	 * @return 如果对象为null返回null，不为null则toString()
	 */
	public static String toString(Object obj) {
		if (obj == null) {
			return null;
		}
		return obj.toString();
	}

	/**
	 * 把对象转化为字符串
	 * 
	 * @param obj
	 *            对象
	 * @return 如果对象为null返回空白字符串，不为null则toString()
	 */
	public static String toStringCheckNull(Object obj) {
		if (obj == null) {
			return "";
		}
		return obj.toString();
	}

	/**
	 * 判断str是否为空白字符串，如果是则返回null
	 * 
	 * @param str
	 * @return
	 */
	public static String changeBlankToNull(String str) {
		if (isBlank(str)) {
			return null;
		}
		return str;
	}

	/**
	 * 去掉字符串的左右空格
	 * 
	 * @param str
	 *            字符串
	 * @param flag
	 *            l=去左空格 r=去右空格 其他=去两边空格
	 * @return
	 */
	public static String trims(String str, String flag) {
		if (str == null || str.equals("")) {
			return str;
		} else {
			str = "" + str;
			// trim left side only
			if ("l".equalsIgnoreCase(flag)) {
				String regularExp = "^[　 ]+";
				return str.replaceAll(regularExp, "");
				// trim right side only
			} else if ("r".equalsIgnoreCase(flag)) {
				String regularExp = "[　 ]+$";
				return str.replaceAll(regularExp, "");
				// defautly, trim both left and right side
			} else {
				String regularExp = "^[　 ]+|[　 ]+$";
				return str.replaceAll(regularExp, "");
			}
		}
	}

	/**
	 * 去掉字符串左边和右边的空格（空格和全角空格）
	 * 
	 * @param str
	 * @return
	 */
	public static String trim(String str) {
		if (str == null || str.equals("")) {
			return str;
		} else {
			return str.replaceAll("^[　 ]+|[　 ]+$", "");
		}
	}

	/**
	 * 去除字符串中间所有的空格、回车、换行符、制表符
	 * 
	 * @param str
	 * @return
	 */
	public static String trimAll(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	/**
	 * 判断对象是否为字符串，并且是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isObjBlank(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof String) {
			String str = (String) obj;
			if (str.equals("")) {
				return true;
			}
			return str.replaceAll("^[　 ]+|[　 ]+$", "").equals("");
		}
		return false;
	}

	/**
	 * 判断字符串是否为空，空格也算空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		if (str == null || str.equals("")) {
			return true;
		} else {
			return str.replaceAll("^[　 ]+|[　 ]+$", "").equals("");
		}
	}

	/**
	 * 判断下拉框是否是未选择
	 * @param value
	 * @return
	 */
	public static boolean isUnSelected(String value) {
		return Constants.UN_SELECT.equals(value) || isBlank(value);
	}

	/**
	 * 合并参数为字符串
	 * 
	 * @param separator
	 *            分隔符
	 * @param parameter
	 *            参数
	 * @return 合并后的字符串
	 */
	public static String join(String separator, String[] parameter) {
		return StringUtils.join(parameter, separator);
	}

	/**
	 * 去掉数组中的null，然后合并数组为字符串
	 * 
	 * @param array
	 *            数组
	 * @param separator
	 *            分隔符
	 * @return 合并后的字符串
	 */
	public static String join(Object[] array, String separator) {
		List<String> list = new ArrayList<String>();
		for (int j = 0; j < array.length; j++) {
			if (array[j] != null) {
				list.add(array[j].toString());
			}
		}
		return StringUtils.join(list.toArray(), separator);
	}

	/**
	 * 把字符串转化为人民币大写
	 * 
	 * @param money
	 * @return
	 */
	public static String toRmbUpperCase(String money) {
		int index = money.indexOf(Constants.DOT);
		// 整数部分
		String integer;
		// 小数部分
		String decimal = null;
		if (index != -1) {
			integer = money.substring(0, index);
			// 小数位数
			int decimalLength = money.length() - index - 1;
			if (decimalLength > 2) {
				decimalLength = 2;
			}
			decimal = money.substring(index + 1, index + 1 + decimalLength);
		} else {
			integer = money;
		}
		StringBuffer sb = new StringBuffer(32);
		char[] charArray = integer.toCharArray();
		int length = charArray.length;
		int j = 0;
		for (int i = length - 1; i >= 0; i--) {
			change4Integer(charArray[i], sb);
			switch (j) {
			case 1:
				sb.insert(1, "拾");
				break;
			case 2:
				sb.insert(1, "佰");
				break;
			case 3:
				sb.insert(1, "仟");
				break;
			case 4:
				sb.insert(1, "万");
				break;
			case 5:
				sb.insert(1, "拾");
				break;
			case 6:
				sb.insert(1, "佰");
				break;
			case 7:
				sb.insert(1, "仟");
				break;
			case 8:
				sb.insert(1, "亿");
				break;
			case 9:
				sb.insert(1, "拾");
				break;
			case 10:
				sb.insert(1, "佰");
				break;
			case 11:
				sb.insert(1, "仟");
				break;
			case 12:
				sb.insert(1, "万");
				break;
			default:
				break;
			}
			j++;
		}
		if (isBlank(decimal) || Integer.parseInt(decimal) == 0) {
			sb.append("元整");
		} else {
			sb.append("元");
			charArray = decimal.toCharArray();
			length = charArray.length;
			char c;
			for (int i = 0; i < length; i++) {
				c = charArray[i];
				if (i == 0) {
					if ('0' != c) {
						change4Decimal(c, sb);
						sb.append("角");
					}
				} else {
					if ('0' != c) {
						change4Decimal(c, sb);
						sb.append("分");
					}
				}
			}
		}
		String out = sb.toString();
		out = out.replaceAll("零拾", "零");
		out = out.replaceAll("零佰", "零");
		out = out.replaceAll("零仟", "零");
		out = out.replaceAll("零零零", "零");
		out = out.replaceAll("零零", "零");
		out = out.replaceAll("零万", "万");
		out = out.replaceAll("零亿", "亿");
		out = out.replaceAll("亿万", "亿");
		out = out.replaceAll("亿零元", "亿元");
		out = out.replaceAll("万零元", "万元");
		out = out.replaceAll("仟零元", "仟元");
		out = out.replaceAll("佰零元", "佰元");
		out = out.replaceAll("拾零", "拾");
		return out;
	}

	/**
	 * 把整数部分转化为人民币大写
	 * 
	 * @param c
	 * @param sb
	 */
	private static void change4Integer(char c, StringBuffer sb) {
		if ('0' == c) {
			sb.insert(0, "零");
		} else if ('1' == c) {
			sb.insert(0, "壹");
		} else if ('2' == c) {
			sb.insert(0, "贰");
		} else if ('3' == c) {
			sb.insert(0, "叁");
		} else if ('4' == c) {
			sb.insert(0, "肆");
		} else if ('5' == c) {
			sb.insert(0, "伍");
		} else if ('6' == c) {
			sb.insert(0, "陆");
		} else if ('7' == c) {
			sb.insert(0, "柒");
		} else if ('8' == c) {
			sb.insert(0, "捌");
		} else if ('9' == c) {
			sb.insert(0, "玖");
		}
	}

	/**
	 * 把小数部分转化为人民币大写，（小数部分不用“零”）
	 * 
	 * @param c
	 * @param sb
	 */
	private static void change4Decimal(char c, StringBuffer sb) {
		if ('1' == c) {
			sb.append("壹");
		} else if ('2' == c) {
			sb.append("贰");
		} else if ('3' == c) {
			sb.append("叁");
		} else if ('4' == c) {
			sb.append("肆");
		} else if ('5' == c) {
			sb.append("伍");
		} else if ('6' == c) {
			sb.append("陆");
		} else if ('7' == c) {
			sb.append("柒");
		} else if ('8' == c) {
			sb.append("捌");
		} else if ('9' == c) {
			sb.append("玖");
		}
	}

	/**
	 * 把只包含字母的字符串转换为数字， 根据A=1～Z=26，用于把excel的列的字母转换为数字 方便取列
	 * 
	 * @param str
	 * @return
	 */
	public static int alphabetString2Num(String str) {
		char[] array = str.toCharArray();
		int length = array.length - 1;
		int result = alphabet2Num(array[length]);
		length--;
		int index = 1;
		for (int i = length; i >= 0; i--) {
			result += alphabet2Num(array[i]) * pow(26, index);
			index++;
		}
		return result - 1;
	}

	/**
	 * 一个整数的n次方
	 * 
	 * @param base
	 *            整数
	 * @param exponent
	 *            整数的N次方
	 * @return
	 */
	public static int pow(int base, int exponent) {
		exponent--;
		for (int i = 0; i < exponent; i++) {
			base *= base;
		}
		return base;
	}

	/**
	 * 把单个字母转换为数字，A=1～Z=26，无视大小写
	 * 
	 * @param c
	 *            字母
	 * @return 数字
	 */
	public static int alphabet2Num(char c) {
		if (c == 'a' || c == 'A') {
			return 1;
		} else if (c == 'b' || c == 'B') {
			return 2;
		} else if (c == 'c' || c == 'C') {
			return 3;
		} else if (c == 'd' || c == 'D') {
			return 4;
		} else if (c == 'e' || c == 'E') {
			return 5;
		} else if (c == 'f' || c == 'F') {
			return 6;
		} else if (c == 'g' || c == 'G') {
			return 7;
		} else if (c == 'h' || c == 'H') {
			return 8;
		} else if (c == 'i' || c == 'I') {
			return 9;
		} else if (c == 'j' || c == 'J') {
			return 10;
		} else if (c == 'k' || c == 'K') {
			return 11;
		} else if (c == 'l' || c == 'L') {
			return 12;
		} else if (c == 'm' || c == 'M') {
			return 13;
		} else if (c == 'n' || c == 'N') {
			return 14;
		} else if (c == 'o' || c == 'O') {
			return 15;
		} else if (c == 'p' || c == 'P') {
			return 16;
		} else if (c == 'q' || c == 'Q') {
			return 17;
		} else if (c == 'r' || c == 'R') {
			return 18;
		} else if (c == 's' || c == 'S') {
			return 19;
		} else if (c == 't' || c == 'T') {
			return 20;
		} else if (c == 'u' || c == 'U') {
			return 21;
		} else if (c == 'v' || c == 'V') {
			return 22;
		} else if (c == 'w' || c == 'W') {
			return 23;
		} else if (c == 'x' || c == 'X') {
			return 24;
		} else if (c == 'y' || c == 'Y') {
			return 25;
		} else {
			return 26;
		}
	}

	/**
	 * 此方法可以判断一个字符串是否是数字
	 * 
	 * @param number
	 *            字符串
	 * @return true是反之不是
	 */
	public static boolean isNumberis(String number) {
		if (number == null || number.length() == 0) {
			return false;
		}
		boolean isNumber = false;
		String regex = "(\\+|\\-)?\\s*\\d+(\\.\\d+)?";
		if (number.trim().matches(regex)) {
			isNumber = true;
		}
		return isNumber;
	}

	/**
	 * 判断是否为数字
	 * 
	 * @param str
	 *            字符串
	 * @return true为是，反之为不是
	 */
	public static boolean isNumber(String str) {
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (!Character.isDigit(charArray[i]) && charArray[i] != '.') { // 非'0'-'9';
				return false;
			}
		}
		return true;
	}

	/**
	 * 将全角的字符转换为半角
	 * 
	 * @param str
	 * @return
	 */
	public static String toDBC(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = charToDBC(chars[i]);
		}
		return new String(chars);
	}

	private static char charToDBC(char ch) {
		if (ch == '\u3000') {
			return '\u0020';// 半角空格:
		} else if (ch > '\uFF00' && ch < '\uFF5F') {
			return (char) (ch - 65248);
		}
		return ch;
	}

	/**
	 * 判断是否为中文字符
	 * 
	 * @param c字符
	 * @return true为真，反之为false
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/**
	 * 将一句字符串中的中文过滤掉
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static String toFilterStr(String str) {
		char[] charArray = str.toCharArray();
		StringBuilder sb = new StringBuilder(64);
		for (char c : charArray) {
			if (!isChinese(c)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static String isNumberReplace(String str) {
		char[] charArray = str.toCharArray();
		System.out.println("charArray:" + charArray[charArray.length - 1]);
		String sb = "";
		System.out.println("开始转换:");
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isDigit(charArray[i]) || charArray[i] == '-') { // 非'0'-'9';
				sb += charArray[i];
			}
		}
		return sb;
	}

	/**
	 * 根据传入的字符串数字，去除小数点后最后一个零（只去除一个）
	 * 
	 * @param value
	 * @return
	 */
	public static String removingZeroDecimal(String value) {
		String newValue = value;
		// 验证尺码是否为数字，并且是否存在有小数点
		if (StringUtil.isNumberis(value)
				&& value.lastIndexOf(Constants.DOT) != -1) {
			// 去除最后一位，如果往前推一位是“.”一同去除
			newValue = value.substring(value.length() - 1, value.length());
			if ("0".equals(newValue)) {
				newValue = value.substring(value.length() - 2,
						value.length() - 1);
				if (Constants.DOT.equals(newValue)) {
					newValue = value.substring(0,
							value.lastIndexOf(Constants.DOT));
				} else {
					newValue = value.substring(0, value.length() - 1);
				}
			} else {
				newValue = value;
			}
		}
		return newValue;
	}

	/**
	 * 根据传入的字符串进行分析成为正常的整数字符串
	 * 
	 * @return 字符
	 */
	public static String toNumericalAnalysis(String value) {
		value = StringUtil.removingZeroDecimal(value);
		if (value.indexOf(Constants.DOT) != -1) {
			try {
				BigDecimal decimal = new BigDecimal(value);
				value = decimal.toString();
				if (value.indexOf(Constants.DOT) != -1) {
					BigInteger bigInteger = decimal.toBigInteger();
					value = bigInteger.toString();
				}
			} catch (NumberFormatException d) {
				return value;
			}
		}
		return value;
	}

	/**
	 * 去空格和横杠
	 * 
	 * @return
	 */
	public static String toTrimAndHorizontal(String value) {
		String code = StringUtil.trimAll(value);// 根据货号查询商品
		code = code.replaceAll(Constants.HORIZONTAL_LINE, "");
		return code;
	}

	/**
	 * 根据身份证获取到出生日期
	 * @param cardID
	 * @return
	 */
	public static Date cardValidate(String cardID) {
		StringBuffer tempStr = null;
		Date date = null;
		if (cardID != null && cardID.trim().length() > 0) {
			if (cardID.trim().length() == 15) {
				tempStr = new StringBuffer(cardID.substring(6, 12));
				tempStr.insert(4, '-');
				tempStr.insert(2, '-');
				tempStr.insert(0, "19");
			} else if (cardID.trim().length() == 18) {
				tempStr = new StringBuffer(cardID.substring(6, 14));
				tempStr.insert(6, '-');
				tempStr.insert(4, '-');
			}
		}
		if (tempStr != null && tempStr.toString().trim().length() > 0) {
			try {
				date = DateUtil.toObjDate(tempStr.toString(), Constants.YYYY_MM_DD);
			} catch (Exception e) {
				return date;
			}
		}
		return date;
	}
	
	/**
	 * 根据身份证获取到性别
	 * @param value
	 * @return
	 */
	public static String cardSex(String value) {
		value = StringUtil.isBlank(value)?"":StringUtil.trimAll(value);
		int length = StringUtil.length(value);
		if (length == 15 || length == 18) {
			String lastValue = value.substring(length - 1, length);
			if (lastValue.equalsIgnoreCase("x")
					|| lastValue.equalsIgnoreCase("e")) {
				return "1";
			} else {
				return Integer.parseInt(lastValue) % 2 == 0 ? "2" : "1";
			}
		}
		return null;
	}
	
	/**
	 * 把汉字转换为拼音，每个字只取头个字母，并且英文和数字不转换
	 * @param chinese 汉字
	 * @return
	 */
	public static String toPinYin(String chinese) {
		StringBuilder pybf = new StringBuilder();
		char[] arr = chinese.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		int length = arr.length;
		char oneChar;
		String[] strArr;
		for (int i = 0; i < length; i++) {
			oneChar = arr[i];
			// 大于128就不是英文和数字了
			if (oneChar > 128) {
				try {
					strArr = PinyinHelper.toHanyuPinyinStringArray(oneChar, defaultFormat);
					if (strArr != null) {
						pybf.append(strArr[0].charAt(0));
					}
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					
				}
				// 空格不转换
			} else if (oneChar != ' ') {
				pybf.append(oneChar);
			}
		}
		return pybf.toString();
	}
    
	/** 
     * 使用系统默认字符源生成验证码 
     * @param verifySize    验证码长度 
     * @return 
     */  
    public static String generateVerifyCode(int verifySize){
        return generateVerifyCode(verifySize, VERIFY_CODES);  
    }  
    
    /** 
     * 使用指定源生成验证码 
     * @param verifySize  验证码长度 
     * @param sources  验证码字符源 
     * @return 
     */  
    public static String generateVerifyCode(int verifySize, String sources){  
        if(sources == null || sources.length() == 0){  
            sources = VERIFY_CODES;  
        }  
        int codesLen = sources.length();  
        Random rand = new Random(System.currentTimeMillis());  
        StringBuilder verifyCode = new StringBuilder(verifySize);  
        for(int i = 0; i < verifySize; i++){  
            verifyCode.append(sources.charAt(rand.nextInt(codesLen-1)));  
        }  
        return verifyCode.toString();  
    }
    
    /**
     * 根据json字符串获取map集合
     * @param param json字符串
     * @return
     * @throws UnsupportedEncodingException
     * @throws JSONException
     */
    public static Map<String, String> getJoinToMap(String param) throws UnsupportedEncodingException, JSONException{
    	JSONObject jsonObject;
    	jsonObject = new JSONObject(URLDecoder.decode(param, "UTF-8"));
		Map<String, String> result = new HashMap<String, String>();
	        Iterator<?> iterator = jsonObject.keys();
        String key = null;
        String value = null;		        
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            value = jsonObject.getString(key);
            result.put(key, value);
        }
    	
    	return result;
    }
    
    /**
     * 根据base64字符串转化字节数组
     * @param fileControl
     * @return
     * @throws IOException
     */
    public static byte[] getByte(String fileControl) throws IOException{
		byte[] byBuffer = null;	
		BASE64Decoder decoder = new BASE64Decoder();
		byBuffer = decoder.decodeBuffer(fileControl);
		return byBuffer;
	}
	
	public static void main(String[] a) {
		String id = "201512141101";
		String substring = id.substring(id.length() -4, id.length());
		System.out.println(substring);
		System.out.println(Integer.valueOf(substring));
		int i = Integer.valueOf(substring).intValue();
		i++;
		String number = "20150812";
		number = number + (String) (i < 10 ? "000" + i : i < 100 ? "00" + i : i < 1000 ? "0" + i : i+"");
		System.out.println(number);
		
		//生成随机字串  
        String verifyCode = generateVerifyCode(6);  
        System.out.println(verifyCode);
	}

}

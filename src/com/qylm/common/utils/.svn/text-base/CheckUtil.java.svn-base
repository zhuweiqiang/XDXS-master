package com.qylm.common.utils;

import java.util.regex.Pattern;

public final class CheckUtil {

	private static final Pattern number = Pattern.compile("[0-9]*");

	private static final Pattern alphabetOrNumber = Pattern.compile("\\w*");

	//private static final Pattern alphabet = Pattern.compile("[A-Za-z]*");

	private static final Pattern email = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
	
	private static final Pattern image = Pattern.compile("^.*\\.(?i)(gif|jpe?g|png)$");
	
	private static final Pattern xls = Pattern.compile("^.*\\.(xls|XLS)$");
	
	private static final Pattern json_Format = Pattern.compile("^[\\w[^\\[\\],{}]]+$");
	
	private static final Pattern phone = Pattern.compile("^(0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?$");
	
	private static final Pattern decimalOrNumber = Pattern.compile("^-?\\d*(\\.)?\\d*$");

	public static boolean isIdCard(String value) {
		if (alphabetOrNumber.matcher(value).matches()) {
			int length = value.length();
			return ((length == 18) || (length == 15));
		}
		return false;
	}

	public static boolean isEmail(String value) {
		if (email.matcher(value).matches()) {
			return true;
		}
		return false;
	}

	public static boolean isAlphabetOrNumber(String value) {
		return alphabetOrNumber.matcher(value).matches();
	}
	
	public static boolean isImage(String value) {
		return image.matcher(value).matches();
	}
	
	public static boolean isXls(String value) {
		return xls.matcher(value).matches();
	}
	
	public static boolean isNumber(String value) {
		return number.matcher(value).matches();
	}
	
	public static boolean isPhone(String value) {
		return phone.matcher(value).matches();
	}
	
	public static boolean isdecimalOrNumber(String value) {
		return decimalOrNumber.matcher(value).matches();
	}
	
	/**
	 * 不是正则返回true
	 * @param value
	 * @return
	 */
	public static boolean isJsonFormat(String value) {
		return json_Format.matcher(value).matches();
	}

}

package com.qylm.common;

import java.util.Collection;

import javax.faces.model.SelectItem;

import com.qylm.common.utils.GenericCodeUtil;
import com.qylm.common.utils.StringUtil;

public class Functions {
	
	private Functions() {}
	
	/**
	 * 
	 * 去除html标签，结束以...代替
	 * @param str 需截取的字符串
	 * @param start 开始位置索引
	 * @param end 结束位置索引
	 * @return 截取之后的字符串 
	 */
	public static String substring(String str, Integer start, Integer end){
		StringUtil.substring(str, start-10, end+10);
		str = str.replaceAll("</?[^<]+>", "");
		// 去除字符串中的空格 回车 换行符 制表符 等
		str = str.replaceAll("\\s*|\t|\r|\n", "");
		// 去除空格
		str = str.replaceAll("&nbsp;", "");
		// 去掉其他一些字符
		//content = content.replaceAll("\", "");
		return StringUtil.abbreviate(str, start, end);
	}
	
	/**
	 * @param name 
	 * @param searchString
	 * @return 判断字符串是否包含另外一个字符串
	 */
	public static boolean contains(String name,String searchString){
		return StringUtil.contains(name, searchString);
	}
	
	/**
	 * @param name 
	 * @param searchString
	 * @return 判断字符串是否包含另外一个字符串(大小写无关)
	 */
	public static boolean containsIgnoreCase(String name,String searchString){
		return StringUtil.containsIgnoreCase(name, searchString);
	}
	
	/**
	 * @param filename
	 * @param suffix
	 * @return 判断字符串是否以另外字符串结束
	 */
	public static boolean endsWith(String filename,String suffix){
		return StringUtil.endsWith(filename, suffix);
	}
	
	/**
	 * @param name
	 * @param separ
	 * @return 子字符串在母字符串中出现的位置
	 */
	public static Integer indexOf(String name,String separator){
		return StringUtil.indexOf(name, separator);
	}
	
	/**
	 * @param array
	 * @param separator
	 * @return 将数组中的数据联合成一个新字符串，并使用指定字符格开
	 */
	public static String join(Object[] array,String separator){
		return StringUtil.join(array, separator);
	}
	
	/**
	 * @param array
	 * @param separator
	 * @return 将数组中的数据联合成一个新字符串，并使用指定字符格开
	 */
	public String join(Collection<Object> array,String separator){
		return StringUtil.join(array.toArray(), separator);
	}
	
	/**
	 * @param array
	 * @param separator
	 * @return 获取数组的大小
	 */
	public static Integer length(Object[] array){
		if(array==null)return 0;
		return array.length;
	}
	
	/**
	 * @param array
	 * @param separator
	 * @return 获取数组的大小
	 */
	public static Integer length(Collection<Object> array){
		if(array==null||array.isEmpty())return 0;
		return array.size();
	}
	
	/**
	 * @param array
	 * @param separator
	 * @return 获取字符串的长度
	 */
	public static Integer length(String str){
		if(StringUtil.isBlank(str))return 0;
		return str.length();
	}
	
	/**
	 * @param items 下拉框集合
	 * @param value 下拉框的值
	 * @return 所要显示的label
	 */
	public static String label(SelectItem[] items, String value){
		return GenericCodeUtil.findLabel(items, value);
	}
	
}

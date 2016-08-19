package com.qylm.common.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import com.qylm.constants.Constants;

/**
 * BigDecimal相关工具类
 * @author 
 *
 */
public final class BigDecimalUtil {
	
	/**
	 * 把数据库中取出来的List转化为单个BigDecimal
	 * 取单个字段的sum的时候使用
	 * @param list
	 * @return
	 */
	public static BigDecimal getSum(List<Object> list) {
		BigDecimal sum;
		if (list.isEmpty()) {
			sum = Constants.BIGDECIMAL_ZERO;
		} else {
			Object obj = list.get(0);
			if (obj == null) {
				sum = Constants.BIGDECIMAL_ZERO;
			} else {
				sum = (BigDecimal) obj;
			}
		}
		return sum;
	}
	
	/**
	 * 把数据库中取出来的List转化为多个BigDecimal
	 * 取出多个BigDecimal类型的字段的sum时使用
	 * @param list hibernate取出的结果集
	 * @param columnNum 取出了几个字段
	 * @return
	 */
	public static BigDecimal[] getMultiSum(List<Object> list, int columnNum) {
		BigDecimal[] returnValue = new BigDecimal[columnNum];
		if (list.isEmpty()) {
			for (int i = 0; i < columnNum; i++) {
				returnValue[i] = Constants.BIGDECIMAL_ZERO;
			}
		} else {
			Object[] obj = (Object[]) list.get(0);
			for (int i = 0; i < columnNum; i++) {
				returnValue[i] = obj[i] == null ? Constants.BIGDECIMAL_ZERO : (BigDecimal) obj[i];
			}
		}
		return returnValue;
	}
	
	/**
	 * 把数据库中取出来的List<Object>转化为List<BigDecimal>，并且相加
	 * 取单个BigDecimal字段并且需要累加的时候使用
	 * @param list
	 * @return
	 */
	public static BigDecimal getCount(List<Object> list) {
		BigDecimal sum = Constants.BIGDECIMAL_ZERO;
		int size = list.size();
		Object obj;
		for (int i = 0; i < size; i++) {
			obj = list.get(i);
			if (obj != null) {
				sum = sum.add((BigDecimal) obj);
			}
		}
		return sum;
	}
	
	/**
	 * 把数据库中取出来的List<Object>转化为List<BigDecimal[]>，并且各自相加
	 * 取多个BigDecimal字段并且需要累加的时候使用
	 * @param list
	 * @return
	 */
	public static BigDecimal[] getMultiCount(List<Object> list, int columnNum) {
		BigDecimal[] sum = new BigDecimal[columnNum];
		for (int i = 0; i < columnNum; i++) {
			sum[i] = Constants.BIGDECIMAL_ZERO;
		}
		int size = list.size();
		Object[] objs;
		Object obj;
		for (int i = 0; i < size; i++) {
			objs = (Object[]) list.get(i);
			for (int j = 0; j < columnNum; j++) {
				obj = objs[j];
				if (obj != null) {
					sum[j] = add(sum[j], (BigDecimal) obj);
				}
			}
		}
		return sum;
	}
	
	/**
	 * 判断b1的值是否等于b2
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static boolean valueEqual(BigDecimal b1, BigDecimal b2) {
		return compare(b1, b2) == 0;
	}
	
	/**
	 * 判断b1是否大于b2
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static boolean bigThan(BigDecimal b1, BigDecimal b2) {
		return compare(b1, b2) > 0;
	}
	
	/**
	 * 判断b1是否大于等于b2
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static boolean bigThanOrEqual(BigDecimal b1, BigDecimal b2) {
		return compare(b1, b2) >= 0;
	}
	
	/**
	 * 判断b1是否小于b2
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static boolean smallThan(BigDecimal b1, BigDecimal b2) {
		return compare(b1, b2) < 0;
	}
	
	/**
	 * 判断b1是否小于等于b2
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static boolean smallThanOrEqual(BigDecimal b1, BigDecimal b2) {
		return compare(b1, b2) <= 0;
	}
	
	/**
	 * 比较b1和b2的大小
	 * @param b1
	 * @param b2
	 * @return 1 = 大于,0 = 等于,-1 =小于
	 */
	public static int compare(BigDecimal b1, BigDecimal b2) {
		if (b1 == null) {
			if (b2 == null) {
				return 0;
			}
			return -1;
		}
		if (b2 == null) {
			return 1;
		}
		return b1.compareTo(b2);
	}
	
	/**
	 * 把BigDecimal转化为字符串
	 * @param b
	 * @return 如果b为null，则返回null，如果不是则返回BigDecimal.toString()
	 */
	public static String toString(BigDecimal b) {
		if (b == null) {
			return null;
		}
		return b.toString();
	}
	
	/**
	 * 把对象转化为BigDecimal
	 * @param b
	 * @return 如果b为null，则返回null，如果不是则返回BigDecimal
	 */
	public static BigDecimal toBigDecimal(Object b) {
		if (b == null) {
			return null;
		}
		try {
			return new BigDecimal(b.toString());
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 把BigDecimal转化为字符串
	 * @param b
	 * @return 如果b为null，则返回空字符串，如果不是则返回BigDecimal.toString()
	 */
	public static String toStringNotNull(BigDecimal b) {
		if (b == null) {
			return "";
		}
		return b.toString();
	}
	
	/**
	 * 用format格式化bigDecimal
	 * @param format
	 * @param bigDecimal
	 * @return
	 */
	public static String format(NumberFormat format, BigDecimal bigDecimal) {
		if (bigDecimal == null) {
			return null;
		}
		return format.format(bigDecimal);
	}
	
	/**
	 * 取b的负数，b为null则返回null
	 * @param b
	 * @return
	 */
	public static BigDecimal negate(BigDecimal b) {
		if (b == null) {
			return null;
		}
		return b.negate();
	}
	
	/**
	 * 取b的绝对值，b为null则返回null
	 * @param b
	 * @return
	 */
	public static BigDecimal abs(BigDecimal b) {
		if (b == null) {
			return null;
		}
		return b.abs();
	}
	
	/**
	 * 为b设置小数位，b为null时直接返回，不设置
	 * @param b
	 * @param newScale 需要设置的小数位
	 * @param roundingMode 小数位进位方式
	 * @see    java.math.BigDecimal#ROUND_UP
     * @see    java.math.BigDecimal#ROUND_DOWN
     * @see    java.math.BigDecimal#ROUND_CEILING
     * @see    java.math.BigDecimal#ROUND_FLOOR
     * @see    java.math.BigDecimal#ROUND_HALF_UP
     * @see    java.math.BigDecimal#ROUND_HALF_DOWN
     * @see    java.math.BigDecimal#ROUND_HALF_EVEN
     * @see    java.math.BigDecimal#ROUND_UNNECESSARY
	 * @return 小数位变更后的值
	 */
	public static BigDecimal setScale(BigDecimal b, int newScale, int roundingMode) {
		if (b == null) {
			return null;
		}
		return b.setScale(newScale, roundingMode);
	}
	
	/**
	 * b1和b2相加，b1不能为null，b2可以为null
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static BigDecimal add(BigDecimal b1, BigDecimal b2) {
		if (b2 == null) {
			return b1;
		}
		return b1.add(b2);
	}
	
	/**
	 * b1和b2相加，b1和b2都可以为null
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static BigDecimal addAndCheckNull(BigDecimal b1, BigDecimal b2) {
		if (b1 == null) {
			return b2;
		}
		if (b2 == null) {
			return b1;
		}
		return b1.add(b2);
	}
	
	/**
	 * b1和b2相减，b1不能为null，b2可以为null
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static BigDecimal subtract(BigDecimal b1, BigDecimal b2) {
		if (b2 == null) {
			return b1;
		}
		return b1.subtract(b2);
	}
	
	/**
	 * b1和b2相减，b1和b2都可以为null
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static BigDecimal subtractAndCheckNull(BigDecimal b1, BigDecimal b2) {
		if (b1 == null) {
			if (b2 == null) {
				return null;
			}
			return b2.negate();
		}
		if (b2 == null) {
			return b1;
		}
		return b1.subtract(b2);
	}
	
	/**
	 * b1和b2相乘，b1不能为null，b2可以为null
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static BigDecimal multiply(BigDecimal b1, BigDecimal b2) {
		if (b2 == null) {
			return b1;
		}
		return b1.multiply(b2);
	}
	
	/**
	 * b1和b2相乘，b1和b2都可以为null
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static BigDecimal multiplyAndCheckNull(BigDecimal b1, BigDecimal b2) {
		if (b1 == null) {
			return b2;
		}
		if (b2 == null) {
			return b1;
		}
		return b1.multiply(b2);
	}
	
	/**
	 * 计算b1除以b2的结果，b1和b2中任意一个为null，则返回null，b2等于0时，也返回null
	 * @param b1 被除数
	 * @param b2 除数
	 * @param scale 计算结果的保留几位小数
	 * @param roundingMode 计算结果的小数点保留方式
	 * @see    java.math.BigDecimal#ROUND_UP
     * @see    java.math.BigDecimal#ROUND_DOWN
     * @see    java.math.BigDecimal#ROUND_CEILING
     * @see    java.math.BigDecimal#ROUND_FLOOR
     * @see    java.math.BigDecimal#ROUND_HALF_UP
     * @see    java.math.BigDecimal#ROUND_HALF_DOWN
     * @see    java.math.BigDecimal#ROUND_HALF_EVEN
     * @see    java.math.BigDecimal#ROUND_UNNECESSARY
	 * @return
	 */
	public static BigDecimal divide(BigDecimal b1, BigDecimal b2, int scale, int roundingMode) {
		if (b1 == null || b2 == null || b2.compareTo(BigDecimal.ZERO) == 0) {
			return null;
		}
		return b1.divide(b2, scale, roundingMode);
	}
	
	/**
	 * array1加array2内部的值都可以为null
	 * @param array1
	 * @param array2
	 * @return
	 */
	public static BigDecimal[] add(BigDecimal[] array1, BigDecimal[] array2) {
		int size = array1.length;
		BigDecimal[] result = new BigDecimal[size];
		BigDecimal b1;
		BigDecimal b2;
		for (int i = 0; i < size; i++) {
			b1 = array1[i];
			b2 = array2[i];
			if(b1 == null){
				result[i] = b2;
			} else {
				if(b2 == null){
					result[i] = b1;
				} else {
					result[i] = b1.add(b2);
				}
			}
		}
		return result;
	}
	
	public static BigDecimal[] subtract(BigDecimal[] array1, BigDecimal[] array2) {
		int size = array1.length;
		BigDecimal[] result = new BigDecimal[size];
		BigDecimal b1;
		BigDecimal b2;
		for (int i = 0; i < size; i++) {
			b1 = array1[i];
			if(b1 != null){
				b2 = array2[i];
				if(b2 == null){
					result[i] = b1;
				} else {
					result[i] = b1.subtract(b2);
				}
			}
		}
		return result;
	}
	
	/**
	 * 判断decimal是否为null或者0
	 * @param decimal 需要验证的值
	 * @return true 是null或者为0，false 反之
	 */
	public static boolean isNullOrZero(BigDecimal decimal) {
		return decimal == null || BigDecimal.ZERO.compareTo(decimal) == 0;
	}
	
	/**
	 * 判断decimal是否不为null或者0
	 * @param decimal 需要验证的值
	 * @return true 不是null并且也不是0，false 反之
	 */
	public static boolean isNotNullOrZero(BigDecimal decimal) {
		return decimal != null && BigDecimal.ZERO.compareTo(decimal) != 0;
	}
	
	/**
	 * 判断decimal是否大于0
	 * @param decimal 需要验证的值
	 * @return true 不等于null并且大于0，false 反之
	 */
	public static boolean bigThanZero(BigDecimal decimal) {
		return decimal != null && decimal.compareTo(BigDecimal.ZERO) > 0;
	}
	
	/**
	 * 判断decimal是否小于0
	 * @param decimal 需要验证的值
	 * @return true 不等于null并且小于0，false 反之
	 */
	public static boolean smallThanZero(BigDecimal decimal) {
		return decimal != null && decimal.compareTo(BigDecimal.ZERO) < 0;
	}
	
	public static void main(String[] age) {
		BigDecimal a = new BigDecimal("0");
		BigDecimal b = new BigDecimal("-2");
		System.out.println(add(a, b));
	}

}

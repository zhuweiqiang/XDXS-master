package com.qylm.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;

import com.qylm.constants.Constants;

public final class DateUtil extends DateUtils {
	
	/**
	 * 比较one是否等于another
	 * @param one
	 * @param another
	 * @return
	 */
	public static boolean equal(Date one, Date another){
		return another != null && one.compareTo(another) == 0;
	}

	/**
	 * 比较日期one是否大于another
	 * @param one 
	 * @param another
	 * @return
	 */
	public static boolean bigThan(Date one, Date another) {
		if (one != null && another != null && one.compareTo(another) > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * <p>用于画面上可以输入日期和时分的比较，例如，【请假结束日期+请假结束时间】和【请假开始日期+请假开始时间】
	 * 比较大小/p>
	 * <p>先比较日期oneDay是否大于anotherDay
	 * 如果相等，则判断oneTime是否大于anotherTime
	 * 如果上记两个判断中一个为true则返回true
	 * 其余情况返回false</p>
	 * @param oneDay
	 * @param anotherDay
	 * @param oneTime
	 * @param anotherTime
	 * @return
	 */
	public static boolean bigThan(Date oneDay, Date oneTime, Date anotherDay, Date anotherTime) {
		if (oneDay != null && anotherDay != null) {
			int result = oneDay.compareTo(anotherDay);
			if(result == 0){
				if(oneTime == null){
					oneTime = get00_00();
				} else {
					oneTime = toHHMM(oneTime);
				}
				if(anotherTime == null){
					anotherTime = get00_00();
				} else {
					anotherTime = toHHMM(anotherTime);
				}
				return bigThan(oneTime, anotherTime);
			} else if(result > 0){
				return true;
			}
		}
		return false;
	}

	/**
	 * 格式化日期
	 * @param format
	 * @param date
	 * @return
	 */
	public static String format(DateFormat format, Date date) {
		if (date == null) {
			return null;
		}
		return format.format(date);
	}
	
	/**
	 * 将日期装换成字符串
	 * @param date 需要转换的日期 
	 * @param constants 日期格式
	 * @return 字符串
	 */
	public static String formatDate(Date date, String constants) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat ymd = new SimpleDateFormat(constants);
		return ymd.format(date);
	}
	
	/**
	 * obj类型转换为date日期类型的相对应格式
	 * @param date object对象的date信息
	 * @param constants 日期格式
	 * @return
	 */
	public static Date toObjDate(Object date, String constants) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(constants);
		try {
			return sdf.parse(date.toString());
		} catch (ParseException e) {
			
		}
		return null;
	}
	
	/**
	 * 按照yyyy-mm-dd的格式转换日期
	 * @return
	 */
	public static Date toyyyymmdd(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.YYYY_MM_DD);
		try {
			return sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			
		}
		return null;
	}
	
	/**
	 * one日期减去another日期相差的时间【分钟数】
	 * @param one 第一个日期
	 * @param another 第二个日期
	 * @return
	 */
	public static long getSubtractMinute(Date one, Date another){
		if(one != null && another != null){
			return (one.getTime() - another.getTime()) / (1000 * 60);
		}
		return 0;
	}
	
	/**
	 * one日期减去another日期相差的时间【小时数】
	 * @param one 第一个日期
	 * @param another 第二个日期
	 * @return
	 */
	public static long getSubtractHour(Date one, Date another){
		if(one != null && another != null){
			return (one.getTime() - another.getTime())/ (1000 * 60 * 60);
		}
		return 0;
	}
	
	/**
	 * one日期减去another日期相差的时间【天数】
	 * @param one 第一个日期
	 * @param another 第二个日期
	 * @return
	 */
	public static long getSubtractday(Date one, Date another){
		if(one != null && another != null){
			return (one.getTime() - another.getTime()) / (1000 * 60 * 60 * 24);
		}
		return 0;
	}
	
	/**
	 * 取得所给date的天
	 * @return 整数类型的天
	 */
	public static int toDD(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.DD);
		return Integer.parseInt(sdf.format(date));
	}
	
	/**
	 * 取得所给date的小时
	 * @return 整数类型的小时
	 */
	public static int toHH(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.HH);
		return Integer.parseInt(sdf.format(date));
	}
	
	/**
	 * 取得所给date的分
	 * @return 整数类型的分钟数
	 */
	public static int toMM(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.MM);
		return Integer.parseInt(sdf.format(date));
	}
	
	/**
	 * 取得所给date的小时和分
	 * @return
	 */
	public static Date toHHMM(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.HH_MM);
		try {
			return sdf.parse(sdf.format(date));
		} catch (ParseException e) {
		}
		return null;
	}
	
	/**
	 * 按照yyyy-mm-dd的格式取得现在日期
	 * @return
	 */
	public static Date getNowyyyymmdd(){
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.YYYY_MM_DD);
		try {
			return sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			
		}
		return null;
	}
	
	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式取得现在日期
	 * @return
	 */
	public static Date getNowyyyymmddhhmmss(){
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.YYYY_MM_DD_HH_MM_SS);
		try {
			return sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			
		}
		return null;
	}
	
	/**
	 * 按照yyyy-MM-dd HH:mm:ss SSS的格式取得现在日期 
	 * @return
	 */
	public static Long getNowyyyymmddhhmmssSSS(){
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.YYYY_MM_DD_HH);
		return Long.valueOf(sdf.format(new Date()));
	}
	
	/**
	 * 取得时间的00:00
	 * @return 00:00
	 */
	public static Date get00_00(){
		SimpleDateFormat hm = new SimpleDateFormat(Constants.HH_MM);
		try {
			return hm.parse("00:00");
		} catch (ParseException e) {
		}
		return null;
	}
	
	/**
	 * 按照yyyy-mm的格式取得现在日期
	 * @return 返回当前年月格式日期
	 */
	public static Date getNowyyyymm() {
		SimpleDateFormat ym = new SimpleDateFormat(Constants.YYYY_MM);
		try {
			return ym.parse(ym.format(new Date()));
		} catch (ParseException e) {
			
		}
		return null;
	}
	
	/**
	 * 该月份的最大天数
	 * @param date 日期
	 * @return 该月最大天数
	 */
	public static int getMonthOfMaxDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 根据传入的时间，在根据传入的天数，加或者减
	 * @param nowDate 当前时间
	 * @param day
	 * @return
	 */
	public static Date getBackDate(Date nowDate, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nowDate);
		calendar.add(Calendar.DAY_OF_YEAR, day);
		return calendar.getTime();
	}
	
	/**
	 * 根据传入的时间，取值到前几个月 或 后几个月的某一条
	 * @param nowDate 当前时间
	 * @param month 前几个月 或者后几个月
	 * @param day 某天
	 * @return
	 */
	public static Date getMonthFixedDate(Date nowDate, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nowDate);
		calendar.add(Calendar.MONTH, month);
		String formatDate = formatDate(calendar.getTime(), Constants.YYYY_MM) + "-" + day ;
		return toObjDate(formatDate, Constants.YYYY_MM_DD);
	}

//	/**
//	 * 返回开始日期和结束日期之间间隔多少天
//	 * 
//	 * @param beginDate
//	 *            开始日期
//	 * @param endDate
//	 *            结束日期
//	 * @return 日期相同返回0， 有一方为null也返回0 结束日期大于开始日期返回-1， 其他计算出相隔天数
//	 * 
//	 */
//	public static int getSubtractDay(Date beginDate, Date endDate) {
//		if (beginDate == null || endDate == null) {
//			return 0;
//		}
//		SimpleDateFormat yyyy = new SimpleDateFormat(Constants.YYYY);
//		SimpleDateFormat month = new SimpleDateFormat(Constants.MM_MONTH);
//		SimpleDateFormat dd = new SimpleDateFormat(Constants.DD);
//		return getSubtractDay(beginDate, endDate, yyyy, month, dd);
//	}

//	/**
//	 * 返回开始日期和结束日期之间间隔多少天
//	 * 
//	 * @param beginDate
//	 *            开始日期
//	 * @param endDate
//	 *            结束日期
//	 * @param yyyy
//	 *            为了提高效率SimpleDateFormat的创建移到外层
//	 * @param month
//	 *            为了提高效率SimpleDateFormat的创建移到外层
//	 * @param dd
//	 *            为了提高效率SimpleDateFormat的创建移到外层
//	 * @return 日期相同返回0， 有一方为null也返回0 结束日期大于开始日期返回-1， 其他计算出相隔天数
//	 */
//	public static int getSubtractDay(Date beginDate, Date endDate, SimpleDateFormat yyyy,
//			SimpleDateFormat month, SimpleDateFormat dd) {
//		if (beginDate == null || endDate == null) {
//			return 0;
//		}
//		int day = 0;
//		int beginDay = Integer.parseInt(dd.format(beginDate));
//		int endDay = Integer.parseInt(dd.format(endDate));
//		int beginMonth = Integer.parseInt(month.format(beginDate));
//		int endMonth = Integer.parseInt(month.format(endDate));
//		int beginYear = Integer.parseInt(yyyy.format(beginDate));
//		int endYear = Integer.parseInt(yyyy.format(endDate));
//		Calendar time = Calendar.getInstance();
//		if (endYear == beginYear) {
//			// 判断是否为同一年
//			time.set(Calendar.YEAR, beginYear);
//			int differenceMonth = endMonth - beginMonth - 1;
//			for (int i = -1; i < differenceMonth; i++) {
//				// Calendar对象默认月份为0-11
//				time.set(Calendar.MONTH, beginMonth + i);
//				// 这月份的天数
//				day = time.getActualMaximum(Calendar.DAY_OF_MONTH) + day;
//			}
//		} else if (endYear > beginYear) {
//			int differenceYear = endYear - beginYear;
//			// 判读间隔几年
//			for (int j = 0; j <= differenceYear; j++) {
//				if (j != 0 && beginYear + j != endYear) {
//					// 每年时间的总和
//					time.set(Calendar.YEAR, beginYear + j);
//					day = time.getActualMaximum(Calendar.DAY_OF_YEAR) + day;
//					// 第一年的时间
//				} else if (j == 0) {
//					time.set(Calendar.YEAR, beginYear);
//					for (int k = -1; k < 11 - beginMonth; k++) {
//						// Calendar对象默认月份为0-11
//						time.set(Calendar.MONTH, beginMonth + k);
//						// 这月份的天数
//						day = time.getActualMaximum(Calendar.DAY_OF_MONTH) + day;
//					}
//					// 加最后一年的时间
//				} else {
//					time.set(Calendar.YEAR, endYear);
//					for (int k = 0; k < endMonth; k++) {
//						// Calendar对象默认月份为0-11
//						time.set(Calendar.MONTH, k);
//						// 这月份的天数
//						day = time.getActualMaximum(Calendar.DAY_OF_MONTH) + day;
//					}
//				}
//			}
//		} else {
//			return -1;
//		}
//		day = day + endDay - beginDay;
//		if (day < 0) {
//			day = -1;
//		}
//		return day;
//	}

	/**
	 * 判断输入的天数是否为星期六 是星期六为true ，不是为false
	 * @param nonceDate 当前天
	 * @return 是否为星期六
	 */
	public static boolean isSaturday(Date nonceDate){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nonceDate);
		int saturDay = calendar.get(Calendar.DAY_OF_WEEK);
		if(Calendar.SATURDAY == saturDay){
			return true;
		}
		return false;
	} 
	
	/**
	 * 输入日期的前一月份日期 或 后一月份的日期
	 * 输入的日期为空 则返回的日期为空
	 * @param inputDate
	 *            输入的日期
	 * @param fluctuateMonth
	 *            上下月时间标识 
	 *            上月为true 
	 *            下月为false
	 * @return 输入月的前一月份的日期 或 者后一月份的日期
	 */
	public static Date nonceDate(Date inputDate, boolean fluctuateMonth) {
		// 输入日期为空 返回空日期
		if (inputDate == null) {
			return null;
		}
		SimpleDateFormat ym = new SimpleDateFormat(Constants.YYYY_MM);
		SimpleDateFormat year = new SimpleDateFormat(Constants.YYYY);
		SimpleDateFormat month = new SimpleDateFormat(Constants.MM_MONTH);
		// 转换后的当前日期
		Date nonceDate = null;
		// 转换后的当前日期（字符串形式 yyyy-MM）
		String nonceDateStr = null;
		// 取出输入日期的年
		String yearStr = year.format(inputDate);
		// 将输入日期的月转成int类型
		int nonceMonth = Integer.parseInt(month.format(inputDate));
		// 上一月份
		if (fluctuateMonth) {
			nonceMonth = nonceMonth - 1;
			// 下一月份
		} else {
			nonceMonth = nonceMonth + 1;
		}
		// 0月份的 上一月是 前一年的12月份
		if (nonceMonth == 0) {
			// 取出输入日期的年 -1为 前一年
			int yearInt = Integer.parseInt(yearStr) - 1;
			// 上一月的日期 为前一年的12月
			nonceDateStr = yearInt + "-12";
			// 13月份的 下一月是 后一年的1月份
		} else if (nonceMonth == 13) {
			// 取出输入日期的年 +1为 后一年
			int yearInt = Integer.parseInt(yearStr) + 1;
			// 下一月的日期 为后一年的1月
			nonceDateStr = yearInt + "-1";
		} else {
			nonceDateStr = yearStr + Constants.HORIZONTAL_LINE + nonceMonth;
		}
		try {
			// 转换为日期 年 月
			nonceDate = ym.parse(nonceDateStr);
		} catch (ParseException e) {
		}
		return nonceDate;
	}
	
	/**
	 * 返回输入月份的星期六 日的集合
	 * Map 里的Key值为这月的哪几号是星期六 日
	 * @param inputDateYM
	 *            输入年月
	 * @param starDay
	 *            星期六 (Map里value值所表示的值)
	 * @param sunDay
	 *            星期天 (Map里value值所表示的值)
	 * @return 星期六 日的集合
	 */
	public static Map<Integer, String> holidayDateMap(String inputDateYM, String starDay, String sunDay) {
		SimpleDateFormat ymd = new SimpleDateFormat(Constants.YYYY_MM_DD);
		// 取出输入的时间 转换成这年这月的第一天
		String yearMonthDay = inputDateYM + "-01";
		// 重新转换成时间
		Date dateTime = new Date();
		try {
			dateTime = ymd.parse(yearMonthDay);
		} catch (ParseException e) {
		//	log.error(Message.MS0058, e);
		}
		// 创建一个时间函数
		Calendar calendar = Calendar.getInstance();
		// 传入当前的时间
		calendar.setTime(dateTime);
		// 这月的总天数
		int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 这月第一天星期几 返回1到7 1为星期天 7为星期六 返回星期减1 0为星期日 6为星期六
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		// 创建 封装这个月 星期六 日的Map集合 key为几号 value为星期
		Map<Integer, String> weekMap = new HashMap<Integer, String>();
		// 第一个星期天
		int sunDay0;
		// 判段这月第一天
		// weekDay 为0 星期日
		if (weekDay == 0) {
			sunDay0 = 1;
			weekMap.put(1, sunDay);
			// weekDay 为6星期六 第2天就是日
		} else if (weekDay == 6) {
			sunDay0 = 2;
			weekMap.put(1, starDay);
			weekMap.put(2, sunDay);
			// weekDay 前7天里的第一个 星期日
		} else {
			sunDay0 = 8 - weekDay;
			weekMap.put(sunDay0 - 1, starDay);
			weekMap.put(sunDay0, sunDay);
		}
		// 一个月最大4周
		for (int i = 1; i <= 4; i++) {
			if (sunDay0 <= day) {
				// 每周7天循环一次+7
				sunDay0 = sunDay0 + 7;
				// 比如 比这月最大值大1一天 为星期日 那么前一天就是星期六
				if (sunDay0 == day + 1) {
					weekMap.put(sunDay0 - 1, starDay);
					// 否则正常求值 7天一循环
				} else if (sunDay0 <= day) {
					weekMap.put(sunDay0 - 1, starDay);
					weekMap.put(sunDay0, sunDay);
				}
			}
		}
		return weekMap;
	}
	
	public static void main(String[] s) {
		System.out.println(DateUtil.getSubtractMinute(DateUtil.getNowyyyymmddhhmmss(), DateUtil.toObjDate("2015-09-16 15:12:00", Constants.YYYY_MM_DD_HH_MM_SS)));
	}

}

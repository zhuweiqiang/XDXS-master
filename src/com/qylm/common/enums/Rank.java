package com.qylm.common.enums;

import com.qylm.common.utils.StringUtil;


/**
 * 尺码排列
 * <ul>
 * <li>1：厘米</li>
 * <li>2：欧洲码</li>
 * <li>3：美国码</li>
 * <li>4：中国码</li>
 * <li>5：身高/胸围</li>
 * <li>6：身高/腰围</li>
 * <li>7：尺码</li>
 * <li>8：均码</li>
 * <li>9：特殊码</li>
 * <ul>
 */
public enum Rank {
	
	SIZE_ONE("厘米"),//尺码：厘米
	SIZE_TWO("欧洲码"),//尺码：欧洲码
	SIZE_THREE("美国码"),//尺码：美国码
	SIZE_FOUR("中国码"),//尺码：中国码
	SIZE_FIVE("身高/胸围"),//尺码：身高/胸围
	SIZE_SIX("身高/腰围"),//尺码：身高/腰围
	SIZE_SEVEN("尺码"),//尺码：尺码
	SIZE_EAIGHT("均码"),//尺码：均码
	SIZE_NINE("特殊码");//尺码：特殊码
	
	private String size;
	
	Rank(String size){
		this.size = size;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		String temp = StringUtil.lowerCase(super.toString());
		String cap = StringUtil.capitalize(String.valueOf(temp.charAt(5)));
		temp = StringUtil.replace(temp,temp.substring(4, 6) , cap);
		return temp;
	}
	

}

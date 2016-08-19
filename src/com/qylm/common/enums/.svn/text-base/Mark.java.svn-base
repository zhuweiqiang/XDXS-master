package com.qylm.common.enums;



/**
 * 
 * <ul>
 * <li>1：购物车</li>
 * <li>2：订单生成</li>
 * <li>3：正常发货</li>
 * <li>4：缺货</li>
 * <li>5：无条件退货</li>
 * <li>6：质量退货</li>
 * <ul>
 */
public enum Mark {
	
	SHOPCART("购物车"),
	GENERATE("订单生成"),
	COMFIRMED("确认订单"),
	INVALID("订单作废"),
	PAYMENT("付款成功"),
	NORMAL("正常发货"),
	QUALITYRETURNS("质量退货"),
	QUALITYRPRICE("质量退款"),
	UNCONDITIONALRETURNS("无条件退货"),
	UNCONDIPRICE("无条件退款"),
	OUTSTOCKPRICE("缺货退款"),//缺货自动退款
	TRANSACTION("交易成功");
	 //* 5:缺货退款
	//OUTSTOCK("缺货"),
	
	
	private String mark;
	
	Mark(String mark){
		this.mark = mark;
	}

	/**
	 * @return the size
	 */
	public String getMark() {
		return mark;
	}

}

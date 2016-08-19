package com.qylm.dto.history;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.MealBuyRecord;
import com.qylm.entity.MealBuyRecordDetail;
import com.qylm.entity.PersonnelInfo;
import com.qylm.entity.TemporaryActivity;
import com.qylm.entity.User;

/**
 * 保存客户套餐记录管理画面需要的值
 * @author smj
 */
public class HistoryTemporaryCreateDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5118929485827187522L;

	/**
	 * 客户档案
	 */
	private CustomInfo customInfo;
	
	/**
	 * 购买时间
	 */
	private Date date;
	
	/**
	 * 美容师
	 */
	private PersonnelInfo personnelInfo;
	
	/**
	 * 人事信息-顾问
	 */
	private PersonnelInfo adviser;
	
	/**
	 * 套餐次数
	 */
	private Integer number;
	
	/**
	 * 实耗金额
	 */
	private BigDecimal realityMoney;
	
	/**
	 * 状态
	 */
	private boolean state;
	
	/**
	 * 客户套餐记录详细列表
	 */
	private List<MealBuyRecordDetail> mealBuyRecordDetailList;
	
	/**
	 * 活动套餐
	 */
	private TemporaryActivity temporaryActivity;
	
	/**
	 * 搜索条件：临时套餐名
	 */
	private String temporaryActivityName;
	
	/**
	 * 创建事件
	 */
	private User creater;
	
	/**
	 * 上级
	 */
	private User belongingUser;
	
	/**
	 * 修改传值
	 */
	private MealBuyRecord transferMealBuyRecord;
	
	/**
	 * 返回共通方法
	 */
	private Returner<?, ?, ?> returner;

	/**
	 * @return the customInfo
	 */
	public CustomInfo getCustomInfo() {
		return customInfo;
	}

	/**
	 * @param customInfo the customInfo to set
	 */
	public void setCustomInfo(CustomInfo customInfo) {
		this.customInfo = customInfo;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the personnelInfo
	 */
	public PersonnelInfo getPersonnelInfo() {
		return personnelInfo;
	}

	/**
	 * @param personnelInfo the personnelInfo to set
	 */
	public void setPersonnelInfo(PersonnelInfo personnelInfo) {
		this.personnelInfo = personnelInfo;
	}

	/**
	 * @return the adviser
	 */
	public PersonnelInfo getAdviser() {
		return adviser;
	}

	/**
	 * @param adviser the adviser to set
	 */
	public void setAdviser(PersonnelInfo adviser) {
		this.adviser = adviser;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * @return the realityMoney
	 */
	public BigDecimal getRealityMoney() {
		return realityMoney;
	}

	/**
	 * @param realityMoney the realityMoney to set
	 */
	public void setRealityMoney(BigDecimal realityMoney) {
		this.realityMoney = realityMoney;
	}

	/**
	 * @return the state
	 */
	public boolean isState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(boolean state) {
		this.state = state;
	}

	/**
	 * @return the mealBuyRecordDetailList
	 */
	public List<MealBuyRecordDetail> getMealBuyRecordDetailList() {
		return mealBuyRecordDetailList;
	}

	/**
	 * @param mealBuyRecordDetailList the mealBuyRecordDetailList to set
	 */
	public void setMealBuyRecordDetailList(
			List<MealBuyRecordDetail> mealBuyRecordDetailList) {
		this.mealBuyRecordDetailList = mealBuyRecordDetailList;
	}

	/**
	 * @return the temporaryActivity
	 */
	public TemporaryActivity getTemporaryActivity() {
		return temporaryActivity;
	}

	/**
	 * @param temporaryActivity the temporaryActivity to set
	 */
	public void setTemporaryActivity(TemporaryActivity temporaryActivity) {
		this.temporaryActivity = temporaryActivity;
	}

	/**
	 * @return the temporaryActivityName
	 */
	public String getTemporaryActivityName() {
		return temporaryActivityName;
	}

	/**
	 * @param temporaryActivityName the temporaryActivityName to set
	 */
	public void setTemporaryActivityName(String temporaryActivityName) {
		this.temporaryActivityName = temporaryActivityName;
	}

	/**
	 * @return the creater
	 */
	public User getCreater() {
		return creater;
	}

	/**
	 * @param creater the creater to set
	 */
	public void setCreater(User creater) {
		this.creater = creater;
	}

	/**
	 * @return the belongingUser
	 */
	public User getBelongingUser() {
		return belongingUser;
	}

	/**
	 * @param belongingUser the belongingUser to set
	 */
	public void setBelongingUser(User belongingUser) {
		this.belongingUser = belongingUser;
	}

	/**
	 * @return the transferMealBuyRecord
	 */
	public MealBuyRecord getTransferMealBuyRecord() {
		return transferMealBuyRecord;
	}

	/**
	 * @param transferMealBuyRecord the transferMealBuyRecord to set
	 */
	public void setTransferMealBuyRecord(MealBuyRecord transferMealBuyRecord) {
		this.transferMealBuyRecord = transferMealBuyRecord;
	}

	/**
	 * @return the returner
	 */
	public Returner<?, ?, ?> getReturner() {
		return returner;
	}

	/**
	 * @param returner the returner to set
	 */
	public void setReturner(Returner<?, ?, ?> returner) {
		this.returner = returner;
	}

}

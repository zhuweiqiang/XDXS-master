package com.qylm.dto.myDesk;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.qylm.bean.returner.Returner;
import com.qylm.dto.custom.ConsumptionRegisterProjectDto;
import com.qylm.entity.ConsumptionRegisterDetail;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.MarketingProject;
import com.qylm.entity.PersonnelInfo;
import com.qylm.entity.User;

/**
 * 保存服务消费登陆画面需要的值
 * @author smj
 */
public class ServiceConsumptionDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3638392202956115753L;

	/**
	 * 客户档案
	 */
	private CustomInfo customInfo;
	
	/**
	 * 美容师
	 */
	private PersonnelInfo personnelInfo;
	
	/**
	 * 人事信息-顾问
	 */
	private PersonnelInfo adviser;
	
	/**
	 * 登记日期
	 */
	private Date date;
	
	/**
	 * 已付款
	 */
	private BigDecimal money;
	
	/**
	 * 欠款
	 */
	private BigDecimal arrearage;
	
	/**
	 * 实耗金额
	 */
	private BigDecimal realityMoney;
	
	/**
	 * 有效状态
	 * true:有效，反之无效
	 */
	private boolean state;
	
	/**
	 * 客户的卡项列表
	 */
	private List<CustomLeaguerDetail> customLeaguerDetailList;
	
	/**
	 * 服务项目列表
	 */
	private List<MarketingProject> marketingProjectList;
	
	/**
	 * 服务项目名称（搜索条件）
	 */
	private String marketingProjectName;
	
	/**
	 * 服务消费列表
	 */
	private List<ConsumptionRegisterDetail> consumptionRegisterDetailList;
	
	/**
	 * 已拥有的项目
	 */
	private List<ConsumptionRegisterProjectDto> consumptionRegisterProjectDtoList;
	
	/**
	 * 卡项列表下拉框
	 */
	private SelectItem[] customLeaguerDetailItems;
	
	/**
	 * 选中的卡项列表id
	 */
	private String customLeaguerDetailId;
	
	/**
	 * 卡额
	 */
	private BigDecimal leaguerMoney;
	
	/**
	 * 卡项支付
	 */
	private BigDecimal leaguerReadyMoney;
	
	/**
	 * 卡项折扣（百分比）
	 */
	private BigDecimal rebate;
	
	/**
	 * 折后金额
	 */
	private BigDecimal rebateMoney;
	
	/**
	 * 服务消费总金额
	 */
	private BigDecimal sumMoney;
	
	/**
	 * 余额支付
	 */
	private BigDecimal balance;
	
	/**
	 * 付款后还需要支付金额
	 */
	private BigDecimal surplusMoney;
	
	/**
	 * 计算出已支付的金额
	 */
	private BigDecimal sumPayMoney;
	
	/**
	 * 现金
	 */
	private BigDecimal readyMoney;

	/**
	 * 创建事件
	 */
	private User creater;
	
	/**
	 * 上级
	 */
	private User belongingUser;
	
	/**
	 * 返回共通方法
	 */
	private Returner<?, ?, ?> returner;
	
	/**
	 * 当前页
	 */
	private int currentPage = 1;
	
	/**
	 * 共有几页
	 */
	private int pageCount = 1;

	/**
	 * 一页多少条数据
	 */
	private int onePageCount = 10;

	/**
	 * 数据总数
	 */
	private int dataCount = 0;
	
	/**
	 * 用数据总条数初始化界面
	 * @param dataCount 数据总条数
	 */
	public void init(int dataCount) {
		this.dataCount = dataCount;
		initPageCount();
		currentPage = 1;
	}
	
	/**
	 * 计算总共有多少页
	 */
	private void initPageCount() {
		if (dataCount <= onePageCount) {
			pageCount = 1;
		} else {
			if (dataCount % onePageCount == 0) {
				pageCount = dataCount / onePageCount;
			} else {
				pageCount = dataCount / onePageCount + 1;
			}
		}
	}

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
	 * @return the money
	 */
	public BigDecimal getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	/**
	 * @return the arrearage
	 */
	public BigDecimal getArrearage() {
		return arrearage;
	}

	/**
	 * @param arrearage the arrearage to set
	 */
	public void setArrearage(BigDecimal arrearage) {
		this.arrearage = arrearage;
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
	 * @return the customLeaguerDetailList
	 */
	public List<CustomLeaguerDetail> getCustomLeaguerDetailList() {
		return customLeaguerDetailList;
	}

	/**
	 * @param customLeaguerDetailList the customLeaguerDetailList to set
	 */
	public void setCustomLeaguerDetailList(
			List<CustomLeaguerDetail> customLeaguerDetailList) {
		this.customLeaguerDetailList = customLeaguerDetailList;
	}

	/**
	 * @return the marketingProjectList
	 */
	public List<MarketingProject> getMarketingProjectList() {
		return marketingProjectList;
	}

	/**
	 * @param marketingProjectList the marketingProjectList to set
	 */
	public void setMarketingProjectList(List<MarketingProject> marketingProjectList) {
		this.marketingProjectList = marketingProjectList;
	}

	/**
	 * @return the marketingProjectName
	 */
	public String getMarketingProjectName() {
		return marketingProjectName;
	}

	/**
	 * @param marketingProjectName the marketingProjectName to set
	 */
	public void setMarketingProjectName(String marketingProjectName) {
		this.marketingProjectName = marketingProjectName;
	}

	/**
	 * @return the consumptionRegisterDetailList
	 */
	public List<ConsumptionRegisterDetail> getConsumptionRegisterDetailList() {
		return consumptionRegisterDetailList;
	}

	/**
	 * @param consumptionRegisterDetailList the consumptionRegisterDetailList to set
	 */
	public void setConsumptionRegisterDetailList(
			List<ConsumptionRegisterDetail> consumptionRegisterDetailList) {
		this.consumptionRegisterDetailList = consumptionRegisterDetailList;
	}

	/**
	 * @return the consumptionRegisterProjectDtoList
	 */
	public List<ConsumptionRegisterProjectDto> getConsumptionRegisterProjectDtoList() {
		return consumptionRegisterProjectDtoList;
	}

	/**
	 * @param consumptionRegisterProjectDtoList the consumptionRegisterProjectDtoList to set
	 */
	public void setConsumptionRegisterProjectDtoList(
			List<ConsumptionRegisterProjectDto> consumptionRegisterProjectDtoList) {
		this.consumptionRegisterProjectDtoList = consumptionRegisterProjectDtoList;
	}

	/**
	 * @return the customLeaguerDetailItems
	 */
	public SelectItem[] getCustomLeaguerDetailItems() {
		return customLeaguerDetailItems;
	}

	/**
	 * @param customLeaguerDetailItems the customLeaguerDetailItems to set
	 */
	public void setCustomLeaguerDetailItems(SelectItem[] customLeaguerDetailItems) {
		this.customLeaguerDetailItems = customLeaguerDetailItems;
	}

	/**
	 * @return the customLeaguerDetailId
	 */
	public String getCustomLeaguerDetailId() {
		return customLeaguerDetailId;
	}

	/**
	 * @param customLeaguerDetailId the customLeaguerDetailId to set
	 */
	public void setCustomLeaguerDetailId(String customLeaguerDetailId) {
		this.customLeaguerDetailId = customLeaguerDetailId;
	}

	/**
	 * @return the leaguerMoney
	 */
	public BigDecimal getLeaguerMoney() {
		return leaguerMoney;
	}

	/**
	 * @param leaguerMoney the leaguerMoney to set
	 */
	public void setLeaguerMoney(BigDecimal leaguerMoney) {
		this.leaguerMoney = leaguerMoney;
	}

	/**
	 * @return the leaguerReadyMoney
	 */
	public BigDecimal getLeaguerReadyMoney() {
		return leaguerReadyMoney;
	}

	/**
	 * @param leaguerReadyMoney the leaguerReadyMoney to set
	 */
	public void setLeaguerReadyMoney(BigDecimal leaguerReadyMoney) {
		this.leaguerReadyMoney = leaguerReadyMoney;
	}

	/**
	 * @return the rebate
	 */
	public BigDecimal getRebate() {
		return rebate;
	}

	/**
	 * @param rebate the rebate to set
	 */
	public void setRebate(BigDecimal rebate) {
		this.rebate = rebate;
	}

	/**
	 * @return the rebateMoney
	 */
	public BigDecimal getRebateMoney() {
		return rebateMoney;
	}

	/**
	 * @param rebateMoney the rebateMoney to set
	 */
	public void setRebateMoney(BigDecimal rebateMoney) {
		this.rebateMoney = rebateMoney;
	}

	/**
	 * @return the sumMoney
	 */
	public BigDecimal getSumMoney() {
		return sumMoney;
	}

	/**
	 * @param sumMoney the sumMoney to set
	 */
	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getSurplusMoney() {
		return surplusMoney;
	}

	public void setSurplusMoney(BigDecimal surplusMoney) {
		this.surplusMoney = surplusMoney;
	}

	public BigDecimal getSumPayMoney() {
		return sumPayMoney;
	}

	public void setSumPayMoney(BigDecimal sumPayMoney) {
		this.sumPayMoney = sumPayMoney;
	}

	public BigDecimal getReadyMoney() {
		return readyMoney;
	}

	public void setReadyMoney(BigDecimal readyMoney) {
		this.readyMoney = readyMoney;
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

	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return the onePageCount
	 */
	public int getOnePageCount() {
		return onePageCount;
	}

	/**
	 * @param onePageCount the onePageCount to set
	 */
	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
	}

	/**
	 * @return the dataCount
	 */
	public int getDataCount() {
		return dataCount;
	}

	/**
	 * @param dataCount the dataCount to set
	 */
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

}

package com.qylm.bean.custom;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.custom.ProjectBuyCreateDto;
import com.qylm.dxo.ProjectBuyCreateDxo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.ProjectBuy;
import com.qylm.entity.ProjectBuyDetail;
import com.qylm.service.CustomLeaguerDetailService;
import com.qylm.service.ProjectBuyDetailService;
import com.qylm.service.ProjectBuyService;

/**
 * 项目购买登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ProjectBuyCreateBean implements Serializable, CreateBean<ProjectBuy> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8807154735714619914L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ProjectBuyCreateBean.class);

	/**
	 * 存放项目购买登陆画面需要保存的值
	 */
	private ProjectBuyCreateDto projectBuyCreateDto = new ProjectBuyCreateDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件业务类
	 */
	@ManagedProperty(value="#{projectBuyService}")
	private ProjectBuyService projectBuyService;
	
	/**
	 * 事件详细业务类
	 */
	@ManagedProperty(value="#{projectBuyDetailService}")
	private ProjectBuyDetailService projectBuyDetailService;
	
	/**
	 * 客户与卡项关系业务类
	 */
	@ManagedProperty(value="#{customLeaguerDetailService}")
	private CustomLeaguerDetailService customLeaguerDetailService;
	
	/**
	 * 此方法绑定于项目购买登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 项目购买登陆画面
	 */
	public String newProjectBuy() {
		Tool.sendLog(LOG, userBean, "【项目购买登陆画面_新建按钮】");
		projectBuyCreateDto.setCustomInfo(null);
		projectBuyCreateDto.setDate(DateUtil.getNowyyyymmdd());
		projectBuyCreateDto.setMoney(null);
		projectBuyCreateDto.setPersonnelInfo(null);
		projectBuyCreateDto.setAdviser(null);
		projectBuyCreateDto.setState(false);
		projectBuyCreateDto.setBalance(null);
		projectBuyCreateDto.setSurplusMoney(null);
		projectBuyCreateDto.setSumMoney(null);
		projectBuyCreateDto.setReadyMoney(null);
		projectBuyCreateDto.setCustomLeaguerDetailList(null);
		projectBuyCreateDto.setProjectBuyDetailList(null);
		projectBuyCreateDto.setCreater(null);
		projectBuyCreateDto.setBelongingUser(null);
		projectBuyCreateDto.setTransferProjectBuy(null);
		return Navigation.PROJECT_BUY_CREATE;
	}
	
	/**
	 * 此方法绑定于项目购买登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【项目购买登陆画面_返回按钮】");
		return projectBuyCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于项目购买登陆画面的保存按钮 
	 * 实现功能：根据transferProjectBuy对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveProjectBuy() {
		Tool.sendLog(LOG, userBean, "【项目购买登陆画面_保存按钮】");
		ProjectBuy transferProjectBuy = projectBuyCreateDto.getTransferProjectBuy();
		operate(transferProjectBuy);
	}

	/**
	 * 进行保存或者更新操作
	 * @param transferProjectBuy
	 */
	private void operate(ProjectBuy transferProjectBuy) {
		List<ProjectBuyDetail> projectBuyDetailList = projectBuyCreateDto.getProjectBuyDetailList();
		if (projectBuyDetailList == null || projectBuyDetailList.isEmpty()) {
			Tool.sendErrorMessage("必须设定活动项目！");
			return;
		}
		if (transferProjectBuy == null) {
			transferProjectBuy = new ProjectBuy();
			projectBuyCreateDto.setCreater(userBean.getUser());
			projectBuyCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferProjectBuy);
			transferProjectBuy.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			projectBuyService.saveProjectBuy(transferProjectBuy, projectBuyDetailList);
			projectBuyCreateDto.setTransferProjectBuy(transferProjectBuy);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferProjectBuy);
			transferProjectBuy.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			projectBuyService.updateProjectBuy(transferProjectBuy, projectBuyDetailList);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferProjectBuy
	 */
	private void create(ProjectBuy transferProjectBuy) {
		List<ProjectBuyDetail> projectBuyDetailList = projectBuyCreateDto.getProjectBuyDetailList();
		for (ProjectBuyDetail projectBuyDetail : projectBuyDetailList) {
			projectBuyDetail.setProjectBuy(transferProjectBuy);
			projectBuyDetail.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			projectBuyDetail.setCreater(userBean.getUser());
			projectBuyDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			projectBuyDetail.setSurplusNumber(projectBuyDetail.getNumber());
		}
		ProjectBuyCreateDxo.dtoToEntity(projectBuyCreateDto, transferProjectBuy);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		projectBuyCreateDto.setReturner(returner);
		projectBuyCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		return Navigation.PROJECT_BUY_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, ProjectBuy projectBuy) {
		projectBuyCreateDto.setReturner(returner);
		ProjectBuyCreateDxo.entityToDto(projectBuy, projectBuyCreateDto);
		projectBuyCreateDto.setTransferProjectBuy(projectBuy);
		// 查询出项目购买详细
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProjectBuyDetail.class);
		detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY, ProjectBuyDetail.PROJECT_BUY, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuyDetail.MARKETING_PROJECT, ProjectBuyDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ProjectBuyDetail.PROJECT_BUY, projectBuy));
		projectBuyCreateDto.setProjectBuyDetailList(projectBuyDetailService.getByDetachedCriteria(detachedCriteria));
		sumMoney();
		return Navigation.PROJECT_BUY_CREATE;
	}
	
	/**
	 * 清空选择到的项目
	 */
	public void clearMarketingProject() {
		// 获取当前客户下所有的卡项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomLeaguerDetail.class);
		detachedCriteria.createAlias(CustomLeaguerDetail.CUSTOM_INFO, CustomLeaguerDetail.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.LEAGUER, CustomLeaguerDetail.LEAGUER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.GIVE_INFO, CustomLeaguerDetail.GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(CustomLeaguerDetail.CUSTOM_INFO, projectBuyCreateDto.getCustomInfo()));
		detachedCriteria.add(Restrictions.gt(CustomLeaguerDetail.MONEY, Constants.BIGDECIMAL_ZERO));
		detachedCriteria.addOrder(Order.desc(CustomLeaguerDetail.LEAGUER));
		projectBuyCreateDto.setCustomLeaguerDetailList(customLeaguerDetailService.getByDetachedCriteria(detachedCriteria));
	}
	
	/**
	 * 此方法绑定于项目购买登陆画面的增加一行活动项目按钮 
	 * @return 画面不跳转
	 */
	public void addProjectBuy() {
		Tool.sendLog(LOG, userBean, "【项目购买登陆画面_增加一行活动项目按钮】");
		List<ProjectBuyDetail> projectBuyDetailList = projectBuyCreateDto.getProjectBuyDetailList();
		if (projectBuyDetailList == null) {
			projectBuyDetailList = new ArrayList<ProjectBuyDetail>();
			projectBuyCreateDto.setProjectBuyDetailList(projectBuyDetailList);
		}
		ProjectBuyDetail projectBuyDetail = new ProjectBuyDetail();
		projectBuyDetail.setNumber(1);
		projectBuyDetailList.add(projectBuyDetail);
	}
	
	/**
	 * 此方法绑定于项目购买登陆画面的删除按钮 
	 * @return 画面不跳转
	 */
	public void deleteProjectBuy(ProjectBuyDetail projectBuyDetail) {
		Tool.sendLog(LOG, userBean, "【项目购买登陆画面_删除按钮】");
		if (projectBuyDetail.getId() != null) {
			projectBuyDetailService.deleteEntity(projectBuyDetail);
		}
		projectBuyCreateDto.getProjectBuyDetailList().remove(projectBuyDetail);
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 自动计算总金额
	 */
	public void getSumMoney() {
		sumMoney();
	}
	
	/**
	 * 统计总金额
	 */
	private void sumMoney() {
		List<ProjectBuyDetail> projectBuyDetailList = projectBuyCreateDto.getProjectBuyDetailList();
		BigDecimal sumMoney = Constants.BIGDECIMAL_ZERO;
		for (ProjectBuyDetail projectBuyDetail : projectBuyDetailList) {
			Integer number = projectBuyDetail.getNumber() == null ? 1 : projectBuyDetail.getNumber();
			System.out.println(projectBuyDetail.getMoney());
			sumMoney = BigDecimalUtil.add(sumMoney, BigDecimalUtil.multiply(new BigDecimal(number.toString()), projectBuyDetail.getMoney()));
		}
		projectBuyCreateDto.setMoney(sumMoney);
	}
	
	/**
	 * 选中项目之后，自动填写数量，及价值
	 * @param marketingProject
	 */
	public void findMarketingProject(ProjectBuyDetail projectBuyDetail) {
		projectBuyDetail.setMoney(projectBuyDetail.getMarketingProject().getMoney());
		sumMoney();
	}
	
	/**
	 * 此方法绑定于服务消费登陆画面的选择付款按钮 
	 * @return 画面不跳转
	 */
	public void findPay() {
		Tool.sendLog(LOG, userBean, "按下【服务消费登陆画面_选择付款按钮】");
		BigDecimal money = projectBuyCreateDto.getCustomInfo().getMoney();
		if (BigDecimalUtil.bigThan(money, projectBuyCreateDto.getMoney())) {
			projectBuyCreateDto.setBalance(projectBuyCreateDto.getMoney());
		} else {
			projectBuyCreateDto.setBalance(money);
		}
		getSurplusMoney();
	}
	
	/**
	 * 此方法绑定于服务消费登陆画面的确认付款按钮 
	 * @return 画面不跳转
	 */
	public void queryPay() {
		Tool.sendLog(LOG, userBean, "按下【服务消费登陆画面_确认付款按钮】");
		List<ProjectBuyDetail> projectBuyDetailList = projectBuyCreateDto.getProjectBuyDetailList();
		if (projectBuyDetailList == null || projectBuyDetailList.isEmpty()) {
			Tool.sendErrorMessage("必须选择套餐");
			return;
		}
		// 验证付款金额是否超出了需要支付的金额
		if (BigDecimalUtil.bigThan(projectBuyCreateDto.getSumMoney(), projectBuyCreateDto.getMoney())) {
			Tool.sendErrorMessage("多付钱了，请确认！");
			return;
		}
		projectBuyCreateDto.setCreater(userBean.getUser());
		projectBuyCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
		projectBuyCreateDto.setState(true);
		ProjectBuy projectBuy = new ProjectBuy();
		create(projectBuy);
		projectBuyService.savePay(projectBuy, 
				projectBuyCreateDto.getBalance(),
				projectBuyCreateDto.getReadyMoney(),
				projectBuyCreateDto.getCustomLeaguerDetailList(),
				projectBuyCreateDto.getProjectBuyDetailList());
		newProjectBuy();
		Tool.sendErrorMessage("付款成功！");
	}
	
	/**
	 * 获取付款后，计算出还需要付款的金额
	 */
	public void getSurplusMoney() {
		BigDecimal sumMoney = Constants.BIGDECIMAL_ZERO;
		// 获取充值卡付款记录
		if (BigDecimalUtil.isNotNullOrZero(projectBuyCreateDto.getBalance())) {
			sumMoney = BigDecimalUtil.add(sumMoney, projectBuyCreateDto.getBalance());
		}
		// 获取现金付款记录
		if (BigDecimalUtil.isNotNullOrZero(projectBuyCreateDto.getReadyMoney())) {
			sumMoney = BigDecimalUtil.add(sumMoney, projectBuyCreateDto.getReadyMoney());
		}
		// 获取充值卡付款记录
		List<CustomLeaguerDetail> customLeaguerDetailList = projectBuyCreateDto.getCustomLeaguerDetailList();
		for (CustomLeaguerDetail customLeaguerDetail : customLeaguerDetailList) {
			sumMoney = BigDecimalUtil.add(sumMoney, customLeaguerDetail.getReadyMoney());
		}
		// 总金额-已经付款的金额=还需要支付的金额
		projectBuyCreateDto.setSumMoney(sumMoney);
		projectBuyCreateDto.setSurplusMoney(BigDecimalUtil.subtract(projectBuyCreateDto.getMoney(), sumMoney));
	}
	
	/**
	 * @param customLeaguerDetailService the customLeaguerDetailService to set
	 */
	public void setCustomLeaguerDetailService(
			CustomLeaguerDetailService customLeaguerDetailService) {
		this.customLeaguerDetailService = customLeaguerDetailService;
	}

	/**
	 * @param projectBuyDetailService the projectBuyDetailService to set
	 */
	public void setProjectBuyDetailService(
			ProjectBuyDetailService projectBuyDetailService) {
		this.projectBuyDetailService = projectBuyDetailService;
	}

	/**
	 * set projectBuyService
	 * @param projectBuyService the projectBuyService to set
	 */
	public void setProjectBuyService(ProjectBuyService projectBuyService) {
		this.projectBuyService = projectBuyService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get projectBuyCreateDto
	 * @return the projectBuyCreateDto
	 */
	public ProjectBuyCreateDto getProjectBuyCreateDto() {
		return projectBuyCreateDto;
	}

	/**
	 * set projectBuyCreateDto
	 * @param projectBuyCreateDto the projectBuyCreateDto to set
	 */
	public void setProjectBuyCreateDto(ProjectBuyCreateDto projectBuyCreateDto) {
		this.projectBuyCreateDto = projectBuyCreateDto;
	}

}

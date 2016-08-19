package com.qylm.bean.custom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.dto.custom.ConsumptionRegisterCreateDto;
import com.qylm.dto.custom.ConsumptionRegisterProjectDto;
import com.qylm.dxo.ConsumptionRegisterCreateDxo;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.ConsumptionRegisterDetail;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.LargessRecord;
import com.qylm.entity.MarketingProject;
import com.qylm.entity.MealBuyRecordDetail;
import com.qylm.entity.ProjectBuyDetail;
import com.qylm.service.ConsumptionRegisterDetailService;
import com.qylm.service.ConsumptionRegisterService;
import com.qylm.service.LargessRecordService;
import com.qylm.service.MarketingProjectService;
import com.qylm.service.MealBuyRecordDetailService;
import com.qylm.service.ProjectBuyDetailService;

/**
 * 个人消费登记登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ConsumptionRegisterCreateBean implements Serializable, CreateBean<ConsumptionRegister> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6037240078125707908L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ConsumptionRegisterCreateBean.class);

	/**
	 * 存放个人消费登记登陆画面需要保存的值
	 */
	private ConsumptionRegisterCreateDto consumptionRegisterCreateDto = new ConsumptionRegisterCreateDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件业务类
	 */
	@ManagedProperty(value="#{consumptionRegisterService}")
	private ConsumptionRegisterService consumptionRegisterService;
	
	/**
	 * 事件详细业务类
	 */
	@ManagedProperty(value="#{consumptionRegisterDetailService}")
	private ConsumptionRegisterDetailService consumptionRegisterDetailService;
	
	/**
	 * 赠送项目记录业务类
	 */
	@ManagedProperty(value="#{largessRecordService}")
	private LargessRecordService largessRecordService;
	
	/**
	 * 套餐购买详细记录业务类
	 */
	@ManagedProperty(value="#{mealBuyRecordDetailService}")
	private MealBuyRecordDetailService mealBuyRecordDetailService;
	
	/**
	 * 项目购买详细记录业务类
	 */
	@ManagedProperty(value="#{projectBuyDetailService}")
	private ProjectBuyDetailService projectBuyDetailService;
	
	/**
	 * 项目业务类
	 */
	@ManagedProperty(value="#{marketingProjectService}")
	private MarketingProjectService marketingProjectService;
	
	/**
	 * 此方法绑定于个人消费登记登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 个人消费登记登陆画面
	 */
	public String newConsumptionRegister() {
		Tool.sendLog(LOG, userBean, "【个人消费登记登陆画面_新建按钮】");
		consumptionRegisterCreateDto.setCustomInfo(null);
		consumptionRegisterCreateDto.setPersonnelInfo(null);
		consumptionRegisterCreateDto.setAdviser(null);
		consumptionRegisterCreateDto.setDate(DateUtil.getNowyyyymmdd());
		consumptionRegisterCreateDto.setMoney(null);
		consumptionRegisterCreateDto.setRealityMoney(null);
		consumptionRegisterCreateDto.setDebt(null);
		consumptionRegisterCreateDto.setState(false);
		consumptionRegisterCreateDto.setConsumptionRegisterDetailList(null);
		consumptionRegisterCreateDto.setConsumptionRegisterProjectDtoList(null);
		consumptionRegisterCreateDto.setDtoList(null);
		consumptionRegisterCreateDto.setSumMoney(null);
		consumptionRegisterCreateDto.setCreater(null);
		consumptionRegisterCreateDto.setBelongingUser(null);
		consumptionRegisterCreateDto.setTransferConsumptionRegister(null);
		return Navigation.CONSUMPTION_REGISTER_CREATE;
	}
	
	/**
	 * 此方法绑定于个人消费登记登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【个人消费登记登陆画面_返回按钮】");
		return consumptionRegisterCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于个人消费登记登陆画面的保存按钮 
	 * 实现功能：根据transferConsumptionRegister对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveConsumptionRegister() {
		Tool.sendLog(LOG, userBean, "【个人消费登记登陆画面_保存按钮】");
		ConsumptionRegister transferConsumptionRegister = consumptionRegisterCreateDto.getTransferConsumptionRegister();
		operate(transferConsumptionRegister);
	}
	

	/**
	 * 此方法绑定于个人消费登记登陆画面的确认按钮 
	 * 实现功能：根据transferConsumptionRegister对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void queryConsumptionRegister() {
		Tool.sendLog(LOG, userBean, "【个人消费登记登陆画面_确认按钮】");
		ConsumptionRegister transferConsumptionRegister = consumptionRegisterCreateDto.getTransferConsumptionRegister();
		consumptionRegisterCreateDto.setState(true);
		operate(transferConsumptionRegister);
	}

	/**
	 * 进行保存或者更新操作
	 * @param transferConsumptionRegister
	 */
	private void operate(ConsumptionRegister transferConsumptionRegister) {
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = consumptionRegisterCreateDto.getConsumptionRegisterDetailList();
		if (consumptionRegisterDetailList == null || consumptionRegisterDetailList.isEmpty()) {
			Tool.sendErrorMessage("必须设定活动项目！");
			return;
		}
		if (transferConsumptionRegister == null) {
			transferConsumptionRegister = new ConsumptionRegister();
			consumptionRegisterCreateDto.setCreater(userBean.getUser());
			consumptionRegisterCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferConsumptionRegister);
			transferConsumptionRegister.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			consumptionRegisterService.saveConsumptionRegister(transferConsumptionRegister, consumptionRegisterDetailList);
			consumptionRegisterCreateDto.setTransferConsumptionRegister(transferConsumptionRegister);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferConsumptionRegister);
			transferConsumptionRegister.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			consumptionRegisterService.updateConsumptionRegister(transferConsumptionRegister, consumptionRegisterDetailList);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferConsumptionRegister
	 */
	private void create(ConsumptionRegister transferConsumptionRegister) {
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = consumptionRegisterCreateDto.getConsumptionRegisterDetailList();
		for (ConsumptionRegisterDetail consumptionRegisterDetail : consumptionRegisterDetailList) {
			consumptionRegisterDetail.setConsumptionRegister(transferConsumptionRegister);
			consumptionRegisterDetail.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			consumptionRegisterDetail.setCreater(userBean.getUser());
			consumptionRegisterDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
		}
		ConsumptionRegisterCreateDxo.dtoToEntity(consumptionRegisterCreateDto, transferConsumptionRegister);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		consumptionRegisterCreateDto.setReturner(returner);
		consumptionRegisterCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		return Navigation.CONSUMPTION_REGISTER_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, ConsumptionRegister consumptionRegister) {
		consumptionRegisterCreateDto.setReturner(returner);
		ConsumptionRegisterCreateDxo.entityToDto(consumptionRegister, consumptionRegisterCreateDto);
		consumptionRegisterCreateDto.setTransferConsumptionRegister(consumptionRegister);
		// 查询出个人消费登记详细
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ConsumptionRegisterDetail.class);
		detachedCriteria.createAlias(ConsumptionRegisterDetail.MARKETING_PROJECT, ConsumptionRegisterDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConsumptionRegisterDetail.PRODUCT_STOCK, ConsumptionRegisterDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConsumptionRegisterDetail.TEMPORARY_ACTIVITY, ConsumptionRegisterDetail.TEMPORARY_ACTIVITY, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConsumptionRegisterDetail.CUSTOMLEAGUER_DATEIL, ConsumptionRegisterDetail.CUSTOMLEAGUER_DATEIL, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConsumptionRegisterDetail.CUSTOMLEAGUER_DATEIL_LEAGUER, ConsumptionRegisterDetail.CUSTOMLEAGUER_DATEIL_LEAGUER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConsumptionRegisterDetail.CUSTOMLEAGUER_DATEIL_GIVE_INFO, ConsumptionRegisterDetail.CUSTOMLEAGUER_DATEIL_GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConsumptionRegisterDetail.PROJECT_BUY_DETAIL, ConsumptionRegisterDetail.PROJECT_BUY_DETAIL, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConsumptionRegisterDetail.PROJECT_BUY_DETAIL_MARKETING_PROJECT, ConsumptionRegisterDetail.PROJECT_BUY_DETAIL_MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ConsumptionRegisterDetail.CONSUMPTION_REGISTER, consumptionRegister));
		consumptionRegisterCreateDto.setConsumptionRegisterDetailList(consumptionRegisterDetailService.getByDetachedCriteria(detachedCriteria));
		return Navigation.CONSUMPTION_REGISTER_CREATE;
	}
	
	/**
	 * 此方法绑定于个人消费登记登陆画面的删除按钮 
	 * @return 画面不跳转
	 */
	public void deleteConsumptionRegister(ConsumptionRegisterDetail consumptionRegisterDetail) {
		Tool.sendLog(LOG, userBean, "【个人消费登记登陆画面_删除按钮】");
		if (consumptionRegisterDetail.getId() != null) {
			consumptionRegisterDetailService.deleteEntity(consumptionRegisterDetail);
		}
		consumptionRegisterCreateDto.getConsumptionRegisterDetailList().remove(consumptionRegisterDetail);
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 此方法绑定于个人消费登记登陆画面的项目按钮 
	 * @return 画面不跳转
	 */
	public void findMarketingProject() {
		Tool.sendLog(LOG, userBean, "按下【个人消费登记登陆画面_选择已购买的项目按钮】");
		CustomInfo customInfo = consumptionRegisterCreateDto.getCustomInfo();
		if (customInfo == null) {
			Tool.sendErrorMessage("客户档案必须选择");
			return;
		}
		List<ConsumptionRegisterProjectDto> list = new ArrayList<ConsumptionRegisterProjectDto>();
		ConsumptionRegisterProjectDto dto;
		// 获取到所有付款项目
		List<MarketingProject> marketingProjectList = marketingProjectService.getAll();
		for (MarketingProject marketingProject : marketingProjectList) {
			dto = new ConsumptionRegisterProjectDto();
			dto.setId(marketingProject.getId());
			dto.setType(ConsumptionRegisterProjectDto.TYPE_1);
			dto.setMarketingProject(marketingProject);
			list.add(dto);
		}
		// 获取所有当前客户已拥有的项目
		// 查询项目赠送记录
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LargessRecord.class);
		detachedCriteria.createAlias(LargessRecord.CUSTOM_INFO, LargessRecord.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(LargessRecord.MARKETING_PROJECT, LargessRecord.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(LargessRecord.CUSTOM_INFO, customInfo));
		List<LargessRecord> largessRecordList = largessRecordService.getByDetachedCriteria(detachedCriteria);
		for (LargessRecord largessRecord : largessRecordList) {
			dto = new ConsumptionRegisterProjectDto();
			dto.setId(largessRecord.getId());
			dto.setType(ConsumptionRegisterProjectDto.TYPE_2);
			dto.setMarketingProject(largessRecord.getMarketingProject());
			dto.setNumber(largessRecord.getNumber());
			list.add(dto);
		}
		// 查询套餐购买记录
		detachedCriteria = DetachedCriteria.forClass(MealBuyRecordDetail.class);
		detachedCriteria.createAlias(MealBuyRecordDetail.MEAL_BUY_RECORD, MealBuyRecordDetail.MEAL_BUY_RECORD, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecordDetail.MARKETING_PROJECT, MealBuyRecordDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecordDetail.MEAL_BUY_RECORD_CUSTOMINFO, MealBuyRecordDetail.MEAL_BUY_RECORD_CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(MealBuyRecordDetail.MEAL_BUY_RECORD_CUSTOMINFO, customInfo));
		List<MealBuyRecordDetail> mealBuyRecordDetailList = mealBuyRecordDetailService.getByDetachedCriteria(detachedCriteria);
		for (MealBuyRecordDetail mealBuyRecordDetail : mealBuyRecordDetailList) {
			dto = new ConsumptionRegisterProjectDto();
			dto.setId(mealBuyRecordDetail.getId());
			dto.setType(ConsumptionRegisterProjectDto.TYPE_3);
			dto.setMarketingProject(mealBuyRecordDetail.getMarketingProject());
			dto.setNumber(mealBuyRecordDetail.getNumber());
			list.add(dto);
		}
		// 项目购买记录
		detachedCriteria = DetachedCriteria.forClass(ProjectBuyDetail.class);
		detachedCriteria.createAlias(ProjectBuyDetail.MARKETING_PROJECT, ProjectBuyDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY, ProjectBuyDetail.PROJECT_BUY, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, customInfo));
		List<ProjectBuyDetail> projectBuyDetailList = projectBuyDetailService.getByDetachedCriteria(detachedCriteria);
		for (ProjectBuyDetail projectBuyDetail : projectBuyDetailList) {
			dto = new ConsumptionRegisterProjectDto();
			dto.setId(projectBuyDetail.getId());
			dto.setType(ConsumptionRegisterProjectDto.TYPE_4);
			dto.setMarketingProject(projectBuyDetail.getMarketingProject());
			dto.setNumber(projectBuyDetail.getNumber());
			list.add(dto);
		}
		consumptionRegisterCreateDto.setConsumptionRegisterProjectDtoList(list);
	}
	
	/**
	 * 此方法绑定于个人消费登记登陆画面的选择按钮 
	 * @return 画面不跳转
	 */
	public void findMarketingProjects(ConsumptionRegisterProjectDto consumptionRegisterProjectDto) {
		Tool.sendLog(LOG, userBean, "按下【个人消费登记登陆画面_选择按钮】");
		List<ConsumptionRegisterProjectDto> dtoList = consumptionRegisterCreateDto.getDtoList();
		if (dtoList == null) {
			dtoList = new ArrayList<ConsumptionRegisterProjectDto>();
			consumptionRegisterCreateDto.setDtoList(dtoList);
		}
		dtoList.add(consumptionRegisterProjectDto);
		consumptionRegisterCreateDto.getConsumptionRegisterProjectDtoList().remove(consumptionRegisterProjectDto);
	}
	
	/**
	 * 此方法绑定于个人消费登记登陆画面的确认并关闭按钮 
	 * @return 画面不跳转
	 */
	public void queryCloce() {
		Tool.sendLog(LOG, userBean, "按下【个人消费登记登陆画面_确认并关闭按钮】");
		List<ConsumptionRegisterProjectDto> dtoList = consumptionRegisterCreateDto.getDtoList();
		Collections.sort(dtoList);
		if (dtoList != null && !dtoList.isEmpty()) {
			List<ConsumptionRegisterDetail> consumptionRegisterDetailList = new ArrayList<ConsumptionRegisterDetail>();
			ConsumptionRegisterDetail consumptionRegisterDetail;
			for (ConsumptionRegisterProjectDto dto : dtoList) {
				consumptionRegisterDetail = new ConsumptionRegisterDetail();
				consumptionRegisterDetail.setMarketingProject(dto.getMarketingProject());
				consumptionRegisterDetailList.add(consumptionRegisterDetail);
			}
			consumptionRegisterCreateDto.setConsumptionRegisterDetailList(consumptionRegisterDetailList);
		}
	}
	
	/**
	 * 清空选择到的项目
	 */
	public void clearMarketingProject() {
		consumptionRegisterCreateDto.setMoney(consumptionRegisterCreateDto.getCustomInfo().getMoney());
		consumptionRegisterCreateDto.setRealityMoney(null);
		consumptionRegisterCreateDto.setSumMoney(null);
		consumptionRegisterCreateDto.setConsumptionRegisterDetailList(null);
		consumptionRegisterCreateDto.setConsumptionRegisterProjectDtoList(null);
	}

	/**
	 * @param marketingProjectService the marketingProjectService to set
	 */
	public void setMarketingProjectService(
			MarketingProjectService marketingProjectService) {
		this.marketingProjectService = marketingProjectService;
	}

	/**
	 * @param projectBuyDetailService the projectBuyDetailService to set
	 */
	public void setProjectBuyDetailService(
			ProjectBuyDetailService projectBuyDetailService) {
		this.projectBuyDetailService = projectBuyDetailService;
	}

	/**
	 * @param mealBuyRecordDetailService the mealBuyRecordDetailService to set
	 */
	public void setMealBuyRecordDetailService(
			MealBuyRecordDetailService mealBuyRecordDetailService) {
		this.mealBuyRecordDetailService = mealBuyRecordDetailService;
	}

	/**
	 * @param largessRecordService the largessRecordService to set
	 */
	public void setLargessRecordService(LargessRecordService largessRecordService) {
		this.largessRecordService = largessRecordService;
	}
	
	/**
	 * @param consumptionRegisterDetailService the consumptionRegisterDetailService to set
	 */
	public void setConsumptionRegisterDetailService(
			ConsumptionRegisterDetailService consumptionRegisterDetailService) {
		this.consumptionRegisterDetailService = consumptionRegisterDetailService;
	}

	/**
	 * set consumptionRegisterService
	 * @param consumptionRegisterService the consumptionRegisterService to set
	 */
	public void setConsumptionRegisterService(ConsumptionRegisterService consumptionRegisterService) {
		this.consumptionRegisterService = consumptionRegisterService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get consumptionRegisterCreateDto
	 * @return the consumptionRegisterCreateDto
	 */
	public ConsumptionRegisterCreateDto getConsumptionRegisterCreateDto() {
		return consumptionRegisterCreateDto;
	}

	/**
	 * set consumptionRegisterCreateDto
	 * @param consumptionRegisterCreateDto the consumptionRegisterCreateDto to set
	 */
	public void setConsumptionRegisterCreateDto(ConsumptionRegisterCreateDto consumptionRegisterCreateDto) {
		this.consumptionRegisterCreateDto = consumptionRegisterCreateDto;
	}

}

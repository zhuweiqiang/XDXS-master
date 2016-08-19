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
import com.qylm.dto.custom.ConsumptionRegisterProjectDto;
import com.qylm.dto.custom.ConversionTreatmentCreateDto;
import com.qylm.dxo.ConversionTreatmentCreateDxo;
import com.qylm.entity.ConversionTreatment;
import com.qylm.entity.ConversionTreatmentDetail;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.LargessRecord;
import com.qylm.entity.MealBuyRecordDetail;
import com.qylm.entity.ProjectBuyDetail;
import com.qylm.service.ConversionTreatmentDetailService;
import com.qylm.service.ConversionTreatmentService;
import com.qylm.service.LargessRecordService;
import com.qylm.service.MealBuyRecordDetailService;
import com.qylm.service.ProjectBuyDetailService;

/**
 * 疗程转换登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ConversionTreatmentCreateBean implements Serializable, CreateBean<ConversionTreatment> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8983411355704526895L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ConversionTreatmentCreateBean.class);

	/**
	 * 存放疗程转换登陆画面需要保存的值
	 */
	private ConversionTreatmentCreateDto conversionTreatmentCreateDto = new ConversionTreatmentCreateDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 疗程转换业务类
	 */
	@ManagedProperty(value="#{conversionTreatmentService}")
	private ConversionTreatmentService conversionTreatmentService;
	
	/**
	 * 疗程转换详细业务类
	 */
	@ManagedProperty(value="#{conversionTreatmentDetailService}")
	private ConversionTreatmentDetailService conversionTreatmentDetailService;
	
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
	 * 此方法绑定于疗程转换登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 疗程转换登陆画面
	 */
	public String newConversionTreatment() {
		Tool.sendLog(LOG, userBean, "【疗程转换登陆画面_新建按钮】");
		conversionTreatmentCreateDto.setCustomInfo(null);
		conversionTreatmentCreateDto.setPersonnelInfo(null);
		conversionTreatmentCreateDto.setAdviser(null);
		conversionTreatmentCreateDto.setDate(DateUtil.getNowyyyymmdd());
		conversionTreatmentCreateDto.setState(false);
		conversionTreatmentCreateDto.setConversionTreatmentDetailList(null);
		conversionTreatmentCreateDto.setCreater(null);
		conversionTreatmentCreateDto.setBelongingUser(null);
		conversionTreatmentCreateDto.setTransferConversionTreatment(null);
		conversionTreatmentCreateDto.setConsumptionRegisterProjectDtoList(null);
		conversionTreatmentCreateDto.setSumFindMoney(null);
		return Navigation.CONVERSION_TREATMENT_CREATE;
	}
	
	/**
	 * 此方法绑定于疗程转换登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【疗程转换登陆画面_返回按钮】");
		return conversionTreatmentCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于疗程转换登陆画面的保存按钮 
	 * 实现功能：根据transferConversionTreatment对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveConversionTreatment() {
		Tool.sendLog(LOG, userBean, "【疗程转换登陆画面_保存按钮】");
		// 验证转换的次数是否正确
		List<ConversionTreatmentDetail> conversionTreatmentDetailList = conversionTreatmentCreateDto.getConversionTreatmentDetailList();
		if (conversionTreatmentDetailList == null || conversionTreatmentDetailList.isEmpty()) {
			Tool.sendErrorMessage("请选择转换疗程");
			return;
		}
		int i = 1;
		boolean state = false;
		for (ConversionTreatmentDetail conversionTreatmentDetail : conversionTreatmentDetailList) {
			if ((conversionTreatmentDetail.getNumber() > conversionTreatmentDetail.getSurplusNumber()) 
					|| conversionTreatmentDetail.getNumber() == null) {
				state = true;
				Tool.sendErrorMessage("第" + i + "行，疗程转换次数有误，请重新选择！");
				i++;
			}
		}
		if (state) {
			return;
		}
		conversionTreatmentCreateDto.setCreater(userBean.getUser());
		conversionTreatmentCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
		conversionTreatmentCreateDto.setState(true);
		ConversionTreatment conversionTreatment = new ConversionTreatment();
		create(conversionTreatment);
		conversionTreatment.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
		conversionTreatmentService.saveConversionTreatment(conversionTreatment, conversionTreatmentCreateDto.getConversionTreatmentDetailList());
		Tool.sendErrorMessage("疗程转换成功！");
		newConversionTreatment();
	}
	
	/**
	 * 赋值
	 * @param transferConversionTreatment
	 */
	private void create(ConversionTreatment transferConversionTreatment) {
		List<ConversionTreatmentDetail> conversionTreatmentDetailList = conversionTreatmentCreateDto.getConversionTreatmentDetailList();
		for (ConversionTreatmentDetail conversionTreatmentDetail : conversionTreatmentDetailList) {
			conversionTreatmentDetail.setConversionTreatment(transferConversionTreatment);
			conversionTreatmentDetail.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			conversionTreatmentDetail.setCreater(userBean.getUser());
			conversionTreatmentDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
		}
		ConversionTreatmentCreateDxo.dtoToEntity(conversionTreatmentCreateDto, transferConversionTreatment);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		conversionTreatmentCreateDto.setReturner(returner);
		conversionTreatmentCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		return Navigation.CONVERSION_TREATMENT_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, ConversionTreatment conversionTreatment) {
		conversionTreatmentCreateDto.setReturner(returner);
		ConversionTreatmentCreateDxo.entityToDto(conversionTreatment, conversionTreatmentCreateDto);
		conversionTreatmentCreateDto.setTransferConversionTreatment(conversionTreatment);
		// 查询出疗程转换详细
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ConversionTreatmentDetail.class);
		detachedCriteria.createAlias(ConversionTreatmentDetail.MARKETING_PROJECT, ConversionTreatmentDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConversionTreatmentDetail.CONVERSION_TREATMENT, ConversionTreatmentDetail.CONVERSION_TREATMENT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ConversionTreatmentDetail.CONVERSION_TREATMENT, conversionTreatment));
		conversionTreatmentCreateDto.setConversionTreatmentDetailList(conversionTreatmentDetailService.getByDetachedCriteria(detachedCriteria));
		return Navigation.CONVERSION_TREATMENT_CREATE;
	}
	
	/**
	 * 清空选择到的项目
	 */
	public void clearMarketingProject() {
		// 获取当前客户下所有的卡项
		conversionTreatmentCreateDto.setState(false);
		conversionTreatmentCreateDto.setConversionTreatmentDetailList(null);
		conversionTreatmentCreateDto.setCreater(null);
		conversionTreatmentCreateDto.setBelongingUser(null);
		conversionTreatmentCreateDto.setTransferConversionTreatment(null);
		conversionTreatmentCreateDto.setConsumptionRegisterProjectDtoList(null);
	}
	
	/**
	 * 选择已拥有的项目
	 */
	public void findMarketingProject() {
		Tool.sendLog(LOG, userBean, "【疗程转换登陆画面_选择已拥有项目按钮】");
		// 获取当前客户下所拥有的项目
		CustomInfo customInfo = conversionTreatmentCreateDto.getCustomInfo();
		List<ConsumptionRegisterProjectDto> list = new ArrayList<ConsumptionRegisterProjectDto>();
		ConsumptionRegisterProjectDto dto;
		// 查询项目赠送记录
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LargessRecord.class);
		detachedCriteria.createAlias(LargessRecord.CUSTOM_INFO, LargessRecord.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(LargessRecord.MARKETING_PROJECT, LargessRecord.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(LargessRecord.CUSTOM_INFO, customInfo));
		detachedCriteria.add(Restrictions.gt(LargessRecord.SURPLUS_NUMBER, 0));
		List<LargessRecord> largessRecordList = largessRecordService.getByDetachedCriteria(detachedCriteria);
		for (LargessRecord largessRecord : largessRecordList) {
			dto = new ConsumptionRegisterProjectDto();
			dto.setId(largessRecord.getId());
			dto.setType(ConsumptionRegisterProjectDto.TYPE_2);
			dto.setMarketingProject(largessRecord.getMarketingProject());
			dto.setNumber(largessRecord.getSurplusNumber());
			dto.setMoney(largessRecord.getMoney());
			list.add(dto);
		}
		// 查询套餐购买记录
		detachedCriteria = DetachedCriteria.forClass(MealBuyRecordDetail.class);
		detachedCriteria.createAlias(MealBuyRecordDetail.MEAL_BUY_RECORD, MealBuyRecordDetail.MEAL_BUY_RECORD, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecordDetail.MARKETING_PROJECT, MealBuyRecordDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecordDetail.MEAL_BUY_RECORD_CUSTOMINFO, MealBuyRecordDetail.MEAL_BUY_RECORD_CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.gt(MealBuyRecordDetail.SURPLUS_NUMBER, 0));
		detachedCriteria.add(Restrictions.eq(MealBuyRecordDetail.MEAL_BUY_RECORD_CUSTOMINFO, customInfo));
		List<MealBuyRecordDetail> mealBuyRecordDetailList = mealBuyRecordDetailService.getByDetachedCriteria(detachedCriteria);
		for (MealBuyRecordDetail mealBuyRecordDetail : mealBuyRecordDetailList) {
			dto = new ConsumptionRegisterProjectDto();
			dto.setId(mealBuyRecordDetail.getId());
			dto.setType(ConsumptionRegisterProjectDto.TYPE_3);
			dto.setMarketingProject(mealBuyRecordDetail.getMarketingProject());
			dto.setNumber(mealBuyRecordDetail.getSurplusNumber());
			dto.setMoney(mealBuyRecordDetail.getMoney());
			list.add(dto);
		}
		// 项目购买记录
		detachedCriteria = DetachedCriteria.forClass(ProjectBuyDetail.class);
		detachedCriteria.createAlias(ProjectBuyDetail.MARKETING_PROJECT, ProjectBuyDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY, ProjectBuyDetail.PROJECT_BUY, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.gt(ProjectBuyDetail.SURPLUS_NUMBER, 0));
		detachedCriteria.add(Restrictions.eq(ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, customInfo));
		List<ProjectBuyDetail> projectBuyDetailList = projectBuyDetailService.getByDetachedCriteria(detachedCriteria);
		for (ProjectBuyDetail projectBuyDetail : projectBuyDetailList) {
			dto = new ConsumptionRegisterProjectDto();
			dto.setId(projectBuyDetail.getId());
			dto.setType(ConsumptionRegisterProjectDto.TYPE_4);
			dto.setMarketingProject(projectBuyDetail.getMarketingProject());
			dto.setNumber(projectBuyDetail.getSurplusNumber());
			dto.setMoney(projectBuyDetail.getMoney());
			list.add(dto);
		}
		
		// 移除已经存在的
		List<ConversionTreatmentDetail> conversionTreatmentDetailList = conversionTreatmentCreateDto.getConversionTreatmentDetailList();
		if (conversionTreatmentDetailList != null && !conversionTreatmentDetailList.isEmpty()) {
			int size = list.size() - 1;
			for (int i = size; i >= 0; i--) {
				dto = list.get(i);
				for (ConversionTreatmentDetail conversionTreatmentDetail : conversionTreatmentDetailList) {
					if (dto.getType().equals(conversionTreatmentDetail.getType()) && dto.getId().equals(conversionTreatmentDetail.getTypeId())) {
						list.remove(i);
						break;
					}
				}
			}
		}
		conversionTreatmentCreateDto.setConsumptionRegisterProjectDtoList(list);
	}
	
	/**
	 * 选择已拥有的项目
	 */
	public void find(ConsumptionRegisterProjectDto consumptionRegisterProjectDto) {
		Tool.sendLog(LOG, userBean, "按下【疗程转换登陆画面_选择按钮】");
		List<ConversionTreatmentDetail> conversionTreatmentDetailList = conversionTreatmentCreateDto.getConversionTreatmentDetailList();
		if (conversionTreatmentDetailList == null) {
			conversionTreatmentDetailList = new ArrayList<ConversionTreatmentDetail>();
			conversionTreatmentCreateDto.setConversionTreatmentDetailList(conversionTreatmentDetailList);
		}
		ConversionTreatmentDetail conversionTreatmentDetail = new ConversionTreatmentDetail();
		conversionTreatmentDetail.setMarketingProject(consumptionRegisterProjectDto.getMarketingProject());
		conversionTreatmentDetail.setType(consumptionRegisterProjectDto.getType());
		conversionTreatmentDetail.setTypeId(consumptionRegisterProjectDto.getId());
		conversionTreatmentDetail.setNumber(consumptionRegisterProjectDto.getNumber());
		conversionTreatmentDetail.setSurplusNumber(consumptionRegisterProjectDto.getNumber());
		conversionTreatmentDetail.setMoney(consumptionRegisterProjectDto.getMoney());
		conversionTreatmentDetailList.add(conversionTreatmentDetail);
		conversionTreatmentCreateDto.getConsumptionRegisterProjectDtoList().remove(consumptionRegisterProjectDto);
	}
	
	/**
	 * 确认关闭选择
	 */
	public void queryClose() {
		Tool.sendLog(LOG, userBean, "按下【疗程转换登陆画面_确认并关闭按钮】");
		computeMoney();
	}
	
	/**
	 * 删除按钮
	 */
	public void deleteConversionTreatment(ConversionTreatmentDetail conversionTreatmentDetail) {
		Tool.sendLog(LOG, userBean, "按下【疗程转换登陆画面_删除按钮】");
		if (conversionTreatmentDetail.getId() != null) {
			conversionTreatmentDetailService.deleteEntity(conversionTreatmentDetail);
		}
		List<ConversionTreatmentDetail> conversionTreatmentDetailList = conversionTreatmentCreateDto.getConversionTreatmentDetailList();
		conversionTreatmentDetailList.remove(conversionTreatmentDetail);
		computeMoney();
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 计算总选择费用
	 */
	private void computeMoney() {
		List<ConversionTreatmentDetail> conversionTreatmentDetailList = conversionTreatmentCreateDto.getConversionTreatmentDetailList();
		if (conversionTreatmentDetailList != null && !conversionTreatmentDetailList.isEmpty()) {
			BigDecimal sumFindMoney = Constants.BIGDECIMAL_ZERO;
			for (ConversionTreatmentDetail conversionTreatmentDetail : conversionTreatmentDetailList) {
				sumFindMoney = BigDecimalUtil.add(sumFindMoney, conversionTreatmentDetail.getSumMoney());
			}
			conversionTreatmentCreateDto.setSumFindMoney(sumFindMoney);
		}
	}
	
	/**
	 * 计算总费用
	 */
	public void getSumMoney() {
		computeMoney();
	}
	
	/**
	 * @param largessRecordService the largessRecordService to set
	 */
	public void setLargessRecordService(LargessRecordService largessRecordService) {
		this.largessRecordService = largessRecordService;
	}

	/**
	 * @param mealBuyRecordDetailService the mealBuyRecordDetailService to set
	 */
	public void setMealBuyRecordDetailService(
			MealBuyRecordDetailService mealBuyRecordDetailService) {
		this.mealBuyRecordDetailService = mealBuyRecordDetailService;
	}

	/**
	 * @param projectBuyDetailService the projectBuyDetailService to set
	 */
	public void setProjectBuyDetailService(
			ProjectBuyDetailService projectBuyDetailService) {
		this.projectBuyDetailService = projectBuyDetailService;
	}

	/**
	 * @param conversionTreatmentDetailService the conversionTreatmentDetailService to set
	 */
	public void setConversionTreatmentDetailService(
			ConversionTreatmentDetailService conversionTreatmentDetailService) {
		this.conversionTreatmentDetailService = conversionTreatmentDetailService;
	}

	/**
	 * set conversionTreatmentService
	 * @param conversionTreatmentService the conversionTreatmentService to set
	 */
	public void setConversionTreatmentService(ConversionTreatmentService conversionTreatmentService) {
		this.conversionTreatmentService = conversionTreatmentService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get conversionTreatmentCreateDto
	 * @return the conversionTreatmentCreateDto
	 */
	public ConversionTreatmentCreateDto getConversionTreatmentCreateDto() {
		return conversionTreatmentCreateDto;
	}

	/**
	 * set conversionTreatmentCreateDto
	 * @param conversionTreatmentCreateDto the conversionTreatmentCreateDto to set
	 */
	public void setConversionTreatmentCreateDto(ConversionTreatmentCreateDto conversionTreatmentCreateDto) {
		this.conversionTreatmentCreateDto = conversionTreatmentCreateDto;
	}

}

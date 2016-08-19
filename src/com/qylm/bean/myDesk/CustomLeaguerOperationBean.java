package com.qylm.bean.myDesk;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.myDesk.CustomLeaguerOperationDto;
import com.qylm.dxo.CustomLeaguerOperationDxo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.CustomLeaguerOperation;
import com.qylm.entity.GiveInfo;
import com.qylm.service.CustomLeaguerDetailService;
import com.qylm.service.CustomLeaguerOperationService;
import com.qylm.service.GiveInfoService;

/**
 * 卡项操作登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class CustomLeaguerOperationBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6532207086034275117L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(CustomLeaguerOperationBean.class);

	/**
	 * 存放卡项操作登陆画面需要保存的值
	 */
	private CustomLeaguerOperationDto customLeaguerOperationDto = new CustomLeaguerOperationDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 卡项操作业务类
	 */
	@ManagedProperty(value="#{customLeaguerOperationService}")
	private CustomLeaguerOperationService customLeaguerOperationService;
	
	/**
	 * 客户档案与卡项业务类
	 */
	@ManagedProperty(value="#{customLeaguerDetailService}")
	private CustomLeaguerDetailService customLeaguerDetailService;
	
	/**
	 * 体验卡、现金卷、身体卷业务类
	 */
	@ManagedProperty(value="#{giveInfoService}")
	private GiveInfoService giveInfoService;
	
	/**
	 * 此方法绑定于卡项操作登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 卡项操作登陆画面
	 */
	public String newCustomLeaguerOperation() {
		Tool.sendLog(LOG, userBean, "【卡项操作登陆画面_新建按钮】");
		customLeaguerOperationDto.setCustomInfo(null);
		customLeaguerOperationDto.setPersonnelInfo(null);
		customLeaguerOperationDto.setAdviser(null);
		customLeaguerOperationDto.setCustomLeaguerDetail(null);
		customLeaguerOperationDto.setDeposit(null);
		customLeaguerOperationDto.setDate(DateUtil.getNowyyyymmdd());
		customLeaguerOperationDto.setMoney(null);
		customLeaguerOperationDto.setState(false);
		customLeaguerOperationDto.setRemark(null);
		customLeaguerOperationDto.setCustomLeaguerDetailId(null);
		customLeaguerOperationDto.setCustomLeaguerDetailItems(null);
		customLeaguerOperationDto.setDepositId(null);
		customLeaguerOperationDto.setDepositItems(null);
		customLeaguerOperationDto.setCreater(null);
		customLeaguerOperationDto.setBelongingUser(null);
		customLeaguerOperationDto.setType(null);
		if (customLeaguerOperationDto.isTypes()) {
			return Navigation.TURN_LEAGUER_OPERATION;
		}
		return Navigation.CUSTOM_LEAGUER_OPERATION;
	}
	
	/**
	 * 此方法绑定于卡项操作登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【卡项操作登陆画面_返回按钮】");
		return customLeaguerOperationDto.getReturner().returnOnly();
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		customLeaguerOperationDto.setReturner(returner);
		customLeaguerOperationDto.setDate(DateUtil.getNowyyyymmdd());
		return Navigation.CUSTOM_LEAGUER_OPERATION;
	}
	
	public String newTurnLeaguerOperation(Returner<?, ?, ?> returner) {
		customLeaguerOperationDto.setReturner(returner);
		customLeaguerOperationDto.setDate(DateUtil.getNowyyyymmdd());
		customLeaguerOperationDto.setTypes(true);
		return Navigation.TURN_LEAGUER_OPERATION;
	}
	
	/**
	 * 绑定确认退卡
	 */
	public void queryTK() {
		Tool.sendLog(LOG, userBean, "【卡项操作登陆画面_确认退卡按钮】");
		// 验证退款金额是否大于，卡额，如果大于卡额提示错误
		if (BigDecimalUtil.bigThan(customLeaguerOperationDto.getMoney(), customLeaguerOperationDto.getCustomLeaguerDetail().getMoney())) {
			Tool.sendErrorMessage("卡额不足不能进行退款！");
			return;
		}
		// 验证身体卷、现金卷是否消费过，消费过不能进行退款
		GiveInfo giveInfo = customLeaguerOperationDto.getCustomLeaguerDetail().getGiveInfo();
		if (giveInfo != null) {
			giveInfo = giveInfoService.getById(giveInfo.getId());
			if (giveInfo.getType().equals(GiveInfo.TYPE_2)) {
				if (BigDecimalUtil.bigThan(giveInfo.getMoney(), customLeaguerOperationDto.getMoney())) {
					Tool.sendErrorMessage("该现金卷已经消费过，不能进行退款！");
					return;
				}
			}
			if (giveInfo.getType().equals(GiveInfo.TYPE_3)) {
				if (BigDecimalUtil.bigThan(giveInfo.getMoney(), customLeaguerOperationDto.getMoney())) {
					Tool.sendErrorMessage("该身体卷已经消费过，不能进行退款！");
					return;
				}
			}
		}
		customLeaguerOperationDto.setState(true);
		customLeaguerOperationDto.setCreater(userBean.getUser());
		customLeaguerOperationDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
		CustomLeaguerOperation customLeaguerOperation = new CustomLeaguerOperation();
		CustomLeaguerOperationDxo.dtoToEntity(customLeaguerOperationDto, customLeaguerOperation);
		customLeaguerOperationService.saveCustomLeaguerOperationTK(customLeaguerOperation);
		if (CustomLeaguerOperation.TYPE_1.equals(customLeaguerOperation.getType())) {
			Tool.sendErrorMessage("已成功退款至充值卡！");
		} else {
			Tool.sendErrorMessage("已成功退款！");
		}
		newCustomLeaguerOperation();
	}
	
	/**
	 * 绑定确认转卡
	 */
	public void queryZK() {
		Tool.sendLog(LOG, userBean, "【卡项操作登陆画面_确认转卡按钮】");
		// 验证是否选择的是相同的卡
		if (customLeaguerOperationDto.getCustomLeaguerDetailId().equals(customLeaguerOperationDto.getDepositId())) {
			Tool.sendErrorMessage("不能选择相同的卡进行转换，因为无意义！");
			return;
		}
		if (StringUtil.isUnSelected(customLeaguerOperationDto.getDepositId())) {
			Tool.sendErrorMessage("不能进行转卡操作！");
			return;
		}
		customLeaguerOperationDto.setState(true);
		customLeaguerOperationDto.setCreater(userBean.getUser());
		customLeaguerOperationDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
		customLeaguerOperationDto.setDeposit(customLeaguerDetailService.getById(Integer.valueOf(customLeaguerOperationDto.getDepositId())));
		customLeaguerOperationDto.setType(CustomLeaguerOperation.TYPE_2);
		CustomLeaguerOperation customLeaguerOperation = new CustomLeaguerOperation();
		CustomLeaguerOperationDxo.dtoToEntity(customLeaguerOperationDto, customLeaguerOperation);
		customLeaguerOperationService.saveCustomLeaguerOperationZK(customLeaguerOperation);
		Tool.sendErrorMessage("已成功转卡！");
		newCustomLeaguerOperation();
	}
	
	/**
	 * 获取最新的客户卡项
	 */
	public void clearLeaguer() {
		// 获取当前客户下所有的卡项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomLeaguerDetail.class);
		detachedCriteria.createAlias(CustomLeaguerDetail.CUSTOM_INFO, CustomLeaguerDetail.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.LEAGUER, CustomLeaguerDetail.LEAGUER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.gt(CustomLeaguerDetail.MONEY, Constants.BIGDECIMAL_ZERO));
		detachedCriteria.add(Restrictions.eq(CustomLeaguerDetail.CUSTOM_INFO, customLeaguerOperationDto.getCustomInfo()));
		detachedCriteria.add(Restrictions.isNotNull(CustomLeaguerDetail.LEAGUER));
		List<CustomLeaguerDetail> customLeaguerDetailList = customLeaguerDetailService.getByDetachedCriteria(detachedCriteria);
		SelectItem[] customLeaguerDetailItems;
		SelectItem[] depositItems;
		if (!customLeaguerDetailList.isEmpty()) {
			int size = customLeaguerDetailList.size();
			depositItems = new SelectItem[size];
			customLeaguerDetailItems = new SelectItem[size];
			customLeaguerOperationDto.setCustomLeaguerDetail(customLeaguerDetailList.get(0));
			customLeaguerOperationDto.setMoney(customLeaguerOperationDto.getCustomLeaguerDetail().getMoney());
			for (int i = 0; i < size; i++) {
				CustomLeaguerDetail customLeaguerDetail = customLeaguerDetailList.get(i);
				String label;
				if (customLeaguerDetail.getLeaguer() != null) {
					label = customLeaguerDetail.getLeaguer().getLabel();
				} else {
					label = customLeaguerDetail.getGiveInfo().getLabel();
				}
				customLeaguerDetailItems[i] = new SelectItem(customLeaguerDetail.getId().toString(), label);
				depositItems[i] = new SelectItem(customLeaguerDetail.getId().toString(), label);
			}
		} else {
			customLeaguerDetailItems = new SelectItem[1];
			customLeaguerDetailItems[0] = Constants.UN_SELECT_ITEM;
			depositItems = new SelectItem[1];
			depositItems[0] = Constants.UN_SELECT_ITEM;
		}
		customLeaguerOperationDto.setCustomLeaguerDetailItems(customLeaguerDetailItems);
		customLeaguerOperationDto.setDepositItems(depositItems);
	}
	
	/**
	 * 获取选择卡项的余额
	 */
	public void clear() {
		CustomLeaguerDetail customLeaguerDetail = customLeaguerDetailService.getById(Integer.valueOf(customLeaguerOperationDto.getCustomLeaguerDetailId()));
		customLeaguerOperationDto.setCustomLeaguerDetail(customLeaguerDetail);
		customLeaguerOperationDto.setMoney(customLeaguerDetail.getMoney());
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomLeaguerDetail.class);
		detachedCriteria.createAlias(CustomLeaguerDetail.CUSTOM_INFO, CustomLeaguerDetail.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.LEAGUER, CustomLeaguerDetail.LEAGUER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.GIVE_INFO, CustomLeaguerDetail.GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(CustomLeaguerDetail.CUSTOM_INFO, customLeaguerOperationDto.getCustomInfo()));
		detachedCriteria.add(Restrictions.not(Restrictions.eq(CustomLeaguerDetail.BASE_ID, customLeaguerDetail.getId())));
		List<CustomLeaguerDetail> customLeaguerDetailList = customLeaguerDetailService.getByDetachedCriteria(detachedCriteria);
		if (customLeaguerDetailList.isEmpty()) {
			SelectItem[] depositItems = new SelectItem[1];
			depositItems[1] = new SelectItem("-1", "无卡可以转入");
			customLeaguerOperationDto.setDepositItems(depositItems);
		} else {
			int size = customLeaguerDetailList.size();
			SelectItem[] depositItems = new SelectItem[size];
			for (int i = 0; i < size; i++) {
				CustomLeaguerDetail detail = customLeaguerDetailList.get(i);
				String label;
				if (detail.getLeaguer() != null) {
					label = detail.getLeaguer().getLabel();
				} else {
					label = detail.getGiveInfo().getLabel();
				}
				depositItems[i] = new SelectItem(detail.getId().toString(), label);
			}
			customLeaguerOperationDto.setDepositItems(depositItems);
		}
	}
	
	/**
	 * @param giveInfoService the giveInfoService to set
	 */
	public void setGiveInfoService(GiveInfoService giveInfoService) {
		this.giveInfoService = giveInfoService;
	}

	/**
	 * @param customLeaguerDetailService the customLeaguerDetailService to set
	 */
	public void setCustomLeaguerDetailService(
			CustomLeaguerDetailService customLeaguerDetailService) {
		this.customLeaguerDetailService = customLeaguerDetailService;
	}

	/**
	 * @param customLeaguerOperationService the customLeaguerOperationService to set
	 */
	public void setCustomLeaguerOperationService(
			CustomLeaguerOperationService customLeaguerOperationService) {
		this.customLeaguerOperationService = customLeaguerOperationService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get customLeaguerOperationDto
	 * @return the customLeaguerOperationDto
	 */
	public CustomLeaguerOperationDto getCustomLeaguerOperationDto() {
		return customLeaguerOperationDto;
	}

	/**
	 * set customLeaguerOperationDto
	 * @param customLeaguerOperationDto the customLeaguerOperationDto to set
	 */
	public void setCustomLeaguerOperationDto(CustomLeaguerOperationDto customLeaguerOperationDto) {
		this.customLeaguerOperationDto = customLeaguerOperationDto;
	}

}

package com.qylm.bean.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.dao.DataIntegrityViolationException;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.custom.MarketingRecordManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.custom.MarketingRecordManageDto;
import com.qylm.entity.MarketingRecord;
import com.qylm.entity.MarketingRecordDetail;
import com.qylm.service.MarketingRecordDetailService;
import com.qylm.service.MarketingRecordService;

/**
 * 产品销售管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class MarketingRecordManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 49339142896605694L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(MarketingRecordManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private MarketingRecordManageDto marketingRecordManageDto = new MarketingRecordManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<MarketingRecord> marketingRecordList;
	
	/**
	 * 删除复选框选择的值
	 */
	private MarketingRecord[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 产品销售记录业务类
	 */
	@ManagedProperty(value="#{marketingRecordService}")
	private MarketingRecordService marketingRecordService;
	
	/**
	 * 产品销售记录详细业务类
	 */
	@ManagedProperty(value="#{marketingRecordDetailService}")
	private MarketingRecordDetailService marketingRecordDetailService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_产品销售菜单】");
		fetchData(0, true);
		return Navigation.MARKETING_RECORD_MANAGE;
	}
	
	/**
	 * 此方法绑定于产品销售管理画面的新建按钮 
	 * 实现功能：跳转至产品销售登陆画面，新建一家事件
	 * @return 产品销售登陆画面
	 */
	public String newMarketingRecord() {
		Tool.sendLog(LOG, userBean, "按下【产品销售管理画面_新建按钮】");
		return Tool.getBackBean(MarketingRecordCreateBean.class).newCreate(new MarketingRecordManageReturner(marketingRecordManageDto, currentPage));
	}

	/**
	 * 此方法绑定于产品销售管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至产品销售登陆画面
	 * @return 产品销售登陆画面
	 */
	public String updateMarketingRecord(MarketingRecord transferMarketingRecord) {
		Tool.sendLog(LOG, userBean, "按下【产品销售管理画面_修改按钮】");
		return Tool.getBackBean(MarketingRecordCreateBean.class).updateDetail(new MarketingRecordManageReturner(marketingRecordManageDto, currentPage), transferMarketingRecord);
	}
	
	/**
	 * 此方法绑定于产品销售管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectMarketingRecord() {
		Tool.sendLog(LOG, userBean, "按下【产品销售管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于产品销售管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【产品销售管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<MarketingRecord> asList = Arrays.asList(selectedModels);
				marketingRecordService.deleteEntityAll(asList);
				marketingRecordList.removeAll(asList);
				removeData(1, marketingRecordList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}

	/**
	 * 此方法绑定于产品销售管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteMarketingRecord(MarketingRecord transferMarketingRecord) {
		Tool.sendLog(LOG, userBean, "按下【产品销售管理画面的_删除按钮】");
		try {
			marketingRecordService.deleteEntity(transferMarketingRecord);
			marketingRecordList.remove(transferMarketingRecord);
			removeData(1, marketingRecordList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(MarketingRecord transferMarketingRecord) {
		Tool.sendLog(LOG, userBean, "按下【产品销售管理画面的_视图按钮】");
		if (transferMarketingRecord == null) {
			transferMarketingRecord = marketingRecordService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(MarketingRecordViewBean.class).viewDetail(transferMarketingRecord);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MarketingRecord.class);
		detachedCriteria.createAlias(MarketingRecord.CUSTOMINFO, MarketingRecord.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MarketingRecord.PERSONNEL_INFO, MarketingRecord.PERSONNEL_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MarketingRecord.ADVISER, MarketingRecord.ADVISER, JoinType.LEFT_OUTER_JOIN);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String name = marketingRecordManageDto.getName();
		Date beginDate = marketingRecordManageDto.getBeginDate();
		Date endDate = marketingRecordManageDto.getEndDate();
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(MarketingRecord.CUSTOMINFO_NAME, name, MatchMode.ANYWHERE));
		}
		if (beginDate != null) {
			detachedCriteria.add(Restrictions.ge(MarketingRecord.DATE, beginDate));
		}
		if (endDate != null) {
			detachedCriteria.add(Restrictions.le(MarketingRecord.DATE, endDate));
		}
		marketingRecordList = marketingRecordService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(marketingRecordService.getRowCount(detachedCriteria));
		}
		if (!marketingRecordList.isEmpty()) {
			detachedCriteria = DetachedCriteria.forClass(MarketingRecordDetail.class);
			detachedCriteria.createAlias(MarketingRecordDetail.MARKETING_RECORD, MarketingRecordDetail.MARKETING_RECORD, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(MarketingRecordDetail.PRODUCT_STOCK, MarketingRecordDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(MarketingRecordDetail.DEPOT_INFO, MarketingRecordDetail.DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.in(MarketingRecordDetail.MARKETING_RECORD, marketingRecordList));
			List<MarketingRecordDetail> detialList = marketingRecordDetailService.getByDetachedCriteria(detachedCriteria);
			for (MarketingRecord marketingRecord : marketingRecordList) {
				List<MarketingRecordDetail> marketingRecordDetailList = new ArrayList<MarketingRecordDetail>();
				for (MarketingRecordDetail marketingRecordDetail : detialList) {
					if (marketingRecord.equals(marketingRecordDetail.getMarketingRecord())) {
						marketingRecordDetailList.add(marketingRecordDetail);
					}
				}
				marketingRecord.setMarketingRecordDetailList(marketingRecordDetailList);
			}
		}
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.MARKETING_RECORD_MANAGE;
	}

	/**
	 * @param marketingRecordDetailService the marketingRecordDetailService to set
	 */
	public void setMarketingRecordDetailService(
			MarketingRecordDetailService marketingRecordDetailService) {
		this.marketingRecordDetailService = marketingRecordDetailService;
	}

	/**
	 * set marketingRecordService
	 * @param marketingRecordService the marketingRecordService to set
	 */
	public void setMarketingRecordService(MarketingRecordService marketingRecordService) {
		this.marketingRecordService = marketingRecordService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get marketingRecordManageDto
	 * @return the marketingRecordManageDto
	 */
	public MarketingRecordManageDto getMarketingRecordManageDto() {
		return marketingRecordManageDto;
	}

	/**
	 * set marketingRecordManageDto
	 * @param marketingRecordManageDto the marketingRecordManageDto to set
	 */
	public void setMarketingRecordManageDto(MarketingRecordManageDto marketingRecordManageDto) {
		this.marketingRecordManageDto = marketingRecordManageDto;
	}

	/**
	 * get marketingRecordList
	 * @return the marketingRecordList
	 */
	public List<MarketingRecord> getMarketingRecordList() {
		return marketingRecordList;
	}

	/**
	 * set marketingRecordList
	 * @param marketingRecordList the marketingRecordList to set
	 */
	public void setMarketingRecordList(List<MarketingRecord> marketingRecordList) {
		this.marketingRecordList = marketingRecordList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public MarketingRecord[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(MarketingRecord[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}

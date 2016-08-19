package com.qylm.bean.custom;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.common.MothedUtil;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.custom.MealBuyRecordSelectDto;
import com.qylm.entity.MealBuyRecord;
import com.qylm.service.MealBuyRecordService;

/**
 * 套餐购买记录查询
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class MealBuyRecordSelectBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2052593202108407875L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(MealBuyRecordSelectBean.class);
	
	/**
	 * 保存事件查询画面需要保存的值
	 */
	private MealBuyRecordSelectDto mealBuyRecordSelectDto = new MealBuyRecordSelectDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<MealBuyRecord> mealBuyRecordList;
	
	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件查询业务类
	 */
	@ManagedProperty(value="#{mealBuyRecordService}")
	private MealBuyRecordService mealBuyRecordService;
	
	/**
	 * 此方法绑定于套餐购买记录查询画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectMealBuyRecord() {
		Tool.sendLog(LOG, userBean, "按下【套餐购买记录查询画面_检索按钮】");
		fetchData(0, true);
	}
	
	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MealBuyRecord.class);
		detachedCriteria.createAlias(MealBuyRecord.CUSTOMINFO, MealBuyRecord.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecord.PERSONNEL_INFO, MealBuyRecord.PERSONNEL_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecord.ADVISER, MealBuyRecord.ADVISER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecord.TEMPORARY_ACTIVITY, MealBuyRecord.TEMPORARY_ACTIVITY, JoinType.LEFT_OUTER_JOIN);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String name = mealBuyRecordSelectDto.getName();
		String temporaryActivityName = mealBuyRecordSelectDto.getTemporaryActivityName();
		Date beginDate = mealBuyRecordSelectDto.getBeginDate();
		Date endDate = mealBuyRecordSelectDto.getEndDate();
		if (StringUtil.isNotBlank(temporaryActivityName)) {
			detachedCriteria.add(Restrictions.like(MealBuyRecord.TEMPORARY_ACTIVITY_NAME, temporaryActivityName, MatchMode.ANYWHERE));
		}
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(MealBuyRecord.CUSTOMINFO_NAME, name, MatchMode.ANYWHERE));
		}
		if (beginDate != null) {
			detachedCriteria.add(Restrictions.ge(MealBuyRecord.DATE, beginDate));
		}
		if (endDate != null) {
			detachedCriteria.add(Restrictions.le(MealBuyRecord.DATE, endDate));
		}
		mealBuyRecordList = mealBuyRecordService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(mealBuyRecordService.getRowCount(detachedCriteria));
		}
		
	}

	/**
	 * set mealBuyRecordService
	 * @param mealBuyRecordService the mealBuyRecordService to set
	 */
	public void setMealBuyRecordService(MealBuyRecordService mealBuyRecordService) {
		this.mealBuyRecordService = mealBuyRecordService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get mealBuyRecordSelectDto
	 * @return the mealBuyRecordSelectDto
	 */
	public MealBuyRecordSelectDto getMealBuyRecordSelectDto() {
		return mealBuyRecordSelectDto;
	}

	/**
	 * set mealBuyRecordSelectDto
	 * @param mealBuyRecordSelectDto the mealBuyRecordSelectDto to set
	 */
	public void setMealBuyRecordSelectDto(MealBuyRecordSelectDto mealBuyRecordSelectDto) {
		this.mealBuyRecordSelectDto = mealBuyRecordSelectDto;
	}

	/**
	 * get mealBuyRecordList
	 * @return the mealBuyRecordList
	 */
	public List<MealBuyRecord> getMealBuyRecordList() {
		return mealBuyRecordList;
	}

	/**
	 * set mealBuyRecordList
	 * @param mealBuyRecordList the mealBuyRecordList to set
	 */
	public void setMealBuyRecordList(List<MealBuyRecord> mealBuyRecordList) {
		this.mealBuyRecordList = mealBuyRecordList;
	}

}

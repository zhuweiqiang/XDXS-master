package com.qylm.bean.myDesk;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.dto.myDesk.LearnCardDto;
import com.qylm.entity.ConversionTreatment;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.GiveInfo;
import com.qylm.service.CustomLeaguerDetailService;

/**
 * 体验卡查询画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class LearnCardBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8219980713371466985L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(LearnCardBean.class);

	/**
	 * 存放体验卡查询画面需要保存的值
	 */
	private LearnCardDto learnCardDto = new LearnCardDto();
	
	/**
	 * 客户档案与卡项的关系列表（检索结果）
	 */
	private List<CustomLeaguerDetail> customLeaguerDetailList;
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 客户档案与卡项业务类
	 */
	@ManagedProperty(value="#{customLeaguerDetailService}")
	private CustomLeaguerDetailService customLeaguerDetailService;
	
	/**
	 * 此方法绑定于体验卡查询画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【体验卡查询画面_返回按钮】");
		return learnCardDto.getReturner().returnOnly();
	}

	public String select(Returner<?, ?, ?> returner) {
		learnCardDto.setReturner(returner);
		fetchData(0, true);
		return Navigation.LEARN_CARD;
	}
	
	/**
	 * 此方法绑定于疗程转换管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出疗程转换
	 * @return 画面不跳转
	 */
	public void selectConversionTreatment() {
		Tool.sendLog(LOG, userBean, "按下【体验卡查询画面_检索按钮】");
		fetchData(0, true);
	}
	
	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomLeaguerDetail.class);
		detachedCriteria.createAlias(CustomLeaguerDetail.CUSTOM_INFO, CustomLeaguerDetail.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.GIVE_INFO, CustomLeaguerDetail.GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(CustomLeaguerDetail.GIVE_INFO_TYPE, GiveInfo.TYPE_1));
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		CustomInfo customInfo = learnCardDto.getCustomInfo();
		Date beginDate = learnCardDto.getStartDate();
		Date endDate = learnCardDto.getEndDate();
		if (customInfo != null) {
			detachedCriteria.add(Restrictions.eq(ConversionTreatment.CUSTOMINFO, customInfo));
		}
		if (beginDate != null) {
			detachedCriteria.add(Restrictions.ge(ConversionTreatment.DATE, beginDate));
		}
		if (endDate != null) {
			detachedCriteria.add(Restrictions.le(ConversionTreatment.DATE, endDate));
		}
		customLeaguerDetailList = customLeaguerDetailService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(customLeaguerDetailService.getRowCount(detachedCriteria));
		}
	}

	/**
	 * @param customLeaguerDetailService the customLeaguerDetailService to set
	 */
	public void setCustomLeaguerDetailService(
			CustomLeaguerDetailService customLeaguerDetailService) {
		this.customLeaguerDetailService = customLeaguerDetailService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * @return the learnCardDto
	 */
	public LearnCardDto getLearnCardDto() {
		return learnCardDto;
	}

	/**
	 * @param learnCardDto the learnCardDto to set
	 */
	public void setLearnCardDto(LearnCardDto learnCardDto) {
		this.learnCardDto = learnCardDto;
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

}

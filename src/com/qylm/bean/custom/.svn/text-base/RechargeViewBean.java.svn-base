package com.qylm.bean.custom;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.common.Navigation;
import com.qylm.dto.custom.RechargeViewDto;
import com.qylm.dxo.RechargeViewDxo;
import com.qylm.entity.Recharge;
import com.qylm.service.RechargeService;

/**
 * 会员充值记录登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class RechargeViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4942128597381411010L;

	/**
	 * 存放会员充值记录登陆画面需要保存的值
	 */
	private RechargeViewDto rechargeViewDto = new RechargeViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{rechargeService}")
	private RechargeService rechargeService;
	
	/**
	 * 查看详细
	 * @param recharge
	 * @return
	 */
	public String viewDetail(Recharge recharge) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Recharge.class);
		detachedCriteria.createAlias(Recharge.CUSTOMINFO, Recharge.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(Recharge.CREATER, Recharge.CREATER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(Recharge.BASE_ID, recharge.getId()));
		List<Recharge> rechargeList = rechargeService.getByDetachedCriteria(detachedCriteria);
		if (!rechargeList.isEmpty()) {
			recharge = rechargeList.get(0);
			RechargeViewDxo.entityToDto(recharge, rechargeViewDto);
		}
		return Navigation.RECHARGE_VIEW;
	}
	
	/**
	 * @param rechargeService the rechargeService to set
	 */
	public void setRechargeService(RechargeService rechargeService) {
		this.rechargeService = rechargeService;
	}

	/**
	 * @return the rechargeViewDto
	 */
	public RechargeViewDto getRechargeViewDto() {
		return rechargeViewDto;
	}

	/**
	 * @param rechargeViewDto the rechargeViewDto to set
	 */
	public void setRechargeViewDto(RechargeViewDto rechargeViewDto) {
		this.rechargeViewDto = rechargeViewDto;
	}

}

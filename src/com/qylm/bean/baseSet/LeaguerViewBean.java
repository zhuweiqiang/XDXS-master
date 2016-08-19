package com.qylm.bean.baseSet;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.qylm.common.Navigation;
import com.qylm.dto.baseSet.LeaguerViewDto;
import com.qylm.dxo.LeaguerViewDxo;
import com.qylm.entity.Leaguer;
import com.qylm.service.LeaguerService;

/**
 * 卡项登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class LeaguerViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2727961120255999780L;

	/**
	 * 存放卡项登陆画面需要保存的值
	 */
	private LeaguerViewDto leaguerViewDto = new LeaguerViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{leaguerService}")
	private LeaguerService leaguerService;
	
	/**
	 * 查看详细
	 * @param leaguer
	 * @return
	 */
	public String viewDetail(Leaguer leaguer) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Leaguer.class);
		detachedCriteria.add(Restrictions.eq(Leaguer.BASE_ID, leaguer.getId()));
		List<Leaguer> leaguerList = leaguerService.getByDetachedCriteria(detachedCriteria);
		if (!leaguerList.isEmpty()) {
			leaguer = leaguerList.get(0);
			LeaguerViewDxo.entityToDto(leaguer, leaguerViewDto);
		}
		return Navigation.LEAGUER_VIEW;
	}
	
	/**
	 * @param leaguerService the leaguerService to set
	 */
	public void setLeaguerService(LeaguerService leaguerService) {
		this.leaguerService = leaguerService;
	}

	/**
	 * @return the leaguerViewDto
	 */
	public LeaguerViewDto getLeaguerViewDto() {
		return leaguerViewDto;
	}

	/**
	 * @param leaguerViewDto the leaguerViewDto to set
	 */
	public void setLeaguerViewDto(LeaguerViewDto leaguerViewDto) {
		this.leaguerViewDto = leaguerViewDto;
	}

}

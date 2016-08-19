package com.qylm.bean.depot;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.qylm.common.Navigation;
import com.qylm.dto.depot.DepotInfoViewDto;
import com.qylm.dxo.DepotInfoViewDxo;
import com.qylm.entity.DepotInfo;
import com.qylm.service.DepotInfoService;

/**
 * 仓库信息登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class DepotInfoViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3966990178950375905L;

	/**
	 * 存放仓库信息登陆画面需要保存的值
	 */
	private DepotInfoViewDto depotInfoViewDto = new DepotInfoViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{depotInfoService}")
	private DepotInfoService depotInfoService;
	
	/**
	 * 查看详细
	 * @param depotInfo
	 * @return
	 */
	public String viewDetail(DepotInfo depotInfo) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(DepotInfo.class);
		detachedCriteria.add(Restrictions.eq(DepotInfo.BASE_ID, depotInfo.getId()));
		List<DepotInfo> depotInfoList = depotInfoService.getByDetachedCriteria(detachedCriteria);
		if (!depotInfoList.isEmpty()) {
			depotInfo = depotInfoList.get(0);
			DepotInfoViewDxo.entityToDto(depotInfo, depotInfoViewDto);
		}
		return Navigation.DEPOT_INFO_VIEW;
	}
	
	/**
	 * @param depotInfoService the depotInfoService to set
	 */
	public void setDepotInfoService(DepotInfoService depotInfoService) {
		this.depotInfoService = depotInfoService;
	}

	/**
	 * @return the depotInfoViewDto
	 */
	public DepotInfoViewDto getDepotInfoViewDto() {
		return depotInfoViewDto;
	}

	/**
	 * @param depotInfoViewDto the depotInfoViewDto to set
	 */
	public void setDepotInfoViewDto(DepotInfoViewDto depotInfoViewDto) {
		this.depotInfoViewDto = depotInfoViewDto;
	}

}

package com.qylm.bean.personnel;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.qylm.common.Navigation;
import com.qylm.dto.personnel.PersonnelInfoViewDto;
import com.qylm.dxo.PersonnelInfoViewDxo;
import com.qylm.entity.PersonnelInfo;
import com.qylm.service.PersonnelInfoService;

/**
 * 人事信息登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class PersonnelInfoViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3966990178950375905L;

	/**
	 * 存放人事信息登陆画面需要保存的值
	 */
	private PersonnelInfoViewDto personnelInfoViewDto = new PersonnelInfoViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{personnelInfoService}")
	private PersonnelInfoService personnelInfoService;
	
	/**
	 * 查看详细
	 * @param personnelInfo
	 * @return
	 */
	public String viewDetail(PersonnelInfo personnelInfo) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PersonnelInfo.class);
		detachedCriteria.add(Restrictions.eq(PersonnelInfo.BASE_ID, personnelInfo.getId()));
		List<PersonnelInfo> personnelInfoList = personnelInfoService.getByDetachedCriteria(detachedCriteria);
		if (!personnelInfoList.isEmpty()) {
			personnelInfo = personnelInfoList.get(0);
			PersonnelInfoViewDxo.entityToDto(personnelInfo, personnelInfoViewDto);
		}
		return Navigation.PERSONNEL_INFO_VIEW;
	}
	
	/**
	 * @param personnelInfoService the personnelInfoService to set
	 */
	public void setPersonnelInfoService(PersonnelInfoService personnelInfoService) {
		this.personnelInfoService = personnelInfoService;
	}

	/**
	 * @return the personnelInfoViewDto
	 */
	public PersonnelInfoViewDto getPersonnelInfoViewDto() {
		return personnelInfoViewDto;
	}

	/**
	 * @param personnelInfoViewDto the personnelInfoViewDto to set
	 */
	public void setPersonnelInfoViewDto(PersonnelInfoViewDto personnelInfoViewDto) {
		this.personnelInfoViewDto = personnelInfoViewDto;
	}

}

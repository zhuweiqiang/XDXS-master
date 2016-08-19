package com.qylm.bean.returner.personnel;

import com.qylm.bean.personnel.PersonnelInfoManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.personnel.PersonnelInfoManageDto;
import com.qylm.entity.PersonnelInfo;

public class PersonnelInfoManageReturner extends Returner<PersonnelInfoManageBean, PersonnelInfoManageDto, PersonnelInfo> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4927319201230973400L;

	public PersonnelInfoManageReturner(PersonnelInfoManageDto personnelInfoManageDto, int currentPage) {
		super(personnelInfoManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(PersonnelInfoManageBean backBean) {
		backBean.setPersonnelInfoManageDto(super.dto);
		return backBean.back(currentPage);
	}

}

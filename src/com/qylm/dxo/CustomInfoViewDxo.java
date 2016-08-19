package com.qylm.dxo;

import com.qylm.dto.baseSet.CustomInfoViewDto;
import com.qylm.dto.history.HistoryArrearageViewDto;
import com.qylm.entity.CustomInfo;

public final class CustomInfoViewDxo {

	public static void dtoToEntity(CustomInfoViewDto dto, CustomInfo entity) {
		entity.setName(dto.getName());
		entity.setBirthday(dto.getBirthday());
		entity.setLeaguerNumber(dto.getLeaguerNumber());
		entity.setSpouse(dto.getSpouse());
		entity.setIssue(dto.getIssue());
		entity.setBloodGroup(dto.getBloodGroup());
		entity.setMaritalStatus(dto.getMaritalStatus());
		entity.setAddressEntity(dto.getAddressEntity());
		entity.setAddressDetail(dto.getAddressDetail());
		entity.setOccupation(dto.getOccupation());
		entity.setMobile(dto.getMobile());
		entity.setSkinType1(dto.getSkinType1());
		entity.setRemark(dto.getRemark());
		entity.setYearNumber(dto.getYearNumber());
		entity.setImpressions(dto.getImpressions());
		entity.setShiftShopCause(dto.getShiftShopCause());
		entity.setPurpose(dto.getPurpose());
		entity.setNurse(dto.getNurse());
		entity.setMoney(dto.getMoney());
		entity.setArrearage(dto.getArrearage());
		entity.setLeaguer(dto.getLeaguer());
		entity.setLeaguerSource(dto.getLeaguerSource());
		entity.setPersonnelInfo1(dto.getPersonnelInfo1());
		entity.setPersonnelInfo2(dto.getPersonnelInfo2());
	}

	public static void entityToDto(CustomInfo entity, CustomInfoViewDto dto) {
		dto.setName(entity.getName());
		dto.setBirthday(entity.getBirthday());
		dto.setLeaguerNumber(entity.getLeaguerNumber());
		dto.setSpouse(entity.getSpouse());
		dto.setIssue(entity.getIssue());
		dto.setBloodGroup(entity.getBloodGroup());
		dto.setMaritalStatus(entity.getMaritalStatus());
		dto.setAddressEntity(entity.getAddressEntity());
		dto.setAddressDetail(entity.getAddressDetail());
		dto.setOccupation(entity.getOccupation());
		dto.setMobile(entity.getMobile());
		dto.setSkinType1(entity.getSkinType1());
		dto.setRemark(entity.getRemark());
		dto.setYearNumber(entity.getYearNumber());
		dto.setImpressions(entity.getImpressions());
		dto.setShiftShopCause(entity.getShiftShopCause());
		dto.setPurpose(entity.getPurpose());
		dto.setNurse(entity.getNurse());
		dto.setMoney(entity.getMoney());
		dto.setArrearage(entity.getArrearage());
		dto.setLeaguer(entity.getLeaguer());
		dto.setLeaguerSource(entity.getLeaguerSource());
		dto.setPersonnelInfo1(entity.getPersonnelInfo1());
		dto.setPersonnelInfo2(entity.getPersonnelInfo2());
	}
	public static void entityToDto(CustomInfo entity, HistoryArrearageViewDto dto) {
		dto.setName(entity.getName());
		dto.setBirthday(entity.getBirthday());
		dto.setLeaguerNumber(entity.getLeaguerNumber());
		dto.setSpouse(entity.getSpouse());
		dto.setIssue(entity.getIssue());
		dto.setBloodGroup(entity.getBloodGroup());
		dto.setMaritalStatus(entity.getMaritalStatus());
		dto.setAddressEntity(entity.getAddressEntity());
		dto.setAddressDetail(entity.getAddressDetail());
		dto.setOccupation(entity.getOccupation());
		dto.setMobile(entity.getMobile());
		dto.setSkinType1(entity.getSkinType1());
		dto.setRemark(entity.getRemark());
		dto.setYearNumber(entity.getYearNumber());
		dto.setImpressions(entity.getImpressions());
		dto.setShiftShopCause(entity.getShiftShopCause());
		dto.setPurpose(entity.getPurpose());
		dto.setNurse(entity.getNurse());
		dto.setMoney(entity.getMoney());
		dto.setArrearage(entity.getArrearage());
		dto.setLeaguer(entity.getLeaguer());
		dto.setLeaguerSource(entity.getLeaguerSource());
		dto.setPersonnelInfo1(entity.getPersonnelInfo1());
		dto.setPersonnelInfo2(entity.getPersonnelInfo2());
	}	

}

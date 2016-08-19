package com.qylm.dxo;

import com.qylm.dto.baseSet.CustomInfoCreateDto;
import com.qylm.dto.history.HistoryArrearageCreateDto;
import com.qylm.entity.CustomInfo;

public final class CustomInfoCreateDxo {

	public static void dtoToEntity(CustomInfoCreateDto dto, CustomInfo entity) {
		entity.setName(dto.getName());
		entity.setBirthday(dto.getBirthday());
		entity.setLeaguerNumber(dto.getLeaguerNumber());
		entity.setSpouse(dto.getSpouse());
		entity.setIssue(dto.getIssue());
		entity.setBloodGroup(dto.getBloodGroup());
		entity.setMaritalStatus(dto.getMaritalStatus());
		entity.setMaritalDeta(dto.getMaritalDeta());
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
		entity.setEmergencyContact(dto.getEmergencyContact());
		entity.setEmergencyMobile(dto.getEmergencyMobile());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(CustomInfo entity, CustomInfoCreateDto customInfoCreateDto) {
		customInfoCreateDto.setName(entity.getName());
		customInfoCreateDto.setBirthday(entity.getBirthday());
		customInfoCreateDto.setLeaguerNumber(entity.getLeaguerNumber());
		customInfoCreateDto.setSpouse(entity.getSpouse());
		customInfoCreateDto.setIssue(entity.getIssue());
		customInfoCreateDto.setBloodGroup(entity.getBloodGroup());
		customInfoCreateDto.setMaritalStatus(entity.getMaritalStatus());
		customInfoCreateDto.setMaritalDeta(entity.getMaritalDeta());
		customInfoCreateDto.setAddressEntity(entity.getAddressEntity());
		customInfoCreateDto.setAddressDetail(entity.getAddressDetail());
		customInfoCreateDto.setOccupation(entity.getOccupation());
		customInfoCreateDto.setMobile(entity.getMobile());
		customInfoCreateDto.setSkinType1(entity.getSkinType1());
		customInfoCreateDto.setRemark(entity.getRemark());
		customInfoCreateDto.setYearNumber(entity.getYearNumber());
		customInfoCreateDto.setImpressions(entity.getImpressions());
		customInfoCreateDto.setShiftShopCause(entity.getShiftShopCause());
		customInfoCreateDto.setPurpose(entity.getPurpose());
		customInfoCreateDto.setNurse(entity.getNurse());
		customInfoCreateDto.setMoney(entity.getMoney());
		customInfoCreateDto.setArrearage(entity.getArrearage());
		customInfoCreateDto.setLeaguer(entity.getLeaguer());
		customInfoCreateDto.setLeaguerSource(entity.getLeaguerSource());
		customInfoCreateDto.setPersonnelInfo1(entity.getPersonnelInfo1());
		customInfoCreateDto.setPersonnelInfo2(entity.getPersonnelInfo2());
		customInfoCreateDto.setEmergencyContact(entity.getEmergencyContact());
		customInfoCreateDto.setEmergencyMobile(entity.getEmergencyMobile());
		customInfoCreateDto.setCreater(entity.getCreater());
		customInfoCreateDto.setBelongingUser(entity.getBelongingUser());
	}
	public static void entityToDto(CustomInfo entity, HistoryArrearageCreateDto customInfoCreateDto) {
		customInfoCreateDto.setName(entity.getName());
		customInfoCreateDto.setBirthday(entity.getBirthday());
		customInfoCreateDto.setLeaguerNumber(entity.getLeaguerNumber());
		customInfoCreateDto.setSpouse(entity.getSpouse());
		customInfoCreateDto.setIssue(entity.getIssue());
		customInfoCreateDto.setBloodGroup(entity.getBloodGroup());
		customInfoCreateDto.setMaritalStatus(entity.getMaritalStatus());
		customInfoCreateDto.setMaritalDeta(entity.getMaritalDeta());
		customInfoCreateDto.setAddressEntity(entity.getAddressEntity());
		customInfoCreateDto.setAddressDetail(entity.getAddressDetail());
		customInfoCreateDto.setOccupation(entity.getOccupation());
		customInfoCreateDto.setMobile(entity.getMobile());
		customInfoCreateDto.setSkinType1(entity.getSkinType1());
		customInfoCreateDto.setRemark(entity.getRemark());
		customInfoCreateDto.setYearNumber(entity.getYearNumber());
		customInfoCreateDto.setImpressions(entity.getImpressions());
		customInfoCreateDto.setShiftShopCause(entity.getShiftShopCause());
		customInfoCreateDto.setPurpose(entity.getPurpose());
		customInfoCreateDto.setNurse(entity.getNurse());
		customInfoCreateDto.setMoney(entity.getMoney());
		customInfoCreateDto.setArrearage(entity.getArrearage());
		customInfoCreateDto.setLeaguer(entity.getLeaguer());
		customInfoCreateDto.setLeaguerSource(entity.getLeaguerSource());
		customInfoCreateDto.setPersonnelInfo1(entity.getPersonnelInfo1());
		customInfoCreateDto.setPersonnelInfo2(entity.getPersonnelInfo2());
		customInfoCreateDto.setEmergencyContact(entity.getEmergencyContact());
		customInfoCreateDto.setEmergencyMobile(entity.getEmergencyMobile());
		customInfoCreateDto.setCreater(entity.getCreater());
		customInfoCreateDto.setBelongingUser(entity.getBelongingUser());
	}


}

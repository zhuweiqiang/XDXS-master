package com.qylm.dxo;

import com.qylm.dto.personnel.PersonnelInfoCreateDto;
import com.qylm.entity.PersonnelInfo;

public final class PersonnelInfoCreateDxo {

	public static void dtoToEntity(PersonnelInfoCreateDto dto, PersonnelInfo entity) {
		entity.setWorkNumber(dto.getWorkNumber());
		entity.setName(dto.getName());
		entity.setWorkState(dto.getWorkState());
		entity.setSex(dto.getSex());
		entity.setBirthDate(dto.getBirthDate());
		entity.setPoliticalStatus(dto.getPoliticalStatus());
		entity.setNation(dto.getNation());
		entity.setMarriage(dto.getMarriage());
		entity.setIdentification(dto.getIdentification());
		entity.setFormalSchooling(dto.getFormalSchooling());
		entity.setType(dto.getType());
		entity.setMobile(dto.getMobile());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(PersonnelInfo entity, PersonnelInfoCreateDto dto) {
		dto.setWorkNumber(entity.getWorkNumber());
		dto.setName(entity.getName());
		dto.setWorkState(entity.getWorkState());
		dto.setSex(entity.getSex());
		dto.setBirthDate(entity.getBirthDate());
		dto.setPoliticalStatus(entity.getPoliticalStatus());
		dto.setNation(entity.getNation());
		dto.setMarriage(entity.getMarriage());
		dto.setIdentification(entity.getIdentification());
		dto.setFormalSchooling(entity.getFormalSchooling());
		dto.setType(entity.getType());
		dto.setMobile(entity.getMobile());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}

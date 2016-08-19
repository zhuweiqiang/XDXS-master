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
import com.qylm.dto.custom.LargessRecordViewDto;
import com.qylm.dxo.LargessRecordViewDxo;
import com.qylm.entity.LargessRecord;
import com.qylm.service.LargessRecordService;

/**
 * 赠送项目记录登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class LargessRecordViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2685354912179124081L;

	/**
	 * 存放赠送项目记录登陆画面需要保存的值
	 */
	private LargessRecordViewDto largessRecordViewDto = new LargessRecordViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{largessRecordService}")
	private LargessRecordService largessRecordService;
	
	/**
	 * 查看详细
	 * @param largessRecord
	 * @return
	 */
	public String viewDetail(LargessRecord largessRecord) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LargessRecord.class);
		detachedCriteria.createAlias(LargessRecord.CUSTOM_INFO, LargessRecord.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(LargessRecord.MARKETING_PROJECT, LargessRecord.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(LargessRecord.PERSONNEL_INFO_1, LargessRecord.PERSONNEL_INFO_1, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(LargessRecord.PERSONNEL_INFO_2, LargessRecord.PERSONNEL_INFO_2, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(LargessRecord.CREATER, LargessRecord.CREATER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(LargessRecord.BASE_ID, largessRecord.getId()));
		List<LargessRecord> largessRecordList = largessRecordService.getByDetachedCriteria(detachedCriteria);
		if (!largessRecordList.isEmpty()) {
			largessRecord = largessRecordList.get(0);
			LargessRecordViewDxo.entityToDto(largessRecord, largessRecordViewDto);
		}
		return Navigation.LARGESS_RECORD_VIEW;
	}
	
	/**
	 * @param largessRecordService the largessRecordService to set
	 */
	public void setLargessRecordService(LargessRecordService largessRecordService) {
		this.largessRecordService = largessRecordService;
	}

	/**
	 * @return the largessRecordViewDto
	 */
	public LargessRecordViewDto getLargessRecordViewDto() {
		return largessRecordViewDto;
	}

	/**
	 * @param largessRecordViewDto the largessRecordViewDto to set
	 */
	public void setLargessRecordViewDto(LargessRecordViewDto largessRecordViewDto) {
		this.largessRecordViewDto = largessRecordViewDto;
	}

}

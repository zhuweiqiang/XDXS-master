package com.qylm.bean.returner.custom;

import com.qylm.bean.custom.LargessRecordManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.custom.LargessRecordManageDto;
import com.qylm.entity.LargessRecord;

public class LargessRecordManageReturner extends Returner<LargessRecordManageBean, LargessRecordManageDto, LargessRecord> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5492862056041845180L;

	public LargessRecordManageReturner(LargessRecordManageDto largessRecordManageDto, int currentPage) {
		super(largessRecordManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(LargessRecordManageBean backBean) {
		backBean.setLargessRecordManageDto(super.dto);
		return backBean.back(currentPage);
	}

}

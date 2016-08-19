package com.qylm.bean.returner.auditing;

import com.qylm.bean.auditing.AuditingSetManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.auditing.AuditingSetManageDto;
import com.qylm.entity.AuditingSet;

public class AuditingSetManageReturner extends Returner<AuditingSetManageBean, AuditingSetManageDto, AuditingSet> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4540098311768157557L;

	public <T> AuditingSetManageReturner(AuditingSetManageDto auditingSetManageDto, Integer firstResult) {
		super(auditingSetManageDto, firstResult);
	}

	@Override
	public String returnOnly(AuditingSetManageBean backBean) {
		return backBean.back(currentPage);
	}

}

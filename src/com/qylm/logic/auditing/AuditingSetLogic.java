package com.qylm.logic.auditing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.dao.AuditingSetDao;
import com.qylm.dao.AuditingSetDetailDao;
import com.qylm.entity.AuditingSet;
import com.qylm.entity.AuditingSetDetail;

public class AuditingSetLogic {

	@Autowired
	private AuditingSetDao auditingSetDao;
	
	@Autowired
	private AuditingSetDetailDao auditingSetDetailDao;
	
	public void saveAuditingSet(AuditingSet auditingSet,
			List<AuditingSetDetail> auditingSetDetailList) {
		auditingSetDao.saveEntity(auditingSet);
		auditingSetDetailDao.saveEntityAll(auditingSetDetailList);
	}

	public void updateAuditingSet(AuditingSet auditingSet,
			List<AuditingSetDetail> auditingSetDetailList) {
		auditingSetDao.updateEntity(auditingSet);
		String sql = "delete From AuditingSetDetail where auditingSetId = " + auditingSet.getId();
		auditingSetDetailDao.bulkUpdate(sql);
		auditingSetDetailDao.saveEntityAll(auditingSetDetailList);
	}
	
}

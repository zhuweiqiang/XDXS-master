package com.qylm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylm.dao.AuditingSetDao;
import com.qylm.entity.AuditingSet;
import com.qylm.entity.AuditingSetDetail;
import com.qylm.logic.auditing.AuditingSetLogic;

@Service("auditingSetService")
public class AuditingSetServiceImpl extends GenericServiceImpl<AuditingSet, Integer> implements AuditingSetService {

	@Autowired
	private AuditingSetLogic auditingSetLogic;

	@Autowired
	protected AuditingSetServiceImpl(AuditingSetDao auditingSetDao) {
		super(auditingSetDao);
	}

	public void saveAuditingSet(AuditingSet auditingSet,
			List<AuditingSetDetail> auditingSetDetailList) {
		auditingSetLogic.saveAuditingSet(auditingSet, auditingSetDetailList);
	}

	public void updateAuditingSet(AuditingSet auditingSet,
			List<AuditingSetDetail> auditingSetDetailList) {
		auditingSetLogic.updateAuditingSet(auditingSet, auditingSetDetailList);
	}

}

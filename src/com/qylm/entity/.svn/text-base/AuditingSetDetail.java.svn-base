package com.qylm.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 审核设定详细
 * @author ShengMinJun
 */
@Entity
@Table(uniqueConstraints = {}, name = "auditingset_detail")
public class AuditingSetDetail extends BaseEntity implements Comparable<AuditingSetDetail> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4192283985381585843L;

	/**
	 * 审核
	 */
	public static final String AUDITING_SET = "auditingSet";
	
	/**
	 * 审核.applyNumber
	 */
	public static final String AUDITING_SET_APPLE_NUMBER = "auditingSet.applyNumber";
	
	/**
	 * 审核员
	 */
	public static final String AUDITOR = "auditor";
	
	/**
	 * 等级顺序
	 */
	public static final String SEQUENCE = "sequence";
	
	/**
	 * 审核
	 */
	@ManyToOne(targetEntity = AuditingSet.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "auditingSetId")
	private AuditingSet auditingSet;

	/**
	 * 审核员
	 */
	@ManyToOne(targetEntity = User.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "auditorId")
	private User auditor;
	
	/**
	 * 等级顺序
	 */
	private Integer sequence;
	
	public int compareTo(AuditingSetDetail o) {
		return this.sequence.compareTo(o.getSequence());
	}
	
	/**
	 * @return the auditingSet
	 */
	public AuditingSet getAuditingSet() {
		return auditingSet;
	}

	/**
	 * @param auditingSet the auditingSet to set
	 */
	public void setAuditingSet(AuditingSet auditingSet) {
		this.auditingSet = auditingSet;
	}

	/**
	 * get auditor
	 * @return the auditor
	 */
	public User getAuditor() {
		return auditor;
	}

	/**
	 * set auditor
	 * @param auditor the auditor to set
	 */
	public void setAuditor(User auditor) {
		this.auditor = auditor;
	}

	/**
	 * get sequence
	 * @return the sequence
	 */
	public Integer getSequence() {
		return sequence;
	}

	/**
	 * set sequence
	 * @param sequence the sequence to set
	 */
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

}

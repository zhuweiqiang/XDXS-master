package com.qylm.faces.event;

import java.util.Date;

import org.primefaces.model.DefaultScheduleEvent;

public class PlanScheduleEvent extends DefaultScheduleEvent {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1609105300987205506L;
	
	public PlanScheduleEvent() {
		
	}

	/**
	 * 主键id
	 */
	private Integer planScheduleId;

	public PlanScheduleEvent(String title, Date start, Date end) {
		super.setTitle(title);
		super.setStartDate(start);
		super.setEndDate(end);
	}

	/**
	 * @return the planScheduleId
	 */
	public Integer getPlanScheduleId() {
		return planScheduleId;
	}

	/**
	 * @param planScheduleId
	 *            the planScheduleId to set
	 */
	public void setPlanScheduleId(Integer planScheduleId) {
		this.planScheduleId = planScheduleId;
	}

}

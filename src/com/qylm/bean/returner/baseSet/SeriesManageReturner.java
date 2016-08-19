package com.qylm.bean.returner.baseSet;

import com.qylm.bean.baseSet.SeriesManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.baseSet.SeriesManageDto;
import com.qylm.entity.Series;

public class SeriesManageReturner extends Returner<SeriesManageBean, SeriesManageDto, Series> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1879386863442434097L;

	public SeriesManageReturner(SeriesManageDto seriesManageDto, int currentPage) {
		super(seriesManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(SeriesManageBean backBean) {
		backBean.setSeriesManageDto(super.dto);
		return backBean.back(currentPage);
	}

}

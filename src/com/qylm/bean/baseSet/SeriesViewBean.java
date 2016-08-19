package com.qylm.bean.baseSet;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.common.Navigation;
import com.qylm.dto.baseSet.SeriesViewDto;
import com.qylm.dxo.SeriesViewDxo;
import com.qylm.entity.Series;
import com.qylm.service.SeriesService;

/**
 * 系类登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class SeriesViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3644880253336485739L;

	/**
	 * 存放系类登陆画面需要保存的值
	 */
	private SeriesViewDto seriesViewDto = new SeriesViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{seriesService}")
	private SeriesService seriesService;
	
	/**
	 * 查看详细
	 * @param series
	 * @return
	 */
	public String viewDetail(Series series) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Series.class);
		detachedCriteria.createAlias(Series.BRAND, Series.BRAND, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(Series.BASE_ID, series.getId()));
		List<Series> seriesList = seriesService.getByDetachedCriteria(detachedCriteria);
		if (!seriesList.isEmpty()) {
			series = seriesList.get(0);
			SeriesViewDxo.entityToDto(series, seriesViewDto);
		}
		return Navigation.SERIES_VIEW;
	}
	
	/**
	 * @param seriesService the seriesService to set
	 */
	public void setSeriesService(SeriesService seriesService) {
		this.seriesService = seriesService;
	}

	/**
	 * @return the seriesViewDto
	 */
	public SeriesViewDto getSeriesViewDto() {
		return seriesViewDto;
	}

	/**
	 * @param seriesViewDto the seriesViewDto to set
	 */
	public void setSeriesViewDto(SeriesViewDto seriesViewDto) {
		this.seriesViewDto = seriesViewDto;
	}

}

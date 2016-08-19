package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.SeriesDao;
import com.qylm.entity.Series;

@Service("seriesService")
public class SeriesServiceImpl extends GenericServiceImpl<Series, Integer> implements SeriesService {

	@Autowired
	protected SeriesServiceImpl(SeriesDao seriesDao) {
		super(seriesDao);
	}

}

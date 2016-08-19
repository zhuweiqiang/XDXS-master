package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.BrandDao;
import com.qylm.entity.Brand;

@Service("brandService")
public class BrandServiceImpl extends GenericServiceImpl<Brand, Integer> implements BrandService {

	@Autowired
	protected BrandServiceImpl(BrandDao brandDao) {
		super(brandDao);
	}

}

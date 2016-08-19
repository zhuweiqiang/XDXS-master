package com.qylm.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.qylm.common.utils.StringUtil;

@Embeddable
public class AddressEntity implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6444757344893921496L;

	/**
	 * 省
	 */
	public static final String PROVINCE_ID = "addressEntity.provinceId";
	
	/**
	 * 市
	 */
	public static final String CITY_ID = "addressEntity.cityId";
	
	/**
	 * 县
	 */
	public static final String DISTRICT_ID = "addressEntity.districtId";

	/**
	 * 省
	 */
	private Integer provinceId;
	
	/**
	 * 市
	 */
	private Integer cityId;
	
	/**
	 * 县
	 */
	private Integer districtId;
	
	/**
	 * 邮编
	 */
	private String zipCode;
	
	/**
	 * get provinceId
	 * @return the provinceId
	 */
	public Integer getProvinceId() {
		return provinceId;
	}

	/**
	 * set provinceId
	 * @param provinceId the provinceId to set
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * get cityId
	 * @return the cityId
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * set cityId
	 * @param cityId the cityId to set
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * get districtId
	 * @return the districtId
	 */
	public Integer getDistrictId() {
		return districtId;
	}

	/**
	 * set districtId
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	/**
	 * get zipCode
	 * @return the zipCode
	 */
	public String getZipCode() {
		if(StringUtil.isBlank(zipCode)){
			if(districtId!=null){
				zipCode = String.valueOf(districtId);
			}else if(cityId!=null){
				zipCode = String.valueOf(cityId);
			}else if(provinceId!=null){
				zipCode = String.valueOf(provinceId);
			}else{
				zipCode="000000";
			}
		}
		return zipCode;
	}

	/**
	 * set zipCode
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}

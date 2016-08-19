package com.qylm.common.address;

import java.io.Serializable;

/**
 * 全国所有的城市
 * @author smj
 *
 */
public class City implements Serializable {

	private static final long serialVersionUID = 3000365466766221552L;
	
	/**
	 * 城市ID
	 */
	private Integer cityId;
	
	/**
	 * 城市名称
	 */
	private String name;
	
	/**
	 * 邮政编码
	 */
	private String zipCode;
	
	/**
	 * 所属省
	 */
	private Province province;
	
	/**
	 * 版本
	 */
	private Integer version;
	
	public City(){}
	
	public City(Integer cityId){
		this.cityId = cityId;
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
	 * get name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get zipCode
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * set zipCode
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * get province
	 * @return the province
	 */
	public Province getProvince() {
		return province;
	}

	/**
	 * set province
	 * @param province the province to set
	 */
	public void setProvince(Province province) {
		this.province = province;
	}

	/**
	 * get version
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * set version
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

}

package com.qylm.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import com.qylm.common.AddressFinder;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.entity.AddressEntity;


@ManagedBean
@RequestScoped
public class AddressFinderBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3763657145539581796L;

	private SelectItem[] cityItems = { Constants.UN_SELECT_ITEM };
	
	private SelectItem[] districtItems = { Constants.UN_SELECT_ITEM };
	
	/**
	 * 第二个城市下拉框
	 */
//	private SelectItem[] cityItems2 = { Constants.UN_SELECT_ITEM };

	@ManagedProperty(value = "#{addressFinder}")
	private AddressFinder addressFinder;
	
	/**
	 * 取得城市的邮政编码
	 * @param pid 省ID
	 * @param cityId 城市ID
	 * @return 邮政编码
	 */
	public String getZipCode(AddressEntity addressEntity){
		return addressFinder.getZipCode(addressEntity.getProvinceId(), addressEntity.getCityId(), addressEntity.getDistrictId());
	}
	
	/**
	 * 通过request中的form1:provinceId取得城市的下拉框
	 * 刷新城市下拉框
	 */
	public void refreshCityItems(AjaxBehaviorEvent event){
		HtmlSelectOneMenu selectOneMenu = (HtmlSelectOneMenu)event.getComponent();
		Integer  pid = Integer.valueOf(String.valueOf(selectOneMenu.getSubmittedValue()));
		//Integer pid = (Integer) selectOneMenu.getValue();
		cityItems = addressFinder.getCityItems(String.valueOf(pid));
		clearDistrictItems();
	}
	
	/**
	 * 通过request中的form1:startProvinceId取得城市的下拉框
	 * 刷新第二个城市下拉框
	 */
//	public void refreshCityItems2(){
//		cityItems2 = addressFinder.getCityItems2();
//	}
	
	/**
	 * 通过request中的form1:cityId取得县的下拉框
	 * 刷新县下拉框
	 */
	public void refreshDistrictItems(AjaxBehaviorEvent event){
		HtmlSelectOneMenu selectOneMenu = (HtmlSelectOneMenu)event.getComponent();
		Integer  cid = Integer.valueOf(String.valueOf(selectOneMenu.getSubmittedValue())) ;
		//Integer cid = (Integer) selectOneMenu.getValue();
		districtItems = addressFinder.getDistrictItems(String.valueOf(cid));
	}
	
	/**
	 * 根据省ID初始化城市下拉框
	 * @param pid
	 */
	private void initCityItems(Integer pid){
		cityItems = addressFinder.getCityItems(pid);
	}
	
	/**
	 * 根据城市ID初始化县下拉框
	 * @param cid
	 */
	private void initDistrictItems(Integer cid){
		districtItems = addressFinder.getDistrictItems(cid);
	}
	
	/**
	 * 根据省ID初始化城市下拉框，如果不存在，则清空下拉框
	 * @param pid
	 */
	@SuppressWarnings("unused")
	private void initCityItems(final String pid){
		if(!StringUtil.isUnSelected(pid)){
			cityItems = addressFinder.getCityItems(Integer.valueOf(pid));
		} else {
			clearCityItems();
		}
	}
	
	/**
	 * 根据城市ID初始化县下拉框，如果不存在，则清空下拉框
	 * @param cid
	 */
	@SuppressWarnings("unused")
	private void initDistrictItems(final String cid){
		if(!StringUtil.isUnSelected(cid)){
			districtItems = addressFinder.getDistrictItems(Integer.valueOf(cid));
		} else {
			clearDistrictItems();
		}
	}
	
	/**
	 * 清空城市下拉框
	 * 
	 */
	private void clearCityItems(){
		cityItems = new SelectItem[]{Constants.UN_SELECT_ITEM};
	}
	
	/**
	 * 清空城市下拉框
	 * 
	 */
	private void clearDistrictItems(){
		districtItems = new SelectItem[]{Constants.UN_SELECT_ITEM};
	}
	
	/**
	 * 根据省ID初始化第二个城市下拉框
	 * @param pid
	 */
//	public void initCityItems2(Integer pid){
//		cityItems2 = addressFinder.getCityItems(pid);
//	}
	
	/**
	 * 根据省ID初始化第二个城市下拉框，如果不存在，则清空下拉框
	 * @param pid
	 */
//	public void initCityItems2(String pid){
//		if(!StringUtil.isUnSelected(pid)){
//			cityItems2 = addressFinder.getCityItems(Integer.valueOf(pid));
//		} else {
//			clearCityItems2();
//		}
//	}
	
	/**
	 * 清空第二个城市下拉框
	 * 
	 */
//	public void clearCityItems2(){
//		cityItems2 = new SelectItem[]{Constants.UN_SELECT_ITEM};
//	}
	
	/**
	 * 以AddressDto初始化城市和县下拉框
	 */
	/*public void initAllByAddressDto(AddressDto dto){
		initCityItems(dto.getProvinceId());
		initDistrictItems(dto.getCityId());
	}*/
	
	/**
	 * 以AddressEntity初始化城市和县下拉框
	 */
	public void initAllByAddressEntity(AddressEntity entity){
		initCityItems(entity.getProvinceId());
		initDistrictItems(entity.getCityId());
	}
	
	/**
	 * 清空城市和县下拉框
	 */
	public void clearAll(){
		clearCityItems();
		clearDistrictItems();
	}
	
	/**
	 * set addressFinder
	 * @param addressFinder the addressFinder to set
	 */
	public void setAddressFinder(AddressFinder addressFinder) {
		this.addressFinder = addressFinder;
	}
	
	/**
	 * get cityItems
	 * @return the cityItems
	 */
	public SelectItem[] getCityItems() {
		return cityItems;
	}

	/**
	 * set cityItems
	 * @param cityItems the cityItems to set
	 */
	public void setCityItems(SelectItem[] cityItems) {
		this.cityItems = cityItems;
	}

	/**
	 * get districtItems
	 * @return the districtItems
	 */
	public SelectItem[] getDistrictItems() {
		return districtItems;
	}

	/**
	 * set districtItems
	 * @param districtItems the districtItems to set
	 */
	public void setDistrictItems(SelectItem[] districtItems) {
		this.districtItems = districtItems;
	}

	/**
	 * get cityItems2
	 * @return the cityItems2
	 */
//	public SelectItem[] getCityItems2() {
//		return cityItems2;
//	}

	/**
	 * set cityItems2
	 * @param cityItems2 the cityItems2 to set
	 */
//	public void setCityItems2(SelectItem[] cityItems2) {
//		this.cityItems2 = cityItems2;
//	}

}

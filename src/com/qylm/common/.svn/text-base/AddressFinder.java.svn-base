package com.qylm.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.InitializingBean;

import com.qylm.common.address.City;
import com.qylm.common.address.CityData;
import com.qylm.common.address.District;
import com.qylm.common.address.DistrictData;
import com.qylm.common.address.Province;
import com.qylm.common.address.ProvinceData;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.entity.AddressEntity;

/**
 * 取得省和城市的共通类
 * @author smj
 *
 */
public class AddressFinder implements InitializingBean,Serializable {
	
//	private List<Province> provinceList;
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 634302208395937268L;

	private Map<Integer, List<City>> provinceCitesLinkMap;
	
	private Map<Integer, List<District>> cityDistrictLinkMap;
	
	private static Map<Integer, SelectItem[]> provinceCityItemsLinkMap;
	
	private static Map<Integer, SelectItem[]> cityDistrictItemsLinkMap;
	
	private static SelectItem[] cityItems;
	
	private static SelectItem[] provinceItems;
	
	public void afterPropertiesSet() throws Exception {
		List<Province> provinceList = ProvinceData.getAllProvinceList();
		provinceCityItemsLinkMap = new HashMap<Integer, SelectItem[]>();
		provinceCitesLinkMap = new HashMap<Integer, List<City>>();
		cityDistrictLinkMap = new HashMap<Integer, List<District>>();
		cityDistrictItemsLinkMap = new HashMap<Integer, SelectItem[]>();
		int size = provinceList.size();
		provinceItems = new SelectItem[size+1];
		provinceItems[0] = Constants.UN_SELECT_ITEM;
		Province province;
		Integer provinceId;
		List<City> allCityList = CityData.getAllCityList();
		List<City> cityList;
		City city;
		int citySize = allCityList.size();
		for (int i = 0; i < size; i++) {
			province = provinceList.get(i);
			provinceId = province.getProvinceId();
			provinceItems[i+1] = new SelectItem(provinceId.toString(), province.getName());
			cityList = new ArrayList<City>();
			for (int j = 0; j < citySize; j++) {
				city = allCityList.get(j);
				if(provinceId.equals(city.getProvince().getProvinceId())){
					city.setProvince(province);
					cityList.add(city);
				}
			}
			provinceCitesLinkMap.put(provinceId, cityList);
			provinceCityItemsLinkMap.put(provinceId, createCitiesItem(cityList));
		}
		cityItems = new SelectItem[citySize];
		List<District> allDistrictList = DistrictData.getAllDistrictList1();
		allDistrictList.addAll(DistrictData.getAllDistrictList2());
		allDistrictList.addAll(DistrictData.getAllDistrictList3());
		District district;
		Integer cityId;
		List<District> districtList;
		int districtSize = allDistrictList.size();
		for (int i = 0; i < citySize; i++) {
			city = allCityList.get(i);
			cityId = city.getCityId();
			cityItems[i] = new SelectItem(city.getCityId().toString(), city.getName());
			districtList = new ArrayList<District>();
			for (int j = 0; j < districtSize; j++) {
				district = allDistrictList.get(j);
				if(city.getCityId().equals(district.getCity().getCityId())){
					district.setCity(city);
					districtList.add(district);
				}
			}
			cityDistrictLinkMap.put(cityId, districtList);
			cityDistrictItemsLinkMap.put(cityId, createDistrictsItem(districtList));
		}
	}
	
	public static String displayAddress(AddressEntity addressEntity) {
		if(addressEntity==null||addressEntity.getProvinceId()==null)
			return null;
		Integer provinceId = addressEntity.getProvinceId();
		Integer cityId = addressEntity.getCityId();
		Integer districtId = addressEntity.getDistrictId();
		StringBuilder sb = new StringBuilder(64);
		int size;
		int i;
		String id;
		SelectItem item;
		id = provinceId.toString();
		size = provinceItems.length;
		for (i = 0; i < size; i++) {
			item = provinceItems[i];
			if(id.equals(item.getValue())){
				sb.append(item.getLabel());
				break;
			}
		}
		if(cityId != null){
			id = cityId.toString();
			SelectItem[] cityItems = provinceCityItemsLinkMap.get(provinceId);
			size = cityItems.length;
			for (i = 0; i < size; i++) {
				item = cityItems[i];
				if(id.equals(item.getValue())){
					sb.append(Constants.BLANK);
					sb.append(item.getLabel());
					break;
				}
			}
		}
		if(districtId != null){
			id = districtId.toString();
			SelectItem[] districtItems = cityDistrictItemsLinkMap.get(cityId);
			if(districtItems != null){
				size = districtItems.length;
				for (i = 0; i < size; i++) {
					item = districtItems[i];
					if(id.equals(item.getValue())){
						sb.append(Constants.BLANK);
						sb.append(item.getLabel());
						break;
					}
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * 取得城市的邮政编码
	 * @param provinceId 省ID
	 * @param cityId 城市ID
	 * @param districtId 县ID
	 * @return 邮政编码
	 */
	public String getZipCode(Integer provinceId, Integer cityId, Integer districtId) {
		String zipCode = null;
		int size;
		if(districtId != null){
			List<District> districtList = cityDistrictLinkMap.get(cityId);
			size = districtList.size();
			District district;
			for (int i = 0; i < size; i++) {
				district = districtList.get(i);
				if(district.getDistrictId().equals(districtId)){
					zipCode = district.getZipCode();
					break;
				}
			}
		}
		if(zipCode == null){
			List<City> cityList = provinceCitesLinkMap.get(provinceId);
			City city;
			size = cityList.size();
			for (int i = 0; i < size; i++) {
				city = cityList.get(i);
				if(city.getCityId().equals(cityId)){
					return city.getZipCode();
				}
			}
		}
		return zipCode;
	}
	
	/**
	 * 创建省份
	 * @return
	 */
	public static AddressEntity createAddressEntity(String provinceName,String cityName,String districtName){
		AddressEntity addressEntity = new AddressEntity();
		if(StringUtil.isNotBlank(provinceName)){
			for(Province province : ProvinceData.getAllProvinceList()){
				if(StringUtil.equalsIgnoreCase(province.getName(), provinceName)){
					addressEntity.setProvinceId(province.getProvinceId());
					break;
				}
			}
		}
		if(addressEntity.getProvinceId()!=null&&StringUtil.isNotBlank(cityName)){
			for(City city : CityData.getAllCityList()){
				Province province = city.getProvince();
				if(province.getProvinceId().compareTo(addressEntity.getProvinceId())==0
						&&StringUtil.equalsIgnoreCase(city.getName(), cityName)){
					addressEntity.setCityId(city.getCityId());
					break;
				}
			}
		}
		if(addressEntity.getCityId()!=null&&StringUtil.isNotBlank(districtName)){
			List<District> districtList1 = DistrictData.getAllDistrictList1();
			for(District district : districtList1){
				City city = district.getCity();
				if(city.getCityId().compareTo(addressEntity.getCityId())==0&&StringUtil.equalsIgnoreCase(district.getName(), districtName)){
					addressEntity.setDistrictId(district.getDistrictId());
					break;
				}
			}
			if(addressEntity.getDistrictId()==null){
				List<District> districtList2 = DistrictData.getAllDistrictList2();
				for(District district : districtList2){
					City city = district.getCity();
					if(city.getCityId().compareTo(addressEntity.getCityId())==0&&StringUtil.equalsIgnoreCase(district.getName(), districtName)){
						addressEntity.setDistrictId(district.getDistrictId());
						break;
					}
				}
			}
			if(addressEntity.getDistrictId()==null){
				List<District> districtList3 = DistrictData.getAllDistrictList3();
				for(District district : districtList3){
					City city = district.getCity();
					if(city.getCityId().compareTo(addressEntity.getCityId())==0&&StringUtil.equalsIgnoreCase(district.getName(), districtName)){
						addressEntity.setDistrictId(district.getDistrictId());
						break;
					}
				}
			}
		}
		return addressEntity;
	}
	
	private SelectItem[] createCitiesItem(List<City> cityList) {
		int size = cityList.size();
		SelectItem[] citiesItem = new SelectItem[size+1];
		citiesItem[0] = Constants.UN_SELECT_ITEM;
		City city;
		for (int i = 0; i < size; i++) {
			city = cityList.get(i);
			citiesItem[i+1] = new SelectItem(city.getCityId().toString(), city.getName());
		}
		return citiesItem;
	}
	
	private SelectItem[] createDistrictsItem(List<District> districtList) {
		int size = districtList.size();
		if(size == 0){
			return null;
		}
		SelectItem[] citiesItem = new SelectItem[size+1];
		citiesItem[0] = Constants.UN_SELECT_ITEM;
		District district;
		for (int i = 0; i < size; i++) {
			district = districtList.get(i);
			citiesItem[i+1] = new SelectItem(district.getDistrictId().toString(), district.getName());
		}
		return citiesItem;
	}
	
	/**
	 * 取得所有省的下拉框
	 * @return
	 */
	public SelectItem[] getProvinceItems() {
		return provinceItems;
	}
	
//	/**
//	 * 取得所有省的对象
//	 * @return
//	 */
//	public List<Province> getProvinceList(){
//		return provinceList;
//	}
	
	/**
	 * 取得省ID对应的城市列表
	 * @param pid
	 * @return
	 */
	public List<City> getCityList(Integer pid) {
		return provinceCitesLinkMap.get(pid);
	}
	
	/**
	 * 所有的城市的下拉框
	 * @param pid
	 * @return
	 */
	public SelectItem[] getAllCityItems() {
		return cityItems;
	}

	/**
	 * 取得省ID对应的城市的下拉框
	 * @param pid
	 * @return
	 */
	public SelectItem[] getCityItems(Integer pid) {
		return provinceCityItemsLinkMap.get(pid);
	}
	
	/**
	 * 取得城市D对应的县的下拉框
	 * @param cid
	 * @return
	 */
	public SelectItem[] getDistrictItems(Integer cid) {
		return cityDistrictItemsLinkMap.get(cid);
	}
	
	/**
	 * 通过request中的<code>form1:provinceId</code>取得城市的下拉框
	 * @return
	 */
	public SelectItem[] getCityItems(String pid) {
		//String pid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form1:provinceId");
		if(StringUtil.isUnSelected(pid)){
			return new SelectItem[]{Constants.UN_SELECT_ITEM};
		}
		return provinceCityItemsLinkMap.get(Integer.valueOf(pid));
	}
	
	/**
	 * 通过request中的<code>form1:startProvinceId</code>取得城市的下拉框
	 * @return
	 */
	public SelectItem[] getCityItems2() {
		String pid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form1:startProvinceId");
		if(StringUtil.isUnSelected(pid)){
			return new SelectItem[]{Constants.UN_SELECT_ITEM};
		}
		return provinceCityItemsLinkMap.get(Integer.valueOf(pid));
	}
	
	/**
	 * 通过request中的<code>form1:cityId</code>取得县的下拉框
	 * @return
	 */
	public SelectItem[] getDistrictItems(String cid) {
		//String cid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form1:cityId");
		if(StringUtil.isUnSelected(cid)){
			return new SelectItem[]{Constants.UN_SELECT_ITEM};
		}
		return cityDistrictItemsLinkMap.get(Integer.valueOf(cid));
	}

}

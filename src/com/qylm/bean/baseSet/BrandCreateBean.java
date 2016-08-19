package com.qylm.bean.baseSet;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.dto.baseSet.BrandCreateDto;
import com.qylm.dxo.BrandCreateDxo;
import com.qylm.entity.Brand;
import com.qylm.service.BrandService;

/**
 * 品牌登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class BrandCreateBean implements Serializable, CreateBean<Brand> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3859212178690803868L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(BrandCreateBean.class);

	/**
	 * 存放品牌登陆画面需要保存的值
	 */
	private BrandCreateDto brandCreateDto = new BrandCreateDto();
	
	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 品牌业务类
	 */
	@ManagedProperty(value="#{brandService}")
	private BrandService brandService;
	
	/**
	 * 此方法绑定于品牌登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 品牌登陆画面
	 */
	public String newBrand() {
		Tool.sendLog(LOG, userBean, "【品牌登陆画面_新建按钮】");
		brandCreateDto.setName(null);
		brandCreateDto.setRemark(null);
		brandCreateDto.setCreater(null);
		brandCreateDto.setBelongingUser(null);
		brandCreateDto.setTransferBrand(null);
		return Navigation.BRAND_CREATE;
	}
	
	/**
	 * 此方法绑定于品牌登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【品牌登陆画面_返回按钮】");
		return brandCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于品牌登陆画面的保存按钮 
	 * 实现功能：根据transferBrand对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveBrand() {
		Tool.sendLog(LOG, userBean, "【品牌登陆画面_保存按钮】");
		Brand transferBrand = brandCreateDto.getTransferBrand();
		if (transferBrand == null) {
			transferBrand = new Brand();
			brandCreateDto.setCreater(userBean.getUser());
			brandCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferBrand);
			transferBrand.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			brandService.saveEntity(transferBrand);
			brandCreateDto.setTransferBrand(transferBrand);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferBrand);
			transferBrand.setUpdateDate(DateUtil.getNowyyyymmdd());
			brandService.updateEntity(transferBrand);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferBrand
	 */
	private void create(Brand transferBrand) {
		BrandCreateDxo.dtoToEntity(brandCreateDto, transferBrand);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		brandCreateDto.setReturner(returner);
		return Navigation.BRAND_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, Brand brand) {
		brandCreateDto.setReturner(returner);
		BrandCreateDxo.entityToDto(brand, brandCreateDto);
		brandCreateDto.setTransferBrand(brand);
		return Navigation.BRAND_CREATE;
	}
	
	/**
	 * set brandService
	 * @param brandService the brandService to set
	 */
	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get brandCreateDto
	 * @return the brandCreateDto
	 */
	public BrandCreateDto getBrandCreateDto() {
		return brandCreateDto;
	}

	/**
	 * set brandCreateDto
	 * @param brandCreateDto the brandCreateDto to set
	 */
	public void setBrandCreateDto(BrandCreateDto brandCreateDto) {
		this.brandCreateDto = brandCreateDto;
	}

}

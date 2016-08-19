package com.qylm.bean.auditing;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.dto.auditing.ShopAuditingCreateDto;
import com.qylm.dxo.ShopAuditingCreateDxo;
import com.qylm.entity.ShopApple;
import com.qylm.entity.ShopAppleDetail;
import com.qylm.entity.ShopAuditing;
import com.qylm.service.ShopAppleDetailService;
import com.qylm.service.ShopAuditingService;

/**
 * 店铺配货审核登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ShopAuditingCreateBean implements Serializable, CreateBean<ShopAuditing> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4573403591365198823L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ShopAuditingCreateBean.class);

	/**
	 * 存放店铺配货审核登陆画面需要保存的值
	 */
	private ShopAuditingCreateDto shopAuditingCreateDto = new ShopAuditingCreateDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件业务类
	 */
	@ManagedProperty(value="#{shopAuditingService}")
	private ShopAuditingService shopAuditingService;
	
	/**
	 *店铺申请配货详细务类
	 */
	@ManagedProperty(value="#{shopAppleDetailService}")
	private ShopAppleDetailService shopAppleDetailService;
	
	/**
	 * 此方法绑定于店铺配货审核登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 店铺配货审核登陆画面
	 */
	public String newShopAuditing() {
		Tool.sendLog(LOG, userBean, "【店铺配货审核登陆画面_新建按钮】");
		shopAuditingCreateDto.setShopApple(null);
		shopAuditingCreateDto.setAuditor(null);
		shopAuditingCreateDto.setRemark(null);
		shopAuditingCreateDto.setDate(null);
		shopAuditingCreateDto.setState(null);
		shopAuditingCreateDto.setSequence(null);
		shopAuditingCreateDto.setCreater(null);
		shopAuditingCreateDto.setBelongingUser(null);
		shopAuditingCreateDto.setTransferShopAuditing(null);
		return Navigation.SHOP_AUDITING_CREATE;
	}
	
	/**
	 * 此方法绑定于店铺配货审核登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【店铺配货审核登陆画面_返回按钮】");
		return shopAuditingCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于店铺配货审核登陆画面的保存按钮 
	 * 实现功能：根据transferShopAuditing对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveShopAuditing() {
		Tool.sendLog(LOG, userBean, "【店铺配货审核登陆画面_保存按钮】");
		ShopAuditing transferShopAuditing = shopAuditingCreateDto.getTransferShopAuditing();
		if (transferShopAuditing == null) {
			transferShopAuditing = new ShopAuditing();
			shopAuditingCreateDto.setCreater(userBean.getUser());
			shopAuditingCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferShopAuditing);
			transferShopAuditing.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			shopAuditingService.saveEntity(transferShopAuditing);
			shopAuditingCreateDto.setTransferShopAuditing(transferShopAuditing);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferShopAuditing);
			transferShopAuditing.setUpdateDate(DateUtil.getNowyyyymmdd());
			shopAuditingService.updateEntity(transferShopAuditing);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 此方法绑定于店铺配货审核登陆画面的审核通过按钮 
	 * @return 画面不跳转
	 */
	public void auditingPass() {
		Tool.sendLog(LOG, userBean, "【店铺配货审核登陆画面_审核通过按钮】");
		shopAuditingCreateDto.setState(ShopAuditing.STATE_2);
		ShopAuditing transferShopAuditing = shopAuditingCreateDto.getTransferShopAuditing();
		create(transferShopAuditing);
		transferShopAuditing.setUpdateDate(DateUtil.getNowyyyymmdd());
		shopAuditingService.updateShopAuditing(transferShopAuditing);
		Tool.sendErrorMessage(Message.GENERAL_APP_PASS);
	}
	
	/**
	 * 此方法绑定于店铺配货审核登陆画面的审核不通过按钮 
	 * @return 画面不跳转
	 */
	public void auditingNoPass() {
		Tool.sendLog(LOG, userBean, "【店铺配货审核登陆画面_审核不通过按钮】");
		shopAuditingCreateDto.setState(ShopAuditing.STATE_3);
		ShopAuditing transferShopAuditing = shopAuditingCreateDto.getTransferShopAuditing();
		create(transferShopAuditing);
		transferShopAuditing.setUpdateDate(DateUtil.getNowyyyymmdd());
		shopAuditingService.updateShopAuditing(transferShopAuditing);
		Tool.sendErrorMessage(Message.GENERAL_APP_PASS);
	}
	
	/**
	 * 赋值
	 * @param transferShopAuditing
	 */
	private void create(ShopAuditing transferShopAuditing) {
		ShopAuditingCreateDxo.dtoToEntity(shopAuditingCreateDto, transferShopAuditing);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		shopAuditingCreateDto.setReturner(returner);
		return Navigation.SHOP_AUDITING_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, ShopAuditing shopAuditing) {
		shopAuditingCreateDto.setReturner(returner);
		ShopAuditingCreateDxo.entityToDto(shopAuditing, shopAuditingCreateDto);
		shopAuditingCreateDto.setTransferShopAuditing(shopAuditing);
		shopAuditingCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ShopAppleDetail.class);
		detachedCriteria.createAlias(ShopAppleDetail.PRODUCT_STOCK, ShopAppleDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ShopAppleDetail.SHOP_APPLE, ShopAppleDetail.SHOP_APPLE, JoinType.LEFT_OUTER_JOIN);
		ShopApple shopApple = shopAuditing.getShopApple();
		detachedCriteria.add(Restrictions.eq(ShopAppleDetail.SHOP_APPLE, shopApple));
		shopApple.setShopAppleDetailList(shopAppleDetailService.getByDetachedCriteria(detachedCriteria));
		return Navigation.SHOP_AUDITING_CREATE;
	}
	
	/**
	 * @param shopAppleDetailService the shopAppleDetailService to set
	 */
	public void setShopAppleDetailService(
			ShopAppleDetailService shopAppleDetailService) {
		this.shopAppleDetailService = shopAppleDetailService;
	}

	/**
	 * set shopAuditingService
	 * @param shopAuditingService the shopAuditingService to set
	 */
	public void setShopAuditingService(ShopAuditingService shopAuditingService) {
		this.shopAuditingService = shopAuditingService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get shopAuditingCreateDto
	 * @return the shopAuditingCreateDto
	 */
	public ShopAuditingCreateDto getShopAuditingCreateDto() {
		return shopAuditingCreateDto;
	}

	/**
	 * set shopAuditingCreateDto
	 * @param shopAuditingCreateDto the shopAuditingCreateDto to set
	 */
	public void setShopAuditingCreateDto(ShopAuditingCreateDto shopAuditingCreateDto) {
		this.shopAuditingCreateDto = shopAuditingCreateDto;
	}

}

package com.qylm.bean.prepareGoods;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.sql.JoinType;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.prepareGoods.ShopAppleCreateDto;
import com.qylm.dxo.ShopAppleCreateDxo;
import com.qylm.entity.ProductStock;
import com.qylm.entity.ShopApple;
import com.qylm.entity.ShopAppleDetail;
import com.qylm.service.ProductStockService;
import com.qylm.service.ShopAppleDetailService;
import com.qylm.service.ShopAppleService;

/**
 * 店铺申请配货登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ShopAppleCreateBean implements Serializable, CreateBean<ShopApple> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5730477862553966426L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ShopAppleCreateBean.class);

	/**
	 * 存放店铺申请配货登陆画面需要保存的值
	 */
	private ShopAppleCreateDto shopAppleCreateDto = new ShopAppleCreateDto();
	
	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 店铺申请配货业务类
	 */
	@ManagedProperty(value="#{shopAppleService}")
	private ShopAppleService shopAppleService;
	
	/**
	 * 产品库存详细务类
	 */
	@ManagedProperty(value="#{productStockService}")
	private ProductStockService productStockService;
	
	/**
	 *店铺申请配货详细务类
	 */
	@ManagedProperty(value="#{shopAppleDetailService}")
	private ShopAppleDetailService shopAppleDetailService;
	
	/**
	 * 此方法绑定于店铺申请配货登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 店铺申请配货登陆画面
	 */
	public String newShopApple() {
		Tool.sendLog(LOG, userBean, "【店铺申请配货登陆画面_新建按钮】");
		shopAppleCreateDto.setNumber(null);
		shopAppleCreateDto.setDepotInfo(null);
		shopAppleCreateDto.setAppleDate(DateUtil.getNowyyyymm());
		shopAppleCreateDto.setRemark(null);
		shopAppleCreateDto.setAppleState(ShopApple.APPLE_STATE_1);
		shopAppleCreateDto.setUser(null);
		shopAppleCreateDto.setShopAppleDetailList(null);
		shopAppleCreateDto.setProductStockList(null);
		shopAppleCreateDto.setProductList(null);
		shopAppleCreateDto.setProductStockName(null);
		shopAppleCreateDto.setCreater(null);
		shopAppleCreateDto.setBelongingUser(null);
		shopAppleCreateDto.setTransferShopApple(null);
		return Navigation.SHOP_APPLE_CREATE;
	}
	
	/**
	 * 此方法绑定于店铺申请配货登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【店铺申请配货登陆画面_返回按钮】");
		return shopAppleCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于店铺申请配货登陆画面的保存按钮 
	 * 实现功能：根据transferShopApple对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveShopApple() {
		Tool.sendLog(LOG, userBean, "【店铺申请配货登陆画面_保存按钮】");
		ShopApple transferShopApple = shopAppleCreateDto.getTransferShopApple();
		operate(transferShopApple);
	}
	
	/**
	 * 此方法绑定于店铺申请配货登陆画面的确认按钮 
	 * 实现功能：根据transferShopApple对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void queryShopApple() {
		Tool.sendLog(LOG, userBean, "【店铺申请配货登陆画面_确认按钮】");
		ShopApple transferShopApple = shopAppleCreateDto.getTransferShopApple();
		shopAppleCreateDto.setAppleState(ShopApple.APPLE_STATE_2);
		operate(transferShopApple);
	}

	/**
	 * 对数据信息进行保存或者更新操作
	 * @param transferShopApple
	 */
	private void operate(ShopApple transferShopApple) {
		List<ShopAppleDetail> shopAppleDetailList = shopAppleCreateDto.getShopAppleDetailList();
		if (shopAppleDetailList == null || shopAppleDetailList.isEmpty()) {
			Tool.sendErrorMessage("店铺配货详细必须选择！");
			return;
		}
		try {
			if (transferShopApple == null) {
				transferShopApple = new ShopApple();
				shopAppleCreateDto.setCreater(userBean.getUser());
				shopAppleCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
				create(transferShopApple);
				transferShopApple.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
				shopAppleService.saveShopApple(transferShopApple, shopAppleDetailList);
				shopAppleCreateDto.setTransferShopApple(transferShopApple);
				Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
			} else {
				create(transferShopApple);
				transferShopApple.setUpdateDate(DateUtil.getNowyyyymmdd());
				shopAppleService.updateShopApple(transferShopApple, shopAppleDetailList);
				Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
			}
		} catch (ConstraintViolationException e) {
			Tool.sendErrorMessage("编号：" + shopAppleCreateDto.getNumber() + "， 已存在，请重新填写！");
		}
		
	}
	
	/**
	 * 赋值
	 * @param transferShopApple
	 */
	private void create(ShopApple transferShopApple) {
		List<ShopAppleDetail> shopAppleDetailList = shopAppleCreateDto.getShopAppleDetailList();
		if (shopAppleDetailList != null && !shopAppleDetailList.isEmpty()) {
			for (ShopAppleDetail shopAppleDetail : shopAppleDetailList) {
				shopAppleDetail.setShopApple(transferShopApple);
				shopAppleDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
				shopAppleDetail.setCreater(transferShopApple.getCreater());
				shopAppleDetail.setBelongingUser(transferShopApple.getBelongingUser());
			}
		}
		ShopAppleCreateDxo.dtoToEntity(shopAppleCreateDto, transferShopApple);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		shopAppleCreateDto.setAppleDate(DateUtil.getNowyyyymm());
		shopAppleCreateDto.setAppleState(ShopApple.APPLE_STATE_1);
		shopAppleCreateDto.setReturner(returner);
		return Navigation.SHOP_APPLE_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, ShopApple shopApple) {
		shopAppleCreateDto.setReturner(returner);
		ShopAppleCreateDxo.entityToDto(shopApple, shopAppleCreateDto);
		shopAppleCreateDto.setTransferShopApple(shopApple);
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ShopAppleDetail.class);
		detachedCriteria.createAlias(ShopAppleDetail.PRODUCT_STOCK, ShopAppleDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ShopAppleDetail.SHOP_APPLE, ShopAppleDetail.SHOP_APPLE, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ShopAppleDetail.SHOP_APPLE, shopApple));
		shopAppleCreateDto.setShopAppleDetailList(shopAppleDetailService.getByDetachedCriteria(detachedCriteria));
		return Navigation.SHOP_APPLE_CREATE;
	}
	
	/**
	 * 此方法绑定于店铺申请配货登陆画面的选择产品按钮 
	 * @return 画面不跳转
	 */
	public void findProductStock() {
		Tool.sendLog(LOG, userBean, "按下【店铺申请配货登陆画面_选择产品按钮】");
		select();
	}

	/**
	 * 此方法绑定于店铺申请配货登陆画面的搜索按钮 
	 * @return 画面不跳转
	 */
	public void selectProductStock() {
		Tool.sendLog(LOG, userBean, "按下【店铺申请配货登陆画面_搜索按钮】");
		select();
	}
	
	private void select() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProductStock.class);
		String productStockName = shopAppleCreateDto.getProductStockName();
		List<ProductStock> productList = shopAppleCreateDto.getProductList();
		if (StringUtil.isNotBlank(productStockName)) {
			detachedCriteria.add(Restrictions.like(ProductStock.NAME, productStockName, MatchMode.ANYWHERE));
		}
		if (productList != null && !productList.isEmpty()) {
			List<Integer> idList = new ArrayList<Integer>();
			for (ProductStock productStock : productList) {
				idList.add(productStock.getId());
			}
			detachedCriteria.add(Restrictions.not(Restrictions.in(ProductStock.BASE_ID, idList)));
		}
		shopAppleCreateDto.setProductStockList(productStockService.getByDetachedCriteria(detachedCriteria, 0, 10));
	}
	
	/**
	 * 此方法绑定于店铺申请配货登陆画面的选择按钮 
	 * @return 画面不跳转
	 */
	public void findProductStocks(ProductStock productStock) {
		Tool.sendLog(LOG, userBean, "按下【店铺申请配货登陆画面_选择按钮】");
		List<ProductStock> productList = shopAppleCreateDto.getProductList();
		if (productList == null) {
			productList = new ArrayList<ProductStock>();
			shopAppleCreateDto.setProductList(productList);
		}
		productList.add(productStock);
		shopAppleCreateDto.getProductStockList().remove(productStock);
	}
	
	/**
	 * 此方法绑定于店铺申请配货登陆画面的确认并结束选择按钮 
	 * @return 画面不跳转
	 */
	public void queryCloce() {
		Tool.sendLog(LOG, userBean, "按下【店铺申请配货登陆画面_确认并结束选择按钮】");
		List<ProductStock> productList = shopAppleCreateDto.getProductList();
		if (productList != null && !productList.isEmpty()) {
			List<ShopAppleDetail> shopAppleDetailList = shopAppleCreateDto.getShopAppleDetailList();
			if (shopAppleDetailList == null) {
				shopAppleDetailList = new ArrayList<ShopAppleDetail>();
				shopAppleCreateDto.setShopAppleDetailList(shopAppleDetailList);
			}
			ShopAppleDetail shopAppleDetail;
			if (shopAppleDetailList.isEmpty()) {
				for (ProductStock productStock : productList) {
					shopAppleDetail = new ShopAppleDetail();
					shopAppleDetail.setProductStock(productStock);
					shopAppleDetailList.add(shopAppleDetail);
				}
			} else {
				for (ProductStock productStock : productList) {
					boolean state = false;
					for (ShopAppleDetail detail : shopAppleDetailList) {
						if (productStock.equals(detail.getProductStock())) {
							state = true;
						}
					}
					if (!state) {
						shopAppleDetail = new ShopAppleDetail();
						shopAppleDetail.setProductStock(productStock);
						shopAppleDetailList.add(shopAppleDetail);
					}
				}
			}
		}
	}
	
	/**
	 * @param shopAppleDetailService the shopAppleDetailService to set
	 */
	public void setShopAppleDetailService(
			ShopAppleDetailService shopAppleDetailService) {
		this.shopAppleDetailService = shopAppleDetailService;
	}

	/**
	 * @param productStockService the productStockService to set
	 */
	public void setProductStockService(
			ProductStockService productStockService) {
		this.productStockService = productStockService;
	}

	/**
	 * set shopAppleService
	 * @param shopAppleService the shopAppleService to set
	 */
	public void setShopAppleService(ShopAppleService shopAppleService) {
		this.shopAppleService = shopAppleService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get shopAppleCreateDto
	 * @return the shopAppleCreateDto
	 */
	public ShopAppleCreateDto getShopAppleCreateDto() {
		return shopAppleCreateDto;
	}

	/**
	 * set shopAppleCreateDto
	 * @param shopAppleCreateDto the shopAppleCreateDto to set
	 */
	public void setShopAppleCreateDto(ShopAppleCreateDto shopAppleCreateDto) {
		this.shopAppleCreateDto = shopAppleCreateDto;
	}

}

package com.qylm.bean.depot;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.depot.ProductDepotAllotCreateDto;
import com.qylm.dxo.ProductDepotAllotCreateDxo;
import com.qylm.entity.DepotInfo;
import com.qylm.entity.ProductDepotAllot;
import com.qylm.entity.ProductStockDetail;
import com.qylm.exception.ProductDepotAllotException;
import com.qylm.service.ProductDepotAllotService;
import com.qylm.service.ProductStockDetailService;

/**
 * 仓库库存调拨登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ProductDepotAllotCreateBean implements Serializable, CreateBean<ProductDepotAllot> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7727493109860664306L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ProductDepotAllotCreateBean.class);

	/**
	 * 存放仓库库存调拨登陆画面需要保存的值
	 */
	private ProductDepotAllotCreateDto productDepotAllotCreateDto = new ProductDepotAllotCreateDto();
	
	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 产品库存调拨业务类
	 */
	@ManagedProperty(value="#{productDepotAllotService}")
	private ProductDepotAllotService productDepotAllotService;
	
	/**
	 * 产品库存详细务类
	 */
	@ManagedProperty(value="#{productStockDetailService}")
	private ProductStockDetailService productStockDetailService;
	
	/**
	 * 此方法绑定于仓库库存调拨登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 仓库库存调拨登陆画面
	 */
	public String newProductDepotAllot() {
		Tool.sendLog(LOG, userBean, "【仓库库存调拨登陆画面_新建按钮】");
		productDepotAllotCreateDto.setDepotInfo(null);
		productDepotAllotCreateDto.setProductStockDetail(null);
		productDepotAllotCreateDto.setAllotDepotInfo(null);
		productDepotAllotCreateDto.setAllotProductStockDetail(null);
		productDepotAllotCreateDto.setNumber(null);
		productDepotAllotCreateDto.setState(false);
		productDepotAllotCreateDto.setCreater(null);
		productDepotAllotCreateDto.setBelongingUser(null);
		productDepotAllotCreateDto.setTransferProductDepotAllot(null);
		return Navigation.PRODUCT_DEPOT_ALLOT_CREATE;
	}
	
	/**
	 * 此方法绑定于仓库库存调拨登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【仓库库存调拨登陆画面_返回按钮】");
		return productDepotAllotCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于仓库库存调拨登陆画面的保存按钮 
	 * 实现功能：根据transferProductDepotAllot对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveProductDepotAllot() {
		Tool.sendLog(LOG, userBean, "【仓库库存调拨登陆画面_保存按钮】");
		ProductDepotAllot transferProductDepotAllot = productDepotAllotCreateDto.getTransferProductDepotAllot();
		operate(transferProductDepotAllot);
	}
	
	/**
	 * 此方法绑定于仓库库存调拨登陆画面的确认按钮 
	 * 实现功能：根据transferProductDepotAllot对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void queryProductDepotAllot() {
		Tool.sendLog(LOG, userBean, "【仓库库存调拨登陆画面_确认按钮】");
		ProductDepotAllot transferProductDepotAllot = productDepotAllotCreateDto.getTransferProductDepotAllot();
		productDepotAllotCreateDto.setState(true);
		operate(transferProductDepotAllot);
	}

	/**
	 * 对数据信息进行保存或者更新操作
	 * @param transferProductDepotAllot
	 */
	private void operate(ProductDepotAllot transferProductDepotAllot) {
		boolean state = false;
		DepotInfo allotDepotInfo = productDepotAllotCreateDto.getAllotDepotInfo();
		if (allotDepotInfo == null) {
			Tool.sendErrorMessage("调往仓库必须选择!");
			state = true;
		}
		if (BigDecimalUtil.isNullOrZero(productDepotAllotCreateDto.getNumber())) {
			Tool.sendErrorMessage("调往数量必须填写！");
			state = true;
		}
		DepotInfo depotInfo = productDepotAllotCreateDto.getDepotInfo();
		if (depotInfo != null && allotDepotInfo.equals(depotInfo)) {
			Tool.sendErrorMessage("调往仓库不能和原仓库相同!");
			state = true;
		}
		if (BigDecimalUtil.bigThan(productDepotAllotCreateDto.getNumber(), productDepotAllotCreateDto.getProductStockDetail().getNumber())) {
			Tool.sendErrorMessage("调往数量不能大于原数量!");
			state = true;
		}
		if (state) {
			return;
		}
		try {
			if (transferProductDepotAllot == null) {
				transferProductDepotAllot = new ProductDepotAllot();
				productDepotAllotCreateDto.setCreater(userBean.getUser());
				productDepotAllotCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
				create(transferProductDepotAllot);
				transferProductDepotAllot.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
				productDepotAllotService.saveProductDepotAllot(transferProductDepotAllot);
				
				productDepotAllotCreateDto.setTransferProductDepotAllot(transferProductDepotAllot);
				Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
			} else {
				create(transferProductDepotAllot);
				transferProductDepotAllot.setUpdateDate(DateUtil.getNowyyyymmdd());
				productDepotAllotService.updateProductDepotAllot(transferProductDepotAllot);
				Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
			}
		} catch (ProductDepotAllotException e) {
			Tool.sendErrorMessage(e.getMessage());
		}
	}
	
	/**
	 * 赋值
	 * @param transferProductDepotAllot
	 */
	private void create(ProductDepotAllot transferProductDepotAllot) {
		ProductDepotAllotCreateDxo.dtoToEntity(productDepotAllotCreateDto, transferProductDepotAllot);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		productDepotAllotCreateDto.setReturner(returner);
		return Navigation.PRODUCT_DEPOT_ALLOT_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, ProductDepotAllot productDepotAllot) {
		productDepotAllotCreateDto.setReturner(returner);
		ProductDepotAllotCreateDxo.entityToDto(productDepotAllot, productDepotAllotCreateDto);
		productDepotAllotCreateDto.setTransferProductDepotAllot(productDepotAllot);
		return Navigation.PRODUCT_DEPOT_ALLOT_CREATE;
	}
	
	/**
	 * 此方法绑定于仓库库存调拨登陆画面的选择原仓库时候的验证事件 
	 * @return 画面不跳转
	 */
	public void validate() {
		Tool.sendLog(LOG, userBean, "按下【仓库库存调拨登陆画面_验证事件】");
		DepotInfo depotInfo = productDepotAllotCreateDto.getDepotInfo();
		// 验证和原先选择的仓库是否是同一个
		ProductStockDetail productStockDetail = productDepotAllotCreateDto.getProductStockDetail();
		if (depotInfo != null && productStockDetail != null) {
			// 如果不相同就清空以下数据
			if (!depotInfo.equals(productStockDetail.getDepotInfo())) {
				productDepotAllotCreateDto.setProductStockDetail(null);
				productDepotAllotCreateDto.setAllotDepotInfo(null);
				productDepotAllotCreateDto.setAllotProductStockDetail(null);
				productDepotAllotCreateDto.setNumber(null);
				productDepotAllotCreateDto.setState(false);
			}
		}
	}
	
	/**
	 * 此方法绑定于仓库库存调拨登陆画面的选择产品按钮 
	 * @return 画面不跳转
	 */
	public void findProductStock() {
		Tool.sendLog(LOG, userBean, "按下【仓库库存调拨登陆画面_选择产品按钮】");
		select();
	}

	/**
	 * 此方法绑定于仓库库存调拨登陆画面的搜索按钮 
	 * @return 画面不跳转
	 */
	public void selectProductStock() {
		Tool.sendLog(LOG, userBean, "按下【仓库库存调拨登陆画面_搜索按钮】");
		select();
	}
	
	private void select() {
		if (productDepotAllotCreateDto.getDepotInfo() == null) {
			Tool.sendErrorMessage("原仓库必须选择！");
			return;
		}
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProductStockDetail.class);
		detachedCriteria.createAlias(ProductStockDetail.DEPOT_INFO, ProductStockDetail.DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProductStockDetail.PRODUCT_STOCK, ProductStockDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ProductStockDetail.DEPOT_INFO, productDepotAllotCreateDto.getDepotInfo()));
		String productStockName = productDepotAllotCreateDto.getProductStockName();
		if (StringUtil.isNotBlank(productStockName)) {
			detachedCriteria.add(Restrictions.like(ProductStockDetail.PRODUCT_STOCK_NAME, productStockName, MatchMode.ANYWHERE));
		}
		productDepotAllotCreateDto.setProductStockDetailList(productStockDetailService.getByDetachedCriteria(detachedCriteria, 0, 10));
	}
	
	/**
	 * 此方法绑定于仓库库存调拨登陆画面的选择按钮 
	 * @return 画面不跳转
	 */
	public void findProductStockDetail(ProductStockDetail productStockDetail) {
		Tool.sendLog(LOG, userBean, "按下【仓库库存调拨登陆画面_选择按钮】");
		productDepotAllotCreateDto.setProductStockDetail(productStockDetail);
	}
	
	/**
	 * @param productStockDetailService the productStockDetailService to set
	 */
	public void setProductStockDetailService(
			ProductStockDetailService productStockDetailService) {
		this.productStockDetailService = productStockDetailService;
	}

	/**
	 * set productDepotAllotService
	 * @param productDepotAllotService the productDepotAllotService to set
	 */
	public void setProductDepotAllotService(ProductDepotAllotService productDepotAllotService) {
		this.productDepotAllotService = productDepotAllotService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get productDepotAllotCreateDto
	 * @return the productDepotAllotCreateDto
	 */
	public ProductDepotAllotCreateDto getProductDepotAllotCreateDto() {
		return productDepotAllotCreateDto;
	}

	/**
	 * set productDepotAllotCreateDto
	 * @param productDepotAllotCreateDto the productDepotAllotCreateDto to set
	 */
	public void setProductDepotAllotCreateDto(ProductDepotAllotCreateDto productDepotAllotCreateDto) {
		this.productDepotAllotCreateDto = productDepotAllotCreateDto;
	}

}

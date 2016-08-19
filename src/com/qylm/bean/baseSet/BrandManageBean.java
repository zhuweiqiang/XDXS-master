package com.qylm.bean.baseSet;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataIntegrityViolationException;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.baseSet.BrandManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.baseSet.BrandManageDto;
import com.qylm.entity.Brand;
import com.qylm.service.BrandService;

/**
 * 品牌管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class BrandManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4066264513617842142L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(BrandManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private BrandManageDto brandManageDto = new BrandManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<Brand> brandList;
	
	/**
	 * 删除复选框选择的值
	 */
	private Brand[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{brandService}")
	private BrandService brandService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_品牌菜单】");
		fetchData(0, true);
		return Navigation.BRAND_MANAGE;
	}
	
	/**
	 * 此方法绑定于品牌管理画面的新建按钮 
	 * 实现功能：跳转至品牌登陆画面，新建一家事件
	 * @return 品牌登陆画面
	 */
	public String newBrand() {
		Tool.sendLog(LOG, userBean, "按下【品牌管理画面_新建按钮】");
		return Tool.getBackBean(BrandCreateBean.class).newCreate(new BrandManageReturner(brandManageDto, currentPage));
	}

	/**
	 * 此方法绑定于品牌管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至品牌登陆画面
	 * @return 品牌登陆画面
	 */
	public String updateBrand(Brand transferBrand) {
		Tool.sendLog(LOG, userBean, "按下【品牌管理画面_修改按钮】");
		return Tool.getBackBean(BrandCreateBean.class).updateDetail(new BrandManageReturner(brandManageDto, currentPage), transferBrand);
	}
	
	/**
	 * 此方法绑定于品牌管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectBrand() {
		Tool.sendLog(LOG, userBean, "按下【品牌管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于品牌管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【品牌管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<Brand> asList = Arrays.asList(selectedModels);
				brandService.deleteEntityAll(asList);
				brandList.removeAll(asList);
				removeData(1, brandList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
		
	}

	/**
	 * 此方法绑定于品牌管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteBrand(Brand transferBrand) {
		Tool.sendLog(LOG, userBean, "按下【品牌管理画面的_删除按钮】");
		try {
			brandService.deleteEntity(transferBrand);
			brandList.remove(transferBrand);
			removeData(1, brandList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(Brand transferBrand) {
		Tool.sendLog(LOG, userBean, "按下【品牌管理画面的_视图按钮】");
		if (transferBrand == null) {
			transferBrand = brandService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(BrandViewBean.class).viewDetail(transferBrand);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Brand.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String name = brandManageDto.getName();
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.eq(Brand.NAME, name));
		}
		brandList = brandService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(brandService.getRowCount(detachedCriteria));
		}
		
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.BRAND_MANAGE;
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
	 * get brandManageDto
	 * @return the brandManageDto
	 */
	public BrandManageDto getBrandManageDto() {
		return brandManageDto;
	}

	/**
	 * set brandManageDto
	 * @param brandManageDto the brandManageDto to set
	 */
	public void setBrandManageDto(BrandManageDto brandManageDto) {
		this.brandManageDto = brandManageDto;
	}

	/**
	 * get brandList
	 * @return the brandList
	 */
	public List<Brand> getBrandList() {
		return brandList;
	}

	/**
	 * set brandList
	 * @param brandList the brandList to set
	 */
	public void setBrandList(List<Brand> brandList) {
		this.brandList = brandList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public Brand[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(Brand[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}

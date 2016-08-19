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
import org.hibernate.sql.JoinType;
import org.springframework.dao.DataIntegrityViolationException;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.baseSet.SeriesManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.baseSet.SeriesManageDto;
import com.qylm.entity.Brand;
import com.qylm.entity.Series;
import com.qylm.service.SeriesService;

/**
 * 系类管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class SeriesManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3592982283251005939L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(SeriesManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private SeriesManageDto seriesManageDto = new SeriesManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<Series> seriesList;
	
	/**
	 * 删除复选框选择的值
	 */
	private Series[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{seriesService}")
	private SeriesService seriesService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_系类菜单】");
		fetchData(0, true);
		return Navigation.SERIES_MANAGE;
	}
	
	/**
	 * 此方法绑定于系类管理画面的新建按钮 
	 * 实现功能：跳转至系类登陆画面，新建一家事件
	 * @return 系类登陆画面
	 */
	public String newSeries() {
		Tool.sendLog(LOG, userBean, "按下【系类管理画面_新建按钮】");
		return Tool.getBackBean(SeriesCreateBean.class).newCreate(new SeriesManageReturner(seriesManageDto, currentPage));
	}

	/**
	 * 此方法绑定于系类管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至系类登陆画面
	 * @return 系类登陆画面
	 */
	public String updateSeries(Series transferSeries) {
		Tool.sendLog(LOG, userBean, "按下【系类管理画面_修改按钮】");
		return Tool.getBackBean(SeriesCreateBean.class).updateDetail(new SeriesManageReturner(seriesManageDto, currentPage), transferSeries);
	}
	
	/**
	 * 此方法绑定于系类管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectSeries() {
		Tool.sendLog(LOG, userBean, "按下【系类管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于系类管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【系类管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<Series> asList = Arrays.asList(selectedModels);
				seriesService.deleteEntityAll(asList);
				seriesList.removeAll(asList);
				removeData(1, seriesList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
		
	}

	/**
	 * 此方法绑定于系类管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteSeries(Series transferSeries) {
		Tool.sendLog(LOG, userBean, "按下【系类管理画面的_删除按钮】");
		try {
			seriesService.deleteEntity(transferSeries);
			seriesList.remove(transferSeries);
			removeData(1, seriesList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(Series transferSeries) {
		Tool.sendLog(LOG, userBean, "按下【系类管理画面的_视图按钮】");
		if (transferSeries == null) {
			transferSeries = seriesService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(SeriesViewBean.class).viewDetail(transferSeries);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Series.class);
		detachedCriteria.createAlias(Series.BRAND, Series.BRAND, JoinType.LEFT_OUTER_JOIN);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String name = seriesManageDto.getName();
		Brand brand = seriesManageDto.getBrand();
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.eq(Series.NAME, name));
		}
		if (brand != null) {
			detachedCriteria.add(Restrictions.eq(Series.BRAND, brand));
		}
		seriesList = seriesService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(seriesService.getRowCount(detachedCriteria));
		}
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.SERIES_MANAGE;
	}

	/**
	 * set seriesService
	 * @param seriesService the seriesService to set
	 */
	public void setSeriesService(SeriesService seriesService) {
		this.seriesService = seriesService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get seriesManageDto
	 * @return the seriesManageDto
	 */
	public SeriesManageDto getSeriesManageDto() {
		return seriesManageDto;
	}

	/**
	 * set seriesManageDto
	 * @param seriesManageDto the seriesManageDto to set
	 */
	public void setSeriesManageDto(SeriesManageDto seriesManageDto) {
		this.seriesManageDto = seriesManageDto;
	}

	/**
	 * get seriesList
	 * @return the seriesList
	 */
	public List<Series> getSeriesList() {
		return seriesList;
	}

	/**
	 * set seriesList
	 * @param seriesList the seriesList to set
	 */
	public void setSeriesList(List<Series> seriesList) {
		this.seriesList = seriesList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public Series[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(Series[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}

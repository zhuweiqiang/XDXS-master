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
import com.qylm.dto.baseSet.SeriesCreateDto;
import com.qylm.dxo.SeriesCreateDxo;
import com.qylm.entity.Series;
import com.qylm.service.SeriesService;

/**
 * 系类登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class SeriesCreateBean implements Serializable, CreateBean<Series> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7963142334474862455L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(SeriesCreateBean.class);

	/**
	 * 存放系类登陆画面需要保存的值
	 */
	private SeriesCreateDto seriesCreateDto = new SeriesCreateDto();
	
	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 系类业务类
	 */
	@ManagedProperty(value="#{seriesService}")
	private SeriesService seriesService;
	
	/**
	 * 此方法绑定于系类登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 系类登陆画面
	 */
	public String newSeries() {
		Tool.sendLog(LOG, userBean, "【系类登陆画面_新建按钮】");
		seriesCreateDto.setBrand(null);
		seriesCreateDto.setName(null);
		seriesCreateDto.setRemark(null);
		seriesCreateDto.setCreater(null);
		seriesCreateDto.setBelongingUser(null);
		seriesCreateDto.setTransferSeries(null);
		return Navigation.SERIES_CREATE;
	}
	
	/**
	 * 此方法绑定于系类登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【系类登陆画面_返回按钮】");
		return seriesCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于系类登陆画面的保存按钮 
	 * 实现功能：根据transferSeries对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveSeries() {
		Tool.sendLog(LOG, userBean, "【系类登陆画面_保存按钮】");
		Series transferSeries = seriesCreateDto.getTransferSeries();
		if (transferSeries == null) {
			transferSeries = new Series();
			seriesCreateDto.setCreater(userBean.getUser());
			seriesCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferSeries);
			transferSeries.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			seriesService.saveEntity(transferSeries);
			seriesCreateDto.setTransferSeries(transferSeries);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferSeries);
			transferSeries.setUpdateDate(DateUtil.getNowyyyymmdd());
			seriesService.updateEntity(transferSeries);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferSeries
	 */
	private void create(Series transferSeries) {
		SeriesCreateDxo.dtoToEntity(seriesCreateDto, transferSeries);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		seriesCreateDto.setReturner(returner);
		return Navigation.SERIES_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, Series series) {
		seriesCreateDto.setReturner(returner);
		SeriesCreateDxo.entityToDto(series, seriesCreateDto);
		seriesCreateDto.setTransferSeries(series);
		return Navigation.SERIES_CREATE;
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
	 * get seriesCreateDto
	 * @return the seriesCreateDto
	 */
	public SeriesCreateDto getSeriesCreateDto() {
		return seriesCreateDto;
	}

	/**
	 * set seriesCreateDto
	 * @param seriesCreateDto the seriesCreateDto to set
	 */
	public void setSeriesCreateDto(SeriesCreateDto seriesCreateDto) {
		this.seriesCreateDto = seriesCreateDto;
	}

}

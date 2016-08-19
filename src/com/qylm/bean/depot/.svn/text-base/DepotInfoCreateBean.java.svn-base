package com.qylm.bean.depot;

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
import com.qylm.dto.depot.DepotInfoCreateDto;
import com.qylm.dxo.DepotInfoCreateDxo;
import com.qylm.entity.DepotInfo;
import com.qylm.service.DepotInfoService;

/**
 * 仓库信息登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class DepotInfoCreateBean implements Serializable, CreateBean<DepotInfo> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4496696563045641052L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(DepotInfoCreateBean.class);

	/**
	 * 存放仓库信息登陆画面需要保存的值
	 */
	private DepotInfoCreateDto depotInfoCreateDto = new DepotInfoCreateDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件业务类
	 */
	@ManagedProperty(value="#{depotInfoService}")
	private DepotInfoService depotInfoService;
	
	/**
	 * 此方法绑定于仓库信息登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 仓库信息登陆画面
	 */
	public String newDepotInfo() {
		Tool.sendLog(LOG, userBean, "【仓库信息登陆画面_新建按钮】");
		depotInfoCreateDto.setName(null);
		depotInfoCreateDto.setRemark(null);
		depotInfoCreateDto.setCreater(null);
		depotInfoCreateDto.setBelongingUser(null);
		depotInfoCreateDto.setTransferDepotInfo(null);
		return Navigation.DEPOT_INFO_CREATE;
	}
	
	/**
	 * 此方法绑定于仓库信息登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【仓库信息登陆画面_返回按钮】");
		return depotInfoCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于仓库信息登陆画面的保存按钮 
	 * 实现功能：根据transferDepotInfo对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveDepotInfo() {
		Tool.sendLog(LOG, userBean, "【仓库信息登陆画面_保存按钮】");
		DepotInfo transferDepotInfo = depotInfoCreateDto.getTransferDepotInfo();
		if (transferDepotInfo == null) {
			transferDepotInfo = new DepotInfo();
			depotInfoCreateDto.setCreater(userBean.getUser());
			depotInfoCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferDepotInfo);
			transferDepotInfo.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			depotInfoService.saveEntity(transferDepotInfo);
			depotInfoCreateDto.setTransferDepotInfo(transferDepotInfo);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferDepotInfo);
			transferDepotInfo.setUpdateDate(DateUtil.getNowyyyymmdd());
			depotInfoService.updateEntity(transferDepotInfo);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferDepotInfo
	 */
	private void create(DepotInfo transferDepotInfo) {
		DepotInfoCreateDxo.dtoToEntity(depotInfoCreateDto, transferDepotInfo);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		depotInfoCreateDto.setReturner(returner);
		return Navigation.DEPOT_INFO_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, DepotInfo depotInfo) {
		depotInfoCreateDto.setReturner(returner);
		DepotInfoCreateDxo.entityToDto(depotInfo, depotInfoCreateDto);
		depotInfoCreateDto.setTransferDepotInfo(depotInfo);
		return Navigation.DEPOT_INFO_CREATE;
	}
	
	/**
	 * set depotInfoService
	 * @param depotInfoService the depotInfoService to set
	 */
	public void setDepotInfoService(DepotInfoService depotInfoService) {
		this.depotInfoService = depotInfoService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get depotInfoCreateDto
	 * @return the depotInfoCreateDto
	 */
	public DepotInfoCreateDto getDepotInfoCreateDto() {
		return depotInfoCreateDto;
	}

	/**
	 * set depotInfoCreateDto
	 * @param depotInfoCreateDto the depotInfoCreateDto to set
	 */
	public void setDepotInfoCreateDto(DepotInfoCreateDto depotInfoCreateDto) {
		this.depotInfoCreateDto = depotInfoCreateDto;
	}

}

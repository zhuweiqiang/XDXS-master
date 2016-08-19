package com.qylm.bean.personnel;

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
import com.qylm.dto.personnel.PersonnelInfoCreateDto;
import com.qylm.dxo.PersonnelInfoCreateDxo;
import com.qylm.entity.PersonnelInfo;
import com.qylm.service.PersonnelInfoService;

/**
 * 人事信息登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class PersonnelInfoCreateBean implements Serializable, CreateBean<PersonnelInfo> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1925436221682658536L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(PersonnelInfoCreateBean.class);

	/**
	 * 存放人事信息登陆画面需要保存的值
	 */
	private PersonnelInfoCreateDto personnelInfoCreateDto = new PersonnelInfoCreateDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件业务类
	 */
	@ManagedProperty(value="#{personnelInfoService}")
	private PersonnelInfoService personnelInfoService;
	
	/**
	 * 此方法绑定于人事信息登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 人事信息登陆画面
	 */
	public String newPersonnelInfo() {
		Tool.sendLog(LOG, userBean, "【人事信息登陆画面_新建按钮】");
		personnelInfoCreateDto.setWorkNumber(null);
		personnelInfoCreateDto.setName(null);
		personnelInfoCreateDto.setWorkState(PersonnelInfo.WORK_STATE_1);
		personnelInfoCreateDto.setSex(null);
		personnelInfoCreateDto.setBirthDate(null);
		personnelInfoCreateDto.setPoliticalStatus(null);
		personnelInfoCreateDto.setNation(null);
		personnelInfoCreateDto.setMobile(null);
		personnelInfoCreateDto.setMarriage(null);
		personnelInfoCreateDto.setIdentification(null);
		personnelInfoCreateDto.setFormalSchooling(null);
		personnelInfoCreateDto.setCreater(null);
		personnelInfoCreateDto.setBelongingUser(null);
		personnelInfoCreateDto.setTransferPersonnelInfo(null);
		return Navigation.PERSONNEL_INFO_CREATE;
	}
	
	/**
	 * 此方法绑定于人事信息登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【人事信息登陆画面_返回按钮】");
		return personnelInfoCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于人事信息登陆画面的保存按钮 
	 * 实现功能：根据transferPersonnelInfo对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void savePersonnelInfo() {
		Tool.sendLog(LOG, userBean, "【人事信息登陆画面_保存按钮】");
		PersonnelInfo transferPersonnelInfo = personnelInfoCreateDto.getTransferPersonnelInfo();
		if (transferPersonnelInfo == null) {
			transferPersonnelInfo = new PersonnelInfo();
			personnelInfoCreateDto.setCreater(userBean.getUser());
			personnelInfoCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferPersonnelInfo);
			transferPersonnelInfo.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			personnelInfoService.saveEntity(transferPersonnelInfo);
			personnelInfoCreateDto.setTransferPersonnelInfo(transferPersonnelInfo);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferPersonnelInfo);
			transferPersonnelInfo.setUpdateDate(DateUtil.getNowyyyymmdd());
			personnelInfoService.updateEntity(transferPersonnelInfo);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferPersonnelInfo
	 */
	private void create(PersonnelInfo transferPersonnelInfo) {
		PersonnelInfoCreateDxo.dtoToEntity(personnelInfoCreateDto, transferPersonnelInfo);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		personnelInfoCreateDto.setReturner(returner);
		personnelInfoCreateDto.setWorkState(PersonnelInfo.WORK_STATE_1);
		return Navigation.PERSONNEL_INFO_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, PersonnelInfo personnelInfo) {
		personnelInfoCreateDto.setReturner(returner);
		PersonnelInfoCreateDxo.entityToDto(personnelInfo, personnelInfoCreateDto);
		personnelInfoCreateDto.setTransferPersonnelInfo(personnelInfo);
		return Navigation.PERSONNEL_INFO_CREATE;
	}
	
	/**
	 * set personnelInfoService
	 * @param personnelInfoService the personnelInfoService to set
	 */
	public void setPersonnelInfoService(PersonnelInfoService personnelInfoService) {
		this.personnelInfoService = personnelInfoService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get personnelInfoCreateDto
	 * @return the personnelInfoCreateDto
	 */
	public PersonnelInfoCreateDto getPersonnelInfoCreateDto() {
		return personnelInfoCreateDto;
	}

	/**
	 * set personnelInfoCreateDto
	 * @param personnelInfoCreateDto the personnelInfoCreateDto to set
	 */
	public void setPersonnelInfoCreateDto(PersonnelInfoCreateDto personnelInfoCreateDto) {
		this.personnelInfoCreateDto = personnelInfoCreateDto;
	}

}

package com.qylm.bean.custom;

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
import com.qylm.dto.custom.LargessRecordCreateDto;
import com.qylm.dxo.LargessRecordCreateDxo;
import com.qylm.entity.LargessRecord;
import com.qylm.service.LargessRecordService;

/**
 * 赠送项目记录登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class LargessRecordCreateBean implements Serializable, CreateBean<LargessRecord> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4351540093332748231L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(LargessRecordCreateBean.class);

	/**
	 * 存放赠送项目记录登陆画面需要保存的值
	 */
	private LargessRecordCreateDto largessRecordCreateDto = new LargessRecordCreateDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件业务类
	 */
	@ManagedProperty(value="#{largessRecordService}")
	private LargessRecordService largessRecordService;
	
	/**
	 * 此方法绑定于赠送项目记录登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 赠送项目记录登陆画面
	 */
	public String newLargessRecord() {
		Tool.sendLog(LOG, userBean, "【赠送项目记录登陆画面_新建按钮】");
		largessRecordCreateDto.setCustomInfo(null);
		largessRecordCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		largessRecordCreateDto.setMarketingProject(null);
		largessRecordCreateDto.setRemark(null);
		largessRecordCreateDto.setNumber(null);
		largessRecordCreateDto.setMoney(null);
		largessRecordCreateDto.setSurplusNumber(null);
		largessRecordCreateDto.setBalance(null);
		largessRecordCreateDto.setPersonnelInfo1(null);
		largessRecordCreateDto.setPersonnelInfo2(null);
		largessRecordCreateDto.setCreater(null);
		largessRecordCreateDto.setBelongingUser(null);
		largessRecordCreateDto.setTransferLargessRecord(null);
		return Navigation.LARGESS_RECORD_CREATE;
	}
	
	/**
	 * 此方法绑定于赠送项目记录登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【赠送项目记录登陆画面_返回按钮】");
		return largessRecordCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于赠送项目记录登陆画面的保存按钮 
	 * 实现功能：根据transferLargessRecord对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveLargessRecord() {
		Tool.sendLog(LOG, userBean, "【赠送项目记录登陆画面_保存按钮】");
		LargessRecord transferLargessRecord = largessRecordCreateDto.getTransferLargessRecord();
		if (transferLargessRecord == null) {
			transferLargessRecord = new LargessRecord();
			largessRecordCreateDto.setCreater(userBean.getUser());
			largessRecordCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferLargessRecord);
			transferLargessRecord.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			largessRecordService.saveEntity(transferLargessRecord);
			largessRecordCreateDto.setTransferLargessRecord(transferLargessRecord);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferLargessRecord);
			transferLargessRecord.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			largessRecordService.updateEntity(transferLargessRecord);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferLargessRecord
	 */
	private void create(LargessRecord transferLargessRecord) {
		largessRecordCreateDto.setSurplusNumber(largessRecordCreateDto.getNumber());
		largessRecordCreateDto.setBalance(largessRecordCreateDto.getMoney());
		LargessRecordCreateDxo.dtoToEntity(largessRecordCreateDto, transferLargessRecord);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		largessRecordCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		largessRecordCreateDto.setCreater(userBean.getUser());
		largessRecordCreateDto.setReturner(returner);
		return Navigation.LARGESS_RECORD_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, LargessRecord largessRecord) {
		largessRecordCreateDto.setReturner(returner);
		LargessRecordCreateDxo.entityToDto(largessRecord, largessRecordCreateDto);
		return Navigation.LARGESS_RECORD_CREATE;
	}
	
	/**
	 * set largessRecordService
	 * @param largessRecordService the largessRecordService to set
	 */
	public void setLargessRecordService(LargessRecordService largessRecordService) {
		this.largessRecordService = largessRecordService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get largessRecordCreateDto
	 * @return the largessRecordCreateDto
	 */
	public LargessRecordCreateDto getLargessRecordCreateDto() {
		return largessRecordCreateDto;
	}

	/**
	 * set largessRecordCreateDto
	 * @param largessRecordCreateDto the largessRecordCreateDto to set
	 */
	public void setLargessRecordCreateDto(LargessRecordCreateDto largessRecordCreateDto) {
		this.largessRecordCreateDto = largessRecordCreateDto;
	}

}

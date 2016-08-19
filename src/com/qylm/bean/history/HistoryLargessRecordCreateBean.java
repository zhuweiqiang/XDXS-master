package com.qylm.bean.history;

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
import com.qylm.dto.history.HistoryLargessRecordCreateDto;
import com.qylm.dxo.HistoryLargessRecordCreateDxo;
import com.qylm.entity.LargessRecord;
import com.qylm.service.LargessRecordService;

/**
 * 客户赠送记录登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class HistoryLargessRecordCreateBean implements Serializable, CreateBean<LargessRecord> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7242383994149285300L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(HistoryLargessRecordCreateBean.class);

	/**
	 * 存放客户赠送记录登陆画面需要保存的值
	 */
	private HistoryLargessRecordCreateDto historyLargessRecordCreateDto = new HistoryLargessRecordCreateDto();
	
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
	 * 此方法绑定于客户赠送记录登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 客户赠送记录登陆画面
	 */
	public String newLargessRecord() {
		Tool.sendLog(LOG, userBean, "【客户赠送记录登陆画面_新建按钮】");
		historyLargessRecordCreateDto.setCustomInfo(null);
		historyLargessRecordCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		historyLargessRecordCreateDto.setMarketingProject(null);
		historyLargessRecordCreateDto.setRemark(null);
		historyLargessRecordCreateDto.setNumber(null);
		historyLargessRecordCreateDto.setMoney(null);
		historyLargessRecordCreateDto.setSurplusNumber(null);
		historyLargessRecordCreateDto.setBalance(null);
		historyLargessRecordCreateDto.setPersonnelInfo1(null);
		historyLargessRecordCreateDto.setPersonnelInfo2(null);
		historyLargessRecordCreateDto.setCreater(null);
		historyLargessRecordCreateDto.setBelongingUser(null);
		historyLargessRecordCreateDto.setTransferLargessRecord(null);
		return Navigation.HISTORY_LARGESS_RECORD_CREATE;
	}
	
	/**
	 * 此方法绑定于客户赠送记录登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【客户赠送记录登陆画面_返回按钮】");
		return historyLargessRecordCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于客户赠送记录登陆画面的保存按钮 
	 * 实现功能：根据transferLargessRecord对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveLargessRecord() {
		Tool.sendLog(LOG, userBean, "【客户赠送记录登陆画面_保存按钮】");
		LargessRecord transferLargessRecord = historyLargessRecordCreateDto.getTransferLargessRecord();
		if (transferLargessRecord == null) {
			transferLargessRecord = new LargessRecord();
			historyLargessRecordCreateDto.setCreater(userBean.getUser());
			historyLargessRecordCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferLargessRecord);
			transferLargessRecord.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			largessRecordService.saveEntity(transferLargessRecord);
			historyLargessRecordCreateDto.setTransferLargessRecord(transferLargessRecord);
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
		historyLargessRecordCreateDto.setBalance(historyLargessRecordCreateDto.getMoney());
		HistoryLargessRecordCreateDxo.dtoToEntity(historyLargessRecordCreateDto, transferLargessRecord);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		historyLargessRecordCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		historyLargessRecordCreateDto.setCreater(userBean.getUser());
		historyLargessRecordCreateDto.setReturner(returner);
		return Navigation.HISTORY_LARGESS_RECORD_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, LargessRecord largessRecord) {
		historyLargessRecordCreateDto.setReturner(returner);
		historyLargessRecordCreateDto.setTransferLargessRecord(largessRecord);
		HistoryLargessRecordCreateDxo.entityToDto(largessRecord, historyLargessRecordCreateDto);
		return Navigation.HISTORY_LARGESS_RECORD_CREATE;
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
	 * get historyLargessRecordCreateDto
	 * @return the historyLargessRecordCreateDto
	 */
	public HistoryLargessRecordCreateDto getHistoryLargessRecordCreateDto() {
		return historyLargessRecordCreateDto;
	}

	/**
	 * set historyLargessRecordCreateDto
	 * @param historyLargessRecordCreateDto the historyLargessRecordCreateDto to set
	 */
	public void setHistoryLargessRecordCreateDto(HistoryLargessRecordCreateDto historyLargessRecordCreateDto) {
		this.historyLargessRecordCreateDto = historyLargessRecordCreateDto;
	}

}

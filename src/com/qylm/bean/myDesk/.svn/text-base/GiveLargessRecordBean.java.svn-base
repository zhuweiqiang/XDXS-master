package com.qylm.bean.myDesk;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.dto.myDesk.GiveLargessRecordDto;
import com.qylm.dxo.GiveLargessRecordDxo;
import com.qylm.entity.LargessRecord;
import com.qylm.service.LargessRecordService;

/**
 * 赠送项目登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class GiveLargessRecordBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2972374827219545605L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(GiveLargessRecordBean.class);

	/**
	 * 存放赠送项目登陆画面需要保存的值
	 */
	private GiveLargessRecordDto giveLargessRecordDto = new GiveLargessRecordDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 项目信息业务类
	 */
	@ManagedProperty(value="#{largessRecordService}")
	private LargessRecordService largessRecordService;
	
	/**
	 * 此方法绑定于赠送项目登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 赠送项目登陆画面
	 */
	public String newGiveLargessRecord() {
		Tool.sendLog(LOG, userBean, "【赠送项目登陆画面_新建按钮】");
		giveLargessRecordDto.setCustomInfo(null);
		giveLargessRecordDto.setDate(DateUtil.getNowyyyymmdd());
		giveLargessRecordDto.setMarketingProject(null);
		giveLargessRecordDto.setRemark(null);
		giveLargessRecordDto.setNumber(null);
		giveLargessRecordDto.setMoney(null);
		giveLargessRecordDto.setSurplusNumber(null);
		giveLargessRecordDto.setBalance(null);
		giveLargessRecordDto.setPersonnelInfo1(null);
		giveLargessRecordDto.setPersonnelInfo2(null);
		giveLargessRecordDto.setCreater(null);
		giveLargessRecordDto.setBelongingUser(null);
		return Navigation.GIVE_LARGESS_RECORD;
	}
	
	/**
	 * 此方法绑定于赠送项目登陆画面的确认赠送按钮
	 */
	public void save() {
		Tool.sendLog(LOG, userBean, "【赠送项目登陆画面_确认赠送按钮】");
		giveLargessRecordDto.setCreater(userBean.getUser());
		giveLargessRecordDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
		giveLargessRecordDto.setSurplusNumber(giveLargessRecordDto.getNumber());
		LargessRecord largessRecord = new LargessRecord();
		GiveLargessRecordDxo.dtoToEntity(giveLargessRecordDto, largessRecord);
		largessRecord.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
		largessRecordService.saveEntity(largessRecord);
		Tool.sendErrorMessage("赠送成功！");
		newGiveLargessRecord();
	}
	
	/**
	 * 此方法绑定于赠送项目登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【赠送项目登陆画面_返回按钮】");
		return giveLargessRecordDto.getReturner().returnOnly();
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		giveLargessRecordDto.setReturner(returner);
		giveLargessRecordDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		return Navigation.GIVE_LARGESS_RECORD;
	}
	
	/**
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
	 * get giveLargessRecordDto
	 * @return the giveLargessRecordDto
	 */
	public GiveLargessRecordDto getGiveLargessRecordDto() {
		return giveLargessRecordDto;
	}

	/**
	 * set giveLargessRecordDto
	 * @param giveLargessRecordDto the giveLargessRecordDto to set
	 */
	public void setGiveLargessRecordDto(GiveLargessRecordDto giveLargessRecordDto) {
		this.giveLargessRecordDto = giveLargessRecordDto;
	}

}

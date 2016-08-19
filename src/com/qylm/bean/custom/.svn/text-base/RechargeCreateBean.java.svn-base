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
import com.qylm.dto.custom.RechargeCreateDto;
import com.qylm.dxo.RechargeCreateDxo;
import com.qylm.entity.Recharge;
import com.qylm.service.RechargeService;

/**
 * 会员充值记录登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class RechargeCreateBean implements Serializable, CreateBean<Recharge> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5607507198109643988L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(RechargeCreateBean.class);

	/**
	 * 存放会员充值记录登陆画面需要保存的值
	 */
	private RechargeCreateDto rechargeCreateDto = new RechargeCreateDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件业务类
	 */
	@ManagedProperty(value="#{rechargeService}")
	private RechargeService rechargeService;
	
	/**
	 * 此方法绑定于会员充值记录登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 会员充值记录登陆画面
	 */
	public String newRecharge() {
		Tool.sendLog(LOG, userBean, "【会员充值记录登陆画面_新建按钮】");
		rechargeCreateDto.setCustomInfo(null);
		rechargeCreateDto.setRechargeDate(DateUtil.getNowyyyymmddhhmmss());
		rechargeCreateDto.setMoney(null);
		rechargeCreateDto.setCreater(userBean.getUser());
		rechargeCreateDto.setBelongingUser(null);
		rechargeCreateDto.setTransferRecharge(null);
		rechargeCreateDto.setState(false);
		return Navigation.RECHARGE_CREATE;
	}
	
	/**
	 * 此方法绑定于会员充值记录登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【会员充值记录登陆画面_返回按钮】");
		return rechargeCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于会员充值记录登陆画面的保存按钮 
	 * 实现功能：根据transferRecharge对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveRecharge() {
		Tool.sendLog(LOG, userBean, "【会员充值记录登陆画面_保存按钮】");
		Recharge transferRecharge = rechargeCreateDto.getTransferRecharge();
		if (transferRecharge == null) {
			transferRecharge = new Recharge();
			rechargeCreateDto.setCreater(userBean.getUser());
			rechargeCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferRecharge);
			transferRecharge.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			rechargeService.saveEntity(transferRecharge);
			rechargeCreateDto.setTransferRecharge(transferRecharge);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferRecharge);
			transferRecharge.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			rechargeService.updateEntity(transferRecharge);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 此方法绑定于会员充值记录登陆画面的确认充值按钮 
	 * 实现功能：确认充值记录，并更新客户档案的金额信息，确认后信息不可修改
	 * @return 画面不跳转
	 */
	public void querRecharge() {
		Tool.sendLog(LOG, userBean, "【会员充值记录登陆画面_确认充值按钮】");
		rechargeCreateDto.setState(true);
		Recharge transferRecharge = rechargeCreateDto.getTransferRecharge();
		if (transferRecharge == null) {
			transferRecharge = new Recharge();
			rechargeCreateDto.setCreater(userBean.getUser());
			rechargeCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferRecharge);
			transferRecharge.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			rechargeService.updateQueryRecharge(transferRecharge);
			rechargeCreateDto.setTransferRecharge(transferRecharge);
		} else {
			create(transferRecharge);
			transferRecharge.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			rechargeService.updateQueryRecharge(transferRecharge);
		}
		Tool.sendErrorMessage("充值成功！");
	}
	
	/**
	 * 赋值
	 * @param transferRecharge
	 */
	private void create(Recharge transferRecharge) {
		RechargeCreateDxo.dtoToEntity(rechargeCreateDto, transferRecharge);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		rechargeCreateDto.setRechargeDate(DateUtil.getNowyyyymmddhhmmss());
		rechargeCreateDto.setCreater(userBean.getUser());
		rechargeCreateDto.setReturner(returner);
		return Navigation.RECHARGE_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, Recharge recharge) {
		rechargeCreateDto.setReturner(returner);
		RechargeCreateDxo.entityToDto(recharge, rechargeCreateDto);
		rechargeCreateDto.setTransferRecharge(recharge);
		return Navigation.RECHARGE_CREATE;
	}
	
	/**
	 * set rechargeService
	 * @param rechargeService the rechargeService to set
	 */
	public void setRechargeService(RechargeService rechargeService) {
		this.rechargeService = rechargeService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get rechargeCreateDto
	 * @return the rechargeCreateDto
	 */
	public RechargeCreateDto getRechargeCreateDto() {
		return rechargeCreateDto;
	}

	/**
	 * set rechargeCreateDto
	 * @param rechargeCreateDto the rechargeCreateDto to set
	 */
	public void setRechargeCreateDto(RechargeCreateDto rechargeCreateDto) {
		this.rechargeCreateDto = rechargeCreateDto;
	}

}

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
import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.dto.myDesk.RepaymentDto;
import com.qylm.dxo.RepaymentDxo;
import com.qylm.entity.RepaymentRecord;
import com.qylm.service.RepaymentRecordService;

/**
 * 还款登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class RepaymentBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1292085510013667488L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(RepaymentBean.class);

	/**
	 * 存放还款登陆画面需要保存的值
	 */
	private RepaymentDto repaymentDto = new RepaymentDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 还款记录业务类
	 */
	@ManagedProperty(value="#{repaymentRecordService}")
	private RepaymentRecordService repaymentRecordService;
	
	/**
	 * 此方法绑定于还款登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 还款登陆画面
	 */
	public String newRepayment() {
		Tool.sendLog(LOG, userBean, "【还款登陆画面_新建按钮】");
		repaymentDto.setCustomInfo(null);
		repaymentDto.setPersonnelInfo(null);
		repaymentDto.setAdviser(null);
		repaymentDto.setDate(DateUtil.getNowyyyymmdd());
		repaymentDto.setMoney(null);
		repaymentDto.setState(false);
		repaymentDto.setRemark(null);
		repaymentDto.setBalance(null);
		repaymentDto.setBalanceSurplus(null);
		repaymentDto.setReadyMoney(null);
		repaymentDto.setReadyMoneySurplus(null);
		repaymentDto.setCreater(null);
		repaymentDto.setBelongingUser(null);
		return Navigation.REPAYMENT;
	}
	
	/**
	 * 此方法绑定于还款登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【还款登陆画面_返回按钮】");
		return repaymentDto.getReturner().returnOnly();
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		repaymentDto.setReturner(returner);
		repaymentDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		return Navigation.REPAYMENT;
	}
	
	/**
	 * 此方法绑定于还款登陆画面的选择付款按钮 
	 * @return 画面不跳转
	 */
	public void findPay() {
		Tool.sendLog(LOG, userBean, "按下【还款登陆画面_选择付款按钮】");
		if (BigDecimalUtil.bigThan(repaymentDto.getMoney(), repaymentDto.getCustomInfo().getMoney())) {
			repaymentDto.setBalance(repaymentDto.getCustomInfo().getMoney());
		} else {
			repaymentDto.setBalance(repaymentDto.getMoney());
		}
		balanceSurplus();
	}
	
	/**
	 * 此方法绑定于还款登陆画面的确认付款按钮 
	 * @return 画面不跳转
	 */
	public void queryPay() {
		Tool.sendLog(LOG, userBean, "按下【还款登陆画面_确认付款按钮】");
		repaymentDto.setCreater(userBean.getUser());
		repaymentDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
		RepaymentRecord repaymentRecord = new RepaymentRecord();
		repaymentRecord.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
		RepaymentDxo.dtoToEntity(repaymentDto, repaymentRecord);
		repaymentRecordService.saveRepaymentRecord(repaymentRecord);
		newRepayment();
		Tool.sendErrorMessage("付款成功！");
	}
	
	/**
	 * 清空选择到的项目
	 */
	public void clearMarketingProject() {
		repaymentDto.setMoney(repaymentDto.getCustomInfo().getArrearage());
	}
	
	/**
	 * 获取余额付款后的剩余金额
	 */
	public void balanceSurplus() {
		repaymentDto.setBalanceSurplus(BigDecimalUtil.subtract(repaymentDto.getMoney(), repaymentDto.getBalance()));
	}
	
	/**
	 * 获取现金付款后的剩余金额
	 */
	public void readyMoneySurplus() {
		if (repaymentDto.getBalanceSurplus() == null) {
			repaymentDto.setBalanceSurplus(repaymentDto.getMoney());
		}
		repaymentDto.setReadyMoneySurplus(BigDecimalUtil.subtract(repaymentDto.getBalanceSurplus(), repaymentDto.getReadyMoney()));
	}
	
	/**
	 * @param repaymentRecordService the repaymentRecordService to set
	 */
	public void setRepaymentRecordService(
			RepaymentRecordService repaymentRecordService) {
		this.repaymentRecordService = repaymentRecordService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get repaymentDto
	 * @return the repaymentDto
	 */
	public RepaymentDto getRepaymentDto() {
		return repaymentDto;
	}

	/**
	 * set repaymentDto
	 * @param repaymentDto the repaymentDto to set
	 */
	public void setRepaymentDto(RepaymentDto repaymentDto) {
		this.repaymentDto = repaymentDto;
	}

}

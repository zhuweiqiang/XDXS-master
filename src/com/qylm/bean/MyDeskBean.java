package com.qylm.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qylm.bean.custom.ConversionTreatmentCreateBean;
import com.qylm.bean.custom.FeedbackRecordCreateBean;
import com.qylm.bean.custom.MarketingRecordCreateBean;
import com.qylm.bean.custom.MealBuyRecordCreateBean;
import com.qylm.bean.custom.ProjectBuyCreateBean;
import com.qylm.bean.custom.ProjectBuyManageBean;
import com.qylm.bean.custom.RechargeCreateBean;
import com.qylm.bean.myDesk.ConsumeBean;
import com.qylm.bean.myDesk.CustomLeaguerOperationBean;
import com.qylm.bean.myDesk.GiveBodyVolumeBean;
import com.qylm.bean.myDesk.GiveCashVolumeBean;
import com.qylm.bean.myDesk.GiveExperienceCardBean;
import com.qylm.bean.myDesk.GiveLargessRecordBean;
import com.qylm.bean.myDesk.LearnCardBean;
import com.qylm.bean.myDesk.RepaymentBean;
import com.qylm.bean.myDesk.ServiceConsumptionBean;
import com.qylm.bean.myDesk.ShopCardBean;
import com.qylm.bean.returner.MyDeskReturner;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.dto.MyDeskDto;

/**
 * 桌面显示上下班按钮，内部消息，BUG管理，工作安排
 * @author 
 */
@ManagedBean
@RequestScoped
public class MyDeskBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 880745397211413612L;

	/**
	 * LOG 日志
	 */
	private static final Log LOG = LogFactory.getLog(MyDeskBean.class);
	
	/**
	 * 存放我的桌面需要保存的值
	 */
	private MyDeskDto myDeskDto = new MyDeskDto();
	
	/**
	 * 登陆用户信息
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 绑定与我的桌面按钮
	 * @return
	 */
	public String getAllMyDesk() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_我的桌面】");
		return Navigation.MY_DESK;
	}
	
	/**
	 * 刷新桌面内容信息
	 */
	public void refreshDesk() {
		
	}
	
	/**
	 * 此方法绑定于我的桌面的客户充值链接
	 * @return
	 */
	public String recharge() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_客户充值链接】");
		return Tool.getBackBean(RechargeCreateBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的客户档案链接
	 * @return
	 */
	public String selectCustomDetail() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_客户档案链接】");
		return Tool.getBackBean(ConsumeBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的产品销售登记链接
	 * @return
	 */
	public String newMarketingRecord() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_产品销售登记链接】");
		return Tool.getBackBean(MarketingRecordCreateBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的购卡链接
	 * @return
	 */
	public String shopCard() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_购卡链接】");
		return Tool.getBackBean(ShopCardBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的客户反馈
	 * @return
	 */
	public String registerFeedbackRecord() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_客户反馈链接】");
		return Tool.getBackBean(FeedbackRecordCreateBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的服务消费
	 * @return
	 */
	public String serviceConsumption() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_服务消费链接】");
		return Tool.getBackBean(ServiceConsumptionBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的套餐购买记录
	 * @return
	 */
	public String mealBuyRecord() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_套餐购买记录链接】");
		return Tool.getBackBean(MealBuyRecordCreateBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的购买套餐服务记录
	 * @return
	 */
	public String projectBuy() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_购买疗程链接】");
		return Tool.getBackBean(ProjectBuyCreateBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的产品销售记录
	 * @return
	 */
	public String marketingRecord() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_产品销售链接】");
		return Tool.getBackBean(MarketingRecordCreateBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的还款连接
	 * @return
	 */
	public String repayment() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_还款链接】");
		return Tool.getBackBean(RepaymentBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的退卡
	 * @return
	 */
	public String customLeaguerOperation() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_退卡链接】");
		return Tool.getBackBean(CustomLeaguerOperationBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的转卡
	 * @return
	 */
	public String turnLeaguerOperation() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_转卡链接】");
		return Tool.getBackBean(CustomLeaguerOperationBean.class).newTurnLeaguerOperation(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的赠送现金卷链接
	 * @return
	 */
	public String giveCashVolume() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_赠送现金卷链接】");
		return Tool.getBackBean(GiveCashVolumeBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的赠送身体卷链接
	 * @return
	 */
	public String giveBodyVolume() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_赠送身体卷链接】");
		return Tool.getBackBean(GiveBodyVolumeBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的赠送体验卡链接
	 * @return
	 */
	public String giveExperienceCard() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_赠送体验卡链接】");
		return Tool.getBackBean(GiveExperienceCardBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的赠送项目链接
	 * @return
	 */
	public String giveLargessRecord() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_赠送项目链接】");
		return Tool.getBackBean(GiveLargessRecordBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的转换链接
	 * @return
	 */
	public String conversionTreatment() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_疗程转换链接】");
		return Tool.getBackBean(ConversionTreatmentCreateBean.class).newCreate(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的体验卡记录查询链接
	 * @return
	 */
	public String learnCard() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_体验卡记录查询链接】");
		return Tool.getBackBean(LearnCardBean.class).select(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * 此方法绑定于我的桌面的购买套餐记录查询链接
	 * @return
	 */
	public String projectBuySelect() {
		Tool.sendLog(LOG, userBean, "按下【我的桌面_购买套餐记录查询链接】");
		return Tool.getBackBean(ProjectBuyManageBean.class).selectProjectBuy(new MyDeskReturner(myDeskDto));
	}
	
	/**
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * @return the myDeskDto
	 */
	public MyDeskDto getMyDeskDto() {
		return myDeskDto;
	}

	/**
	 * @param myDeskDto the myDeskDto to set
	 */
	public void setMyDeskDto(MyDeskDto myDeskDto) {
		this.myDeskDto = myDeskDto;
	}

}

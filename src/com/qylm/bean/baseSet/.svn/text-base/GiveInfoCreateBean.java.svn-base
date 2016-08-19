package com.qylm.bean.baseSet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.dto.baseSet.GiveInfoCreateDto;
import com.qylm.dxo.GiveInfoCreateDxo;
import com.qylm.entity.GiveInfo;
import com.qylm.entity.GiveInfoDetail;
import com.qylm.service.GiveInfoDetailService;
import com.qylm.service.GiveInfoService;

/**
 * 体验卡登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class GiveInfoCreateBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6661599874066510670L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(GiveInfoCreateBean.class);

	/**
	 * 存放体验卡登陆画面需要保存的值
	 */
	private GiveInfoCreateDto giveInfoCreateDto = new GiveInfoCreateDto();
	
	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 体验卡业务类
	 */
	@ManagedProperty(value="#{giveInfoService}")
	private GiveInfoService giveInfoService;
	
	/**
	 * 体验卡详细业务类
	 */
	@ManagedProperty(value="#{giveInfoDetailService}")
	private GiveInfoDetailService giveInfoDetailService;
	
	/**
	 * 此方法绑定于体验卡登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 体验卡登陆画面
	 */
	public String newGiveInfo() {
		Tool.sendLog(LOG, userBean, "【体验卡登陆画面_新建按钮】");
		giveInfoCreateDto.setTitle(null);
		giveInfoCreateDto.setMoney(null);
		giveInfoCreateDto.setRebate(null);
		giveInfoCreateDto.setGiveInfoDetailList(null);
		giveInfoCreateDto.setCreater(null);
		giveInfoCreateDto.setBelongingUser(null);
		giveInfoCreateDto.setTransferGiveInfo(null);
		return Navigation.GIVE_INFO_CREATE;
	}
	
	/**
	 * 此方法绑定于体验卡登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【体验卡登陆画面_返回按钮】");
		return giveInfoCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于体验卡登陆画面的保存按钮 
	 * 实现功能：根据transferGiveInfo对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveGiveInfo() {
		Tool.sendLog(LOG, userBean, "【体验卡登陆画面_保存按钮】");
		GiveInfo transferGiveInfo = giveInfoCreateDto.getTransferGiveInfo();
		if (transferGiveInfo == null) {
			transferGiveInfo = new GiveInfo();
			giveInfoCreateDto.setCreater(userBean.getUser());
			giveInfoCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferGiveInfo);
			transferGiveInfo.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			giveInfoService.saveGiveInfo(transferGiveInfo, giveInfoCreateDto.getGiveInfoDetailList());
			giveInfoCreateDto.setTransferGiveInfo(transferGiveInfo);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferGiveInfo);
			transferGiveInfo.setUpdateDate(DateUtil.getNowyyyymmdd());
			giveInfoService.updateGiveInfo(transferGiveInfo, giveInfoCreateDto.getGiveInfoDetailList());
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferGiveInfo
	 */
	private void create(GiveInfo transferGiveInfo) {
		List<GiveInfoDetail> giveInfoDetailList = giveInfoCreateDto.getGiveInfoDetailList();
		if (giveInfoDetailList != null && !giveInfoDetailList.isEmpty()) {
			for (GiveInfoDetail giveInfoDetail : giveInfoDetailList) {
				giveInfoDetail.setGiveInfo(transferGiveInfo);
				giveInfoDetail.setCreater(userBean.getUser());
				giveInfoDetail.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
				giveInfoDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			}
		}
		GiveInfoCreateDxo.dtoToEntity(giveInfoCreateDto, transferGiveInfo);
	}

	public String newCreate(Returner<?, ?, ?> returner, String type) {
		giveInfoCreateDto.setReturner(returner);
		giveInfoCreateDto.setType(type);
		return Navigation.GIVE_INFO_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, GiveInfo giveInfo) {
		giveInfoCreateDto.setReturner(returner);
		GiveInfoCreateDxo.entityToDto(giveInfo, giveInfoCreateDto);
		giveInfoCreateDto.setTransferGiveInfo(giveInfo);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GiveInfoDetail.class);
		detachedCriteria.createAlias(GiveInfoDetail.GIVE_INFO, GiveInfoDetail.GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(GiveInfoDetail.PRODUCT_STOCK_DETIAL, GiveInfoDetail.PRODUCT_STOCK_DETIAL, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(GiveInfoDetail.MARKETING_PROJECT, GiveInfoDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(GiveInfoDetail.GIVE_INFO, giveInfo));
		List<GiveInfoDetail> giveInfoDetailList = giveInfoDetailService.getByDetachedCriteria(detachedCriteria);
		giveInfoCreateDto.setGiveInfoDetailList(giveInfoDetailList);
		return Navigation.GIVE_INFO_CREATE;
	}
	
	/**
	 * 此方法绑定于体验卡登陆画面的增加一行消费项目按钮 
	 * @return 画面不跳转
	 */
	public void addMarketingProject() {
		Tool.sendLog(LOG, userBean, "【体验卡登陆画面_增加一行消费项目按钮】");
		List<GiveInfoDetail> giveInfoDetailList = giveInfoCreateDto.getGiveInfoDetailList();
		if (giveInfoDetailList == null) {
			giveInfoDetailList = new ArrayList<GiveInfoDetail>();
			giveInfoCreateDto.setGiveInfoDetailList(giveInfoDetailList);
		}
		GiveInfoDetail giveInfoDetail = new GiveInfoDetail();
		giveInfoDetail.setNumber(1);
		giveInfoDetailList.add(giveInfoDetail);
	}
	
	/**
	 * 此方法绑定于体验卡登陆画面的删除按钮 
	 * @return 画面不跳转
	 */
	public void deleteGiveInfoDetail(GiveInfoDetail giveInfoDetail) {
		Tool.sendLog(LOG, userBean, "【体验卡登陆画面_删除按钮】");
		if (giveInfoDetail.getId() != null) {
			giveInfoDetailService.deleteEntity(giveInfoDetail);
		}
		giveInfoCreateDto.getGiveInfoDetailList().remove(giveInfoDetail);
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * @param giveInfoDetailService the giveInfoDetailService to set
	 */
	public void setGiveInfoDetailService(GiveInfoDetailService giveInfoDetailService) {
		this.giveInfoDetailService = giveInfoDetailService;
	}

	/**
	 * set giveInfoService
	 * @param giveInfoService the giveInfoService to set
	 */
	public void setGiveInfoService(GiveInfoService giveInfoService) {
		this.giveInfoService = giveInfoService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get giveInfoCreateDto
	 * @return the giveInfoCreateDto
	 */
	public GiveInfoCreateDto getGiveInfoCreateDto() {
		return giveInfoCreateDto;
	}

	/**
	 * set giveInfoCreateDto
	 * @param giveInfoCreateDto the giveInfoCreateDto to set
	 */
	public void setGiveInfoCreateDto(GiveInfoCreateDto giveInfoCreateDto) {
		this.giveInfoCreateDto = giveInfoCreateDto;
	}

}

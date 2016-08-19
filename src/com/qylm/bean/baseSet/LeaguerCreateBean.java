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
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.dto.baseSet.LeaguerCreateDto;
import com.qylm.dxo.LeaguerCreateDxo;
import com.qylm.entity.GiveInfo;
import com.qylm.entity.Leaguer;
import com.qylm.entity.LeaguerDetail;
import com.qylm.entity.MarketingProject;
import com.qylm.entity.ProductStock;
import com.qylm.service.LeaguerDetailService;
import com.qylm.service.LeaguerService;
import com.qylm.service.MarketingProjectService;
import com.qylm.service.ProductStockService;

/**
 * 卡项登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class LeaguerCreateBean implements Serializable, CreateBean<Leaguer> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6661599874066510670L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(LeaguerCreateBean.class);

	/**
	 * 存放卡项登陆画面需要保存的值
	 */
	private LeaguerCreateDto leaguerCreateDto = new LeaguerCreateDto();
	
	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 卡项业务类
	 */
	@ManagedProperty(value="#{leaguerService}")
	private LeaguerService leaguerService;
	
	/**
	 * 服务管理业务类
	 */
	@ManagedProperty(value="#{marketingProjectService}")
	private MarketingProjectService marketingProjectService;
	
	/**
	 * 卡项详细业务类
	 */
	@ManagedProperty(value="#{leaguerDetailService}")
	private LeaguerDetailService leaguerDetailService;
	
	/**
	 * 产品业务类
	 */
	@ManagedProperty(value="#{productStockService}")
	private ProductStockService productStockService;
	
	/**
	 * 此方法绑定于卡项登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 卡项登陆画面
	 */
	public String newLeaguer() {
		Tool.sendLog(LOG, userBean, "【卡项登陆画面_新建按钮】");
		leaguerCreateDto.setLevel(null);
		leaguerCreateDto.setMoney(null);
		leaguerCreateDto.setRebate(null);
		leaguerCreateDto.setProductStockList(null);
		leaguerCreateDto.setMarketingProjectList(null);
		leaguerCreateDto.setProductStockList(null);
		leaguerCreateDto.setCreater(null);
		leaguerCreateDto.setBelongingUser(null);
		leaguerCreateDto.setTransferLeaguer(null);
		return Navigation.LEAGUER_CREATE;
	}
	
	/**
	 * 此方法绑定于卡项登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【卡项登陆画面_返回按钮】");
		return leaguerCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于卡项登陆画面的保存按钮 
	 * 实现功能：根据transferLeaguer对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveLeaguer() {
		Tool.sendLog(LOG, userBean, "【卡项登陆画面_保存按钮】");
		Leaguer transferLeaguer = leaguerCreateDto.getTransferLeaguer();
		if (transferLeaguer == null) {
			transferLeaguer = new Leaguer();
			leaguerCreateDto.setCreater(userBean.getUser());
			leaguerCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferLeaguer);
			transferLeaguer.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			leaguerService.saveLeaguer(transferLeaguer, leaguerCreateDto.getLeaguerDetailList());
			leaguerCreateDto.setTransferLeaguer(transferLeaguer);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferLeaguer);
			transferLeaguer.setUpdateDate(DateUtil.getNowyyyymmdd());
			leaguerService.updateLeaguer(transferLeaguer, leaguerCreateDto.getLeaguerDetailList());
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferLeaguer
	 */
	private void create(Leaguer transferLeaguer) {
		List<LeaguerDetail> leaguerDetailList = new ArrayList<LeaguerDetail>();
		List<LeaguerDetail> marketingProjectList = leaguerCreateDto.getMarketingProjectList();
		List<LeaguerDetail> productStockList = leaguerCreateDto.getProductStockList();
		List<LeaguerDetail> projectGiveList = leaguerCreateDto.getProjectGiveList();
		List<LeaguerDetail> gashRollList = leaguerCreateDto.getGashRollList();
		List<LeaguerDetail> bodyVolumeList = leaguerCreateDto.getBodyVolumeList();
		if (marketingProjectList != null && !marketingProjectList.isEmpty()) {
			leaguerDetailList.addAll(marketingProjectList);
		}
		if (productStockList != null && !productStockList.isEmpty()) {
			leaguerDetailList.addAll(productStockList);
		}
		if (projectGiveList != null && !projectGiveList.isEmpty()) {
			leaguerDetailList.addAll(projectGiveList);
		}
		if (gashRollList != null && !gashRollList.isEmpty()) {
			leaguerDetailList.addAll(gashRollList);
		}
		if (bodyVolumeList != null && !bodyVolumeList.isEmpty()) {
			leaguerDetailList.addAll(bodyVolumeList);
		}
		if (leaguerDetailList != null && !leaguerDetailList.isEmpty()) {
			for (LeaguerDetail leaguerDetail : leaguerDetailList) {
				leaguerDetail.setLeaguer(transferLeaguer);
				leaguerDetail.setCreater(userBean.getUser());
				leaguerDetail.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
				leaguerDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			}
		}
		leaguerCreateDto.setLeaguerDetailList(leaguerDetailList);
		LeaguerCreateDxo.dtoToEntity(leaguerCreateDto, transferLeaguer);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		leaguerCreateDto.setReturner(returner);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MarketingProject.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		List<MarketingProject> marketingProjectList = marketingProjectService.getByDetachedCriteria(detachedCriteria);
		List<LeaguerDetail> list = new ArrayList<LeaguerDetail>();
		LeaguerDetail leaguerDetail;
		for (MarketingProject marketingProject : marketingProjectList) {
			leaguerDetail = new LeaguerDetail();
			leaguerDetail.setMarketingProject(marketingProject);
			list.add(leaguerDetail);
		}
		leaguerCreateDto.setMarketingProjectList(list);
		detachedCriteria = DetachedCriteria.forClass(ProductStock.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		List<ProductStock> productStockList = productStockService.getByDetachedCriteria(detachedCriteria);
		list = new ArrayList<LeaguerDetail>();
		for (ProductStock productStock : productStockList) {
			leaguerDetail = new LeaguerDetail();
			leaguerDetail.setProductStock(productStock);
			list.add(leaguerDetail);
		}
		leaguerCreateDto.setProductStockList(list);
		return Navigation.LEAGUER_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, Leaguer leaguer) {
		leaguerCreateDto.setReturner(returner);
		LeaguerCreateDxo.entityToDto(leaguer, leaguerCreateDto);
		leaguerCreateDto.setTransferLeaguer(leaguer);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MarketingProject.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		List<MarketingProject> marketingProjectList = marketingProjectService.getByDetachedCriteria(detachedCriteria);
		
		detachedCriteria = DetachedCriteria.forClass(ProductStock.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		List<ProductStock> productStockList = productStockService.getByDetachedCriteria(detachedCriteria);
		detachedCriteria = DetachedCriteria.forClass(LeaguerDetail.class);
		detachedCriteria.createAlias(LeaguerDetail.LEAGUER, LeaguerDetail.LEAGUER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(LeaguerDetail.MARKETING_PROJECT, LeaguerDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(LeaguerDetail.PRODUCT_STOCK, LeaguerDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(LeaguerDetail.GIVE_INFO, LeaguerDetail.GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(LeaguerDetail.LEAGUER, leaguer));
		List<LeaguerDetail> leaguerDetailList = leaguerDetailService.getByDetachedCriteria(detachedCriteria);
		for (MarketingProject marketingProject : marketingProjectList) {
			boolean state = false;
			for (LeaguerDetail leaguerDetail : leaguerDetailList) {
				if (marketingProject.equals(leaguerDetail.getMarketingProject())) {
					state = true;
				}
			}
			if (!state) {
				LeaguerDetail leaguerDetail = new LeaguerDetail();
				leaguerDetail.setMarketingProject(marketingProject);
				leaguerDetailList.add(leaguerDetail);
			}
		}
		for (ProductStock productStock : productStockList) {
			boolean state = false;
			for (LeaguerDetail leaguerDetail : leaguerDetailList) {
				if (productStock.equals(leaguerDetail.getProductStock())) {
					state = true;
				}
			}
			if (!state) {
				LeaguerDetail leaguerDetail = new LeaguerDetail();
				leaguerDetail.setProductStock(productStock);
				leaguerDetailList.add(leaguerDetail);
			}
		}
		leaguerCreateDto.setLeaguerDetailList(leaguerDetailList);
		List<LeaguerDetail> projectList = new ArrayList<LeaguerDetail>();
		List<LeaguerDetail> stockList = new ArrayList<LeaguerDetail>();
		List<LeaguerDetail> projectGiveList = new ArrayList<LeaguerDetail>();
		List<LeaguerDetail> gashRollList = new ArrayList<LeaguerDetail>();
		List<LeaguerDetail> bodyVolumeList = new ArrayList<LeaguerDetail>();
		for (LeaguerDetail leaguerDetail : leaguerDetailList) {
			if (leaguerDetail.getMarketingProject() != null && !leaguerDetail.isState()) {
				projectList.add(leaguerDetail);
			} else if (leaguerDetail.getProductStock() != null) {
				stockList.add(leaguerDetail);
			} else if (leaguerDetail.getGiveInfo() != null && GiveInfo.TYPE_2.equals(leaguerDetail.getGiveInfo().getType())){ // 现金卷
				gashRollList.add(leaguerDetail);
			} else if (leaguerDetail.getGiveInfo() != null && GiveInfo.TYPE_3.equals(leaguerDetail.getGiveInfo().getType())){ // 现金卷
				bodyVolumeList.add(leaguerDetail);
			} else {
				projectGiveList.add(leaguerDetail);
			}
		}
		leaguerCreateDto.setMarketingProjectList(projectList);
		leaguerCreateDto.setProductStockList(stockList);
		leaguerCreateDto.setProjectGiveList(projectGiveList);
		leaguerCreateDto.setGashRollList(gashRollList);
		leaguerCreateDto.setBodyVolumeList(bodyVolumeList);
		return Navigation.LEAGUER_CREATE;
	}
	
	/**
	 * 此方法绑定于项目购买登陆画面的增加一行活动项目按钮 
	 * @return 画面不跳转
	 */
	public void addLeaguer() {
		Tool.sendLog(LOG, userBean, "【项目购买登陆画面_增加一行活动项目按钮】");
		List<LeaguerDetail> projectGiveList = leaguerCreateDto.getProjectGiveList();
		if (projectGiveList == null) {
			projectGiveList = new ArrayList<LeaguerDetail>();
			leaguerCreateDto.setProjectGiveList(projectGiveList);
		}
		LeaguerDetail leaguerDetail = new LeaguerDetail();
		leaguerDetail.setState(true);
		projectGiveList.add(leaguerDetail);
	}
	
	/**
	 * 此方法绑定于项目购买登陆画面的增加一行现金卷按钮 
	 * @return 画面不跳转
	 */
	public void addGashRoll() {
		Tool.sendLog(LOG, userBean, "【项目购买登陆画面_增加一行现金卷按钮】");
		List<LeaguerDetail> gashRollList = leaguerCreateDto.getGashRollList();
		if (gashRollList == null) {
			gashRollList = new ArrayList<LeaguerDetail>();
			leaguerCreateDto.setGashRollList(gashRollList);
		}
		LeaguerDetail leaguerDetail = new LeaguerDetail();
		leaguerDetail.setState(true);
		gashRollList.add(leaguerDetail);
	}
	
	/**
	 * 此方法绑定于项目购买登陆画面的增加一行身体卷按钮 
	 * @return 画面不跳转
	 */
	public void addBodyVolume() {
		Tool.sendLog(LOG, userBean, "【项目购买登陆画面_增加一行身体卷按钮】");
		List<LeaguerDetail> bodyVolumeList = leaguerCreateDto.getBodyVolumeList();
		if (bodyVolumeList == null) {
			bodyVolumeList = new ArrayList<LeaguerDetail>();
			leaguerCreateDto.setBodyVolumeList(bodyVolumeList);
		}
		LeaguerDetail leaguerDetail = new LeaguerDetail();
		leaguerDetail.setState(true);
		bodyVolumeList.add(leaguerDetail);
	}
	
	/**
	 * 此方法绑定于项目购买登陆画面的删除按钮 
	 * @return 画面不跳转
	 */
	public void deleteLeaguer(LeaguerDetail leaguerDetail) {
		Tool.sendLog(LOG, userBean, "【项目购买登陆画面_删除按钮】");
		if (leaguerDetail.getId() != null) {
			leaguerDetailService.deleteEntity(leaguerDetail);
		}
		leaguerCreateDto.getProjectGiveList().remove(leaguerDetail);
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 此方法绑定于项目购买登陆画面的删除按钮 
	 * @return 画面不跳转
	 */
	public void deleteGashRoll(LeaguerDetail leaguerDetail) {
		Tool.sendLog(LOG, userBean, "【项目购买登陆画面_删除按钮】");
		if (leaguerDetail.getId() != null) {
			leaguerDetailService.deleteEntity(leaguerDetail);
		}
		leaguerCreateDto.getGashRollList().remove(leaguerDetail);
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 此方法绑定于项目购买登陆画面的删除按钮 
	 * @return 画面不跳转
	 */
	public void deleteBodyVolume(LeaguerDetail leaguerDetail) {
		Tool.sendLog(LOG, userBean, "【项目购买登陆画面_删除按钮】");
		if (leaguerDetail.getId() != null) {
			leaguerDetailService.deleteEntity(leaguerDetail);
		}
		leaguerCreateDto.getBodyVolumeList().remove(leaguerDetail);
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 此方法绑定于项目购买登陆画面的获取项目价值事件按钮 
	 * @return 画面不跳转
	 */
	public void getProjectMoney() {
		List<LeaguerDetail> projectGiveList = leaguerCreateDto.getProjectGiveList();
		if (projectGiveList != null && !projectGiveList.isEmpty()) {
			for (LeaguerDetail leaguerDetail : projectGiveList) {
				leaguerDetail.setMoney(leaguerDetail.getMarketingProject().getMoney());
				leaguerDetail.setNumber(1);
				leaguerDetail.setState(true);
			}
		}
	}
	
	/**
	 * @param productStockService the productStockService to set
	 */
	public void setProductStockService(ProductStockService productStockService) {
		this.productStockService = productStockService;
	}

	/**
	 * @param leaguerDetailService the leaguerDetailService to set
	 */
	public void setLeaguerDetailService(LeaguerDetailService leaguerDetailService) {
		this.leaguerDetailService = leaguerDetailService;
	}

	/**
	 * @param marketingProjectService the marketingProjectService to set
	 */
	public void setMarketingProjectService(
			MarketingProjectService marketingProjectService) {
		this.marketingProjectService = marketingProjectService;
	}

	/**
	 * set leaguerService
	 * @param leaguerService the leaguerService to set
	 */
	public void setLeaguerService(LeaguerService leaguerService) {
		this.leaguerService = leaguerService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get leaguerCreateDto
	 * @return the leaguerCreateDto
	 */
	public LeaguerCreateDto getLeaguerCreateDto() {
		return leaguerCreateDto;
	}

	/**
	 * set leaguerCreateDto
	 * @param leaguerCreateDto the leaguerCreateDto to set
	 */
	public void setLeaguerCreateDto(LeaguerCreateDto leaguerCreateDto) {
		this.leaguerCreateDto = leaguerCreateDto;
	}

}

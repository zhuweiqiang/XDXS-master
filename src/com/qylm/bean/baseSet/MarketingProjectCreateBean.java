package com.qylm.bean.baseSet;

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
import com.qylm.dto.baseSet.MarketingProjectCreateDto;
import com.qylm.dxo.MarketingProjectCreateDxo;
import com.qylm.entity.MarketingProject;
import com.qylm.service.MarketingProjectService;

/**
 * 服务管理登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class MarketingProjectCreateBean implements Serializable, CreateBean<MarketingProject> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7609880236846464051L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(MarketingProjectCreateBean.class);

	/**
	 * 存放服务管理登陆画面需要保存的值
	 */
	private MarketingProjectCreateDto marketingProjectCreateDto = new MarketingProjectCreateDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件业务类
	 */
	@ManagedProperty(value="#{marketingProjectService}")
	private MarketingProjectService marketingProjectService;
	
	/**
	 * 此方法绑定于服务管理登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 服务管理登陆画面
	 */
	public String newMarketingProject() {
		Tool.sendLog(LOG, userBean, "【服务管理登陆画面_新建按钮】");
		marketingProjectCreateDto.setProject(null);
		marketingProjectCreateDto.setMoney(null);
		marketingProjectCreateDto.setRemark(null);
		marketingProjectCreateDto.setState(false);
		marketingProjectCreateDto.setType(null);
		marketingProjectCreateDto.setCreater(null);
		marketingProjectCreateDto.setBelongingUser(null);
		marketingProjectCreateDto.setTransferMarketingProject(null);
		return Navigation.MARKETING_PROJECT_CREATE;
	}
	
	/**
	 * 此方法绑定于服务管理登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【服务管理登陆画面_返回按钮】");
		return marketingProjectCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于服务管理登陆画面的保存按钮 
	 * 实现功能：根据transferMarketingProject对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveMarketingProject() {
		Tool.sendLog(LOG, userBean, "【服务管理登陆画面_保存按钮】");
		MarketingProject transferMarketingProject = marketingProjectCreateDto.getTransferMarketingProject();
		operate(transferMarketingProject);
	}
	
	/**
	 * 此方法绑定于服务管理登陆画面的确认按钮 
	 * 实现功能：根据transferMarketingProject对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void queryMarketingProject() {
		Tool.sendLog(LOG, userBean, "【服务管理登陆画面_确认按钮】");
		MarketingProject transferMarketingProject = marketingProjectCreateDto.getTransferMarketingProject();
		marketingProjectCreateDto.setState(true);
		operate(transferMarketingProject);
	}

	/**
	 * 进行保存或者更新操作
	 * @param transferMarketingProject
	 */
	private void operate(MarketingProject transferMarketingProject) {
		if (transferMarketingProject == null) {
			transferMarketingProject = new MarketingProject();
			marketingProjectCreateDto.setCreater(userBean.getUser());
			marketingProjectCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferMarketingProject);
			transferMarketingProject.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			marketingProjectService.saveEntity(transferMarketingProject);
			marketingProjectCreateDto.setTransferMarketingProject(transferMarketingProject);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferMarketingProject);
			transferMarketingProject.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			marketingProjectService.updateEntity(transferMarketingProject);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferMarketingProject
	 */
	private void create(MarketingProject transferMarketingProject) {
		MarketingProjectCreateDxo.dtoToEntity(marketingProjectCreateDto, transferMarketingProject);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		marketingProjectCreateDto.setReturner(returner);
		return Navigation.MARKETING_PROJECT_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, MarketingProject marketingProject) {
		marketingProjectCreateDto.setReturner(returner);
		MarketingProjectCreateDxo.entityToDto(marketingProject, marketingProjectCreateDto);
		marketingProjectCreateDto.setTransferMarketingProject(marketingProject);
		return Navigation.MARKETING_PROJECT_CREATE;
	}
	
	/**
	 * set marketingProjectService
	 * @param marketingProjectService the marketingProjectService to set
	 */
	public void setMarketingProjectService(MarketingProjectService marketingProjectService) {
		this.marketingProjectService = marketingProjectService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get marketingProjectCreateDto
	 * @return the marketingProjectCreateDto
	 */
	public MarketingProjectCreateDto getMarketingProjectCreateDto() {
		return marketingProjectCreateDto;
	}

	/**
	 * set marketingProjectCreateDto
	 * @param marketingProjectCreateDto the marketingProjectCreateDto to set
	 */
	public void setMarketingProjectCreateDto(MarketingProjectCreateDto marketingProjectCreateDto) {
		this.marketingProjectCreateDto = marketingProjectCreateDto;
	}

}

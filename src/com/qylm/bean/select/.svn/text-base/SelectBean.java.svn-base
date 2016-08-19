package com.qylm.bean.select;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.qylm.bean.UserBean;
import com.qylm.common.MothedUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.entity.Brand;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.DepotInfo;
import com.qylm.entity.GiveInfo;
import com.qylm.entity.Leaguer;
import com.qylm.entity.MarketingProject;
import com.qylm.entity.PersonnelInfo;
import com.qylm.entity.User;
import com.qylm.service.BrandService;
import com.qylm.service.CustomInfoService;
import com.qylm.service.DepotInfoService;
import com.qylm.service.GiveInfoService;
import com.qylm.service.LeaguerService;
import com.qylm.service.MarketingProjectService;
import com.qylm.service.PersonnelInfoService;
import com.qylm.service.UserService;

/**
 * 用于所有输入框查询
 * @author 
 */
@ManagedBean
@RequestScoped
public class SelectBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1681709681228643903L;
	
	/**
	 * bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 用户业务类
	 */
	@ManagedProperty(value="#{userService}")
	private UserService userService;
	
	/**
	 * 卡项级别业务类
	 */
	@ManagedProperty(value="#{leaguerService}")
	private LeaguerService leaguerService;
	
	/**
	 * 客户档案业务类
	 */
	@ManagedProperty(value="#{customInfoService}")
	private CustomInfoService customInfoService;
	
	/**
	 * 营业详细业务类
	 */
	@ManagedProperty(value="#{marketingProjectService}")
	private MarketingProjectService marketingProjectService;
	
	/**
	 * 人事业务类
	 */
	@ManagedProperty(value="#{personnelInfoService}")
	private PersonnelInfoService personnelInfoService;
	
	/**
	 * 仓库信息业务类
	 */
	@ManagedProperty(value="#{depotInfoService}")
	private DepotInfoService depotInfoService;
	
	/**
	 * 品牌业务类
	 */
	@ManagedProperty(value="#{brandService}")
	private BrandService brandService;
	
	/**
	 * 身体卷、赠送身体卷、赠送现金卷业务类
	 */
	@ManagedProperty(value="#{giveInfoService}")
	private GiveInfoService giveInfoService;
	
	/**
	 * 根据输入的查询条件，查询出所有用户信息
	 * @param query 用户名称
	 * @return 对象集合
	 */
	public List<User> selectUser(String query) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		detachedCriteria.add(Restrictions.like(User.USER_NAME, query, MatchMode.ANYWHERE));
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		return userService.getByDetachedCriteria(detachedCriteria, 0, 10);
	}
	
	/**
	 * 根据输入的查询条件，查询出所有卡项级别信息
	 * @param query 级别名称
	 * @return 对象集合
	 */
	public List<Leaguer> selectLeaguer(String query) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Leaguer.class);
		if (StringUtil.isNotBlank(query)) {
			detachedCriteria.add(Restrictions.like(Leaguer.LEVEL, query, MatchMode.ANYWHERE));
		}
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		return leaguerService.getByDetachedCriteria(detachedCriteria, 0, 10);
	}
	
	/**
	 * 根据输入的查询条件，查询出所有客户档案信息
	 * @param query 客户名称
	 * @return 对象集合
	 */
	public List<CustomInfo> selectCustomInfo(String query) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomInfo.class);
		if (StringUtil.isNotBlank(query)) {
			detachedCriteria.add(Restrictions.like(CustomInfo.NAME, query, MatchMode.ANYWHERE));
		}
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		return customInfoService.getByDetachedCriteria(detachedCriteria, 0, 10);
	}
	
	/**
	 * 根据输入的查询条件，查询出所有客户档案信息
	 * @param query 卡号
	 * @return 对象集合
	 */
	public List<CustomInfo> selectCustomInfoNumber(String query) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomInfo.class);
		if (StringUtil.isNotBlank(query)) {
			detachedCriteria.add(Restrictions.or(Restrictions.like(CustomInfo.LEAGUER_NUMBER, query, MatchMode.ANYWHERE), Restrictions.like(CustomInfo.NAME, query, MatchMode.ANYWHERE)));
		}
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		return customInfoService.getByDetachedCriteria(detachedCriteria, 0, 10);
	}
	
	/**
	 * 根据输入的查询条件，查询出所有营业项目信息
	 * @param query 营业项目
	 * @return 对象集合
	 */
	public List<MarketingProject> selectMarketingProject(String query) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MarketingProject.class);
		if (StringUtil.isNotBlank(query)) {
			detachedCriteria.add(Restrictions.like(MarketingProject.PROJECT, query, MatchMode.ANYWHERE));
		}
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		return marketingProjectService.getByDetachedCriteria(detachedCriteria, 0, 10);
	}
	
	/**
	 * 根据输入的查询条件，查询出美容师
	 * @param query 营业项目
	 * @return 对象集合
	 */
	public List<PersonnelInfo> selectPersonnelInfo1(String query) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PersonnelInfo.class);
		detachedCriteria.add(Restrictions.eq(PersonnelInfo.TYPE, PersonnelInfo.TYPE_1));
		detachedCriteria.add(Restrictions.eq(PersonnelInfo.WORK_STATE, PersonnelInfo.WORK_STATE_1));
		if (StringUtil.isNotBlank(query)) {
			detachedCriteria.add(Restrictions.like(PersonnelInfo.NAME, query, MatchMode.ANYWHERE));
		}
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		return personnelInfoService.getByDetachedCriteria(detachedCriteria, 0, 10);
	}
	
	/**
	 * 根据输入的查询条件，查询出顾问
	 * @param query 营业项目
	 * @return 对象集合
	 */
	public List<PersonnelInfo> selectPersonnelInfo2(String query) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PersonnelInfo.class);
		detachedCriteria.add(Restrictions.eq(PersonnelInfo.TYPE, PersonnelInfo.TYPE_2));
		detachedCriteria.add(Restrictions.eq(PersonnelInfo.WORK_STATE, PersonnelInfo.WORK_STATE_1));
		if (StringUtil.isNotBlank(query)) {
			detachedCriteria.add(Restrictions.like(PersonnelInfo.NAME, query, MatchMode.ANYWHERE));
		}
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		return personnelInfoService.getByDetachedCriteria(detachedCriteria, 0, 10);
	}
	
	/**
	 * 根据输入的查询条件，查询出所有仓库信息
	 * @param query
	 * @return 对象集合
	 */
	public List<DepotInfo> selectDepotInfo(String query) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(DepotInfo.class);
		if (StringUtil.isNotBlank(query)) {
			detachedCriteria.add(Restrictions.like(DepotInfo.NAME, query, MatchMode.ANYWHERE));
		}
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		return depotInfoService.getByDetachedCriteria(detachedCriteria, 0, 10);
	}
	
	/**
	 * 根据输入的查询条件，查询出所有仓库信息
	 * @param query
	 * @return 对象集合
	 */
	public List<DepotInfo> selectUserDepotInfo(String query) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(DepotInfo.class);
		if (StringUtil.isNotBlank(query)) {
			detachedCriteria.add(Restrictions.like(DepotInfo.NAME, query, MatchMode.ANYWHERE));
		}
		User user = userBean.getUser();
		if (!User.USER_LEVEL_1.equals(user.getUserlevel())) {
			List<DepotInfo> depotInfoList = user.getDepotInfoList();
			if (depotInfoList != null && !depotInfoList.isEmpty()) {
				List<Integer> idList = new ArrayList<Integer>();
				for (DepotInfo depotInfo : depotInfoList) {
					idList.add(depotInfo.getId());
				}
				detachedCriteria.add(Restrictions.in(DepotInfo.BASE_ID, idList));
			}
		}
		MothedUtil.getBelongingUser(detachedCriteria, user);
		return depotInfoService.getByDetachedCriteria(detachedCriteria, 0, 10);
	}
	
	/**
	 * 根据输入的查询条件，查询出所有品牌
	 * @param query 品牌名称
	 * @return 对象集合
	 */
	public List<Brand> selectBrand(String query) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Brand.class);
		if (StringUtil.isNotBlank(query)) {
			detachedCriteria.add(Restrictions.like(Brand.NAME, query, MatchMode.ANYWHERE));
		}
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		return brandService.getByDetachedCriteria(detachedCriteria, 0, 10);
	}
	
	/**
	 * 根据输入的查询条件，查询出所有体验卡
	 * @param query 体验卡名称
	 * @return 对象集合
	 */
	public List<GiveInfo> selectGiveInfo1(String query) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GiveInfo.class);
		detachedCriteria.add(Restrictions.eq(GiveInfo.TYPE, GiveInfo.TYPE_1));
		if (StringUtil.isNotBlank(query)) {
			detachedCriteria.add(Restrictions.like(GiveInfo.TITLE, query, MatchMode.ANYWHERE));
		}
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		return giveInfoService.getByDetachedCriteria(detachedCriteria, 0, 10);
	}
	
	/**
	 * 根据输入的查询条件，查询出所有现金卷
	 * @param query 现金卷名称
	 * @return 对象集合
	 */
	public List<GiveInfo> selectGiveInfo2(String query) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GiveInfo.class);
		detachedCriteria.add(Restrictions.eq(GiveInfo.TYPE, GiveInfo.TYPE_2));
		if (StringUtil.isNotBlank(query)) {
			detachedCriteria.add(Restrictions.like(GiveInfo.TITLE, query, MatchMode.ANYWHERE));
		}
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		return giveInfoService.getByDetachedCriteria(detachedCriteria, 0, 10);
	}
	
	/**
	 * 根据输入的查询条件，查询出所有身体卷
	 * @param query 身体卷名称
	 * @return 对象集合
	 */
	public List<GiveInfo> selectGiveInfo3(String query) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GiveInfo.class);
		detachedCriteria.add(Restrictions.eq(GiveInfo.TYPE, GiveInfo.TYPE_3));
		if (StringUtil.isNotBlank(query)) {
			detachedCriteria.add(Restrictions.like(GiveInfo.TITLE, query, MatchMode.ANYWHERE));
		}
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		return giveInfoService.getByDetachedCriteria(detachedCriteria, 0, 10);
	}
	
	/**
	 * @param giveInfoService the giveInfoService to set
	 */
	public void setGiveInfoService(GiveInfoService giveInfoService) {
		this.giveInfoService = giveInfoService;
	}

	/**
	 * @param brandService the brandService to set
	 */
	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	/**
	 * @param depotInfoService the depotInfoService to set
	 */
	public void setDepotInfoService(DepotInfoService depotInfoService) {
		this.depotInfoService = depotInfoService;
	}

	/**
	 * @param personnelInfoService the personnelInfoService to set
	 */
	public void setPersonnelInfoService(PersonnelInfoService personnelInfoService) {
		this.personnelInfoService = personnelInfoService;
	}

	/**
	 * @param marketingProjectService the marketingProjectService to set
	 */
	public void setMarketingProjectService(
			MarketingProjectService marketingProjectService) {
		this.marketingProjectService = marketingProjectService;
	}

	/**
	 * @param customInfoService the customInfoService to set
	 */
	public void setCustomInfoService(CustomInfoService customInfoService) {
		this.customInfoService = customInfoService;
	}

	/**
	 * @param leaguerService the leaguerService to set
	 */
	public void setLeaguerService(LeaguerService leaguerService) {
		this.leaguerService = leaguerService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

}

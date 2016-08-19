package com.qylm.bean.returner;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.qylm.common.Tool;

/**
 * 调用画面返回时的工具类
 * @author 
 *
 * @param <BackBean> 调用画面的BackBean
 * @param <Dto> 调用画面的Dto
 * @param <Entity> 需要返回的实体类
 */
public abstract class Returner<BackBean, Dto, Entity> implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6168358369439192536L;

	/**
	 * 调用画面的类
	 */
	protected Class<BackBean> backBeanClass;
	
	/**
	 * 调用画面的Dto
	 */
	protected Dto dto;
	
	/**
	 * 如果调用画面有翻页的话，表示当前是第几页
	 */
	protected int currentPage = 1;
	
	@SuppressWarnings("unchecked")
	private Class<BackBean> getBackBeanClass() {
		return (Class<BackBean>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	public Returner() {
		backBeanClass = getBackBeanClass();
	}
	
	public Returner(int currentPage) {
		this.currentPage = currentPage;
		backBeanClass = getBackBeanClass();
	}
	
	public Returner(Dto dto) {
		this.dto = dto;
		backBeanClass = getBackBeanClass();
	}
	
	public Returner(Dto dto, int currentPage) {
		this.dto = dto;
		this.currentPage = currentPage;
		backBeanClass = getBackBeanClass();
	}
	
	public String returnEntity(Entity entity) {
		return returnEntity(Tool.getBackBean(backBeanClass), entity);
	}
	
	/**
	 * 各returner请按自己需要重写本方法，返回被选择的单个实体类
	 * @param backBean 调用画面的BackBean
	 * @param entity 被选择的实体类
	 * @return 调用画面的navigation-case
	 */
	public String returnEntity(BackBean backBean, Entity entity) {
		return null;
	}

	public String returnEntityList(List<Entity> entityList) {
		return returnEntityList(Tool.getBackBean(backBeanClass), entityList);
	}

	/**
	 * 各returner请按自己需要重写本方法，返回被选择的实体类列表
	 * @param backBean 调用画面的BackBean
	 * @param idList 被选择的实体类列表
	 * @return 调用画面的navigation-case
	 */
	public String returnEntityList(BackBean backBean, List<Entity> entityList) {
		return null;
	}
	
	public String returnOnly() {
		return returnOnly(Tool.getBackBean(backBeanClass));
	}
	
	/**
	 * 用户什么也没有选择，直接返回的情况下，调用的方法
	 * @param backBean 调用画面的BackBean
	 * @return 调用画面的navigation-case
	 */
	public abstract String returnOnly(BackBean backBean);

}

package com.qylm.common;

import com.qylm.bean.returner.Returner;

/**
 * 登陆画面的接口，所有登陆画面必须实现这个接口
 * @author 
 * 
 * @param <Entity> 实体类
 *
 */
public interface CreateBean<Entity> {

	/**
	 * 新建按钮（其他画面按【新建】按钮，跳转到本画面）
	 * @param returner 返回调用画面用的工具类
	 * @return 跳转到登陆画面的navigation-case
	 */
	public String newCreate(Returner<?, ?, ?> returner);
	
	/**
	 * 修改/详细按钮（其他画面按【修改/详细】按钮，跳转到本画面）
	 * @param returner 返回调用画面用的工具类
	 * @param entity 实体类
	 * @return 跳转到登陆画面的navigation-case
	 */
	public String updateDetail(Returner<?, ?, ?> returner, Entity entity);
	
}

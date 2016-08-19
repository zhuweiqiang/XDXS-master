package com.qylm.dto.custom;

import java.io.Serializable;

import com.qylm.entity.Leaguer;

/**
 * 保存客户卡项查询管理画面需要的值
 * @author smj
 */
public class CustomLeaguerDetailManageDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3717765746334193162L;

	/**
	 * 卡项
	 */
	private Leaguer leaguer;
	
	/**
	 * 客户姓名
	 */
	private String name;
	
	/**
	 * @return the leaguer
	 */
	public Leaguer getLeaguer() {
		return leaguer;
	}

	/**
	 * @param leaguer the leaguer to set
	 */
	public void setLeaguer(Leaguer leaguer) {
		this.leaguer = leaguer;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}

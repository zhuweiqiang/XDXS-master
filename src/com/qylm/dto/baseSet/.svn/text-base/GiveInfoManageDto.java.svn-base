package com.qylm.dto.baseSet;

import java.io.Serializable;

import com.qylm.entity.GiveInfo;

/**
 * 保存 体验卡管理画面需要的值
 * @author smj
 */
public class GiveInfoManageDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6092307894803690792L;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 类型
	 */
	private String type;
	
	/**
	 * 名称
	 */
	public String getName() {
		String name = "";
		if (GiveInfo.TYPE_1.equals(type)) {
			name = "体验卡";
		} else if (GiveInfo.TYPE_2.equals(type)) {
			name = "现金卷";
		} else {
			name = "身体卷";
		}
		return name;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}

package com.qylm.bean.returner;

import com.qylm.bean.MyDeskBean;
import com.qylm.dto.MyDeskDto;

public class MyDeskReturner extends Returner<MyDeskBean, MyDeskDto, Object> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -383843502485142946L;

	public MyDeskReturner(MyDeskDto myDeskDto) {
		super(myDeskDto);
	}
	
	@Override
	public String returnOnly(MyDeskBean backBean) {
		backBean.setMyDeskDto(dto);
		return backBean.getAllMyDesk();
	}

}

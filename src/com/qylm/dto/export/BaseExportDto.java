package com.qylm.dto.export;

import java.io.Serializable;
import java.util.List;

/**
 * baseExport
 * @author smj
 */
public class BaseExportDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2174664637148720413L;
	
	/**
	 * 行数
	 */
	private int row;
	
	/**
	 * 错误系统提示
	 * errorList
	 */
	private List<String> errorList;

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the errorList
	 */
	public List<String> getErrorList() {
		return errorList;
	}

	/**
	 * @param errorList the errorList to set
	 */
	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
	
}

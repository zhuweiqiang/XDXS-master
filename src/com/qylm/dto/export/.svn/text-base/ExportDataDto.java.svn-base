package com.qylm.dto.export;

import java.io.Serializable;
import java.util.List;

/**
 * baseExport
 * @author smj
 */
public class ExportDataDto<T extends BaseExportDto> implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3327697897695944303L;

	/**
	 * 
	 */
	private List<T> exportDtoList;
	
	/**
	 * 错误系统提示
	 * errorList
	 */
	private List<String> errorList;

	/**
	 * @return the exportDtoList
	 */
	public List<T> getExportDtoList() {
		return exportDtoList;
	}

	/**
	 * @param exportDtoList the exportDtoList to set
	 */
	public void setExportDtoList(List<T> exportDtoList) {
		this.exportDtoList = exportDtoList;
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

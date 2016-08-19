package com.qylm.exception;

/**
 * 上传的excel文件行数过多时的异常
 * @author 
 *
 */
public class ExcelUpfileRowNumOverSizeException extends Exception {

	private static final long serialVersionUID = -5953713476245599266L;

	public ExcelUpfileRowNumOverSizeException(){}
	
	public ExcelUpfileRowNumOverSizeException(String message){
		super(message);
	}

}

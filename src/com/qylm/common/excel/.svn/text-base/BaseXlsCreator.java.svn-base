package com.qylm.common.excel;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.qylm.common.Message;
import com.qylm.common.utils.ExcelUtil;

/**
 * 生成EXCEL父类
 * @author 
 *
 */
public class BaseXlsCreator {
	
	/**
	 * LOG
	 */
	protected static final Log LOG = LogFactory.getLog(BaseXlsCreator.class);
	
	/**
	 * 设置开始位置的默认值为0
	 */
	protected static final int DEFAULT_START_COLUMN = 0;
	
	/**
	 * 表的结束位置
	 */
	protected static final int input41End = 41;
	
	protected HSSFWorkbook workbook;
	
	protected HSSFSheet sheet;
	
	protected HSSFCellStyle border;
	
	protected HSSFCellStyle borderLeft;
	
	/**
	 * 构建默认样式
	 */
	protected void colorStyle() {
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 12);
		border = ExcelUtil.defaultStyle(workbook);
		border.setFont(font);
		borderLeft = ExcelUtil.defaultStyle(workbook);
		HSSFFont fontLeft = workbook.createFont();
		fontLeft.setFontHeightInPoints((short) 15);
		borderLeft.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		fontLeft.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		borderLeft.setFont(fontLeft);
	}
	
	/**
	 * 读取模板文件，并且初始化样式
	 * @param templet 模板文件名称
	 */
	protected void initResource(String templet) {
		ClassLoader classLoader = BaseXlsCreator.class.getClassLoader();
		// 获得文件路径
		URL resUrl = classLoader.getResource(templet);
		InputStream is;
		try {
			is = new BufferedInputStream(resUrl.openStream());
			workbook = new HSSFWorkbook(is);
	    	is.close();
		} catch (IOException e) {
			if(LOG.isErrorEnabled()){
				LOG.error(Message.GENERAL_FILE_FETCH_ERROR, e);
			}
		}
		// 读取第一页,一般一个excel文件会有三个工作表，这里获取第一个工作表来进行操作
		sheet = workbook.getSheetAt(0);
		// 初始化样式
		colorStyle();
	}
	
	/**
	 * 合并单元格并个单元格赋值（行高样式都为默认）
	 * @param startColumn 从第几列开始
	 * @param endColumn 到第几列
	 * @param rowNum 在第几行
	 * @param str 单元格内容
	 */
	protected void createCell(int startColumn, int endColumn, int rowNum, String str) {
		createCellRowHeight(startColumn, endColumn, rowNum, str, 0, border);
	}
	
	/**
	 * 合并单元格并个单元格赋值（单元格样式为默认）
	 * @param startColumn 从第几列开始
	 * @param endColumn 到第几列
	 * @param rowNum 在第几行
	 * @param str 单元格内容
	 * @param rowHeight 行高
	 */
	protected void createCellNoBoder(int startColumn, int endColumn, int rowNum, String str, int cellRowHeight) {
		createCellRowHeight(startColumn, endColumn, rowNum, str, cellRowHeight, border);
	}
	
	/**
	 * 合并单元格并个单元格赋值（行高默认）
	 * @param startColumn 从第几列开始
	 * @param endColumn 到第几列
	 * @param rowNum 在第几行
	 * @param str 单元格内容
	 * @param border 单元格样式
	 */
	protected void createCellBorder(int startColumn, int endColumn, int rowNum, String str, HSSFCellStyle borderLeft) {
		createCellRowHeight(startColumn, endColumn, rowNum, str, 0, borderLeft);
	}
	
	/**
	 * 合并单元格标题样式（单元格样式标题样式）
	 * @param startColumn 从第几列开始
	 * @param endColumn 到第几列
	 * @param rowNum 在第几行
	 * @param str 单元格内容
	 * @param rowHeight 行高
	 */
	protected void createTitle(int startColumn, int endColumn, int rowNum, String str, int rowHeight) {
		// 设置样式
		ExcelUtil.setRegionStyle(sheet, rowNum, rowNum + rowHeight, startColumn, endColumn, borderLeft);
		setCellValue(getRow(rowNum), startColumn, str);
	}
	
	/**
	 * 合并单元格并为单元格赋值
	 * @param startColumn 从第几列开始
	 * @param endColumn 到第几列
	 * @param rowNum 在第几行
	 * @param str 单元格内容
	 * @param rowHeight 行高
	 * @param border 单元格样式
	 */
	protected void createCellRowHeight(int startColumn, int endColumn, int rowNum, String str, int rowHeight, HSSFCellStyle border) {
		// 设置样式
		ExcelUtil.setRegionStyle(sheet, rowNum, rowNum + rowHeight, startColumn, endColumn, border);
		setCellValue(getRow(rowNum), startColumn, str);
	}
	
	/**
	 * 创建单元格并赋值
	 * @param row 行
	 * @param cellnum 在第几列
	 * @param str 单元格内容
	 */
	protected void setCellValue(HSSFRow row, int cellnum, String str) {
		ExcelUtil.setCellValue(row, cellnum, str);
	}
	
	/**
	 * 创建单元格并赋值，并且上设置样式
	 * @param row 行
	 * @param cellnum 在第几列
	 * @param str 单元格内容
	 * @param border 单元格样式
	 */
	protected void setCellValue(HSSFRow row, int cellnum, String str, HSSFCellStyle border) {
		HSSFCell cell = ExcelUtil.getCell(cellnum, row);
		cell.setCellStyle(border);
		cell.setCellValue(new HSSFRichTextString(str));
	}
	
	/**
	 * 取得行
	 * @param rowNum 在第几行
	 * @return
	 */
	protected HSSFRow getRow(int rowNum) {
		return ExcelUtil.getRow(rowNum, sheet);
	}

}

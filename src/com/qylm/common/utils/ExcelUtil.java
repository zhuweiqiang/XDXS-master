package com.qylm.common.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.util.CellRangeAddress;
import org.primefaces.model.UploadedFile;

import com.qylm.common.Message;
import com.qylm.constants.Constants;
import com.qylm.constants.FileConstants;
import com.qylm.exception.ExcelUpfileRowNumOverSizeException;

/**
 * excel相关工具类
 * @author 
 *
 */
public final class ExcelUtil {

	/**
	 * 当前位置
	 */
	private int currPosition;

	/**
	 * 日期的格式
	 */
	private SimpleDateFormat dateFormat;

	private HSSFSheet sheet;
	// HSSFWorkbook
	private HSSFWorkbook workbook;
	
	private static HSSFFormulaEvaluator evaluator;
	
	/**
	 * 把指定的行的高度设定为0，达到隐藏的目的
	 * @param sheet excel的sheet
	 * @param rowNum 第几行
	 */
	public static void setRowHidden(HSSFSheet sheet, int rowNum) {
		getRow(rowNum, sheet).setHeight((short) 0);
	}
	
	/**
	 * 合并单元格
	 * @param sheet
	 * @param region
	 * @param cs 单元格样式
	 */
	public static void setRegionStyle(HSSFSheet sheet, int firstRow, int lastRow, int firstCol, int lastCol, HSSFCellStyle cs) {
		HSSFRow row;
		CellRangeAddress region = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);
		sheet.addMergedRegion(region);
		for (int i = firstRow; i <= lastRow; i++) {
			row = getRow(i, sheet);
			for (int j = firstCol; j <= lastCol; j++) {
				getCell(j, row).setCellStyle(cs);
			}
		}
	}
	
	/**
	 * 取得行
	 * @param rowNum 是第几行
	 * @param sheet
	 * @return
	 */
	public static HSSFRow getRow(int rowNum, HSSFSheet sheet) {
		HSSFRow row = sheet.getRow(rowNum);
		if (row == null) {
			row = sheet.createRow(rowNum);
		}
		return row;
	}
	
	/**
	 * 取得单元格
	 * @param cellnum 第几列
	 * @param row 行
	 * @return
	 */
	public static HSSFCell getCell(int cellnum, HSSFRow row) {
		HSSFCell cell = row.getCell(cellnum);
		if (cell == null) {
			cell = row.createCell(cellnum);
		}
		return cell;
	}
	
	/**
	 * 设置单元格的值
	 * @param row excel行
	 * @param cellnum 单元格在第几列
	 * @param str 单元格内容
	 */
	public static void setCellValue(HSSFRow row, int cellnum, String str) {
		// 设置显示的文字
		getCell(cellnum, row).setCellValue(new HSSFRichTextString(str));
	}
	
	/**
	 * 默认的excel单元格样式
	 * @param workbook
	 */
	public static HSSFCellStyle defaultStyle(HSSFWorkbook workbook) {
		HSSFCellStyle border = workbook.createCellStyle();
		border.setBorderTop(HSSFCellStyle.BORDER_THIN);
		border.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		border.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		border.setBorderRight(HSSFCellStyle.BORDER_THIN);
		border.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		border.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		border.setWrapText(true);
		return border;
	}
	
	/**
	 * 检查是否是excel文件
	 * 
	 * @param upFile
	 * @return true OK false NG
	 */
	public static boolean checkFileType(UploadedFile upFile) {
		String name = upFile.getFileName();
		if (FileConstants.XLS.equalsIgnoreCase(name.substring(name.lastIndexOf(Constants.DOT) + 1))) {
			return true;
		}
		return false;
	}

	/**
	 * 以文件的InputStream初始化
	 * @param is
	 * @throws IOException
	 */
	public void initReader(InputStream is) throws IOException {
		// 设置开始行为1,第一行为标题，不写入
		initReader(is, 1);
	}
	
	/**
	 * 以文件的InputStream初始化
	 * @param is
	 * @param currPosition 从第几行开始写入
	 * @throws IOException
	 */
	public int initReader(InputStream is, int currPosition) throws IOException {
		this.currPosition = currPosition;
		// 如果是Excel文件则创建HSSFWorkbook读取
		workbook = new HSSFWorkbook(new BufferedInputStream(is));
		sheet = workbook.getSheetAt(0);
		dateFormat = new SimpleDateFormat(Constants.YYYY_MM_DD);
		evaluator = new HSSFFormulaEvaluator(workbook);
		is.close();
		return sheet.getLastRowNum();
	}
	
	/**
	 * 初始化ExcelUtil，并且不跳过标题行
	 * @param is
	 * @throws IOException
	 */
	public void initReaderStartFirst(InputStream is) throws IOException {
		workbook = new HSSFWorkbook(new BufferedInputStream(is));
		sheet = workbook.getSheetAt(0);
		is.close();
	}

	/**
	 * 验证excel的数据行数是否超过允许上传的最大行数
	 * @throws ExcelUpfileRowNumOverSizeException
	 */
	public void checkSize() throws ExcelUpfileRowNumOverSizeException {
		if (sheet.getLastRowNum() > 500000) {
			throw new ExcelUpfileRowNumOverSizeException(Message.GENERAL_FILE_OVERSTEP_LENGTH);
		}
	}

	/**
	 * 以文件名初始化
	 * @param fileName
	 * @throws IOException
	 */
	public void initWriter(String fileName) throws IOException {
		// 默认第一行不写入
		fileName = FileConstants.TEMPLET_EXPORT_PATH + fileName;
		initWriter(fileName, 1);
	}
	
	/**
	 * 以文件名初始化
	 * @param fileName
	 * @param currPosition 从第几行开始写入
	 * @throws IOException
	 */
	public void initWriter(String fileName, int currPosition) throws IOException {
		ClassLoader classLoader = ExcelUtil.class.getClassLoader();
		URL resUrl = classLoader.getResource(fileName);
		InputStream is = new BufferedInputStream(resUrl.openStream());
		initReader(is, currPosition);
	}
	
	/**
	 * 把数据写入excel
	 * @param input 需要写入excel的数据
	 */
	public void writeLine(Object... input) {
		HSSFRow row = sheet.createRow(currPosition);
		int length = input.length;
		HSSFCell cell;
		Object obj;
		for (int i = 0; i < length; i++) {
			obj = input[i];
			if (obj == null) {
				continue;
			}
			cell = row.createCell(i);
			if (obj instanceof String) {
				cell.setCellValue(new HSSFRichTextString((String) obj));
			} else if (obj instanceof Date) {
				cell.setCellValue(new HSSFRichTextString(dateFormat.format((Date) obj)));
			} else if (obj instanceof Boolean) {
				if (((Boolean) obj).booleanValue()) {
					cell.setCellValue(new HSSFRichTextString("是"));
				} else {
					cell.setCellValue(new HSSFRichTextString("否"));
				}
			} else if (obj instanceof Integer) {
				cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				cell.setCellValue((Integer) obj);
			} else {
				cell.setCellValue(new HSSFRichTextString(obj.toString()));
			}
		}
		currPosition++;
	}

	/**
	 * 把excel输出到硬盘上
	 * @param os
	 */
	public void writeBook(OutputStream os) {
		try {
			workbook.write(os);
			// os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取excel的一行
	 * @param columnNum
	 * @return
	 * @throws IOException
	 */
	public Object[] readLine(int columnNum) throws IOException {
		// 判断当前行是否到但前Sheet的结尾
		if (currPosition > sheet.getLastRowNum()) {
			return null;
		}
		Object[] outPut = new Object[columnNum];
		int row = currPosition;
		currPosition++;
		// 根据行数取得Sheet的一行
		HSSFRow rowline = sheet.getRow(row);
		if (rowline == null) {
			return null;
		}
		// 读取当前行数据
		int size = outPut.length;
		// 循环遍历所有列
		for (int i = 0; i < size; i++) {
			outPut[i] = getCellValue(rowline.getCell(i));
		}
		return outPut;
	}

	/**
	 * 读取excel的一行中的固定几列
	 * @param columnNum
	 * @return
	 * @throws IOException
	 */
	public Object[] readColumns(int[] columns) throws IOException {
		// 判断当前行是否到但前Sheet的结尾
		if (currPosition > sheet.getLastRowNum()) {
			return null;
		}
		int size = columns.length;
		Object[] outPut = new Object[columns.length];
		int row = currPosition;
		currPosition++;
		// 读取当前行数据，只读取固定几列
		// 根据行数取得Sheet的一行
		HSSFRow rowline = sheet.getRow(row);
		if (rowline == null) {
			return null;
		}
		// 循环遍历所有列
		for (int i = 0; i < size; i++) {
			outPut[i] = getCellValue(rowline.getCell(columns[i]));
		}
		return outPut;
	}
	
	/**
	 * 取得单元格的值，本方法不会返回null，如果单元格为空则返回空字符串""
	 * @param cellnum 第几列
	 * @param row 行
	 * @return
	 */
	public static Object getCellValue(int cellnum, HSSFRow row) {
		return getCellValue(getCell(cellnum, row));
	}
	
	/**
	 * 取得单元格的值，本方法不会返回null，如果单元格为空则返回空字符串""
	 * @param cell 单元格
	 * @return
	 */
	public static Object getCellValue(HSSFCell cell) {
		Object obj;
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			// 如果当前Cell的Type为NUMERIC
			case HSSFCell.CELL_TYPE_NUMERIC: {
				// 判断当前的cell是否为Date
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// 如果是Date类型则，取得该Cell的Date值
					obj = cell.getDateCellValue();
				}
				// 如果是纯数字
				else {
					// 取得当前Cell的数值
					// outPut[i] =
					// String.valueOf(cell.getNumericCellValue());
					// outPut[i] = new
					// BigDecimal(cell.getNumericCellValue());
					// obj = Integer.valueOf((int) cell.getNumericCellValue());
					obj = Double.toString(cell.getNumericCellValue());
				}
				break;
			}
			// 如果当前Cell的Type为String
			case HSSFCell.CELL_TYPE_STRING:
				// 取得当前的Cell字符串
				obj = cell.getRichStringCellValue().getString();
				break;
//			// 如果当前Cell的Type为计算公式
			case HSSFCell.CELL_TYPE_FORMULA:
				//设置单元格所在行
				CellValue cellValue = evaluator.evaluate(cell);
				switch (cellValue.getCellType()) {
				case HSSFCell.CELL_TYPE_NUMERIC:
					// 判断当前的cell是否为Date
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						// 如果是Date类型则，取得该Cell的Date值
						obj = cell.getDateCellValue();
					}
					// 如果是纯数字
					else {
						obj = Double.toString(cell.getNumericCellValue());
					}
					break;
				case HSSFCell.CELL_TYPE_STRING:
					// 取得当前的Cell字符串
					obj = cell.getRichStringCellValue().getString();
				    break;
				default:
					obj = "";
				}
				break;
			// 默认的Cell值
			default:
				obj = "";
			}
		} else {
			obj = "";
		}
		return obj;
	}
	
	/**
	 * 取得单元格的字符串形式的值
	 * @param cellnum 第几列
	 * @param row 行
	 * @return
	 */
	public static String getCellStrValue(int cellnum, HSSFRow row) {
		return getCellValue(cellnum, row).toString();
	}
	
	/**
	 * 取得单元格的字符串形式的值
	 * @param cell 单元格
	 * @return
	 */
	public static String getCellStrValue(HSSFCell cell) {
		return getCellValue(cell).toString();
	}
	
	/**
	 * 取得workbook
	 * 
	 * @return workbook
	 */
	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	/**
	 * get sheet
	 * @return the sheet
	 */
	public HSSFSheet getSheet() {
		return sheet;
	}

	/**
	 * set sheet
	 * @param sheet the sheet to set
	 */
	public void setSheet(HSSFSheet sheet) {
		this.sheet = sheet;
	}
	
}

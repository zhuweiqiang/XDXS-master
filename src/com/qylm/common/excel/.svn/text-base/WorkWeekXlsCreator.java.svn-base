package com.qylm.common.excel;


/**
 * 周报生成excel文件
 * @author 陈祥飞
 */
public class WorkWeekXlsCreator extends BaseXlsCreator {
	
	/**
	 * 合并一行
	 */
	private static final int heBingYiHang = 0;
	
	/**
	 * 从第二行行后开始合并
	 */
	private static final int rowHeBing = 3;
	
	/**
	 * 从部门的第一列开始合并
	 */
	private static final int rowOnw = 1;
	
//	/**
//	 * 下载生产报表
//	 * @param title 标题
//	 * @param engineeringProjectDetailList 生产 报表
//	 * @return
//	 */
//	public HSSFWorkbook workWeekXls(String title, List<EngineeringProjectDetail> engineeringProjectDetailList) {
//		initResource(FileConstants.TEMPLET_EXPORT_PATH + ExcelFiles.EXPORT_PRODUCTION_STATISTICS_XLS);
//		int rowNum = 0;
//		HSSFRow row = getRow(rowNum);
//		// 设置标题
//		createTitle(heBingYiHang, heBingYiHang, heBingYiHang, title, 0);
//		row = getRow(rowNum + 2);
//		int size = engineeringProjectDetailList.size();
//		// 最大行数，为10000
//		int count = 10000;
//		if (size > count) {
//			size = count;
//		}
//		EngineeringProjectDetail engineeringProjectDetail;
//		for (int i = 0; i < size; i++) {
//			engineeringProjectDetail = engineeringProjectDetailList.get(i);
//			setCellValue(row, 0, DateUtil.formatDate(engineeringProjectDetail.getStartPumpDate(), Constants.YYYY_MM_DD), border);
//			setCellValue(row, 1, engineeringProjectDetail.getVehicleInfo().getNumber(), border);
//			setCellValue(row, 2, engineeringProjectDetail.getEngineeringProject().getCustomer().getName(), border);
//			setCellValue(row, 3, engineeringProjectDetail.getEngineeringProject().getWorkAddress(), border);
//			setCellValue(row, 4, engineeringProjectDetail.getPumpParts(), border);
//			setCellValue(row, 5, BigDecimalUtil.toString(engineeringProjectDetail.getSchedule()), border);
//			setCellValue(row, 6, DateUtil.formatDate(engineeringProjectDetail.getStartPumpDate(), Constants.YYYY_MM_DD_HH_MM_SS), border);
//			setCellValue(row, 7, DateUtil.formatDate(engineeringProjectDetail.getEndPumpDate(), Constants.YYYY_MM_DD_HH_MM_SS), border);
//			setCellValue(row, 8, BigDecimalUtil.toString(engineeringProjectDetail.getEngineeringProject().getPumpPrice()), border);
//			setCellValue(row, 9, BigDecimalUtil.toString(engineeringProjectDetail.getGasVolume()), border);
//			setCellValue(row, 10, BigDecimalUtil.toString(engineeringProjectDetail.getGasPrice()), border);
//			if (engineeringProjectDetail.getProjectEmployeeDetailList() != null && !engineeringProjectDetail.getProjectEmployeeDetailList().isEmpty()) {
//				int detailSize = 11;
//				for (ProjectEmployeeDetail projectEmployeeDetail : engineeringProjectDetail.getProjectEmployeeDetailList()) {
//					setCellValue(row, detailSize, projectEmployeeDetail.getName(), border);
//					detailSize++;
//				}
//			}
//		}
//		return workbook;
//	}

}

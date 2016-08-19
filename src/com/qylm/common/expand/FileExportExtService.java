package com.qylm.common.expand;

import java.util.List;

import org.primefaces.model.UploadedFile;

import com.qylm.dto.export.BaseExportDto;
import com.qylm.dto.export.ExportDataDto;

/**
 * excel数据导入
 * @author Administrator
 */
public interface FileExportExtService<T extends BaseExportDto> {
	
	/**
	 * 对excel文件内的数据进行验证，如果存在有错误就显示出来
	 * 只验证上传Excel是字段必填获得数据规格验证。电话号码等验证
	 * @param uploadedFile
	 * @return
	 */
	public ExportDataDto<T> validatorExcel(UploadedFile uploadedFile);
	
	/**
	 * 对BaseExportDto中数据的进行数据库验证
	 * 入是否有重复 如 身份证号是否有重复
	 * @param exportDataDto
	 * @returnx
	 */
	public ExportDataDto<T> validatorExportDto(ExportDataDto<T> exportDataDto);
	
	/**
	 * 保存BaseExportDto文件内的数据
	 * @param baseExportDtoList
	 */
	public void saveExportData(List<T> baseExportDtoList);
	
}

package com.qylm.service;

import java.util.List;

import com.qylm.common.expand.FileExportExtService;
import com.qylm.dto.export.BaseExportDto;
import com.qylm.entity.FileEntity;
import com.qylm.entity.FileExport;
import com.qylm.exception.FileExportLogicException;

public interface FileExportService extends GenericService<FileExport, Integer> {

	/**
	 * 保存文件
	 * @param fileExportExtService 文件保存service
	 * @param baseExportDtoList 保存的dto
	 * @param entity 上传文件对应哪个持久化类
	 * @param fileEntity 文件信息
	 * @return 文件控件
	 * @throws FileExportLogicException 
	 */
	public FileExport saveEntity(FileExportExtService<BaseExportDto> fileExportExtService, List<BaseExportDto> baseExportDtoList, String entityType, FileEntity fileEntity) throws FileExportLogicException;
	
	/**
	 * 根据实体类查询出对应的所有文件信息
	 * @param entity
	 * @return
	 */
	public List<FileExport> getFileExportList(String entityType);
}

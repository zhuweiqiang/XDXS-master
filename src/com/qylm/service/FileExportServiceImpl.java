package com.qylm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylm.common.expand.FileExportExtService;
import com.qylm.dao.FileExportDao;
import com.qylm.dto.export.BaseExportDto;
import com.qylm.entity.FileEntity;
import com.qylm.entity.FileExport;
import com.qylm.exception.FileExportLogicException;
import com.qylm.logic.FileExportLogic;

@Service("fileExportService")
public class FileExportServiceImpl extends GenericServiceImpl<FileExport, Integer> implements FileExportService {

	@Autowired
	private FileExportLogic fileExportLogic;
	
	@Autowired
	protected FileExportServiceImpl(FileExportDao fileExportDao) {
		super(fileExportDao);
	}
	
	public FileExport saveEntity(FileExportExtService<BaseExportDto> fileExportExtService, List<BaseExportDto> baseExportDtoList, String entityType, FileEntity fileEntity) throws FileExportLogicException {
		return fileExportLogic.saveEntity(fileExportExtService, baseExportDtoList, entityType, fileEntity);
	}
	
	/**
	 * @param entityClass 持久化类class名称
	 * @param entityType 持久化类
	 * @return 持久化类对应文件
	 */
	public List<FileExport> getFileExportList(String entityType){
		return fileExportLogic.getFileExportList(entityType);
	}
	
	public void deleteEntity(FileExport fileExport){
		fileExportLogic.deleteEntity(fileExport);
	}

}

package com.qylm.logic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.common.expand.FileExportExtService;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.constants.FileConstants;
import com.qylm.dao.FileExportDao;
import com.qylm.dto.export.BaseExportDto;
import com.qylm.entity.FileEntity;
import com.qylm.entity.FileExport;
import com.qylm.exception.FileExportLogicException;

public class FileExportLogic {

	/**
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(FileExportLogic.class);

	@Autowired
	private FileExportDao fileExportDao;

	/**
	 * @param entity 持久化类
	 * @return 持久化类对应文件
	 */
	public List<FileExport> getFileExportList(String entityType) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(FileExport.class);
		detachedCriteria.add(Restrictions.eq(FileExport.ENTITY_TYPE, entityType));
		List<FileExport> fileExportList = fileExportDao.getByDetachedCriteria(detachedCriteria);
		return fileExportList;
	}

	/**
	 * @param entityType 上传文件对应哪个持久化类
	 * @param type 上传文件的类型文件夹
	 * @param uploadedFile 上传文件
	 * @return 文件控件
	 */
	public FileExport saveEntity(FileExportExtService<BaseExportDto> fileExportExtService, List<BaseExportDto> baseExportDtoList, String entityType, FileEntity fileEntity) throws FileExportLogicException {
		fileExportExtService.saveExportData(baseExportDtoList);
		FileExport fileExport = null;
		if (fileEntity != null && fileEntity.getUploadedFile() != null 	&& fileEntity.getUploadedFile().getSize() > 0) {
			StringBuilder sb = new StringBuilder(64);
			sb.append(FileConstants.FILE_EXPORT).append(File.separatorChar);
			sb.append(entityType);
			if (StringUtil.isNotBlank(fileEntity.getFolder())) {
				sb.append(File.separatorChar).append(fileEntity.getFolder());
			}
			InputStream is = null;
			BufferedOutputStream os = null;
			try {
				String url = sb.toString();
				File file = new File(Constants.fileStorePath + url);
				if (!file.exists() && !file.isDirectory()) {
					file.mkdirs();
				}
				fileExport = new FileExport();
				fileExport.setEntityType(entityType);
				String fileName = fileEntity.getUploadedFile().getFileName();// 原文件名
				fileExport.setOriginalName(fileName.substring(fileName.lastIndexOf(File.separator) + 1).toLowerCase());
				StringBuilder currentName = new StringBuilder(64);// 当前文件名
				currentName.append(entityType);
				currentName.append(Constants.UNDERLINE).append(UUID.randomUUID());
				currentName.append(FileConstants.EX_NAME_XLS);//
				String tempName = currentName.toString();
				fileExport.setCurrentName(tempName);
				url += File.separatorChar + tempName;
				fileExport.setUrl(url);
				fileExport.setFolder(fileEntity.getFolder());
				File detailFile = new File(Constants.fileStorePath + url);
				os = new BufferedOutputStream(FileUtils.openOutputStream(detailFile));
				is = new BufferedInputStream(fileEntity.getUploadedFile().getInputstream());
				IOUtils.copy(is, os);
				fileExportDao.saveEntity(fileExport);
			} catch (FileNotFoundException e) {
				logger.error("文件不存在");
				e.printStackTrace();
				throw new FileExportLogicException("文件不存在");
			} catch (IOException e) {
				logger.error("操作文件出错");
				e.printStackTrace();
				throw new FileExportLogicException("操作文件出错");
			} finally {
				IOUtils.closeQuietly(is);
				IOUtils.closeQuietly(os);
			}
		}
		return fileExport;
	}

	/**
	 * 删除文件
	 * @param fileExport
	 */
	public void deleteEntity(FileExport fileExport) {
		fileExportDao.deleteEntity(fileExport);
		File file = new File(fileExport.getAbsoluteUrl());
		try {
			FileUtils.forceDelete(file);// 删除文件
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param fileExportDao
	 *            the fileExportDao to set
	 */
	public void setFileExportDao(FileExportDao fileExportDao) {
		this.fileExportDao = fileExportDao;
	}

}

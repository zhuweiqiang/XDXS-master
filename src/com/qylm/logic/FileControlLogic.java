package com.qylm.logic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.persistence.DiscriminatorValue;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.common.utils.CheckUtil;
import com.qylm.common.utils.CipherUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.constants.FileConstants;
import com.qylm.dao.EntityClassDao;
import com.qylm.dao.FileControlDao;
import com.qylm.entity.BaseEntity;
import com.qylm.entity.EntityClass;
import com.qylm.entity.FileControl;
import com.qylm.entity.FileEntity;
import com.qylm.exception.FileControlLogicException;

public class FileControlLogic {
	
	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(FileControlLogic.class);

	@Autowired
	private FileControlDao fileControlDao;
	
	@Autowired
	private EntityClassDao entityClassDao;
	
	/**
	 * @param entity 持久化类
	 * @return 持久化类对应文件
	 */
	public FileControl getFileControlOne(BaseEntity entity){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(FileControl.class);
		detachedCriteria.add(Restrictions.eq(FileControl.ENTITY, entity));
		List<FileControl> fileControlList = fileControlDao.getByDetachedCriteria(detachedCriteria, 0, 1);
		if(!fileControlList.isEmpty())return fileControlList.get(0);
		return null;
	}

	/**
	 * @param entity 持久化类
	 * @return 持久化类对应文件
	 */
	public List<FileControl> getFileControlList(BaseEntity entity){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(FileControl.class);
		detachedCriteria.add(Restrictions.eq(FileControl.ENTITY, entity));
		List<FileControl> fileControlList = fileControlDao.getByDetachedCriteria(detachedCriteria);
		return fileControlList;
	}
	
	/**
	 * 根据不同的类型查询对应文件
	 * @param entity 持久化类
	 * @param type 持久化类
	 * @return 持久化类对应文件
	 */
	public List<FileControl> getFileControlByTypeList(BaseEntity entity, String type){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(FileControl.class);
		detachedCriteria.add(Restrictions.eq(FileControl.DESCRIPTION, type));
		detachedCriteria.add(Restrictions.eq(FileControl.ENTITY, entity));
		List<FileControl> fileControlList = fileControlDao.getByDetachedCriteria(detachedCriteria);
		return fileControlList;
	}
	
	/**
	 * @param entity 上传文件对应哪个持久化类
	 * @param type 上传文件的类型文件夹
	 * @param uploadedFile 上传文件
	 * @return 文件控件
	 */
	public FileControl saveEntity(BaseEntity entity, FileEntity fileEntity) throws FileControlLogicException{
		FileControl fileControl = null;
		if (fileEntity!=null && fileEntity.getUploadedFile() != null
				&&fileEntity.getUploadedFile().getSize()>0) {
			StringBuilder sb = new StringBuilder(64);
			sb.append(FileConstants.FILE_UPLOAD).append(File.separatorChar);
			sb.append(entity.getClass().getSimpleName());
			if(StringUtil.isNotBlank(fileEntity.getFolder()))
				sb.append(File.separatorChar).append(fileEntity.getFolder());
			InputStream is = null;
			OutputStream os = null;
			try {
				String url = sb.toString();
				File file = new File(Constants.fileStorePath + url);
				if(!file.exists() && !file.isDirectory())file.mkdirs();
				fileControl = new FileControl();
				fileControl.setEntity(entity);
				fileControl.setSizeLimit(fileEntity.getUploadedFile().getSize());
				String fileName = fileEntity.getUploadedFile().getFileName();//原文件名
				fileControl.setOriginalName(fileName.substring(fileName.lastIndexOf(File.separator)+1).toLowerCase());
				StringBuilder currentName = new StringBuilder(64);//当前文件名
				currentName.append(entity.getClass().getName()).append(Constants.UNDERLINE).append(entity.getId());
				currentName.append(Constants.UNDERLINE).append(UUID.randomUUID());
				fileControl.setSuffix(fileName.substring(fileName.lastIndexOf(Constants.DOT)+1).toLowerCase());//后缀名
				currentName.append(Constants.DOT).append(fileControl.getSuffix());//
				String tempName = currentName.toString();
				fileControl.setCurrentName(tempName);
				url += File.separatorChar + tempName;
				fileControl.setUrl(url);
				fileControl.setFolder(fileEntity.getFolder());
				String type = (CheckUtil.isImage(fileControl.getOriginalName()))?FileControl.TYPE_1:FileControl.TYPE_2;
				fileControl.setType(type);
				if(StringUtil.isNotBlank(fileEntity.getEncryptionPass())){//加密
					fileControl.setEncryptionType("RSA");//加密类型
					//fileControl.setEncryptionPass("");//加密密码
					fileControl.setEncryption(true);
					File detailFile = new File(Constants.fileStorePath + url);
					os = new BufferedOutputStream(FileUtils.openOutputStream(detailFile));
					is = new BufferedInputStream(fileEntity.getUploadedFile().getInputstream());
					CipherUtil.RSAFileEncryptByPublicKey(is, os, fileEntity.getEncryptionPass());//Constants.PUBLIC_KEY
				}else{
					fileControl.setEncryption(fileEntity.isEncryption());//是否加密
					File detailFile = new File(Constants.fileStorePath + url);
					os = new BufferedOutputStream(FileUtils.openOutputStream(detailFile));
					is = new BufferedInputStream(fileEntity.getUploadedFile().getInputstream());
					IOUtils.copy(is, os);
					//fileControl.setEncryptionType("DES");//加密类型
					//CipherInputStream cipherInputStream = CipherUtil.DESFileEncrypt(is, CipherUtil.generateDESKey("SANLI_ZJBY"));
					//IOUtils.copy(cipherInputStream, os);
				}
				fileControl.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
				fileControl.setDescription(fileEntity.getDescription()); //用于记录车主上传文件类型
				fileControlDao.saveEntity(fileControl);
			} catch (FileNotFoundException e) {
				LOG.error("文件不存在");
				e.printStackTrace();
				throw new FileControlLogicException("文件不存在");
			} catch (IOException e) {
				LOG.error("操作文件出错");
				e.printStackTrace();
				throw new FileControlLogicException("操作文件出错");
			}finally{
				IOUtils.closeQuietly(is);
				IOUtils.closeQuietly(os);
			}
		}
		return fileControl;
	}
	
	/**
	 * 当前实体类对应的文件复制到另一个实体类
	 * @param entity 实体类
	 * @param other 另一个实体类
	 */
	public void copyEntityToOther(BaseEntity entity, BaseEntity other) throws FileControlLogicException{
		List<FileControl> fileControlList = getFileControlList(entity);
		FileControl otherFileControl = null;
		InputStream is = null;
		BufferedOutputStream os = null;
		try {
			for(FileControl entityFileControl : fileControlList){
				otherFileControl = new FileControl();
				StringBuilder sb = new StringBuilder(64);
				sb.append(FileConstants.FILE_UPLOAD).append(File.separatorChar);
				sb.append(other.getClass().getSimpleName());
				if(StringUtil.isNotBlank(entityFileControl.getFolder()))
					sb.append(File.separatorChar).append(entityFileControl.getFolder());
				String url = sb.toString();
				File file = new File(Constants.fileStorePath + url);
				if(!file.exists() && !file.isDirectory())file.mkdirs();
				otherFileControl.setEntity(other);
				otherFileControl.setSizeLimit(entityFileControl.getSizeLimit());
				otherFileControl.setOriginalName(entityFileControl.getOriginalName());//原文件名
				StringBuilder currentName = new StringBuilder(64);//当前文件名
				currentName.append(other.getClass().getName()).append(Constants.UNDERLINE).append(other.getId());
				currentName.append(Constants.UNDERLINE).append(UUID.randomUUID());
				otherFileControl.setSuffix(entityFileControl.getSuffix());//后缀名
				currentName.append(Constants.DOT).append(entityFileControl.getSuffix());//
				String tempName = currentName.toString();
				otherFileControl.setCurrentName(tempName);
				url += File.separatorChar + tempName;
				otherFileControl.setUrl(url);
				otherFileControl.setType(entityFileControl.getType());
				otherFileControl.setEncryption(entityFileControl.isEncryption());//是否加密
				otherFileControl.setEncryptionType(entityFileControl.getEncryptionType());//加密类型
				otherFileControl.setEncryptionPass(entityFileControl.getEncryptionPass());//加密密码
				File detailFile = new File(Constants.fileStorePath + url);
				os = new BufferedOutputStream(FileUtils.openOutputStream(detailFile));
				is = new BufferedInputStream(FileUtils.openInputStream(new File(entityFileControl.getAbsoluteUrl())));
				IOUtils.copy(is, os);
				otherFileControl.setDescription(entityFileControl.getDescription()); //用于记录车主上传文件类型
				fileControlDao.saveEntity(otherFileControl);
			}
		} catch (FileNotFoundException e) {
			LOG.error("文件不存在");
			e.printStackTrace();
			throw new FileControlLogicException("文件不存在");
		} catch (IOException e) {
			LOG.error("操作文件出错");
			e.printStackTrace();
			throw new FileControlLogicException("操作文件出错");
		}finally{
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
	}
	
	/**
	 * @param entity 上传文件对应哪个持久化类
	 * @param deleteFile 是否删除原文件
	 * @param uploadedFile 上传文件
	 * @return 文件控件
	 * @throws FileControlLogicException 
	 */
	public FileControl updateEntity(BaseEntity entity, FileEntity fileEntity) throws FileControlLogicException{
		List<FileControl> fileControlList = null;
		if(fileEntity.isDeleteFile()) fileControlList= getFileControlList(entity);//查询老文件
		FileControl fileControl = saveEntity(entity,fileEntity);//保存新文件
		if(fileEntity.isDeleteFile()&&!fileControlList.isEmpty()){
			for(FileControl fileControl1 : fileControlList)deleteEntity(fileControl1);//删除老文件
		}
		return fileControl;
	}
	
	/**
	 * 删除文件
	 * @param fileControl
	 */
	public void deleteEntity(FileControl fileControl){
		fileControlDao.deleteEntity(fileControl);
		File file = new File(fileControl.getAbsoluteUrl());
		try {
			FileUtils.forceDelete(file);//删除文件
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 实体类对应单个文件
	 * @param entityList
	 * @return
	 */
	public Map<Integer, FileControl> getFileControlOneList(List<? extends BaseEntity> entityList) {
		Map<Integer, FileControl> fileControlMap = new HashMap<Integer, FileControl>();
		if (entityList == null || entityList.isEmpty())
			return fileControlMap;
		DiscriminatorValue discriminatorValue = entityList.get(0).getClass().getAnnotation(DiscriminatorValue.class);
		Set<Integer> entityIds = new HashSet<Integer>(entityList.size());
		for (BaseEntity baseEntity : entityList)
			entityIds.add(baseEntity.getId());
//		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(FileControl.class);
//		detachedCriteria.add(Restrictions.in(FileControl.ENTITY_ID, entityIds));
//		detachedCriteria.add(Restrictions.sqlRestriction(FileControl.CASUE_GROUP_SQL, discriminatorValue.value(), StringType.INSTANCE));
//		List<FileControl> fileControlList = fileControlDao.getByDetachedCriteria(detachedCriteria);
//		for (BaseEntity baseEntity : entityList) {
//			fc: for (FileControl fileControl : fileControlList) {
//				if (fileControl.getEntity().equals(baseEntity)) {
//					fileControlMap.put(baseEntity.getId(), fileControl);
//					break fc;
//				}
//			}
//		}
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(FileControl.class);
		detachedCriteria.add(Restrictions.eq(FileControl.ENTITY_TYPE, discriminatorValue.value()));
		detachedCriteria.add(Restrictions.in(FileControl.ENTITY_ID, entityIds));
		List<FileControl> fileControlList = fileControlDao.getByDetachedCriteria(detachedCriteria);
		for (BaseEntity baseEntity : entityList) {
			FileControl fileControls = null;
			for (FileControl fileControl : fileControlList) {
				if (fileControl.getEntity().equals(baseEntity)) {
					fileControls = fileControl;
					if (fileControl.isDefaultState()) {
						break;
					}
				}
			}
			fileControlMap.put(baseEntity.getId(), fileControls);
		}
		return fileControlMap;
	}

	/**
	 * 实体类对应多个个文件
	 * @param entityList
	 * @return
	 */
	public Map<Integer, List<FileControl>> getFileControlManyList(List<? extends BaseEntity> entityList) {
		Map<Integer, List<FileControl>> fileControlsMap = new HashMap<Integer, List<FileControl>>();
		if(entityList==null||entityList.isEmpty())return fileControlsMap;
		DiscriminatorValue discriminatorValue = entityList.get(0).getClass().getAnnotation(DiscriminatorValue.class);
		Set<Integer> entityIds = new HashSet<Integer>(entityList.size());
		for(BaseEntity baseEntity : entityList)entityIds.add(baseEntity.getId());
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(FileControl.class);
		detachedCriteria.add(Restrictions.eq(FileControl.ENTITY_TYPE, discriminatorValue.value()));
		detachedCriteria.add(Restrictions.in(FileControl.ENTITY_ID, entityIds));
		List<FileControl> fileControlList = fileControlDao.getByDetachedCriteria(detachedCriteria);
		List<FileControl> fileControls = null;
		for(BaseEntity baseEntity : entityList){
			fileControls = new ArrayList<FileControl>();
			for(FileControl fileControl : fileControlList){
				if(fileControl.getEntity().equals(baseEntity)){
					fileControls.add(fileControl);
				}
			}
			fileControlsMap.put(baseEntity.getId(), fileControls);
		}
		return fileControlsMap;
	}
	
	public FileControl saveEntity(BaseEntity entity, String type, UploadedFile uploadedFile) {
		if (uploadedFile != null) {
			EntityClass entityClass = entityClassDao.saveOrGetByCls(entity.getClass().getName(),true);
			StringBuilder sb = new StringBuilder(64);
			sb.append(FileConstants.FILE_UPLOAD).append(File.separatorChar);
			sb.append(entity.getClass().getSimpleName());
			if(StringUtil.isNotBlank(type))
				sb.append(File.separatorChar).append(type);
			InputStream is = null;
			BufferedOutputStream os = null;
			try {
				String url = sb.toString();
				File file = new File(Constants.fileStorePath + url);
				if(!file.exists() && !file.isDirectory())file.mkdirs();
				FileControl fileControl = new FileControl();
				fileControl.setEntityclass(entityClass);
				fileControl.setObjectId(entity.getId());
				String fileName = uploadedFile.getFileName();//原文件名
				fileControl.setOriginalName(fileName);
				StringBuilder currentName = new StringBuilder(64);//当前文件名
				currentName.append(entityClass.getCls()).append(Constants.UNDERLINE).append(entity.getId());
				currentName.append(Constants.UNDERLINE).append(UUID.randomUUID());
				fileControl.setSuffix(fileName.substring(fileName.lastIndexOf(Constants.DOT)+1).toLowerCase());//后缀名
				currentName.append(".").append(fileControl.getSuffix());//
				String tempName = currentName.toString();
				fileControl.setCurrentName(tempName);
				url += File.separatorChar + tempName;
				fileControl.setUrl(url);
				fileControl.setType(type);
				File detailFile = new File(Constants.fileStorePath + url);
				os = new BufferedOutputStream(new FileOutputStream(detailFile));
//				if(entity instanceof Product&&CheckUtil.isImage(fileName)){//商品图片自动压缩
//					//Thumbnails.of(uploadedFile.getInputstream()) .size(150, 150).toOutputStream(os);
//					BufferedImage bufferedImage = ImageIO.read(uploadedFile.getInputstream());
//					int width = bufferedImage.getWidth()>150?150:bufferedImage.getWidth();
//					int height = bufferedImage.getHeight()>150?150:bufferedImage.getHeight();
//					//不按照比例，指定大小进行缩放
//					Thumbnails.of(uploadedFile.getInputstream()).size(width, height).keepAspectRatio(true).toOutputStream(os);
//				}else{
					is = new BufferedInputStream(uploadedFile.getInputstream());
					IOUtils.copy(is, os);
//				}
				fileControlDao.saveEntity(fileControl);
				return fileControl;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				IOUtils.closeQuietly(is);
				IOUtils.closeQuietly(os);
			}
		}
		return null;
	}
	
	/**
	 * 根据字节保存文件
	 * @param entity
	 * @param bfile
	 * @param filePath
	 * @param fileName
	 * @param description
	 * @return
	 */
	public FileControl updateFileByWeb(BaseEntity entity,byte[] bfile, String filePath,String fileName, String description){		
		StringBuilder sb = new StringBuilder(64);
		sb.append(FileConstants.FILE_UPLOAD).append(File.separatorChar);
		sb.append(entity.getClass().getSimpleName());
		String url = sb.toString();
		File file = new File(Constants.fileStorePath + url);
		if(!file.exists() && !file.isDirectory())file.mkdirs();
		
		StringBuilder currentName = new StringBuilder(64);//当前文件名
		currentName.append(entity.getClass().getName()).append(Constants.UNDERLINE).append(entity.getId());
		currentName.append(Constants.UNDERLINE).append(UUID.randomUUID());
		currentName.append(Constants.DOT).append("jpg");
		
		FileControl fileControl = new FileControl();
		fileControl.setCreateDate(DateUtil.getNowyyyymm());
		fileControl.setDescription(description);
		fileControl.setCurrentName(currentName.toString());
		fileControl.setType("1");
		fileControl.setEntityType(entity.toString());
		fileControl.setEntityId(entity.getId());
		fileControl.setUrl(url+File.separatorChar+currentName.toString());
		fileControl.setSizeLimit((long) bfile.length);
		fileControl.setCreater(entity.getCreater());
		fileControl.setBelongingUser(entity.getBelongingUser());
		fileControl.setOriginalName(currentName.toString());
		System.out.println(url+File.separatorChar+currentName.toString());
		url=Constants.fileStorePath+url+File.separatorChar+currentName.toString();
		BufferedOutputStream bos = null;  
	       FileOutputStream fos = null;  
	       File fileweb = null;  
	       try { 
	           fileweb = new File(url);  
	           fos = new FileOutputStream(fileweb);  
	           bos = new BufferedOutputStream(fos);  
	           bos.write(bfile);  
	       } catch (Exception e) {  
	           e.printStackTrace();  
	       } finally {
	           if (bos != null) {  
	               try {  
	                   bos.close();
	               } catch (IOException e1) {  
	                   e1.printStackTrace();  
	               }  
	           }  
	           if (fos != null) {  
	               try {  
	                   fos.close();  
	               } catch (IOException e1) {  
	                   e1.printStackTrace();  
	               }  
	           }  

	       }
		fileControlDao.saveEntity(fileControl);
		return fileControl;
	}

}

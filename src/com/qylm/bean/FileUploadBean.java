package com.qylm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.util.AgentUtils;

import com.qylm.bean.returner.Returner;
import com.qylm.common.Message;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.dto.FileUploadDto;
import com.qylm.entity.BaseEntity;
import com.qylm.entity.FileControl;
import com.qylm.entity.FileEntity;
import com.qylm.exception.FileControlLogicException;
import com.qylm.service.FileControlService;

/**
 * 
 * 文件上传
 * @author ZhuHong
 *
 */
@ManagedBean
@RequestScoped
public class FileUploadBean implements Serializable {
	
	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(FileUploadBean.class);

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2466881119894952873L;

	/**
	 * 用于保存文件登录画面注入的值
	 */
	private FileUploadDto fileUploadDto = new FileUploadDto();
	
	/**
	 * IE浏览器上传文件
	 */
	private UploadedFile uploadedFile;
	
	/**
	 * 判断是否是IE浏览器
	 */
	private Boolean hasIE;
	
	/**
	 * 登陆用户信息
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 文件控制业务类
	 */
	@ManagedProperty(value = "#{fileControlService}")
	private FileControlService fileControlService;
	
	/**
	 * 此方法绑定于用户登录画面的返回按钮
	 * @return 从哪里来返回哪里
	 */
	public String back() {
		//BaseEntity transferEntity = fileUploadDto.getTransferEntity();
		return fileUploadDto.getReturner().returnOnly();
		//return fileUploadDto.getReturner().returnEntity(transferEntity);
	}
	
	/**
	 * IE浏览器文件上传
	 * @param event
	 */
	public void handleFileUpload() {
		Tool.sendLog(LOG, userBean, "按下【文件上传菜单IE浏览器_上传】按钮");
		FileControl fileControl = null;
		try {
			FileEntity dest = new FileEntity();
			BeanUtils.copyProperties(dest, fileUploadDto.getFileEntity());
			dest.setUploadedFile(uploadedFile);
			fileControl = fileControlService.saveEntity(fileUploadDto.getTransferEntity(),dest);
		} catch (FileControlLogicException e) {
			Tool.sendErrorMessage(e.getMessage());
		} catch(Exception e){
			e.fillInStackTrace();
		}
		if(fileControl!=null)fileUploadDto.getFileControlList().add(fileControl);
	}
	
	/**
	 * 非IE浏览器文件上传
	 * 文件上传
	 * @param event
	 */
	public void handleFileUpload(FileUploadEvent event) {
		Tool.sendLog(LOG, userBean, "按下【文件上传菜单非IE浏览器_上传】按钮");
		UploadedFile uploadedFile = event.getFile();
		FileControl fileControl = null;
		try {
			FileEntity dest = new FileEntity();
			BeanUtils.copyProperties(dest, fileUploadDto.getFileEntity());
			dest.setUploadedFile(uploadedFile);
			fileControl = fileControlService.saveEntity(fileUploadDto.getTransferEntity(),dest);
		} catch (FileControlLogicException e) {
			Tool.sendErrorMessage(e.getMessage());
		} catch(Exception e){
			e.fillInStackTrace();
		}
		if (fileControl != null) {
			List<FileControl> fileControlList = fileUploadDto.getFileControlList();
			fileControlList.add(fileControl);
		}
	}
	
	/**
	 * 文件删除
	 * @param event
	 */
	public void deleteFileControl(FileControl fileControl) {
		Tool.sendLog(LOG, userBean, "按下【文件上传菜单文件_删除】按钮");
		fileControlService.deleteEntity(fileControl);
		fileUploadDto.getFileControlList().remove(fileControl);
	}
	
	/**
	 * 设置为默认
	 * @param event
	 */
	public void defaultFielControl(FileControl fileControl) {
		Tool.sendLog(LOG, userBean, "按下【文件上传菜单文件_默认显示】按钮");
		List<FileControl> fileControlList = fileUploadDto.getFileControlList();
		for (FileControl control : fileControlList) {
			control.setDefaultState(false);
		}
		fileControl.setDefaultState(true);
		fileControlService.updateEntityAll(fileControlList);
	}
	
	/**
	 * @param returner
	 * @param fileEntity
	 * @param fileControlList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String infoFileUpload(Returner<?, ?, ?> returner, FileEntity fileEntity, List<FileControl> fileControlList) {
		fileUploadDto.setReturner((Returner<?, ?, BaseEntity>)returner);
		fileUploadDto.setFileEntity(fileEntity);
		fileUploadDto.setPattern(fileEntity.getPattern());
		fileUploadDto.setTransferEntity(fileEntity.getBaseEntity());
		fileUploadDto.setFileControlList(fileControlList==null?new ArrayList<FileControl>():fileControlList);
		return Navigation.FILE_UPLOAD;
	}
	
	/**
	 * @param returner
	 * @param entity
	 * @param folder
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String infoFileUpload(Returner<?, ?, ?> returner, FileEntity fileEntity) {
		fileUploadDto.setReturner((Returner<?, ?, BaseEntity>)returner);
		fileUploadDto.setFileEntity(fileEntity);
		fileUploadDto.setPattern(fileEntity.getPattern());
		fileUploadDto.setTransferEntity(fileEntity.getBaseEntity());
		List<FileControl> fileControlList = fileControlService.getFileControlList(fileEntity.getBaseEntity());
		fileUploadDto.setFileControlList(fileControlList);
		return Navigation.FILE_UPLOAD;
	}
	
	/**
	 * 根据单个实体类对象，返回一张图片
	 * @param baseEntity
	 * @return
	 */
	public FileControl getOneImage(BaseEntity baseEntity) {
		return fileControlService.getFileControlOne(baseEntity);
	}
	
	/**
	 * 根据单个实体类对象，返回多张图片
	 * @param baseEntity
	 * @return
	 */
	public List<FileControl> getManyImage(BaseEntity baseEntity) {
		List<FileControl> fileControlList = fileControlService.getFileControlList(baseEntity);
		return fileControlList;
	}
	
	/**
	 * @param context
	 * @param component
	 * @param obj
	 * @throws ValidatorException
	 */
	public void validateFile(FacesContext context, UIComponent component, Object obj) throws ValidatorException{
		if(obj==null||fileUploadDto.getPattern()==null)return;
		String value = "";//获取要校验的字段值
		if(obj instanceof UploadedFile){
			UploadedFile uploadedFile = (UploadedFile)obj;
			value = uploadedFile.getFileName();
		}else{
			value = (String) obj;   //获取要校验的字段值
		}
        //boolean ptv = fileUploadDto.getPattern().matcher(value).matches();
        if (fileUploadDto.getPattern().matcher(value).matches()) return;
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, Message.GENERAL_FIND_RIGHT_FILE, Message.GENERAL_FIND_RIGHT_FILE);
		throw new ValidatorException(fm);      
    }

	/**
	 * @return the hasIE
	 */
	public boolean isHasIE() {
		if(hasIE==null)
			hasIE = AgentUtils.isIE(FacesContext.getCurrentInstance());
		return hasIE;
	}

	/**
	 * set fileControlService
	 * @param fileControlService the fileControlService to set
	 */
	public void setFileControlService(FileControlService fileControlService) {
		this.fileControlService = fileControlService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get fileUploadDto
	 * @return the fileUploadDto
	 */
	public FileUploadDto getFileUploadDto() {
		return fileUploadDto;
	}

	/**
	 * get uploadedFile
	 * @return the uploadedFile
	 */
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	/**
	 * set fileUploadDto
	 * @param fileUploadDto the fileUploadDto to set
	 */
	public void setFileUploadDto(FileUploadDto fileUploadDto) {
		this.fileUploadDto = fileUploadDto;
	}

	/**
	 * set uploadedFile
	 * @param uploadedFile the uploadedFile to set
	 */
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	/**
	 * set hasIE
	 * @param hasIE the hasIE to set
	 */
	public void setHasIE(Boolean hasIE) {
		this.hasIE = hasIE;
	}
	
}

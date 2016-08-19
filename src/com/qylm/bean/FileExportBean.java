package com.qylm.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.primefaces.model.UploadedFile;

import com.qylm.bean.returner.Returner;
import com.qylm.common.Message;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.expand.FileExportExtService;
import com.qylm.common.utils.CheckUtil;
import com.qylm.dto.FileExportDto;
import com.qylm.dto.export.BaseExportDto;
import com.qylm.dto.export.ExportDataDto;
import com.qylm.entity.BaseEntity;
import com.qylm.entity.FileEntity;
import com.qylm.entity.FileExport;
import com.qylm.exception.FileExportLogicException;
import com.qylm.service.FileExportService;

/**
 * 文件上传
 * @author smj
 */
@ManagedBean
@RequestScoped
public class FileExportBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6910054552395830742L;

	/**
	 * 用于保存文件登录画面注入的值
	 */
	private FileExportDto fileExportDto = new FileExportDto();
	
	/**
	 * IE浏览器上传文件
	 */
	private UploadedFile uploadedFile;
	
	/**
	 * 存放错误信息
	 */
	private List<String> errorList;
	
	/**
	 * 文件控制业务类
	 */
	@ManagedProperty(value = "#{fileExportService}")
	private FileExportService fileExportService;
	
	/**
	 * 此方法绑定于用户登录画面的返回按钮
	 * @return 从哪里来返回哪里
	 */
	public String back() {
		return fileExportDto.getReturner().returnOnly();
	}
	
	/**
	 * IE浏览器文件上传
	 * @param event
	 */
	@SuppressWarnings("unchecked")
	public void handleFileExport() {
		FileExportExtService<BaseExportDto> fileExportExtService = fileExportDto.getFileExportExtService();
		ExportDataDto<BaseExportDto> exportDataDto = fileExportExtService.validatorExcel(uploadedFile);//验证Excel数据
		if (!exportDataDto.getErrorList().isEmpty()) {
			errorList = exportDataDto.getErrorList();
			return;
		}
		exportDataDto = fileExportExtService.validatorExportDto(exportDataDto);//验证Dto数据
		if (!exportDataDto.getErrorList().isEmpty()) {
			errorList = exportDataDto.getErrorList();
			return;
		}
		FileExport fileExport = null;
		try {
			fileExport = fileExportService.saveEntity(fileExportExtService, exportDataDto.getExportDtoList(), fileExportDto.getEntityType(),new FileEntity(uploadedFile, fileExportDto.getFolder()));
		} catch (FileExportLogicException e) {
			Tool.sendErrorMessage("文件上传错误！");
		}
		if(fileExport!=null)fileExportDto.getFileExportList().add(fileExport);
		Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
	}
	
	/**
	 * 文件删除
	 * @param event
	 */
	public void deleteFileExport(FileExport fileExport) {
		fileExportService.deleteEntity(fileExport);
		fileExportDto.getFileExportList().remove(fileExport);
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 调用此方法需要实现接口FileExportExtService，并为实体类建立名称，例如Material类
	 * @param returner
	 * @param entityType
	 * @param folder
	 * @param fileExportExtService
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String infoFileUpload(Returner<?, ?, ?> returner, String entityType, String folder, FileExportExtService<?> fileExportExtService) {
		fileExportDto.setReturner((Returner<?, ?, BaseEntity>)returner);
		fileExportDto.setFolder(folder);
		fileExportDto.setEntityType(entityType);
		fileExportDto.setFileExportExtService(fileExportExtService);
		List<FileExport> fileExportList = fileExportService.getFileExportList(entityType);
		fileExportDto.setFileExportList(fileExportList);
		return Navigation.FILE_EXPORT;
	}
	
	/**
	 * @param context
	 * @param component
	 * @param obj
	 * @throws ValidatorException
	 */
	public void validateFile(FacesContext context, UIComponent component, Object obj) throws ValidatorException{
		if(obj==null)return;
		String value = "";//获取要校验的字段值
		if(obj instanceof UploadedFile){
			UploadedFile uploadedFile = (UploadedFile)obj;
			value = uploadedFile.getFileName();
		}else{
			value = (String) obj;   //获取要校验的字段值
		}
        if (CheckUtil.isXls(value)) return;
		String mfMsg = "上传文件格式不正确";
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, mfMsg, mfMsg);
		throw new ValidatorException(fm);      
    }
	
	/**
	 * @return the fileExportDto
	 */
	public FileExportDto getFileExportDto() {
		return fileExportDto;
	}

	/**
	 * @param fileExportDto the fileExportDto to set
	 */
	public void setFileExportDto(FileExportDto fileExportDto) {
		this.fileExportDto = fileExportDto;
	}

	/**
	 * @param fileExportService the fileExportService to set
	 */
	public void setFileExportService(FileExportService fileExportService) {
		this.fileExportService = fileExportService;
	}

	/**
	 * @return the uploadedFile
	 */
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	/**
	 * @param uploadedFile the uploadedFile to set
	 */
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	/**
	 * @return the errorList
	 */
	public List<String> getErrorList() {
		return errorList;
	}

	/**
	 * @param errorList the errorList to set
	 */
	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

}

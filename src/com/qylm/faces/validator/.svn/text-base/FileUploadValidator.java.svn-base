package com.qylm.faces.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.model.UploadedFile;

@FacesValidator(value="fileUploadValidator")
public class FileUploadValidator implements Validator {

	private static final String FILE_TYPE = "^.*\\.(?i)(gif|jpe?g|png)$";

	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		Pattern patron = Pattern.compile(FILE_TYPE);
		UploadedFile uploadedFile = (UploadedFile) value;
		Matcher encaja = patron.matcher(uploadedFile.getFileName());
		if (!(encaja.matches())) {
			FacesMessage message = new FacesMessage();
			message.setDetail("上传文件格式不正确！");
			message.setSummary("上传文件格式不正确！");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}else if(uploadedFile.getSize()>1024000){
			FacesMessage message = new FacesMessage();
			message.setDetail("上传文件不能大于10M！");
			message.setSummary("上传文件不能大于10M！");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}

}

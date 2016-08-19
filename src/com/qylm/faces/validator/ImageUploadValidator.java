package com.qylm.faces.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.qylm.common.utils.CheckUtil;
import com.qylm.common.utils.StringUtil;

@FacesValidator(value="imageUploadValidator")
public class ImageUploadValidator implements Validator {

	/*@Override
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
	}*/
	
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		if ((value==null)||(StringUtil.isBlank(value.toString())) || (!CheckUtil.isImage(value.toString()))) return;
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "上传文件格式不正确", "上传文件格式不正确");
			throw new ValidatorException(fm);

	}

}

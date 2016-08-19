package com.qylm.faces.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.qylm.common.utils.CheckUtil;

@FacesValidator("alphabetOrNumberValidator")
public class AlphabetOrNumberValidator implements Validator {
	
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		if ((value == null) || (CheckUtil.isAlphabetOrNumber(value.toString()))) return;
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "必须为字符或数字", "必须为字符或数字");
			throw new ValidatorException(fm);
	}
}

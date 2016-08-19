package com.qylm.faces.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.qylm.common.utils.CheckUtil;
import com.qylm.common.utils.StringUtil;

@FacesValidator(value="idCardValidator")
public class IdCardValidator implements Validator {

	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		if ((value==null)||(StringUtil.isBlank(value.toString())) || (CheckUtil.isIdCard(value.toString()))) return;
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "身份证号不正确", "身份证号不正确");
			throw new ValidatorException(fm);

	}

}

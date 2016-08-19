package com.qylm.faces.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.qylm.common.utils.StringUtil;

@FacesValidator(value="unSelectValidator")
public class UnSelectValidator implements Validator {
	
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		Object obj = component.getAttributes().get("requiredCheck");
		if(obj == null || !"false".equals(obj.toString())){
			if (StringUtil.isUnSelected((String.valueOf(value)))) {
				FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "未选择", "未选择");
				throw new ValidatorException(fm);
			}
		}
	}

}

package com.qylm.bean.select.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.qylm.entity.BaseEntity;
import com.qylm.service.GiveInfoService;
import com.qylm.spring.application.ApplicationContextHelper;

/**
 * @author smj
 */
@FacesConverter("giveInfoConverter")
public class GiveInfoConverter implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				GiveInfoService service = ApplicationContextHelper.getBean("giveInfoService");
				return service.getById(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "选择错误", "没有此信息！"));
			}
		} else {
			return null;
		}
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((BaseEntity) object).getId());
		} else {
			return null;
		}
	}

}

package com.qylm.common;

import java.io.IOException;

import javax.crypto.BadPaddingException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExceptionHandler {
	
	private static final Log LOG = LogFactory.getLog(ExceptionHandler.class);

	public void handleException(FacesContext facesContext, Exception ex) {
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		Throwable cause = ex.getCause();
		try {
			if (cause instanceof BadPaddingException) {
				response.sendRedirect(request.getContextPath() + "/exceptionHandler.xhtml");
				facesContext.responseComplete();
			} else {
				if (LOG.isErrorEnabled()) {
					LOG.error(Message.GENERAL_ERROR, ex);
				}
			}
		} catch (IOException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Message.GENERAL_ERROR, ex);
			}
		}
	}
	
	public void handleThrowable(FacesContext facesContext, Throwable ex) {
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		Throwable cause = ex.getCause();
		try {
			if (LOG.isErrorEnabled()) {
				LOG.error(Message.GENERAL_ERROR, ex);
			}
			if (cause instanceof BadPaddingException) {
				response.sendRedirect(request.getContextPath() + "/exceptionHandler.xhtml");
				facesContext.responseComplete();
			}
		} catch (IOException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Message.GENERAL_ERROR, ex);
			}
		}
	}
}

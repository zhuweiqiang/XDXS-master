package com.qylm.common;

import javax.el.ELException;
import javax.el.MethodExpression;
import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.component.ActionSource2;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;

import org.hibernate.StaleObjectStateException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;

import com.sun.faces.application.ActionListenerImpl;

public class BaseActionListenerImpl extends ActionListenerImpl {

	public void processAction(ActionEvent actionEvent) throws AbortProcessingException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Application application = facesContext.getApplication();

		ActionSource2 actionSource = (ActionSource2) actionEvent.getComponent();
		MethodExpression methodExpression = actionSource.getActionExpression();

		String fromAction = null;
		String outcome = null;
		if (methodExpression != null) {
			fromAction = methodExpression.getExpressionString();
			try {
				Object objOutcome = methodExpression.invoke(facesContext.getELContext(), null);

				if (objOutcome != null) {
					outcome = objOutcome.toString();
				}
			} catch (ELException e) {
				Throwable cause = e.getCause();
				if (cause != null) {
					if (cause instanceof AbortProcessingException) {
						throw (AbortProcessingException) cause;
					}
					cause = cause.getCause();
					if (cause instanceof HibernateOptimisticLockingFailureException) {
						FacesMessage fm = new FacesMessage(
								FacesMessage.SEVERITY_INFO,
								Message.GENERAL_HIBERNATE_OPTIMISTIC_LOCK,
								Message.GENERAL_HIBERNATE_OPTIMISTIC_LOCK);
						FacesContext.getCurrentInstance().addMessage(null, fm);
					} else if (cause instanceof StaleObjectStateException) {
						FacesMessage fm = new FacesMessage(
								FacesMessage.SEVERITY_INFO,
								Message.GENERAL_HIBERNATE_OPTIMISTIC_LOCK,
								Message.GENERAL_HIBERNATE_OPTIMISTIC_LOCK);
						FacesContext.getCurrentInstance().addMessage(null, fm);
					} else if (cause instanceof DataIntegrityViolationException) {
						FacesMessage fm = new FacesMessage(
								FacesMessage.SEVERITY_INFO,
								Message.GENERAL_HIBERNATE_OPTIMISTIC_LOCK,
								Message.GENERAL_HIBERNATE_OPTIMISTIC_LOCK);
						FacesContext.getCurrentInstance().addMessage(null, fm);
					} else {
						throw new FacesException(
								"Error calling action method of component with id "
										+ actionEvent.getComponent()
												.getClientId(facesContext), e);
					}
				} else {
					throw new FacesException("Error calling action method of component with id "
							+ actionEvent.getComponent().getClientId(facesContext), e);
				}

			} catch (RuntimeException e) {
				throw new FacesException("Error calling action method of component with id "
						+ actionEvent.getComponent().getClientId(facesContext), e);
			}
		}

		NavigationHandler navigationHandler = application.getNavigationHandler();
		navigationHandler.handleNavigation(facesContext, fromAction, outcome);
		// Render Response if needed
		facesContext.renderResponse();

	}
}

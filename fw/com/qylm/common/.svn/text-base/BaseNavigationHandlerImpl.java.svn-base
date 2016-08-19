package com.qylm.common;

import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

public class BaseNavigationHandlerImpl extends NavigationHandler {

	public void handleNavigation(FacesContext facesContext, String fromAction, String outcome) {
		if (outcome == null) {
			// stay on current ViewRoot
			return;
		}

		ViewHandler viewHandler = facesContext.getApplication().getViewHandler();
		// create new view
		String newViewId = outcome;
		UIViewRoot viewRoot = viewHandler.createView(facesContext, newViewId);
		facesContext.setViewRoot(viewRoot);
		facesContext.renderResponse();
	}

}
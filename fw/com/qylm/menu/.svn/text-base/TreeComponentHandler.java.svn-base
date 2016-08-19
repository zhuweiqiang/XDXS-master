package com.qylm.menu;

import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.ComponentConfig;
import javax.faces.view.facelets.ComponentHandler;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagAttribute;

import com.qylm.entity.User;

public class TreeComponentHandler extends ComponentHandler {
	
	private TagAttribute user;
	
    private TagAttribute styleClass;
    
    private TagAttribute type;
    
	public TreeComponentHandler(ComponentConfig config) {
		super(config);
		user = getRequiredAttribute("user");
		styleClass = getAttribute("styleClass");
		type = getAttribute("type");
	}

	public void setAttributes(FaceletContext ctx, Object instance) {
		super.setAttributes(ctx, instance);
		FacesContext context = ctx.getFacesContext();
		ELContext eLContext = context.getELContext();
		TreeComponent treeComponent = (TreeComponent) instance;
		User curUser = (User) user.getValueExpression(ctx, User.class).getValue(eLContext);
		treeComponent.setUser(curUser);
		treeComponent.setStyleClass(styleClass.getValue());
		treeComponent.setType(type.getValue());
	}

}

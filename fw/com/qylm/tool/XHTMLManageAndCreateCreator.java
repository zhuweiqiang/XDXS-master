package com.qylm.tool;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.URL;

import com.qylm.common.utils.ReflectionUtil;
import com.qylm.common.utils.StringUtil;

public class XHTMLManageAndCreateCreator {
	
	public static String root = "";//D:\\xinwork\\LXXF\\WebRoot

	public static void createManageBean(String xhtmlUrl, Class<?> backBean ,Class<?> entity, Class<?> manageDto, String title) throws IOException {
		URL url = Thread.currentThread().getContextClassLoader().getResource("");
		String src = url.toString();
		// 路径地址
		root = src.substring(6, src.indexOf("WEB-INF"));
		String backBeanAliasName = StringUtil.uncapitalize(backBean.getSimpleName());
		// 管理dto别名
		String manageDtoAliasName  = StringUtil.uncapitalize(manageDto.getSimpleName());
		//管理路径
		String manageXhtmlUrl = root+xhtmlUrl;
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(manageXhtmlUrl)));
		pw.println("<html jsfc=\"f:view\" xmlns=\"http://www.w3.org/1999/xhtml\"");
		pw.println("\txmlns:jsp=\"http://java.sun.com/JSP/Page\"");
		pw.println("\txmlns:ui=\"http://java.sun.com/jsf/facelets\"");
		pw.println("\txmlns:h=\"http://java.sun.com/jsf/html\"");
		pw.println("\txmlns:f=\"http://java.sun.com/jsf/core\"");
		pw.println("\txmlns:t=\"http://myfaces.apache.org/tomahawk\"");
		pw.println("\txmlns:c=\"http://java.sun.com/jstl/core\"");
		pw.println("xmlns:rw=\"http://www.qylm.com\">");
		pw.println("\txmlns:util=\"http://java.sun.com/jsf/composite/component/util\"");
		pw.println("\ttemplate=\"/WEB-INF/templates/back/baseTemplate.xhtml\">");
		pw.println("\t<ui:param name=\"title\" value=\""+ title +"管理\" />");
		pw.println("\t<ui:define name=\"tableCenter\">");
		pw.println("\t\t<sl:saveState value=\"#{"+backBeanAliasName+"."+manageDtoAliasName+"}\"/>");
		pw.println("\t\t<sl:saveState value=\"#{"+backBeanAliasName+".dataModel}\"/>");
		pw.println("\t\t<sl:saveState value=\"#{"+backBeanAliasName+".firstResult}\"/>");
		
		//buttonNorth
		pw.println("\t\t<div class=\"buttonNorth\">");
		pw.println("\t\t\t<p:commandButton value=\"添加\" action=\"#{"+backBeanAliasName+".newCreate}\" rendered=\"#{p:ifAnyGranted('ROLE_ADMIN')}\" ajax=\"false\" styleClass=\"createBtn\" accesskey=\"c\"/>");
		pw.println("\t\t\t<p:commandButton value=\"批量删除\" actionListener=\"#{"+backBeanAliasName+".deleteMul}\" rendered=\"#{p:ifAnyGranted('ROLE_ADMIN')}\" update=\"viewTable messages\" onstart=\"return confirmation(cfg)\" styleClass=\"multipleDelBtn\" accesskey=\"d\"/>");
		pw.println("\t\t</div>");
		
		//searchRequirementNorth
		pw.println("\t\t<ui:fragment rendered=\"#{p:ifAnyGranted('ROLE_ADMIN')}\">");
		pw.println("\t\t<div class=\"searchRequirementNorth\">");
		Field[] Fields = ReflectionUtil.getAllFields(manageDto);
		for(Field field : Fields){if("serialVersionUID".equalsIgnoreCase(field.getName()))continue;pw.println("\t\t\t<p:focus for=\""+field.getName()+"\" />");break;}
		pw.println("\t\t\t<h:panelGrid id=\"manageGrid\" columns=\""+((Fields.length-1)*2+1)+"\">");
		for(Field field : Fields){
			if("serialVersionUID".equalsIgnoreCase(field.getName()))continue;
			String typeName = field.getGenericType().toString();
			if(typeName.contains("Date")){
				pw.println("\t\t\t\t<h:outputLabel for=\""+field.getName()+"\" value=\""+field.getName()+"\" />");
				pw.println("\t\t\t\t<p:calendar id=\""+field.getName()+"\" size=\"20\" maxlength=\"16\"");
				pw.println("\t\t\t\t\tvalue=\"#{"+backBeanAliasName+"."+manageDtoAliasName+"."+field.getName()+"}\"");
				pw.println("\t\t\t\t\tpattern=\"yyyy-MM-dd HH:mm\"/>");
			}else{
				pw.println("\t\t\t\t<h:outputLabel for=\""+field.getName()+"\" value=\""+field.getName()+"\" />");
				pw.println("\t\t\t\t<p:inputText styleClass=\"inputText\" id=\""+field.getName()+"\" size=\"20\" maxlength=\"20\"");
				pw.println("\t\t\t\t\tvalue=\"#{"+backBeanAliasName+"."+manageDtoAliasName+"."+field.getName()+"}\" />");
			}
		}
		pw.println("\t\t\t\t<!--<p:outputLabel for=\"genericCode\" value=\"下拉框\" />");
		pw.println("\t\t\t\t<h:selectOneMenu id=\"genericCode\" value=\"#{"+backBeanAliasName+"."+manageDtoAliasName+".genericCode}\">");
		pw.println("\t\t\t\t\t<f:selectItems value=\"#{genericCodeBean.c0201}\" />");
		pw.println("\t\t\t\t</h:selectOneMenu>-->");
		pw.println("\t\t\t\t<p:commandButton id=\"searchBtn\" value=\"搜索\" action=\"#{"+backBeanAliasName+".select}\" process=\":form:manageGrid\" ");
		pw.println("\t\t\t\t\tupdate=\":form:viewTable messages\" styleClass=\"searchBtn\" accesskey=\"s\" />");
		pw.println("\t\t\t</h:panelGrid>");
		pw.println("\t\t</div>");
		
		pw.println("\t\t</ui:fragment>");
		
		pw.println("\t\t<div class=\"tableCenter\">");
		pw.println("\t\t\t<p:dataTable emptyMessage=\"暂无数据\" var=\"model\" value=\"#{"+backBeanAliasName+".dataModel}\" rowIndexVar=\"rowIndex\"");
		pw.println("\t\t\t\tpaginator=\"true\" widgetVar=\"viewTable\" rowKey=\"#{model.id}\" paginatorAlwaysVisible=\"true\"");
		pw.println("\t\t\t\trows=\"20\" paginatorTemplate=\"#{PEConstants.PAGINATOR_TEMPLATE}\" sortBy=\"createDate\" sortOrder=\"descending\"");
		pw.println("\t\t\t\trowsPerPageTemplate=\"#{PEConstants.PAGE_TEMPLATE}\" first=\"#{"+backBeanAliasName+".firstResult}\" id=\"viewTable\"");
		pw.println("\t\t\t\tselection=\"#{"+backBeanAliasName+".selectedModels}\" lazy=\"true\" paginatorPosition=\"#{PEConstants.PAGINATOR_POSITION}\">");
		pw.println("\t\t\t\t<f:facet name=\"header\" >");
		pw.println("\t\t\t\t\t"+title+"列表");
		pw.println("\t\t\t\t</f:facet>");	
		pw.println("\t\t\t\t<!--<pe:javascript event=\"rowDblselect\" execute=\"viewDialog(source, event, params, ext, 'form:viewDialog')\"/>-->");
		pw.println("\t\t\t\t<p:column selectionMode=\"multiple\" exportable=\"false\" style=\"width:32px\" />");
		pw.println("\t\t\t\t<!--<h:outputText value=\"#{sl:label(genericCodeBean.c0202,model.genericCode)}\" />-->");
		Field[] Field1s = ReflectionUtil.getAllFields(entity);
		for(Field field : Field1s){
			if("serialVersionUID".equalsIgnoreCase(field.getName())
					||"id".equalsIgnoreCase(field.getName())
					||"version".equalsIgnoreCase(field.getName())
					||"updateDate".equalsIgnoreCase(field.getName())
					||StringUtil.isAllUpperCase(field.getName().replace("_", "")))continue;
			String typeName = field.getGenericType().toString();
			if(typeName.contains("Date")){
				pw.println("\t\t\t\t<p:column headerText=\""+field.getName()+"\" sortBy=\"#{model."+field.getName()+"}\" style=\"width: 140px;\">");
				pw.println("\t\t\t\t\t<h:outputText value=\"#{model."+field.getName()+"}\" >");
				pw.println("\t\t\t\t\t\t<f:convertDateTime pattern=\"yyyy-MM-dd HH:mm\"/>");
				pw.println("\t\t\t\t\t</h:outputText>");
				pw.println("\t\t\t\t</p:column>");
			}else{
				pw.println("\t\t\t\t<p:column headerText=\""+field.getName()+"\" sortBy=\"#{model."+field.getName()+"}\" >");
				pw.println("\t\t\t\t\t<h:outputText value=\"#{model."+field.getName()+"}\" />");
				pw.println("\t\t\t\t</p:column>");
			}
		}
		pw.println("\t\t\t\t<p:column headerText=\"基本操作\" exportable=\"false\" style=\"width: 100px;\">");
		pw.println("\t\t\t\t\t<p:commandButton value=\"修改\" action=\"#{"+backBeanAliasName+".updateDetail(model)}\"");
		pw.println("\t\t\t\t\t\trendered=\"#{p:ifAnyGranted('ROLE_ADMIN')}\"");
		pw.println("\t\t\t\t\t\tajax=\"false\" styleClass=\"modifyBtn\"/>");
		pw.println("\t\t\t\t\t<p:commandButton value=\"视图\" action=\"#{"+backBeanAliasName+".viewDetail(model)}\"");
		pw.println("\t\t\t\t\t\trendered=\"#{p:ifAnyGranted('ROLE_ADMIN')}\"");
		pw.println("\t\t\t\t\t\tajax=\"false\" styleClass=\"viewBtn\"/>");
		pw.println("\t\t\t\t\t<p:commandButton value=\"删除\" action=\"#{"+backBeanAliasName+".deleteSin(model)}\"");
		pw.println("\t\t\t\t\t\trendered=\"#{p:ifAnyGranted('ROLE_ADMIN')}\"");
		pw.println("\t\t\t\t\t\tpartialSubmit=\"true\" process=\"@this\"  update=\"viewTable\"");
		pw.println("\t\t\t\t\t\tonstart=\"return confirmation(cfg)\" styleClass=\"singleDelBtn\"/>");
		pw.println("\t\t\t\t</p:column>");
		
		pw.println("\t\t\t</p:dataTable>");
		pw.println("\t\t</div>");
		pw.println("\t\t<!--<util:viewDialog id=\"viewDialog\" modelId=\"#{"+backBeanAliasName+".modelId}\" actionMethod=\"#{"+backBeanAliasName+".viewDetail(null)}\"  />-->");
		
		pw.println("\t</ui:define>");
		
		pw.println("</ui:composition>");
		pw.close();
		
		System.out.println("OK！！！！！！！！！！！！！！！！！！！！");
	}
	
	public static void createCreateBean(String xhtmlUrl,Class<?> backBean , Class<?> createDto, String title, Integer col) throws IOException {
		col = col==null?2:col;
		URL url = Thread.currentThread().getContextClassLoader().getResource("");
		String src = url.toString();
		// 路径地址
		root = src.substring(6, src.indexOf("WEB-INF"));
		String backBeanAliasName = StringUtil.uncapitalize(backBean.getSimpleName());
		// 登陆dto别名
		String createDtoAliasName  = StringUtil.uncapitalize(createDto.getSimpleName());
		//登陆路径
		String createXhtmlUrl = root+xhtmlUrl;
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(createXhtmlUrl)));
		// manageXhtml
		pw.println("<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"");
		pw.println("\txmlns:h=\"http://java.sun.com/jsf/html\"");
		pw.println("\txmlns:f=\"http://java.sun.com/jsf/core\"");
		pw.println("\txmlns:p=\"http://primefaces.org/ui\"");
		pw.println("\txmlns:ui=\"http://java.sun.com/jsf/facelets\"");
		pw.println("\txmlns:pe=\"http://primefaces.org/ui/extensions\"");
		pw.println("\txmlns:sl=\"http://www.sanli.com/ui/component\"");
		pw.println("\ttemplate=\"/WEB-INF/templates/back/baseTemplate.xhtml\">");
		pw.println("\t<ui:param name=\"title\" value=\""+ title +"登录\" />");
		pw.println("\t<ui:define name=\"tableCenter\">");
		pw.println("\t\t<sl:saveState value=\"#{"+backBeanAliasName+"."+createDtoAliasName+"}\"/>");
		//buttonNorth
		pw.println("\t\t<div class=\"buttonNorth\">");
		pw.println("\t\t\t<p:commandButton value=\"返回\" action=\"#{"+backBeanAliasName+".back}\" immediate=\"true\"  ajax=\"false\" styleClass=\"backBtn\" />");
		pw.println("\t\t\t<p:commandButton value=\"添加\" action=\"#{"+backBeanAliasName+".newCreate}\" immediate=\"true\" update=\"@form\" rendered=\"#{p:ifAnyGranted('ROLE_ADMIN')}\" styleClass=\"createBtn\" />");
		pw.println("\t\t\t<p:commandButton value=\"保存\" actionListener=\"#{"+backBeanAliasName+".save}\" update=\"@form\" rendered=\"#{p:ifAnyGranted('ROLE_ADMIN')}\" styleClass=\"saveBtn\" />");
		pw.println("\t\t</div>");
		//tableCenter
		//searchRequirementNorth
		pw.println("\t\t<div class=\"tableCenter\">");
		Field[] Fields = ReflectionUtil.getAllFields(createDto);
		for(Field field : Fields){if("serialVersionUID".equalsIgnoreCase(field.getName()))continue;pw.println("\t\t\t<p:focus for=\""+field.getName()+"\" />");break;}
		pw.println("\t\t\t<p:panelGrid id=\"manageGrid\" styleClass=\"dataTable\"> ");
		int len = Fields.length;int j = 0;
		for(int i = 0; i< len;i++){
			Field field = Fields[i];
			if("serialVersionUID".equalsIgnoreCase(field.getName())
					||field.getName().indexOf("Transfer")!=-1
					||field.getName().indexOf("returner")!=-1)continue;
			if(j%col==0)pw.println("\t\t\t\t<p:row>");
			String typeName = field.getGenericType().toString();
			String column = j%col!=(col-1)?"column2":"column4";
			if(typeName.contains("Date")){
				pw.println("\t\t\t\t\t<p:column styleClass=\"column1\">");
				pw.println("\t\t\t\t\t\t<p:outputLabel for=\""+field.getName()+"\" value=\""+field.getName()+"\" />");
				pw.println("\t\t\t\t\t</p:column>");
				pw.println("\t\t\t\t\t<p:column styleClass=\""+column+"\">");
				pw.println("\t\t\t\t\t\t<p:calendar id=\""+field.getName()+"\" size=\"20\" maxlength=\"16\"");
				pw.println("\t\t\t\t\t\t\tvalue=\"#{"+backBeanAliasName+"."+createDtoAliasName+"."+field.getName()+"}\"");
				pw.println("\t\t\t\t\t\t\tpattern=\"yyyy-MM-dd HH:mm\"/>");
				pw.println("\t\t\t\t\t</p:column>");
			}else{
				pw.println("\t\t\t\t\t<p:column styleClass=\"column1\">");
				pw.println("\t\t\t\t\t\t<h:outputLabel for=\""+field.getName()+"\" value=\""+field.getName()+"\" />");
				pw.println("\t\t\t\t\t</p:column>");
				pw.println("\t\t\t\t\t<p:column styleClass=\""+column+"\">");
				pw.println("\t\t\t\t\t\t<p:inputText styleClass=\"inputText\" id=\""+field.getName()+"\" size=\"20\" maxlength=\"20\"");
				pw.println("\t\t\t\t\t\t\tvalue=\"#{"+backBeanAliasName+"."+createDtoAliasName+"."+field.getName()+"}\" />");
				pw.println("\t\t\t\t\t</p:column>");
			}
			if(j%col==(col-1))pw.println("\t\t\t\t</p:row>");
			j++;
		}
		if(j%col!=0){pw.println("\t\t\t\t</p:row>");}
		pw.println("\t\t\t\t<!--<p:outputLabel for=\"genericCode\" value=\"下拉框\" />");
		pw.println("\t\t\t\t<h:selectOneMenu id=\"genericCode\" value=\"#{"+backBeanAliasName+"."+createDtoAliasName+".genericCode}\">");
		pw.println("\t\t\t\t\t<f:selectItems value=\"#{genericCodeBean.c0201}\" />");
		pw.println("\t\t\t\t</h:selectOneMenu>-->");
		pw.println("\t\t\t</p:panelGrid>");
		pw.println("\t\t</div>");
		
		pw.println("\t</ui:define>");
		
		pw.println("</ui:composition>");
		pw.close();
		
		System.out.println("OK！！！！！！！！！！！！！！！！！！！！");
	}
	
	public static void createViewBean(String xhtmlUrl, Class<?> backBean , Class<?> viewDto, String title, Integer col) throws IOException {
		col = col==null?2:col;
		URL url = Thread.currentThread().getContextClassLoader().getResource("");
		String src = url.toString();
		// 路径地址
		root = src.substring(6, src.indexOf("WEB-INF"));
		String backBeanAliasName = StringUtil.uncapitalize(backBean.getSimpleName());
		// 视图dto别名
		String viewDtoAliasName  = StringUtil.uncapitalize(viewDto.getSimpleName());
		//视图路径
		String viewXhtmlUrl = root+xhtmlUrl;
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(viewXhtmlUrl)));
		// manageXhtml
		pw.println("<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"");
		pw.println("\txmlns:h=\"http://java.sun.com/jsf/html\"");
		pw.println("\txmlns:f=\"http://java.sun.com/jsf/core\"");
		pw.println("\txmlns:p=\"http://primefaces.org/ui\"");
		pw.println("\txmlns:ui=\"http://java.sun.com/jsf/facelets\"");
		pw.println("\txmlns:pe=\"http://primefaces.org/ui/extensions\"");
		pw.println("\txmlns:sl=\"http://www.sanli.com/ui/component\"");
		pw.println("\ttemplate=\"/WEB-INF/templates/back/baseTemplate.xhtml\">");
		pw.println("\t<ui:param name=\"title\" value=\""+ title +"视图\" />");
		pw.println("\t<ui:define name=\"tableCenter\">");
		pw.println("\t\t<sl:saveState value=\"#{"+backBeanAliasName+"."+viewDtoAliasName+"}\"/>");
		//buttonNorth
		pw.println("\t\t<div class=\"buttonNorth\">");
		pw.println("\t\t\t<p:commandButton value=\"返回\" action=\"#{"+backBeanAliasName+".back}\" rendered=\"#{"+backBeanAliasName+"."+viewDtoAliasName+".viewType eq '1'}\" immediate=\"true\"  ajax=\"false\" styleClass=\"backBtn\" />");
		pw.println("\t\t\t<p:commandButton value=\"修改\" action=\"#{"+backBeanAliasName+".updateDetail}\" immediate=\"true\" ajax=\"false\" rendered=\"#{p:ifAnyGranted('ROLE_ADMIN')}\" styleClass=\"modifyBtn\" />");
		pw.println("\t\t</div>");
		//tableCenter
		//searchRequirementNorth
		pw.println("\t\t<div class=\"tableCenter\">");
		Field[] Fields = ReflectionUtil.getAllFields(viewDto);
		pw.println("\t\t\t<p:panelGrid id=\"manageGrid\" styleClass=\"dataTable\"> ");
		int len = Fields.length;int j = 0;
		for(int i = 0; i< len;i++){
			Field field = Fields[i];
			if("serialVersionUID".equalsIgnoreCase(field.getName())
					||field.getName().indexOf("Transfer")!=-1
					||field.getName().indexOf("returner")!=-1)continue;
			if(j%col==0)pw.println("\t\t\t\t<p:row>");
			String typeName = field.getGenericType().toString();
			String column = j%col!=(col-1)?"column2":"column4";
			if(typeName.contains("Date")){
				pw.println("\t\t\t\t\t<p:column styleClass=\"column1\">");
				pw.println("\t\t\t\t\t\t"+field.getName());
				pw.println("\t\t\t\t\t</p:column>");
				pw.println("\t\t\t\t\t<p:column styleClass=\""+column+"\">");
				pw.println("\t\t\t\t\t\t<h:outputText value=\"#{"+backBeanAliasName+"."+viewDtoAliasName+"."+field.getName()+"}\" >");
				pw.println("\t\t\t\t\t\t\t<f:convertDateTime pattern=\"yyyy-MM-dd HH:mm\"/>");
				pw.println("\t\t\t\t\t\t</h:outputText>");
				pw.println("\t\t\t\t\t</p:column>");
			}else{
				pw.println("\t\t\t\t\t<p:column styleClass=\"column1\">");
				pw.println("\t\t\t\t\t\t"+field.getName());
				pw.println("\t\t\t\t\t</p:column>");
				pw.println("\t\t\t\t\t<p:column styleClass=\""+column+"\">");
				pw.println("\t\t\t\t\t\t#{"+backBeanAliasName+"."+viewDtoAliasName+"."+field.getName()+"}");
				pw.println("\t\t\t\t\t</p:column>");
			}
			if(j%col==(col-1))pw.println("\t\t\t\t</p:row>");
			j++;
		}
		if(j%col!=0){pw.println("\t\t\t\t</p:row>");}
		pw.println("\t\t\t\t<!--#{sl:label(genericCodeBean.c0601,"+backBeanAliasName+"."+viewDtoAliasName+".genericCode)}-->");
		pw.println("\t\t\t</p:panelGrid>");
		pw.println("\t\t</div>");
		
		pw.println("\t</ui:define>");
		
		pw.println("</ui:composition>");
		pw.close();
		
		System.out.println("OK！！！！！！！！！！！！！！！！！！！！");
	}
	
}

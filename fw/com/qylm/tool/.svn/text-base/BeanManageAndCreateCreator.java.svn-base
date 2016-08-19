package com.qylm.tool;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;

import com.qylm.common.utils.ReflectionUtil;
import com.qylm.common.utils.StringUtil;

public class BeanManageAndCreateCreator {

	public static void createManageBean(String packScan,Class<?> entity, Class<?> manageDto, Class<?> manageReturner, String title) throws IOException {
		// 输入名
		String name = entity.getSimpleName();
		// 实体类名
		String entityName = StringUtil.capitalize(name);
		// 实体类别名
		String entityAliasName = StringUtil.uncapitalize(name);
		//大写
		String manageReturnerName = StringUtil.capitalize(manageReturner.getSimpleName());
		//小写
		String manageReturnerUNName = StringUtil.uncapitalize(manageReturner.getSimpleName());
		//路径
		String packUrl = "src/"+packScan.replace(".", "/")+"/";
		
		// ManageBean
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(packUrl + entityName + "ManageBean.java")));
		
		pw.println("package " + packScan + ";");
		pw.println();
		pw.println("import java.util.Arrays;");
		pw.println("import java.util.List;");
		pw.println();
		pw.println("import javax.faces.bean.ManagedBean;");
		pw.println("import javax.faces.bean.ManagedProperty;");
		pw.println("import javax.faces.bean.RequestScoped;");
		pw.println("import javax.faces.event.ActionEvent;");
		pw.println();
		pw.println("import org.apache.commons.logging.Log;");
		pw.println("import org.apache.commons.logging.LogFactory;");
		pw.println("import org.hibernate.criterion.DetachedCriteria;");
		pw.println("import org.hibernate.criterion.MatchMode;");
		pw.println("import org.hibernate.criterion.Restrictions;");
		pw.println("import org.hibernate.sql.JoinType;");
		pw.println();
		//com.qylm.bean.back.returner.personnelMatters.PersonnelManageReturner;
		//pw.println(returnerPackScan + entityName +"ManageReturner;");
		pw.println("import import com.qylm.bean.UserBean;");
		pw.println("import com.qylm.bean.BasePagingBean;");
		pw.println("import com.qylm.common.Message;");
		pw.println("import com.qylm.common.Tool;");
		pw.println("import com.qylm.common.utils.StringUtil;");
		pw.println("import" + manageReturner.getName());
		pw.println("import com.qylm.common.Navigation;");
		pw.println("import " + entity.getName() +";");
		pw.println("import " + manageDto.getName() +";");
		pw.println("import com.qylm.service." + entityName +"Service;");
		pw.println();
		pw.println("/**");
		pw.println(" * "+title+"管理");
		pw.println(" * @author qylm");
		pw.println(" */");
		pw.println("@ManagedBean");
		pw.println("@RequestScoped");
		pw.println("public class " + entityName + "ManageBean extends BasePagingBean {");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * 存放"+title+"管理画面需要保存的值");
		pw.println("\t */");
		pw.println("\tprivate " + StringUtil.capitalize(manageDto.getSimpleName())  +" "+ StringUtil.uncapitalize(manageDto.getSimpleName()) + " = new " + StringUtil.capitalize(manageDto.getSimpleName()) + "();");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * 删除复选框选择的值");
		pw.println("\t */");
		pw.println("\tprivate " + entityName + "[] selectedModels;");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * "+title+"业务类");
		pw.println("\t */");
		pw.println("\t@ManagedProperty(value = \"#{" + entityAliasName + "Service}\")");
		pw.println("\tprivate " + entityName + "Service "+entityAliasName+"Service;");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * 此方法绑定与菜单列表的"+title+"管理菜单列表");
		pw.println("\t * "+title+"管理画面");
		pw.println("\t */");
		pw.println("\tpublic String select() {");
		pw.println("\t\tsuper.setFirstResult(0);");
		pw.println("\t\tdataModel = new LazyCustomDataModel();");
		pw.println("\t\treturn NavigationConstants."+ toUpcase(entityAliasName)+"_MANAGE;");
		pw.println("\t}");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * 绑定于"+title+"管理画面的添加按钮");
		pw.println("\t * "+title+"登录画面");
		pw.println("\t */");
		pw.println("\tpublic String newCreate() {");
		pw.println("\t\t"+manageReturnerName+" "+ manageReturnerUNName+" = new "+manageReturnerName+"("+ StringUtil.uncapitalize(manageDto.getSimpleName()) + ",firstResult);");
		pw.println("\t\treturn FacesUtil.getBackBean("+ entityName+"CreateBean.class).newCreate("+manageReturnerUNName+");");
		pw.println("\t}");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * 绑定于"+title+"管理页面的修改按钮");
		pw.println("\t * "+title+"登录画面");
		pw.println("\t */");
		pw.println("\tpublic String updateDetail("+entityName +" transfer"+entityName+") {");
		//pw.println("\t\tsuper.setFirstResult(0);");
		pw.println("\t\t"+manageReturnerName+" "+ manageReturnerUNName+" = new "+manageReturnerName+"("+ StringUtil.uncapitalize(manageDto.getSimpleName()) + ",firstResult);");
		pw.println("\t\treturn FacesUtil.getBackBean("+ entityName+"CreateBean.class).updateDetail("+manageReturnerUNName+",transfer"+entityName+");");
		pw.println("\t}");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * 绑定于"+title+"管理页面的视图按钮");
		pw.println("\t * "+title+"视图画面");
		pw.println("\t */");
		pw.println("\tpublic String viewDetail("+entityName +" transfer"+entityName+") {");
		//pw.println("\t\tsuper.setFirstResult(0);");if(transferExpressSender==null)transferExpressSender = super.getModel();
		pw.println("\t\tString viewType = transfer"+entityName+"==null?BaseViewDto.VIEW_TYPE_2:BaseViewDto.VIEW_TYPE_1;");
		pw.println("\t\tif(transfer"+entityName+"==null)transfer"+ entityName+" = super.getModel();");
		pw.println("\t\t"+manageReturnerName+" "+ manageReturnerUNName+" = new "+manageReturnerName+"("+ StringUtil.uncapitalize(manageDto.getSimpleName()) + ",firstResult);");
		pw.println("\t\treturn FacesUtil.getBackBean("+ entityName+"ViewBean.class).viewDetail("+manageReturnerUNName+",transfer"+entityName+",viewType);");
		pw.println("\t}");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * 绑定于"+title+"管理画面的全选删除按钮");
		pw.println("\t * @param event");
		pw.println("\t */");
		pw.println("\tpublic void deleteMul(ActionEvent event) {");
		pw.println("\t\t"+entityAliasName +"Service.deleteEntityAll(Arrays.asList(selectedModels));");
		pw.println("\t\tMessageUtil.addInfoMessage(Message.GENERAL_DELETESUCCESS);");
		pw.println("\t}");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * 绑定于"+title+"管理画面的单个删除按钮");
		pw.println("\t * @param event");
		pw.println("\t */");
		pw.println("\tpublic void deleteSin("+entityName +" transfer"+entityName+") {");
		pw.println("\t\t"+entityAliasName +"Service.deleteEntity(transfer"+entityName+");");
		pw.println("\t\tMessageUtil.addInfoMessage(Message.GENERAL_DELETESUCCESS);");
		pw.println("\t}");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * 返回到本页面调用此方法");
		pw.println("\t * @return");
		pw.println("\t */");
		pw.println("\tpublic String currentBack() {");
		pw.println("\t\tdataModel = new LazyCustomDataModel();");
		pw.println("\t\treturn NavigationConstants."+ toUpcase(entityAliasName)+"_MANAGE;");
		pw.println("\t}");
		pw.println();
		pw.println("\t@Override");
		pw.println("\tprotected List<"+entityName+"> fetchData(int first, int pageSize, String sortField, SortOrder sortOrder,");
		pw.println("\t\t Map<String, Object> filters, LazyDataModel<"+entityName+"> dataModel) {");
		pw.println("\t\tDetachedCriteria detachedCriteria = DetachedCriteria.forClass("+entityName+".class);");
		pw.println("\t\t//detachedCriteria.createAlias("+entityName+", "+entityName+", JoinType.LEFT_OUTER_JOIN);");
		Field[] Fields = ReflectionUtil.getAllFields(manageDto);
		for(Field field : Fields){
			if("serialVersionUID".equalsIgnoreCase(field.getName()))continue;
			pw.println("\t\tif(StringUtil.isNotBlank(" +StringUtil.uncapitalize(manageDto.getSimpleName()) + ".get"+StringUtil.capitalize(field.getName())+"())){");
			pw.println("\t\t\tdetachedCriteria.add(Restrictions.like("+entityName+"."+toUpcase(field.getName())+", StringUtil.trim(" +StringUtil.uncapitalize(manageDto.getSimpleName()) + ".get"+StringUtil.capitalize(field.getName())+"()), MatchMode.ANYWHERE));");
			pw.println("\t\t}");
		}
		pw.println("\t\tif(StringUtil.isNotBlank(sortField)){");
		pw.println("\t\t\tdetachedCriteria.addOrder(sortOrder.compareTo(SortOrder.ASCENDING)==0?Order.asc(sortField):Order.desc(sortField));");
		pw.println("\t\t}");
		pw.println("\t\tPageModel<"+entityName+"> model = "+entityAliasName+"Service.getByModelDetachedCriteria(detachedCriteria,first,pageSize);");
		pw.println("\t\tdataModel.setRowCount(model.getTotalResults());");
		pw.println("\t\treturn model.getList();");
		pw.println("\t}");
		
		pw.println();
		pw.println("}");
		pw.close();
		
		System.out.println("OK！！！！！！！！！！！！！！！！！！！！");
		
	}
	
	public static void createCreateBean(String packScan,Class<?> entity, Class<?> createDto, String title) throws IOException {
		// 输入名
		String name = entity.getSimpleName();
		// 实体类名
		String entityName = StringUtil.capitalize(name);
		// 实体类别名
		String entityAliasName = StringUtil.uncapitalize(name);
		//路径
		String packUrl = "src/"+packScan.replace(".", "/")+"/";
		
		
		// CreateDto
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(packUrl + entityName + "CreateBean.java")));
		pw.println("package " + packScan + ";");
		pw.println();
		pw.println("import java.io.Serializable;");
		pw.println();
		pw.println("import javax.faces.bean.ManagedBean;");
		pw.println("import javax.faces.bean.ManagedProperty;");
		pw.println("import javax.faces.bean.RequestScoped;");
		pw.println("import javax.faces.event.ActionEvent;");
		pw.println();
		pw.println("import com.qylm.bean.back.returner.Returner;");
		pw.println("import com.qylm.common.CreateBean;");
		pw.println("import com.qylm.common.Message;");
		pw.println("import com.qylm.common.utils.FacesUtil;");
		pw.println("import com.qylm.common.utils.MessageUtil;");
		pw.println("import com.qylm.constants.NavigationConstants;");
		pw.println("import " + createDto.getName() +";");
		pw.println("import com.qylm.dxo." + entityName +"CreateDxo;");
		pw.println("import " + entity.getName() +";");
		pw.println("import com.qylm.service." + entityName +"Service;");
		pw.println();
		pw.println("/**");
		pw.println(" * "+title+"登录");
		pw.println(" * @author qylm");
		pw.println(" */");
		pw.println("@ManagedBean");
		pw.println("@RequestScoped");
		//public class DimissionCreateDto implements Serializable
		pw.println("public class "+entityName+"CreateBean implements CreateBean<"+entityName+">,Serializable {");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * 存放"+title+"登录画面需要保存的值");
		pw.println("\t */");
		pw.println("\tprivate " + StringUtil.capitalize(createDto.getSimpleName()) + " " + StringUtil.uncapitalize(createDto.getSimpleName()) + " = new " + StringUtil.capitalize(createDto.getSimpleName()) + "();");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * "+title+"业务类");
		pw.println("\t */");
		pw.println("\t@ManagedProperty(value = \"#{" + entityAliasName + "Service}\")");
		pw.println("\tprivate " + entityName + "Service "+entityAliasName+"Service;");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * 此方法绑定于"+title+"登录画面的添加按钮");
		pw.println("\t * @return 清空当前画面信息，页面不跳转");
		pw.println("\t */");
		pw.println("\tpublic String newCreate() {");
		pw.println();
		pw.println("\t\treturn NavigationConstants."+ toUpcase(entityAliasName)+"_CREATE;");
		pw.println("\t}");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * 此方法绑定于"+title+"登录画面的保存按钮");
		pw.println("\t * 用于保存或者是修改当前"+title+"信息");
		pw.println("\t * @return 画面不跳转");
		pw.println("\t */");
		pw.println("\tpublic void save(ActionEvent event) {");
		pw.println("\t\t"+ entityName+" "+entityAliasName+" = "+StringUtil.uncapitalize(createDto.getSimpleName())+".getTransfer"+entityName+"();");
		pw.println("\t\tif ("+entityAliasName+" == null) {");
		pw.println("\t\t\t"+entityAliasName+" = new "+entityName+"();");
		pw.println("\t\t\t"+entityName+"CreateDxo.dtoToEntity("+StringUtil.uncapitalize(createDto.getSimpleName())+","+entityAliasName+");");
		pw.println("\t\t\t"+entityAliasName+"Service.saveEntity("+entityAliasName+");");
		pw.println("\t\t\t"+StringUtil.uncapitalize(createDto.getSimpleName())+".setTransfer"+entityName+"("+entityAliasName+");");
		pw.println("\t\t\tMessageUtil.addInfoMessage(Message.GENERAL_SAVESUCCESS);");
		pw.println("\t\t} else {");
		pw.println("\t\t\t"+entityName+"CreateDxo.dtoToEntity("+StringUtil.uncapitalize(createDto.getSimpleName())+","+entityAliasName+");");
		pw.println("\t\t\t"+entityAliasName+"Service.updateEntity("+entityAliasName+");");
		pw.println("\t\t\tMessageUtil.addInfoMessage(Message.GENERAL_UPDATESUCCESS);");
		pw.println("\t\t}");
		pw.println("\t}");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * 此方法绑定于"+title+"登录画面的返回按钮");
		pw.println("\t * @return 从哪里来返回哪里");
		pw.println("\t */");
		pw.println("\tpublic String back() {");
		pw.println("\t\treturn "+StringUtil.uncapitalize(createDto.getSimpleName())+".getReturner().returnOnly();");
		pw.println("\t}");
		pw.println();
		pw.println("\t@Override");
		pw.println("\tpublic String newCreate(Returner<?, ?, ?> returner) {");
		pw.println("\t\t"+StringUtil.uncapitalize(createDto.getSimpleName())+".setReturner(returner);");
		pw.println("\t\treturn newCreate();");
		pw.println("\t}");
		pw.println();
		pw.println("\t@Override");
		pw.println("\tpublic String updateDetail(Returner<?, ?, ?> returner, "+entityName+" entity) {");
		pw.println("\t\t"+StringUtil.uncapitalize(createDto.getSimpleName())+".setReturner(returner);");
		pw.println("\t\t"+StringUtil.uncapitalize(createDto.getSimpleName())+".setTransfer"+entityName+"(entity);");
		pw.println("\t\t"+entityName+"CreateDxo.entityToDto(entity,"+StringUtil.uncapitalize(createDto.getSimpleName())+");");
		pw.println("\t\treturn NavigationConstants."+ toUpcase(entityAliasName)+"_CREATE;");
		pw.println("\t}");
		pw.println();
		
		pw.println("}");
		pw.close();
		
		System.out.println("OK！！！！！！！！！！！！！！！！！！！！");
		
	}
	
	public static void createViewBean(String packScan,Class<?> entity, Class<?> viewDto, Class<?> viewReturner, String title) throws IOException {
		// 输入名
		String name = entity.getSimpleName();
		// 实体类名
		String entityName = StringUtil.capitalize(name);
		// 实体类别名
		String entityAliasName = StringUtil.uncapitalize(name);
		//大写
		String viewReturnerName = StringUtil.capitalize(viewReturner.getSimpleName());
		//小写
		String viewReturnerUNName = StringUtil.uncapitalize(viewReturner.getSimpleName());
		//路径
		String packUrl = "src/"+packScan.replace(".", "/")+"/";
		
		
		// CreateDto
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(packUrl + entityName + "ViewBean.java")));
		pw.println("package " + packScan + ";");
		pw.println();
		pw.println("import java.io.Serializable;");
		pw.println();
		pw.println("import javax.faces.bean.ManagedBean;");
		pw.println("import javax.faces.bean.ManagedProperty;");
		pw.println("import javax.faces.bean.RequestScoped;");
		pw.println("import javax.faces.event.ActionEvent;");
		pw.println();
		pw.println("import com.qylm.bean.back.returner.Returner;");
		pw.println("import com.qylm.common.ViewBean;");
		pw.println("import com.qylm.common.utils.FacesUtil;");
		pw.println("import com.qylm.constants.NavigationConstants;");
		pw.println("import " + viewDto.getName() +";");
		pw.println("import com.qylm.dxo." + entityName +"ViewDxo;");
		pw.println("import " + entity.getName() +";");
		pw.println("import com.qylm.service." + entityName +"Service;");
		pw.println();
		pw.println("/**");
		pw.println(" * "+title+"视图");
		pw.println(" * @author qylm");
		pw.println(" */");
		pw.println("@ManagedBean");
		pw.println("@RequestScoped");
		//public class DimissionCreateDto implements Serializable
		pw.println("public class "+entityName+"ViewBean implements ViewBean<"+entityName+">,Serializable {");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * 存放"+title+"视图画面需要保存的值");
		pw.println("\t */");
		pw.println("\tprivate " + StringUtil.capitalize(viewDto.getSimpleName()) + " " + StringUtil.uncapitalize(viewDto.getSimpleName()) + " = new " + StringUtil.capitalize(viewDto.getSimpleName()) + "();");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * "+title+"业务类");
		pw.println("\t */");
		pw.println("\t@ManagedProperty(value = \"#{" + entityAliasName + "Service}\")");
		pw.println("\tprivate " + entityName + "Service "+entityAliasName+"Service;");
		pw.println();
		pw.println("\t@Override");
		pw.println("\tpublic String viewDetail(Returner<?, ?, ?> returner, "+entityName+" entity, String viewType) {");
		pw.println("\t\t"+StringUtil.uncapitalize(viewDto.getSimpleName())+".setReturner(returner);");
		pw.println("\t\t"+StringUtil.uncapitalize(viewDto.getSimpleName())+".setViewType(viewType);");
		pw.println("\t\t"+StringUtil.uncapitalize(viewDto.getSimpleName())+".setTransfer"+entityName+"(entity);");
		pw.println("\t\t"+entityName+"ViewDxo.entityToDto(entity,"+StringUtil.uncapitalize(viewDto.getSimpleName())+");");
		pw.println("\t\treturn NavigationConstants."+ toUpcase(entityAliasName)+"_VIEW;");
		pw.println("\t}");
		pw.println();
		pw.println("\t@Override");
		pw.println("\tpublic String updateDetail() {");
		pw.println("\t\t"+viewReturnerName+" "+ viewReturnerUNName+" = new "+viewReturnerName+"("+ StringUtil.uncapitalize(viewDto.getSimpleName()) + ");");
		pw.println("\t\treturn FacesUtil.getBackBean("+ entityName+"CreateBean.class).updateDetail("+viewReturnerUNName+","+StringUtil.uncapitalize(viewDto.getSimpleName())+".getTransfer"+entityName+"());");
		pw.println("\t}");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * 此方法绑定于"+title+"视图画面的返回按钮");
		pw.println("\t * @return 从哪里来返回哪里");
		pw.println("\t */");
		pw.println("\tpublic String back() {");
		pw.println("\t\treturn "+StringUtil.uncapitalize(viewDto.getSimpleName())+".getReturner().returnOnly();");
		pw.println("\t}");
		pw.println();
		pw.println("\t/**");
		pw.println("\t * @return 页面跳转画面");
		pw.println("\t */");
		pw.println("\tpublic String currentBack() {");
		pw.println("\t\t"+entityName+"ViewDxo.entityToDto("+StringUtil.uncapitalize(viewDto.getSimpleName())+".getTransfer"+entityName+"(),"+StringUtil.uncapitalize(viewDto.getSimpleName())+");");
		pw.println("\t\treturn NavigationConstants."+ toUpcase(entityAliasName)+"_VIEW;");
		pw.println("\t}");
		pw.println();
		pw.println("}");
		pw.close();
		
		System.out.println("OK！！！！！！！！！！！！！！！！！！！！");
		
	}
	
	private static String toUpcase(String entityName){
		StringBuilder sb = new StringBuilder(64);
		char[] chars = entityName.toCharArray();
		int size = chars.length;
		for (int i = 0; i < size; i++) {
			if(chars[i] == '.'){
				break;
			}
			if(Character.isUpperCase(chars[i])){
				sb.append("_");
			}
			sb.append(Character.toUpperCase(chars[i]));
		}
		return sb.toString();
	}
}

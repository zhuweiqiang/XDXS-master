package com.qylm.common;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import com.qylm.bean.UserBean;
import com.qylm.constants.Constants;
import com.qylm.entity.User;

/**
 * 共通工具类
 * @author 
 */
public final class Tool {

	private Tool() {
	}
	
	/**
	 * 共通信息出力
	 * @param message
	 */
	public static void sendErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
	}
	
	/**
	 * 出力格式化过的信息
	 * @param message
	 */
	public static void sendFormatedErrorMessage(String format, Object[] args) {
		MessageFormat mf = new MessageFormat(format);
		sendErrorMessage(mf.format(args));
	}
	
	/**
	 * 构造格式化过的信息
	 * @param message
	 */
	public static String createFormatedErrorMessage(String format, Object[] args) {
		MessageFormat mf = new MessageFormat(format);
		return mf.format(args);
	}
	
	/**
	 * 共通信息出力
	 * @param messages
	 */
	public static void sendErrorMessages(String... messages) {
		FacesContext context = FacesContext.getCurrentInstance();
		int length = messages.length;
		for (int i = 0; i < length; i++) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, messages[i], null));
		}
	}
	
	/**
	 * 共通日志出力
	 * @param log
	 * @param message
	 */
	public static void sendLog(Log log, String message){
		if (log.isWarnEnabled()) {
			log.warn(message);
		}
	}
	
	/**
	 * 共通日志出力
	 * @param log
	 * @param userBean
	 * @param message
	 */
	public static void sendLog(Log log, UserBean userBean, String message){
		if (log.isWarnEnabled()) {
			User user = userBean.getUser();
			FacesContext context = FacesContext.getCurrentInstance();
			StringBuilder sb = new StringBuilder(32);
			if (context != null) {
				ExternalContext externalContext = context.getExternalContext();
				if (externalContext != null) {
					HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
					sb.append("IP:(");
					sb.append(request.getRemoteAddr());
					sb.append(')');
				}
			}
			sb.append("用户:");
			sb.append(user.getUserName());
			sb.append(message);
			log.warn(sb.toString());
		}
	}
	
	public static String titleTime(){
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.TITLE_TIME); 
		return sdf.format(new Date());
	}
	
	public static String getFileRealName(UploadedFile uploadedFile){
		String tmpName = uploadedFile.getName();
		int index = -1;
		index = tmpName.lastIndexOf("\\");
		if (index >= 0) {
			return tmpName.substring(index + 1);
		} 
		return tmpName;
	}
	
	/**
	 * 用EL表达式取得对应的值（Bean一类的）
	 * @param <T>
	 * @param expression 表达式
	 * @param expectedType 用表达式可以取得的对象的class
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getByEl(String expression, Class<T> expectedType) {
		FacesContext context = FacesContext.getCurrentInstance();
		return (T) context.getApplication().evaluateExpressionGet(context, expression, expectedType);
	}
	
	/**
	 * 取得BackBean的注册名例如UserManageBean->userManageBean
	 * 第一个字母变成小写
	 * @param <T>
	 * @param backBeanClass BackBean的Class
	 * @return
	 */
	public static <T> String getBackBeanName(Class<T> backBeanClass) {
		String className = backBeanClass.getSimpleName();
		return new StringBuilder(32).append("#{").append(Character.toLowerCase(className.charAt(0)))
				.append(className.substring(1)).append("}").toString();
	}
	
	/**
	 * 把对应属性的头一个字母变成大写
	 * @param name 属性
	 * @return
	 */
	public static <T> String firstUpperCase(String name) {
		return new StringBuilder(32).append(Character.toUpperCase(name.charAt(0)))
				.append(name.substring(1)).toString();
	}
	
	/**
	 * 把对应属性的头一个字母变成小写
	 * @param name 属性
	 * @return
	 */
	public static <T> String firstLowerCase(String name) {
		return new StringBuilder(32).append(Character.toLowerCase(name.charAt(0)))
				.append(name.substring(1)).toString();
	}
	
	/**
	 * 取得一个类及其父类的所有属性
	 * @param clazz 类
	 * @return
	 */
	public static Field[] getAllFields(Class<?> clazz){
		Field[] fields = clazz.getDeclaredFields();
		clazz = clazz.getSuperclass();
		while(clazz != null){
			fields = (Field[]) ArrayUtils.addAll(fields, clazz.getDeclaredFields());
			clazz = clazz.getSuperclass();
		}
		return fields;
	}
	
	/**
	 * 用EL表达式取得BackBean
	 * @param <T>
	 * @param backBeanClass BackBean的Class
	 * @return
	 */
	public static <T> T getBackBean(Class<T> backBeanClass) {
		return getByEl(getBackBeanName(backBeanClass), backBeanClass);
	}
	
	/**
	 * 删除BackBean
	 * @param <T>
	 * @param backBeanClass
	 */
	public static <T> void clearBackBean(Class<T> backBeanClass) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ELContext elContext = facesContext.getELContext();
		facesContext.getApplication().getExpressionFactory().createValueExpression(elContext,
				getBackBeanName(backBeanClass), backBeanClass).setValue(elContext, null);
	}
	
	/**
	 * 清空原来的backBean，然后新建一个backBean
	 * @param <T>
	 * @param backBeanClass
	 */
	public static <T> T newBackBean(Class<T> backBeanClass) {
		clearBackBean(backBeanClass);
		return getBackBean(backBeanClass);
	}
	
	/**
	 * 用EL表达式取得CreateBean
	 * @param <T>
	 * @param backBeanClass BackBean的Class
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T, Entity> CreateBean<Entity> getCreateBean(Class<T> backBeanClass) {
		return (CreateBean<Entity>)getBackBean(backBeanClass);
	}
	
}

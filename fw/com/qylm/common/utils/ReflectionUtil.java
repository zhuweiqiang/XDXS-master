package com.qylm.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.util.Assert;



/**
 * @author ZhuHong
 *反射的Util函数集合. 
  *  
  * 提供访问私有变量,获取泛型类型Class,提取集合中元素的属性,转换字符串到对象等Util函数. 
 */
public final class ReflectionUtil extends BeanUtils{
	
	 private static Log logger = LogFactory.getLog(ReflectionUtil.class); 
	 
	 public static final String CGLIB_CLASS_SEPARATOR = "$$";
	 
	 /**
      * 调用Getter方法.
      */
     public static Object invokeGetterMethod(Object obj, String propertyName) {
             String getterMethodName = "get" + StringUtil.capitalize(propertyName);
             return invokeMethod(obj, getterMethodName, new Class[] {}, new Object[] {});
     }

     /**
      * 调用Setter方法.使用value的Class来查找Setter方法.
      */
     public static void invokeSetterMethod(Object obj, String propertyName, Object value) {
             invokeSetterMethod(obj, propertyName, value, null);
     }

     /**
      * 调用Setter方法.
      *
      * @param propertyType 用于查找Setter方法,为空时使用value的Class替代.
      */
     public static void invokeSetterMethod(Object obj, String propertyName, Object value, Class<?> propertyType) {
             Class<?> type = propertyType != null ? propertyType : value.getClass();
             String setterMethodName = "set" + StringUtil.capitalize(propertyName);
             invokeMethod(obj, setterMethodName, new Class[] { type }, new Object[] { value });
     }

	  
     /** 
      * 直接读取对象属性值, 无视private/protected修饰符, 不经过getter函数. 
      */ 
     public static Object getFieldValue(final Object object, final String fieldName) { 
             Field field = getDeclaredField(object, fieldName); 
             if (field == null) 
                     throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]"); 
             makeAccessible(field); 
             Object result = null; 
             try { 
                     result = field.get(object); 
             } catch (IllegalAccessException e) { 
//                     logger.error("不可能抛出的异常{}", e.getMessage()); 
             } 
             return result; 
     } 

     /** 
      * 直接设置对象属性值, 无视private/protected修饰符, 不经过setter函数. 
      */ 
     public static void setFieldValue(final Object object, final String fieldName, final Object value) { 
             Field field = getDeclaredField(object, fieldName); 

             if (field == null) 
                     throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]"); 

             makeAccessible(field); 

             try { 
                     field.set(object, value); 
             } catch (IllegalAccessException e) { 
       //             logger.error("不可能抛出的异常:{}", e.getMessage()); 
             } 
     } 
     
     /**
      * 对于被cglib AOP过的对象, 取得真实的Class类型.
      */
     public static Class<?> getUserClass(Class<?> clazz) {
             if (clazz != null && clazz.getName().contains(CGLIB_CLASS_SEPARATOR)) {
                     Class<?> superClass = clazz.getSuperclass();
                     if (superClass != null && !Object.class.equals(superClass)) {
                             return superClass;
                     }
             }
             return clazz;
     }

     /** 
      * 直接调用对象方法, 无视private/protected修饰符. 
      */ 
     public static Object invokeMethod(final Object object, final String methodName, final Class<?>[] parameterTypes, 
                     final Object[] parameters) { 
             Method method = getDeclaredMethod(object, methodName, parameterTypes); 
             if (method == null) 
                     throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + object + "]"); 

             method.setAccessible(true); 

             try { 
                     return method.invoke(object, parameters); 
             } catch (Exception e) { 
                     throw convertReflectionExceptionToUnchecked(e); 
             } 
     } 

     /** 
      * 循环向上转型, 获取对象的DeclaredField. 
      *  
      * 如向上转型到Object仍无法找到, 返回null. 
      */ 
     protected static Field getDeclaredField(final Object object, final String fieldName) { 
             Assert.notNull(object, "object不能为空"); 
             Assert.hasText(fieldName, "fieldName"); 
             for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass 
                             .getSuperclass()) { 
                     try { 
                             return superClass.getDeclaredField(fieldName); 
                     } catch (NoSuchFieldException e) { 
                             // Field不在当前类定义,继续向上转型 
                     } 
             } 
             return null; 
     } 

     /** 
      * 强行设置Field可访问. 
      */ 
     protected static void makeAccessible(final Field field) { 
             if (!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers())) { 
                     field.setAccessible(true); 
             } 
     } 

     /** 
      * 循环向上转型,获取对象的DeclaredMethod. 
      *  
      * 如向上转型到Object仍无法找到, 返回null. 
      */ 
     protected static Method getDeclaredMethod(Object object, String methodName, Class<?>[] parameterTypes) { 
             Assert.notNull(object, "object不能为空"); 

             for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass 
                             .getSuperclass()) { 
                     try { 
                             return superClass.getDeclaredMethod(methodName, parameterTypes); 
                     } catch (NoSuchMethodException e) { 
                             // Method不在当前类定义,继续向上转型 
                     } 
             } 
             return null; 
     } 

     /** 
      * 通过反射,获得Class定义中声明的父类的泛型参数的类型. 
      * 如无法找到, 返回Object.class. 
      * eg. 
      * public UserDao extends HibernateDao<User> 
      * 
      * @param clazz The class to introspect 
      * @return the first generic declaration, or Object.class if cannot be determined 
      */ 
     public static Class<?> getSuperClassGenricType(final Class<?> clazz) { 
             return getSuperClassGenricType(clazz, 0); 
     } 

     /** 
      * 通过反射,获得定义Class时声明的父类的泛型参数的类型. 
      * 如无法找到, 返回Object.class. 
      *  
      * 如public UserDao extends HibernateDao<User,Long> 
      * 
      * @param clazz clazz The class to introspect 
      * @param index the Index of the generic ddeclaration,start from 0. 
      * @return the index generic declaration, or Object.class if cannot be determined 
      */ 
     public static Class<?> getSuperClassGenricType(final Class<?> clazz, final int index) { 

             Type genType = clazz.getGenericSuperclass(); 

             if (!(genType instanceof ParameterizedType)) { 
                     logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType"); 
                     return Object.class; 
             } 

             Type[] params = ((ParameterizedType) genType).getActualTypeArguments(); 

             if (index >= params.length || index < 0) { 
                     logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: " 
                                     + params.length); 
                     return Object.class; 
             } 
             if (!(params[index] instanceof Class)) { 
                     logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter"); 
                     return Object.class; 
             } 

             return (Class<?>) params[index]; 
     } 

     /** 
      * 提取集合中的对象的属性(通过getter函数), 组合成List. 
      *  
      * @param collection 来源集合. 
      * @param propertyName 要提取的属性名. 
      */ 
     public static List<T> convertElementPropertyToList(final Collection<T> collection, final String propertyName) { 
             List<T> list = new ArrayList<T>(); 
             try { 
                     for (Object obj : collection) { 
                             list.add((T) PropertyUtils.getProperty(obj, propertyName)); 
                     } 
             } catch (Exception e) { 
                     throw convertReflectionExceptionToUnchecked(e); 
             } 

             return list; 
     } 

     /** 
      * 提取集合中的对象的属性(通过getter函数), 组合成由分割符分隔的字符串. 
      *  
      * @param collection 来源集合. 
      * @param propertyName 要提取的属性名. 
      * @param separator 分隔符. 
      */ 
     public static String convertElementPropertyToString(final Collection<T> collection, final String propertyName, 
                     final String separator) { 
             List<T> list = convertElementPropertyToList(collection, propertyName); 
             return StringUtil.join(list, separator); 
     } 

     /** 
      * 转换字符串类型到clazz的property类型的值. 
      *  
      * @param value 待转换的字符串 
      * @param clazz 提供类型信息的Class 
      * @param propertyName 提供类型信息的Class的属性. 
      */ 
     public static Object convertValue(Object value, Class<?> toType) { 
             try { 
                     DateConverter dc = new DateConverter(); 
                     dc.setUseLocaleFormat(true); 
                     dc.setPatterns(new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss" }); 
                     ConvertUtils.register(dc, Date.class); 
                     return ConvertUtils.convert(value, toType); 
             } catch (Exception e) { 
                     throw convertReflectionExceptionToUnchecked(e); 
             } 
     } 

     /** 
      * 将反射时的checked exception转换为unchecked exception. 
      */ 
     public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) { 
             if (e instanceof IllegalAccessException || e instanceof IllegalArgumentException 
                             || e instanceof NoSuchMethodException) 
                     return new IllegalArgumentException("Reflection Exception.", e); 
             else if (e instanceof InvocationTargetException) 
                     return new RuntimeException("Reflection Exception.", ((InvocationTargetException) e).getTargetException()); 
             else if (e instanceof RuntimeException) { 
                     return (RuntimeException) e; 
             } 
             return new RuntimeException("Unexpected Checked Exception.", e); 
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

}

package com.qylm.common.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

import com.qylm.constants.Constants;

/**
 * 
 * Properties文件工具类
 * @author ZhuHong
 *
 */
public final class PropertiesUtil {
	
	 private static final String DEFAULT_ENCODING = Constants.UTF_8;

     /**
 	 * LOG
 	 */
 	private static final Log LOG = LogFactory.getLog(PropertiesUtil.class);

     private static PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();
     
     private static ResourceLoader resourceLoader = new DefaultResourceLoader();

     /**
      * 载入多个properties文件, 相同的属性在最后载入的文件中的值将会覆盖之前的载入.
      * 文件路径使用Spring Resource格式, 文件编码使用UTF-8.
      *
      * @see org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
      */
     public static Properties loadProperties(String... resourcesPaths) throws IOException {
             Properties props = new Properties();
             for (String location : resourcesPaths) {
            	 LOG.debug("Loading properties file from:" + location);
                 InputStream is = null;
                 Reader reader = null;
                 try {
                     Resource resource = resourceLoader.getResource(location);
                     //logger.info(resource.getFile().getPath());
                     is = new FileInputStream(resource.getFile());//resource.getInputStream();
                     reader = new InputStreamReader(is, DEFAULT_ENCODING);
                     propertiesPersister.load(props, reader);
                 } catch (IOException ex) {
                	 LOG.info("Could not load properties from classpath:" + location + ": " + ex.getMessage());
                 } finally {
                         if (is != null)is.close();
                         if (reader != null)reader.close();
                 }
             }
             return props;
     }
     
     /**
      * 写入properties信息
     * @param resourcesPaths
     * @param prop
     * @throws IOException
     */
    public static void writeProperties(String resourcesPaths, Properties prop) throws IOException {
    	 OutputStream fos = null;
    	 Writer writer = null;
    	 try {
             Resource resource = resourceLoader.getResource(resourcesPaths);
             //logger.info(resource.getFile().getPath());
             fos = new FileOutputStream(resource.getFile());
             writer = new OutputStreamWriter(fos, DEFAULT_ENCODING);
             propertiesPersister.store(prop, writer, "系统配置");
	     } catch (IOException ex) {
	    	 LOG.info("Could not load properties from classpath:" + resourcesPaths + ": " + ex.getMessage());
	     } finally {
	             if (fos != null)fos.close();
	             if (writer != null)writer.close();
	     }
     }

}

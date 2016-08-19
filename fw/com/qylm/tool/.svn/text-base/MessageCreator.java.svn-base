package com.qylm.tool;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Map.Entry;
import java.util.Properties;

import com.qylm.common.utils.StringUtil;


public class MessageCreator {
	
	public static void create() throws Throwable {
		// 获取message_zh_CN.properties文件
		InputStream is;
		try {

			ClassLoader classLoader = MessageCreator.class.getClassLoader();
			URL resUrl = classLoader.getResource("com/qylm/resources/messages_zh_CN.properties");
			File file = new File(resUrl.getPath());
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			is = new BufferedInputStream(resUrl.openStream());
			Properties properties = new Properties();
			properties.load(is);
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/com/qylm/common/Message.java")));
			pw.println("package com.qylm.common;");
			pw.println();
			// 类名
			pw.println("public final class Message {");
			String key;
			while (br.ready()) {
				key = br.readLine();
				if (StringUtil.isNotBlank(key)) {
					key = key.substring(0, key.indexOf("="));
					for (Entry<Object, Object> entrySet : properties.entrySet()) {
						if (entrySet.getKey().equals(key)) {
							pw.println();
							pw.println("	/**");
							pw.println("	 * " + entrySet.getValue());
							pw.println("	 */");
							pw.println("	public static final String  " + toName(entrySet.getKey().toString()) + " = \"" + entrySet.getValue() + "\";");
						}
					}
				}
			}
			pw.println();
			pw.println("}");
			pw.close();
			properties.clear();
			properties = null;
			is.close();
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String toName(String key) {
		key = key.replaceAll("\\.", "_");
		return key.toUpperCase();
	}
	
}

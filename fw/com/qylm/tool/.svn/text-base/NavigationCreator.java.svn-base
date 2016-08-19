package com.qylm.tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

public class NavigationCreator {
	
	public static String[] excludeFile = { "menu.xhtml", "top.xhtml" };
	
	public static int excludeFileSize = excludeFile.length;
	
	public static String[] excludeDir = { "css", "images", "js", "WEB-INF", "META-INF" };
	
	public static int excludeDirSize = excludeDir.length;
	
	public static String root = "e:\\xinworkTwo\\qq\\WebRoot";
	
	public static int rootSize = root.length();
	
	public static void create() throws IOException {
		create(false);
		System.out.println("OK");
	}
	
	public static void createOld() throws IOException {
		create(true);
		System.out.println("OK");
	}
	
	@SuppressWarnings("unchecked")
	private static void create(boolean old) throws IOException {
		String[] extensions = {"xhtml"};
		File directory = new File(root);
		Collection<File> files = FileUtils.listFiles(directory, extensions, true);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/com/qylm/common/Navigation.java")));
		pw.println("package com.qylm.common;");
		pw.println();
		// 类名
		pw.println("public final class Navigation {");
		String name;
		String path;
		for (File file : files) {
			name = file.getName();
			if(excludeDir(file)){
				continue;
			}
			if(exclude(name)){
				continue;
			}
			path = file.getAbsolutePath().substring(rootSize).replace("\\", "/");
			pw.println();
			pw.println("	/**");
			pw.println("	 * 跳转到"+path);
			pw.println("	 */");
			if (old) {
				pw.println("	public static final String "+toUpcase(name)+" = \""+toJumpName(name)+"\";");
			} else {
				pw.println("	public static final String "+toUpcase(name)+" = \""+path+"\";");
			}
		}
		pw.println();
		pw.println("}");
		pw.close();
	}
	
	private static String toUpcase(String name){
		StringBuilder sb = new StringBuilder(64);
		if(name.endsWith("Page.xhtml")){
			name = name.substring(0, name.length()-10);
		}
		if(name.endsWith(".xhtml")){
			name = name.substring(0, name.length()-6);
		}
		char[] chars = name.toCharArray();
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
	
	private static String toJumpName(String name){
		if(name.endsWith("Page.xhtml")){
			return name.substring(0, name.length()-10);
		}
		if(name.endsWith(".xhtml")){
			return name.substring(0, name.length()-6);
		}
		return null;
	}
	
	private static boolean exclude(String name){
		for (int i = 0; i < excludeFileSize; i++) {
			if(excludeFile[i].equals(name)){
				return true;
			}
		}
		return false;
	}
	
	private static boolean excludeDir(File file){
		if(file.getParent().equals(root)){
			return false;
		}
		String name = file.getAbsolutePath().substring(rootSize+1);
		for (int i = 0; i < excludeDirSize; i++) {
			if(name.startsWith(excludeDir[i])){
				return true;
			}
		}
		return false;
	}

}

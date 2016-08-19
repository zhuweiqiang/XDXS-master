package tool;

import java.net.URL;

import com.qylm.tool.NavigationCreator;


public class NavigationCreatorExe {
	
	public static void main(String[] args) {
		// 设定不生成路径的文件名称
		NavigationCreator.excludeFile = new String[] { "menu.xhtml", "top.xhtml"};
		// 不生成文件名称的长度
		NavigationCreator.excludeFileSize = NavigationCreator.excludeFile.length;
		// 设定不生成路径的文件夹名称
		NavigationCreator.excludeDir = new String[] { "resources", "WEB-INF", "META-INF" };
		// 长度
		NavigationCreator.excludeDirSize = NavigationCreator.excludeDir.length;
		URL url = Thread.currentThread().getContextClassLoader().getResource("");
		String src = url.toString();
		// 路径地址
		NavigationCreator.root = src.substring(6, src.indexOf("/WEB-INF"));//"D:\\xinwork\\LXXF\\WebRoot"; 
		NavigationCreator.rootSize = NavigationCreator.root.length();
		try {
			NavigationCreator.create();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}

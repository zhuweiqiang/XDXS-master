package tool;

import com.qylm.tool.GenericCodeBeanCreator;

public class GenericCodeBeanCreatorExe {

	public static void main(String[] args) {
		try {
			GenericCodeBeanCreator.create();
			System.out.println("OK!!!!!!!!!!!!!!!!!!!!");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}

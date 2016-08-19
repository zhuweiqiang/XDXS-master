package tool;

import com.qylm.tool.MessageCreator;

public class MessageCreatorExe {

	public static void main(String[] args) {
		try {
			MessageCreator.create();
			System.out.println("OK!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}

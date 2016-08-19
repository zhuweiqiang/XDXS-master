package tool;
import java.io.IOException;

import com.qylm.dto.history.HistoryArrearageCreateDto;
import com.qylm.entity.CustomInfo;
import com.qylm.tool.DxoCreator;


public class DxoCreatorExe {

	public static void main(String[] args) {
		try {
			DxoCreator.create(HistoryArrearageCreateDto.class, CustomInfo.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

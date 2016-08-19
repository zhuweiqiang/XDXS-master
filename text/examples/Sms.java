package examples;

import java.util.ArrayList;
import java.util.List;

/***
 * 短信猫操作类 包括短信猫的打开、关闭、读取等操作
 * 
 * @author hzy
 * 
 */
public class Sms {

	private CommonSms commonsms;
	private static char symbol1 = 13;
	private static String strReturn = "", atCommand = "";

	public boolean SendSms(Port myport) {
		if (!myport.isIsused()) {
			System.out.println("COM通讯端口未正常打开!");
			return false;
		}
		setMessageMode(myport, 1);
		// 空格
		char symbol2 = 34;
		// ctrl~z 发送指令
		char symbol3 = 26;
		try {
			atCommand = "AT+CSMP=17,169,0,08" + String.valueOf(symbol1);
			strReturn = myport.sendAT(atCommand);
			System.out.println(strReturn);
			if (strReturn.indexOf("OK", 0) != -1) {
				atCommand = "AT+CMGS=" + commonsms.getRecver()
						+ String.valueOf(symbol1);
				strReturn = myport.sendAT(atCommand);
				atCommand = StringUtil.encodeHex(commonsms.getSmstext().trim())
						+ String.valueOf(symbol3) + String.valueOf(symbol1);
				strReturn = myport.sendAT(atCommand);
				// System.out.println("+++++++++++++++++++++++++++++++++++++");
				// System.out.println(atCommand+"++++++++++++++++++++"+commonsms.getSmstext().trim()+"+++++++++++++++++"+commonsms.getSmstext().trim().length());
				// System.out.println("+++++++++++++++++++++++++++++++++++++");
				if (strReturn.indexOf("OK") != -1
						&& strReturn.indexOf("+CMGS") != -1) {
					System.out.println("短信发送成功...");
					return true;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("短信发送失败...");
			return false;
		}
		System.out.println("短信发送失败...");
		return false;
	}

	/**
	 * 设置消息模式
	 * 
	 * @param op
	 *            0-pdu 1-text(默认1 文本方式 )
	 * @return
	 */
	public boolean setMessageMode(Port myport, int op) {
		try {
			String atCommand = "AT+CMGF=" + String.valueOf(op)
					+ String.valueOf(symbol1);
			String strReturn = myport.sendAT(atCommand);
			if (strReturn.indexOf("OK", 0) != -1) {
				System.out.println("*************文本方式设置成功************");
				return true;
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * 读取所有短信
	 * 
	 * @return CommonSms集合
	 */
	public List<CommonSms> RecvSmsList(Port myport) {
		if (!myport.isIsused()) {
			System.out.println("System Message:  COM通讯端口未正常打开!");
			return null;
		}
		List<CommonSms> listMes = new ArrayList<CommonSms>();
		try {
			atCommand = "AT+CMGL=\"ALL\"";
			strReturn = myport.sendAT(atCommand);
			listMes = StringUtil.analyseArraySMS(strReturn);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listMes;
	}

	/**
	 * 删除短信
	 * 
	 * @param index
	 *            短信存储的位置
	 * @return boolean
	 */

	public boolean DeleteSMS(int index, Port myport) {
		if (!myport.isIsused()) {
			System.out.println("System Message:  COM通讯端口未正常打开!");
			return false;
		}
		try {
			atCommand = "AT+CMGD=" + index;
			strReturn = myport.sendAT(atCommand);
			if (strReturn.indexOf("OK") != -1) {
				System.out.println("System Message:  成功删除存储位置为" + index
						+ "的短信......");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}

	/**
	 * 删除短信猫中所有短信
	 * 
	 * @return boolean
	 */
	public boolean DeleteAllSMS(Port myport) {
		List list = RecvSmsList(myport);
		boolean ret = true;
		if (list != null && !list.equals("") && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				CommonSms tempcomsms = (CommonSms) list.get(i);
				if (!DeleteSMS(tempcomsms.getId(), myport)) {
					ret = false;
				}
			}
		}
		return ret;
	}

	public CommonSms getCommonsms() {
		return commonsms;
	}

	public void setCommonsms(CommonSms commonsms) {
		this.commonsms = commonsms;
	}

	/**
	 * 号码，内容，发送短信息
	 * 
	 * @param phone
	 * @param countstring
	 * @throws Exception
	 */
	public static void sendmsn(String phone, String countstring) {
		Sms s = new Sms();
		// 发送测试
		CommonSms cs = new CommonSms();
		cs.setRecver(phone);
		cs.setSmstext(countstring);
		s.setCommonsms(cs);
		Port myort = new Port("COM4");
		System.out.println(myort.isIsused() + "     " + myort.getCOMname());
		s.SendSms(myort);
		// s.RecvSmsList(myort);
		// s.DeleteSMS(3,myort);
		s.DeleteAllSMS(myort);
		myort.close();
	}

	public static void main(String[] args) throws Exception {
		sendmsn("18967937625", "我有一筐的愿望，却等不到一颗流星,闭上眼睛，我看到了我的前途");

	}
}
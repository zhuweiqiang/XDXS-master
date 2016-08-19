package com.qylm.common.sms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.smslib.GatewayException;
import org.smslib.InboundMessage;
import org.smslib.InboundMessage.MessageClasses;
import org.smslib.Library;
import org.smslib.Message.MessageEncodings;
import org.smslib.OutboundMessage;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.modem.SerialModemGateway;

import com.qylm.constants.SmsConstants;

/**
 * 短信发，读取，删除，串口打开、关闭操作工具类
 * @author 盛民军
 */
public final class SmsUtil {
	
	/**
	 * 短信服务
	 */
	private static Service service;
	
	/**
	 * 为null时才启动服务
	 */
	public static void startService() {
		if (service == null) {
			OutboundNotification outboundNotification = new OutboundNotification();
			CallNotification callNotification = new CallNotification();
			System.out.println("Example: Send message from a serial gsm modem.");
			System.out.println(Library.getLibraryDescription());
			System.out.println("Version: " + Library.getLibraryVersion());
			service = new Service();

			SerialModemGateway gateway = new SerialModemGateway(SmsConstants.COM_NAME, SmsConstants.COM, SmsConstants.BL_115200, "wavecom", "17254");
			gateway.setInbound(true);
			gateway.setOutbound(true);
			gateway.setSimPin(SmsConstants.SIMPIN);// 这个按sim卡来
			gateway.setOutboundNotification(outboundNotification);
			gateway.setCallNotification(callNotification);
			gateway.setSmscNumber(SmsConstants.SMS_SERVICE_MODILE);//短信服务中心号码
			service.addGateway(gateway);
			try {
				service.startService();
				System.out.println("Modem Information:");
				System.out.println("  Manufacturer: " + gateway.getManufacturer());
				System.out.println("  Model: " + gateway.getModel());
				System.out.println("  Serial No: " + gateway.getSerialNo());
				System.out.println("  SIM IMSI: " + gateway.getImsi());
				System.out.println("  Signal Level: " + gateway.getSignalLevel() + "%");
				System.out.println("  Battery Level: " + gateway.getBatteryLevel()	+ "%");
				System.out.println();
			} catch (TimeoutException e) {
				e.printStackTrace();
			} catch (GatewayException e) {
				e.printStackTrace();
			} catch (SMSLibException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 终止服务
	 */
	public static void stopSerice() {
		try {
			service.stopService();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (GatewayException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 发短信
	 * @param recver 收件人
	 * @param smstext 短信内容
	 * @return true发送成功，反之失败
	 */
	public static boolean sendSms(String recver, String smstext) {
		boolean state = false;
		SmsUtil.startService();
		OutboundMessage msg;
		msg = new OutboundMessage(recver, smstext);
		msg.setEncoding(MessageEncodings.ENCUCS2);
		try {
			state = service.sendMessage(msg);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (GatewayException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	/**
	 * 读取所有短信
	 * @return
	 */
	public static List<InboundMessage> readSms() {
		List<InboundMessage> msgList = new ArrayList<InboundMessage>();
		SmsUtil.startService();
		try {
			service.readMessages(msgList, MessageClasses.ALL);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (GatewayException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return msgList;
	}
	
	/**
	 * 删除某条短信
	 * @param index
	 * @return
	 */
	public static boolean deleteSMS(InboundMessage inboundMessage) {
		boolean state = false;
		try {
			Thread.sleep(100);
			state = service.deleteMessage(inboundMessage);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (GatewayException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	/**
	 * 删除所有短信
	 * @param inboundMessageList
	 * @return
	 */
	public static void deleteAllSms(List<InboundMessage> inboundMessageList) {
		if (inboundMessageList != null && !inboundMessageList.isEmpty()) {
			for (InboundMessage inboundMessage : inboundMessageList) {
				SmsUtil.deleteSMS(inboundMessage);
			}
		}
	}
}

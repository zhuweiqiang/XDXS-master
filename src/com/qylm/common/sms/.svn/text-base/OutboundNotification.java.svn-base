package com.qylm.common.sms;

import org.smslib.IOutboundMessageNotification;
import org.smslib.OutboundMessage;

public class OutboundNotification implements IOutboundMessageNotification {

	public void process(String gatewayId, OutboundMessage msg) {
		System.out.println("短信设备开始启动");
		System.out.println("Outbound handler called from Gateway: " + gatewayId);
		System.out.println(msg);
	}

}

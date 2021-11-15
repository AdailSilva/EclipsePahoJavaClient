package com.adailsilva.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class OneListener implements IMqttMessageListener {

	public OneListener(OneClient clienteMQTT, String topico, int qos) {
		clienteMQTT.subscribe(qos, this, topico);
	}

	@Override
	public void messageArrived(String topico, MqttMessage mm) throws Exception {
		System.out.println("Mensagem recebida: ");
		System.out.println("\tTópico: " + topico);
		System.out.println("\tMensagem: " + new String(mm.getPayload()));
		System.out.println("");
	}
}
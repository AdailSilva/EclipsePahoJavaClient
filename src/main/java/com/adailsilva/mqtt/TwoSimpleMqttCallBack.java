package com.adailsilva.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class TwoSimpleMqttCallBack implements MqttCallback {

	public void connectionLost(Throwable throwable) {
		System.out.println("Conexão com o broker MQTT perdida!");
	}

	public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
		System.out.println("Mensagem recebida:\t" + new String(mqttMessage.getPayload()));
	}

	public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
	}
}
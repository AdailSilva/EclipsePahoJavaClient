package com.adailsilva.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class TwoSubscriber {

	private static final String CONNECTION_URL = "tcp://127.0.0.1:1883";
	private static final String SUBSCRIPTION = "/topic/energymeter";
	private static final String USERNAME = "adailsilva";
	private static final String PASSWORD = "@Hacker101";

	public static void main(String[] args) throws MqttException {

		System.out.println("== INICIAR ASSINANTE ==");

		MqttClient client = new MqttClient(CONNECTION_URL, MqttClient.generateClientId());

		MqttConnectOptions connOpts = setUpConnectionOptions(USERNAME, PASSWORD);

		client.setCallback(new TwoSimpleMqttCallBack());
		client.connect(connOpts);

		client.subscribe(SUBSCRIPTION);
	}

	public void messageArrived(String topic, MqttMessage message) throws MqttException {
		System.out.println(String.format("[%s] %s", topic, new String(message.getPayload())));
		System.out.println("\tMensagem publicada no tópico: 'IoT'");
	}

	private static MqttConnectOptions setUpConnectionOptions(String username, String password) {
		MqttConnectOptions connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);
		connOpts.setUserName(username);
		connOpts.setPassword(password.toCharArray());
		return connOpts;
	}

}

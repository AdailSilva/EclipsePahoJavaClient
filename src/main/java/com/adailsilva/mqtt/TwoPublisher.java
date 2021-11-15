package com.adailsilva.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class TwoPublisher {

	public static void main(String[] args) {
		
		String topic = "/topic/energymeter";
		String content = "Mensagem do Publisher em Java";
		int qos = 2;
		String broker = "tcp://127.0.0.1:1883";
		String clientId = "Java";
		String username = "adailsilva";
		String password = "@Hacker101";

		if (args.length == 2) {
			content = args[1];
		}
		
		MemoryPersistence persistence = new MemoryPersistence();

		try {
			MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
			
			System.out.println("VER isso: "+persistence.toString());
			
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			connOpts.setUserName(username);
			connOpts.setPassword(password.toCharArray());
			System.out.println("Conectando ao broker: " + broker);
			sampleClient.connect(connOpts);
			
			System.out.println(connOpts);
			
			System.out.println("Conectado");
			System.out.println("Publicando mensagem: " + content);
			MqttMessage message = new MqttMessage(content.getBytes());
			message.setQos(qos);
			sampleClient.publish(topic, message);
			System.out.println("Mensagem publicada");
			sampleClient.disconnect();
			System.out.println("Desconectado");
			System.exit(0);
		} catch (MqttException me) {
			System.out.println(">>> Exceção <<<");
			System.out.println("Razão: " + me.getReasonCode());
			System.out.println("Mensagem: " + me.getMessage());
			System.out.println("Localização: " + me.getLocalizedMessage());
			System.out.println("Causa: " + me.getCause());
			System.out.println("Exceção: " + me);
			me.printStackTrace();
		}
	}

}

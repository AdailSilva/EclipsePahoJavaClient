package com.adailsilva.mqtt;

import org.eclipse.paho.client.mqttv3.MqttException;

public class TwoInit {

	public static void main(String[] args) throws MqttException {

		if (args.length < 1) {
			throw new IllegalArgumentException("Deve ter 'publisher' ou 'subscriber' como argumento");
		}
		switch (args[0]) {
		case "publisher":
			TwoPublisher.main(args);
			break;
		case "subscriber":
			TwoSubscriber.main(args);
			break;
		default:
			throw new IllegalArgumentException("Argumento não Permitido " + args[0]);
		}
	}
}

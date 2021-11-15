package com.adailsilva.mqtt;

import java.text.SimpleDateFormat;

public class OneMain {

	public static void main(String[] args) throws InterruptedException {
		OneClient clienteMQTT = new OneClient("tcp://localhost:1883", "adailsilva", "@Hacker101");
		clienteMQTT.iniciar();

		new OneListener(clienteMQTT, "IoT", 0);

		while (true) {
			Thread.sleep(2000);
			String mensagem = "Publicação enviada em "
					+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(System.currentTimeMillis())
					+ " - Teste de MQTT disponivel em https://github.com/AdailSilva";

			clienteMQTT.publicar("IoT", mensagem.getBytes(), 0);
		}
	}
}

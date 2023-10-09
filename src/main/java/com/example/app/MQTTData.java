package com.example.app;

import com.vaadin.flow.server.VaadinSession;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.UUID;

public class MQTTData {
    static String broker = "tcp://localhost:1883";
    //static String topicName = "test/myTopic3";



    static String topicFinal= "test/";

    public MQTTData() {
    }

    public void mqttCall(String byIndex,Long index) throws MqttException {
        MemoryPersistence persistence = new MemoryPersistence();
        MqttClient mqttClient =new MqttClient(broker, UUID.randomUUID().toString(),persistence);

        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true); //no persistent session
        connOpts.setKeepAliveInterval(1000);

        //JSONParser parser= new JSONParser(byIndex.toString());





        MqttMessage message=  new MqttMessage(byIndex.getBytes());
        //System.out.println("Ed Sheeran".getBytes());


        message.setQos(1);
        message.setRetained(true);
        User user = VaadinSession.getCurrent().getAttribute(User.class);

        MqttTopic topic2= mqttClient.getTopic(topicFinal+user.getUsername());

        mqttClient.connect(connOpts);
        topic2.publish(message);

    }



}

package finpos.global.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author Suman.dhungana@citytech.global
 */
public class MqttSubscribe {

    public static void main(String[] args) {

        System.out.println("Subscriber running");
        new MqttSubscribe().subscribe("terminal/F20MP1106001795");

    }

    public void subscribe(String topic) {
//        MemoryPersistence persistence = new MemoryPersistence();
        try
        {

            MqttClient mqttClient = new MqttClient("tcp://11.12.12.100:2323", "HelloWorldSub");
            MqttConnectOptions connectionOptions = new MqttConnectOptions();
            connectionOptions.setCleanSession(true);
//            connectionOptions.setUserName("solace-cloud-client");
//            connectionOptions.setPassword("sc1qnn9kuqo515h0g".toCharArray());
            System.out.println("Connecting to broker::");

            mqttClient.setCallback(new MqttCallbackExtended() {
                @Override
                public void connectComplete(boolean b, String s) {
                    System.out.println("Connected");
                }

                @Override
                public void connectionLost(Throwable throwable) {
                    System.out.println("Connection Lost");
                }

                @Override
                public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                    System.out.println("Message Received");
                    System.out.println("MESSAGE IS::::::"+mqttMessage);
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                    System.out.println("Delivery Complete");
                }
            });

            mqttClient.connect(connectionOptions);
            mqttClient.subscribe(topic,1);
        } catch (MqttException me) {
            System.out.println(me);
        }
    }
}

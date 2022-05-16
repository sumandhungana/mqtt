//package finpos.global.hivemq;
//
//import com.hivemq.client.mqtt.MqttClient;
//import com.hivemq.client.mqtt.datatypes.MqttQos;
//import com.hivemq.client.mqtt.mqtt5.Mqtt5AsyncClient;
//import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;
//
//import java.nio.charset.StandardCharsets;
//import java.util.UUID;
//
///**
// * @author Suman.dhungana@citytech.global
// */
//public class MqttSubcribe {
//    public static void main(String[] args) {
//        final String host = "tcp://11.12.12.100:2323";
//
//        final Mqtt5Client client = Mqtt5Client.builder()
//                .identifier("4564" )
//                .serverHost(host)
//                .automaticReconnectWithDefaultConfig()
//                .serverPort(31468)
//                .sslWithDefaultConfig()
//                .build();
//
//        client.toAsync().connect();
//
//        client.toAsync().subscribeWith()
//                .topicFilter("test/topics")
//                .qos(MqttQos.AT_LEAST_ONCE)
//                .callback(publish -> {
//                    System.out.println("Received message on topic " + publish.getTopic() + ": " +
//                            new String(publish.getPayloadAsBytes(), StandardCharsets.UTF_8));
//                })
//                .send();
//    }
//
//    }
//

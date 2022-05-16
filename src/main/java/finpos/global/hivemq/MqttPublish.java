//package finpos.global.hivemq;
//
//import com.hivemq.client.mqtt.MqttClient;
//import com.hivemq.client.mqtt.datatypes.MqttQos;
//import com.hivemq.client.mqtt.mqtt5.Mqtt5AsyncClient;
//import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;
//import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;
//import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5PublishResult;
//
//import java.nio.charset.StandardCharsets;
//import java.util.UUID;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author Suman.dhungana@citytech.global
// */
//public class MqttPublish {
//    public static void main(String[] args) {
//        String host = "tcp://11.12.12.100:2323";
////        String username = "solace-cloud-client";
////        String password = "ksool389qnn9kuqo515h0g";
//
//        final Mqtt5Client client = Mqtt5Client.builder()
//                .identifier("123")
//                .serverHost(host)
//                .automaticReconnectWithDefaultConfig()
//                .serverPort(31468)
//                .sslWithDefaultConfig()
//                .build();
//
//        client.toAsync().connect();
////                .simpleAuth()
////                .username(username)
////                .password(password.getBytes(StandardCharsets.UTF_8))
////                .applySimpleAuth()
////                .send();
//
//            System.out.println("PUHBLSHD");
//        client.toAsync().publishWith()
//                .
//                    .topic("test/topics")
//                    .payload("actual Content".getBytes())
//                    .qos(MqttQos.AT_LEAST_ONCE)
//                    .send();
//            System.out.println("MESSSAGE PUBLISHED");
//
//
//
//    }
//
//    }
//

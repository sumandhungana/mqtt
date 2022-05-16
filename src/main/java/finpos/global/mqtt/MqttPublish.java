package finpos.global.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Suman.dhungana@citytech.global
 */
public class MqttPublish {
    public static void main(String[] args) {
//        String [] topic = {"topic"};
        List<String> topic = new ArrayList<>();
        topic.add("topic/1911100997");
        topic.add("topic/908001216");
        topic.add("terminals");
//        topic.parallelStream().forEach(item -> {
//            topic.add("termilnal/"+item);
//        });

        topic.add("terminal/");

        String content = """
                {
                   "code":"",
                   "message":"",
                   "data":[
                      {
                         "id":"0001",
                         "command":"SWITCH_CONFIG_UPDATE"
                      }
                   ]
                }""";
        int qos = 2;

        try{
            MqttClient mqttClient = new MqttClient("tcp://11.12.12.100:2323", "HelloWorldSubID");
            MqttConnectOptions connectionOptions = new MqttConnectOptions();
            System.out.println("Connecting to broker::");
            mqttClient.connect(connectionOptions);
            System.out.println("Connected");

            System.out.println("Publishing message::" + content);
            MqttMessage message = new MqttMessage(content.getBytes(StandardCharsets.UTF_8));
            message.setQos(qos);
//            for (singleTopic: topic) {
//                (mqttClient.publish(sin, message));
//            }
            topic.parallelStream().forEach(singleTopic -> {
                try {
                    mqttClient.publish(singleTopic,message);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            });

//            for (String singleTopic:topic) {
//                mqttClient.publish(singleTopic,message);
//            }

//            for(int i =0;i<topic.length;i++){
//                mqttClient.publish(topic[i],message);
//            }
//            mqttClient.publish(topic, message);
            System.out.println("Message published");

//            mqttClient.disconnect();
//            System.out.println("Disconnected");
//            System.exit(0);

        }catch (MqttException me){
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }
}

package messaging;

import com.kumuluz.ee.amqp.common.annotations.AMQPProducer;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageProducer {

    //splitRoute moet gestuurd worden.
    @AMQPProducer(host="RabbitMQ", exchange = "trackExchange", key = "newTrack")
    public String sendJSONMessage(String message) {
        return message;
    }
}
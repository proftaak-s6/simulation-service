package messaging;

import javax.enterprise.context.ApplicationScoped;

import com.kumuluz.ee.amqp.common.annotations.AMQPProducer;

@ApplicationScoped
public class RabbitMqMessageProducer implements MessageProducer {

    @AMQPProducer(host="rabbitmq", exchange = "trackingExchange", key = "newTrack")
    public Object sendJSONMessage(String message) {
        return message;
    }
}
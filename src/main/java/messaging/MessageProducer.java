package messaging;

public interface MessageProducer {
    Object sendJSONMessage(String message);
}
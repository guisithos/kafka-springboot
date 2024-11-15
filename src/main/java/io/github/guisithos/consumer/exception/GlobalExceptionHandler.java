package io.github.guisithos.consumer.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component("kafkaErrorHandler")
public class GlobalExceptionHandler implements KafkaListenerErrorHandler {
    
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        log.error("Error processing message: {}", message.getPayload(), exception);
        // Implement retry logic or send to DLQ
        return null;
    }
} 
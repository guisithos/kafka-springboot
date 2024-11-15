package io.github.guisithos.consumer.service;

import io.github.guisithos.consumer.model.Student;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class StudentListener {

    @KafkaListener(topics = "student-topic", groupId = "student-group", containerFactory = "jsonContainerFactory", errorHandler = "kafkaErrorHandler")
    public void consumeMessage(@Payload Student student) {
        try {
            log.info("Reading student: {}", student);
            // Process student
        } catch (Exception e) {
            log.error("Error processing student: {}", student, e);
            throw new KafkaProcessingException("Failed to process student", e);
        }
    }
}

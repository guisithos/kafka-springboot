package io.github.guisithos.consumer.integration;

import io.github.guisithos.consumer.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = {"student-topic"})
@ActiveProfiles("test")
class StudentListenerIntegrationTest {

    @Autowired
    private KafkaTemplate<String, Student> kafkaTemplate;

    @Test
    void shouldProcessStudentMessage() {
        // Test implementation
    }
} 
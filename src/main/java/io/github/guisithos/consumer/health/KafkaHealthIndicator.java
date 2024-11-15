package io.github.guisithos.consumer.health;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class KafkaHealthIndicator extends AbstractHealthIndicator {

    private final KafkaAdmin kafkaAdmin;
    private final String topicName = "student-topic";

    public KafkaHealthIndicator(KafkaAdmin kafkaAdmin) {
        super("Kafka health check failed");
        this.kafkaAdmin = kafkaAdmin;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        try (AdminClient adminClient = AdminClient.create(kafkaAdmin.getConfigurationProperties())) {
            // Check if we can list topics (tests connection)
            adminClient.listTopics(new ListTopicsOptions().timeoutMs(5000))
                    .names()
                    .get(5, TimeUnit.SECONDS);

            // Check if our specific topic exists
            boolean topicExists = adminClient.listTopics()
                    .names()
                    .get(5, TimeUnit.SECONDS)
                    .contains(topicName);

            if (topicExists) {
                builder.up()
                        .withDetail("topic", topicName)
                        .withDetail("status", "available");
            } else {
                builder.down()
                        .withDetail("topic", topicName)
                        .withDetail("status", "topic not found");
            }
        } catch (Exception e) {
            builder.down()
                    .withDetail("error", e.getMessage())
                    .withDetail("status", "unavailable");
        }
    }
} 
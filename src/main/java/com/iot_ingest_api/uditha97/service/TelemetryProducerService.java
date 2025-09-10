package com.iot_ingest_api.uditha97.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TelemetryProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;

    public TelemetryProducerService(KafkaTemplate<String, String> kafkaTemplate,
                                    @Value("${kafka.topic:telemetry}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void send(String deviceId, String payload) {
        kafkaTemplate.send(topic, deviceId, payload);
    }
}

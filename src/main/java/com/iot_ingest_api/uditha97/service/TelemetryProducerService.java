package com.iot_ingest_api.uditha97.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * Service for producing telemetry messages to Kafka.
 * Handles asynchronous message sending and metrics collection.
 */
@Service
public class TelemetryProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;
    private final MeterRegistry meterRegistry;

    public TelemetryProducerService(KafkaTemplate<String, String> kafkaTemplate,
                                    @Value("${kafka.topic:telemetry}") String topic,
                                    MeterRegistry meterRegistry) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
        this.meterRegistry = meterRegistry;
    }

    /**
     * Sends telemetry data to Kafka asynchronously.
     * Includes success/failure logging and Prometheus metrics collection.
     *
     * @param deviceId the device identifier for message key
     * @param payload the telemetry data payload as JSON string
     */
    public void send(String deviceId, String payload) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, deviceId, payload);

        future.whenComplete((result, ex) -> {
            if (ex != null) {
                System.err.println("Failed to send telemetry for device " + deviceId + ": " + ex.getMessage());
            } else {
                // Log success
                System.out.println("Telemetry sent for device " + deviceId);

                // Increment Prometheus counter
                meterRegistry.counter("iot.telemetry.sent", "deviceId", deviceId).increment();
            }
        });
    }
}

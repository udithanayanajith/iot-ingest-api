package com.iot_ingest_api.uditha97.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

/**
 * Entity class representing telemetry data from IoT devices.
 * Maps to database table with indexing for performance.
 */
@Entity
@Data
@Table(name = "telemetry", indexes = {
        @Index(name = "idx_device_ts", columnList = "deviceId,timestamp")
})
@Schema(description = "Telemetry data entity for IoT device measurements")
public class Telemetry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Auto-generated unique identifier", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @Schema(
            description = "Unique identifier of the device that generated the telemetry",
            example = "device-abc-123",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String deviceId;

    @Column(nullable = false)
    @Schema(
            description = "Timestamp when the telemetry data was generated",
            example = "2023-12-01T10:30:00Z",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Instant timestamp;

    @Column(columnDefinition = "json")
    @Schema(
            description = "JSON payload containing telemetry measurements",
            example = "{\"temperature\": 25.5, \"humidity\": 60.2, \"batteryLevel\": 85}",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String payload;
}
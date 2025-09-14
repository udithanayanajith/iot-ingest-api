package com.iot_ingest_api.uditha97.dto;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Data Transfer Object for bulk telemetry payloads.
 * Represents telemetry data sent by IoT devices in bulk format.
 */

@Data
@Schema(name = "TelemetryBulk", description = "Bulk telemetry payload sent by devices")
public class TelemetryBulkDTO {

    @Schema(description = "Unique device identifier", example = "device-abc-123")
    private String deviceId;

    @ArraySchema(schema = @Schema(description = "List of readings. Each reading is a JSON object (map).",
            example = "{\"timestamp\": \"2025-09-01T10:00:00Z\", \"temperature\": 27.3}"))
    private List<Map<String, Object>> readings;

}

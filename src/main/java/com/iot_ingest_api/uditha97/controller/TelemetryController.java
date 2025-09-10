package com.iot_ingest_api.uditha97.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot_ingest_api.uditha97.business.DeviceBusinessService;
import com.iot_ingest_api.uditha97.dto.TelemetryBulkDTO;
import com.iot_ingest_api.uditha97.service.TelemetryProducerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Telemetry", description = "Telemetry ingestion endpoints")
@RestController
@RequestMapping("/api/v1/telemetry")
public class TelemetryController {

    private final TelemetryProducerService producerService;
    private final DeviceBusinessService deviceBusinessService;
    private final ObjectMapper mapper = new ObjectMapper();

    public TelemetryController(TelemetryProducerService producerService,
                               DeviceBusinessService deviceBusinessService) {
        this.producerService = producerService;
        this.deviceBusinessService = deviceBusinessService;
    }


    @Operation(summary = "Ingest telemetry (bulk)",
            description = "Accepts bulk telemetry payloads and publishes to Kafka asynchronously. Returns 202 Accepted.")
    @PostMapping
    public ResponseEntity<?> ingest(@RequestBody TelemetryBulkDTO payload) {
        try {
            // Convert to JSON
            String json = mapper.writeValueAsString(payload);
            // Send to Kafka asynchronously
            producerService.send(payload.getDeviceId(), json);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to ingest telemetry: " + e.getMessage());
        }
    }
}
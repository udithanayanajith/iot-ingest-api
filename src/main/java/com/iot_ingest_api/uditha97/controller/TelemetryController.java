package com.iot_ingest_api.uditha97.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot_ingest_api.uditha97.dto.TelemetryBulkDTO;
import com.iot_ingest_api.uditha97.service.TelemetryProducerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Telemetry", description = "Telemetry ingestion endpoints")
@RestController
@RequestMapping("/api/v1/telemetry")
public class TelemetryController {

    private final TelemetryProducerService producerService;
    private final ObjectMapper mapper = new ObjectMapper();

    public TelemetryController(TelemetryProducerService producerService) {
        this.producerService = producerService;
    }

    @Operation(summary = "Ingest telemetry (bulk)",
            description = "Accepts a bulk telemetry payload and publishes it to Kafka. Returns 202 Accepted.")
    @PostMapping
    public ResponseEntity<?> ingest(@RequestBody TelemetryBulkDTO payload) throws Exception {
        String json = mapper.writeValueAsString(payload);
        producerService.send(payload.getDeviceId(), json);
        return ResponseEntity.accepted().build();
    }
}
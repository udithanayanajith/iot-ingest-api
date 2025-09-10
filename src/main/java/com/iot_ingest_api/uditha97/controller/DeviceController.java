package com.iot_ingest_api.uditha97.controller;

import com.iot_ingest_api.uditha97.model.Device;
import com.iot_ingest_api.uditha97.repository.DeviceRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Device Management", description = "Endpoints for device registration and retrieval")
@RestController
@RequestMapping("/api/v1/devices")
public class DeviceController {
    private final DeviceRepository deviceRepository;

    public DeviceController(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Operation(
            summary = "Register a new device",
            description = "Registers a new IoT device in the system and returns the created device with generated ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Device successfully registered",
                    content = @Content(schema = @Schema(implementation = Device.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid device data provided"
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Device with this ID already exists"
            )
    })
    @PostMapping
    public ResponseEntity<Device> register(
            @Parameter(
                    description = "Device object to register",
                    required = true,
                    content = @Content(schema = @Schema(implementation = Device.class))
            )
            @RequestBody Device device
    ) {
        return ResponseEntity.ok(deviceRepository.save(device));
    }

    @Operation(
            summary = "Get device by ID",
            description = "Retrieves device information by its unique device identifier"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Device found",
                    content = @Content(schema = @Schema(implementation = Device.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Device not found"
            )
    })
    @GetMapping("/{deviceId}")
    public ResponseEntity<Device> get(
            @Parameter(
                    description = "Unique device identifier",
                    required = true,
                    example = "device-abc-123"
            )
            @PathVariable String deviceId
    ) {
        return deviceRepository.findByDeviceId(deviceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
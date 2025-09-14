package com.iot_ingest_api.uditha97.business;

import com.iot_ingest_api.uditha97.model.Device;
import com.iot_ingest_api.uditha97.repository.DeviceRepositoryTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Business service layer for device-related operations.
 * Handles device registration and retrieval logic.
 */
@Service
public class DeviceBusinessService {

    private final DeviceRepositoryTemplate deviceRepositoryTemplate;

    public DeviceBusinessService( DeviceRepositoryTemplate deviceRepositoryTemplate) {
        this.deviceRepositoryTemplate = deviceRepositoryTemplate;
    }

    /**
     * Registers a new device in the system.
     * Validates device ID uniqueness before saving.
     *
     * @param device the device entity to register
     * @return the saved device entity
     * @throws IllegalArgumentException if device with the same ID already exists
     */
    public Device registerDevice(Device device) {
        if (deviceRepositoryTemplate.deviceExistsByDeviceId(device.getDeviceId())) {
            throw new IllegalArgumentException("Device with ID " + device.getDeviceId() + " already exists");
        }
        return deviceRepositoryTemplate.saveDevice(device);
    }

    /**
     * Retrieves a device by its unique device identifier.
     *
     * @param deviceId the unique device identifier
     * @return Optional containing the device if found, empty otherwise
     */
    public Optional<Device> getDeviceById(String deviceId) {
        return deviceRepositoryTemplate.getDeviceByDeviceId(deviceId);
    }

    /**
     * Checks if a device exists by its device ID.
     * Used for telemetry validation before processing.
     *
     * @param deviceId the unique device identifier
     * @return true if device exists, false otherwise
     */
    public boolean getTelemetryByDeviceId(String deviceId) {
        return deviceRepositoryTemplate.deviceExistsByDeviceId(deviceId);
    }
}
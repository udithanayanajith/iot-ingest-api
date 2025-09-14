package com.iot_ingest_api.uditha97.repository.impl;

import com.iot_ingest_api.uditha97.model.Device;
import com.iot_ingest_api.uditha97.repository.DeviceRepository;
import com.iot_ingest_api.uditha97.repository.DeviceRepositoryTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of DeviceRepositoryTemplate interface.
 * Provides data access operations for Device entities using JPA repository.
 */
@Service
public class DeviceRepoIMPL implements DeviceRepositoryTemplate {

    private final DeviceRepository deviceRepository;

    public DeviceRepoIMPL(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    /**
     * Saves a device entity to the database.
     *
     * @param device the device entity to save
     * @return the saved device entity
     */
    @Override
    public Device saveDevice(Device device) {
        return deviceRepository.save(device);
    }

    /**
     * Retrieves a device by its device ID.
     *
     * @param deviceId the unique device identifier
     * @return Optional containing the device if found
     */
    @Override
    public Optional<Device> getDeviceByDeviceId(String deviceId) {
        return deviceRepository.findByDeviceId(deviceId);
    }

    /**
     * Checks if a device exists with the given device ID.
     *
     * @param deviceId the unique device identifier
     * @return true if device exists, false otherwise
     */
    @Override
    public boolean deviceExistsByDeviceId(String deviceId) {
        return deviceRepository.existsByDeviceId(deviceId);
    }
}
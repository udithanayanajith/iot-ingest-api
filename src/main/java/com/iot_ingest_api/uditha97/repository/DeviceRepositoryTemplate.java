package com.iot_ingest_api.uditha97.repository;

import com.iot_ingest_api.uditha97.model.Device;
import java.util.Optional;

/**
 * Template interface for device repository operations.
 * Defines contract for device data access operations.
 */
public interface DeviceRepositoryTemplate {
    Device saveDevice(Device device);
    Optional<Device> getDeviceByDeviceId(String deviceId);
    boolean deviceExistsByDeviceId(String deviceId);
}
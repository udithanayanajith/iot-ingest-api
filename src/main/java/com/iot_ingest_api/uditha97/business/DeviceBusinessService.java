package com.iot_ingest_api.uditha97.business;

import com.iot_ingest_api.uditha97.model.Device;
import com.iot_ingest_api.uditha97.repository.DeviceRepositoryTemplate;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceBusinessService {

    private final DeviceRepositoryTemplate deviceRepositoryTemplate;

    public DeviceBusinessService( DeviceRepositoryTemplate deviceRepositoryTemplate) {
        this.deviceRepositoryTemplate = deviceRepositoryTemplate;
    }



    public Device registerDevice(Device device) {
        if (deviceRepositoryTemplate.deviceExistsByDeviceId(device.getDeviceId())) {
            throw new IllegalArgumentException("Device with ID " + device.getDeviceId() + " already exists");
        }
        return deviceRepositoryTemplate.saveDevice(device);
    }

    public Optional<Device> getDeviceById(String deviceId) {
        return deviceRepositoryTemplate.getDeviceByDeviceId(deviceId);
    }

}
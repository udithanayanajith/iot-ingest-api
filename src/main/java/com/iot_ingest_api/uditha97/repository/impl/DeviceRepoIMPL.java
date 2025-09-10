package com.iot_ingest_api.uditha97.repository.impl;

import com.iot_ingest_api.uditha97.model.Device;
import com.iot_ingest_api.uditha97.repository.DeviceRepository;
import com.iot_ingest_api.uditha97.repository.DeviceRepositoryTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceRepoIMPL implements DeviceRepositoryTemplate {

    private final DeviceRepository deviceRepository;

    public DeviceRepoIMPL(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }


    @Override
    public Device saveDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Optional<Device> getDeviceByDeviceId(String deviceId) {
        return deviceRepository.findByDeviceId(deviceId);
    }

    @Override
    public boolean deviceExistsByDeviceId(String deviceId) {
        return deviceRepository.existsByDeviceId(deviceId);
    }
}
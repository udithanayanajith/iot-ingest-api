package com.iot_ingest_api.uditha97.repository;

import com.iot_ingest_api.uditha97.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Optional<Device> findByDeviceId(String deviceId);
    boolean existsByDeviceId(String deviceId);
}
package com.iot_ingest_api.uditha97.repository;

import com.iot_ingest_api.uditha97.model.Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface TelemetryRepository extends JpaRepository<Telemetry, Long> {
    List<Telemetry> findByDeviceIdAndTimestampBetween(String deviceId, Instant from, Instant to);
}

package com.iot_ingest_api.uditha97.repository;

import com.iot_ingest_api.uditha97.model.Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface TelemetryRepository extends JpaRepository<Telemetry, Long> {
    List<Telemetry> findByDeviceId(String deviceId);

    @Query("SELECT t FROM Telemetry t WHERE t.deviceId = :deviceId AND t.timestamp BETWEEN :from AND :to")
    List<Telemetry> findByDeviceIdAndTimestampBetween(
            @Param("deviceId") String deviceId,
            @Param("from") Instant from,
            @Param("to") Instant to
    );
}
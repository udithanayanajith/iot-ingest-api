package com.iot_ingest_api.uditha97.repository.impl;

import com.iot_ingest_api.uditha97.model.Telemetry;
import com.iot_ingest_api.uditha97.repository.TelemetryRepository;
import com.iot_ingest_api.uditha97.repository.TelemetryRepositoryTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TelemetryRepoIMPL implements TelemetryRepositoryTemplate {

    private final TelemetryRepository telemetryRepository;

    public TelemetryRepoIMPL(TelemetryRepository telemetryRepository) {
        this.telemetryRepository = telemetryRepository;
    }

    @Override
    public Telemetry save(Telemetry telemetry) {
        return telemetryRepository.save(telemetry);
    }

    @Override
    public List<Telemetry> findByDeviceId(String deviceId) {
        return telemetryRepository.findByDeviceId(deviceId);
    }

    @Override
    public List<Telemetry> findByDeviceIdAndTimestampBetween(String deviceId, Long startTime, Long endTime) {
        Instant startInstant = Instant.ofEpochMilli(startTime);
        Instant endInstant = Instant.ofEpochMilli(endTime);
        return telemetryRepository.findByDeviceIdAndTimestampBetween(deviceId, startInstant, endInstant);
    }
}
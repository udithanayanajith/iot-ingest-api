package com.iot_ingest_api.uditha97.business;

import com.iot_ingest_api.uditha97.model.Telemetry;
import com.iot_ingest_api.uditha97.repository.TelemetryRepositoryTemplate;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TelemetryBusinessService {

    private final TelemetryRepositoryTemplate telemetryRepositoryTemplate;

    public TelemetryBusinessService(TelemetryRepositoryTemplate telemetryRepository) {
        this.telemetryRepositoryTemplate = telemetryRepository;
    }

    public Telemetry saveTelemetry(Telemetry telemetry) {
        return telemetryRepositoryTemplate.save(telemetry);
    }

    public List<Telemetry> getTelemetryByDeviceId(String deviceId) {
        return telemetryRepositoryTemplate.findByDeviceId(deviceId);
    }

    public List<Telemetry> getTelemetryByDeviceIdAndTimeRange(String deviceId, Long startTime, Long endTime) {
        return telemetryRepositoryTemplate.findByDeviceIdAndTimestampBetween(deviceId, startTime, endTime);
    }
}
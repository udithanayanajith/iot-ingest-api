package com.iot_ingest_api.uditha97.repository;

import com.iot_ingest_api.uditha97.model.Telemetry;
import java.util.List;

public interface TelemetryRepositoryTemplate {
    Telemetry save(Telemetry telemetry);
    List<Telemetry> findByDeviceId(String deviceId);
    List<Telemetry> findByDeviceIdAndTimestampBetween(String deviceId, Long startTime, Long endTime);
}
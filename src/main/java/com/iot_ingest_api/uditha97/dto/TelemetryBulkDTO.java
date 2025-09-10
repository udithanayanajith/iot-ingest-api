package com.iot_ingest_api.uditha97.dto;

import java.util.List;
import java.util.Map;

public class TelemetryBulkDTO {
    private String deviceId;
    private List<Map<String, Object>> readings;

    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public List<Map<String, Object>> getReadings() {
        return readings;
    }
    public void setReadings(List<Map<String, Object>> readings) {
        this.readings = readings;
    }
}

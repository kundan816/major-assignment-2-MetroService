package com.example.NammaMetro.Metroservice.entity;

import java.io.Serializable;

public class ActiveUser implements Serializable {  // ✅ Implements Serializable for Redis
    private Long userId;
    private String stationName;
    private Long checkInTime;

    public ActiveUser() {}

    public ActiveUser(Long userId, String stationName, Long checkInTime) {
        this.userId = userId;
        this.stationName = stationName;
        this.checkInTime = checkInTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Long getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Long checkInTime) {
        this.checkInTime = checkInTime;
    }
}

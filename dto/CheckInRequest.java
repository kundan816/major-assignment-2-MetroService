package com.example.NammaMetro.Metroservice.dto;

import lombok.Data;

@Data
public class CheckInRequest {
    private Long userId;
    private Long stationId;
    private String qrCode;
}

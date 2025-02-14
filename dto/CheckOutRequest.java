package com.example.NammaMetro.Metroservice.dto;

import lombok.Data;

@Data
public class CheckOutRequest {
    private Long userId;
    private Long stationId;
}

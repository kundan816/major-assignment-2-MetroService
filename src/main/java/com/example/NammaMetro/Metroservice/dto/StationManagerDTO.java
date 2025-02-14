package com.example.NammaMetro.Metroservice.dto;

import lombok.Data;

@Data
public class StationManagerDTO {
    private Long id;
    private String name;
    private String email;
    private Long stationId; // Reference to Station
}

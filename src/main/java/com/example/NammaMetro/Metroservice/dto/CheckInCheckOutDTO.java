package com.example.NammaMetro.Metroservice.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CheckInCheckOutDTO {
    private Long userId;
    private Long stationId;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private Double fare;
}

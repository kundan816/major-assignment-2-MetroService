package com.example.NammaMetro.Metroservice.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SOSAlertDTO {
    private Long id;
    private Long userId;
    private Long stationId;
    private String message;
    private LocalDateTime timestamp;
}

package com.example.NammaMetro.Metroservice.controller;

import com.example.NammaMetro.Metroservice.entity.SOSAlert;
import com.example.NammaMetro.Metroservice.service.SOSAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sos")
public class SOSAlertController {

    @Autowired
    private SOSAlertService sosAlertService;

    @PostMapping("/trigger/{userId}/{stationId}")
    public SOSAlert triggerSOS(@PathVariable Long userId, @PathVariable Long stationId, @RequestParam String message) {
        return sosAlertService.triggerSOS(userId, stationId, message);
    }
}

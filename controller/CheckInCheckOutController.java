package com.example.NammaMetro.Metroservice.controller;

import com.example.NammaMetro.Metroservice.dto.CheckInCheckOutDTO;
import com.example.NammaMetro.Metroservice.dto.CheckInRequest;
import com.example.NammaMetro.Metroservice.dto.CheckOutRequest;
import com.example.NammaMetro.Metroservice.service.CheckInCheckOutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metro")
public class CheckInCheckOutController {

    private final CheckInCheckOutService checkInCheckOutService;

    public CheckInCheckOutController(CheckInCheckOutService checkInCheckOutService) {
        this.checkInCheckOutService = checkInCheckOutService;
    }

    @PostMapping("/checkin")
    public ResponseEntity<CheckInCheckOutDTO> checkIn(@RequestBody CheckInRequest request) {
        return ResponseEntity.ok(checkInCheckOutService.checkIn(request.getUserId(), request.getStationId(), request.getQrCode()));
    }

    @PostMapping("/checkout")
    public ResponseEntity<CheckInCheckOutDTO> checkOut(@RequestBody CheckOutRequest request) {
        return ResponseEntity.ok(checkInCheckOutService.checkOut(request.getUserId(), request.getStationId()));
    }
    @GetMapping("/active-checkins")
    public ResponseEntity<List<CheckInCheckOutDTO>> getActiveCheckIns(@RequestParam Long userId) {
        List<CheckInCheckOutDTO> activeCheckIns = checkInCheckOutService.getActiveCheckIns(userId);
        return ResponseEntity.ok(activeCheckIns);
    }
    @GetMapping("/trip-history")
    public ResponseEntity<List<CheckInCheckOutDTO>> getTripHistory(@RequestParam Long userId) {
        List<CheckInCheckOutDTO> tripHistory = checkInCheckOutService.getTripHistory(userId);
        return ResponseEntity.ok(tripHistory);
    }


}

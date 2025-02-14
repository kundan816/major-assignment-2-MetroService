package com.example.NammaMetro.Metroservice.controller;

import com.example.NammaMetro.Metroservice.entity.Station;
import com.example.NammaMetro.Metroservice.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/metro")
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping("/stations")
    public List<Station> getAllStations() {
        return stationService.getAllStations();
    }

    @GetMapping("/station-details")
    public Station getStationById(@RequestParam Long stationId) {
        return stationService.getStationById(stationId)
                .orElseThrow(() -> new RuntimeException("Station not found for ID: " + stationId));
    }

    @PostMapping("/stations")
    public Station saveStation(@RequestBody Station station) {
        return stationService.saveStation(station);
    }
}

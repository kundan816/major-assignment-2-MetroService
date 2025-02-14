package com.example.NammaMetro.Metroservice.controller;

import com.example.NammaMetro.Metroservice.entity.StationManager;
import com.example.NammaMetro.Metroservice.service.StationManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/station-managers")
public class StationManagerController {

    @Autowired
    private StationManagerService stationManagerService;

    @GetMapping
    public List<StationManager> getAllManagers() {
        return stationManagerService.getAllManagers();
    }

    @GetMapping("/{id}")
    public StationManager getManagerById(@PathVariable Long id) {
        return stationManagerService.getManagerById(id);
    }

    @PostMapping
    public StationManager saveManager(@RequestBody StationManager manager) {
        return stationManagerService.saveManager(manager);
    }
}

package com.example.NammaMetro.Metroservice.service;

import com.example.NammaMetro.Metroservice.entity.Station;
import com.example.NammaMetro.Metroservice.entity.StationManager;
import com.example.NammaMetro.Metroservice.repository.StationManagerRepository;
import com.example.NammaMetro.Metroservice.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationManagerService {

    @Autowired
    private StationManagerRepository stationManagerRepository;

    @Autowired
    private StationRepository stationRepository;  // Add StationRepository

    public List<StationManager> getAllManagers() {
        return stationManagerRepository.findAll();
    }

    public StationManager getManagerById(Long id) {
        return stationManagerRepository.findById(id).orElse(null);
    }

    public StationManager saveManager(StationManager manager) {
        // Fetch full Station entity before saving
        if (manager.getStation() != null && manager.getStation().getId() != null) {
            Optional<Station> stationOpt = stationRepository.findById(manager.getStation().getId());
            stationOpt.ifPresent(manager::setStation);
        }

        return stationManagerRepository.save(manager);
    }
}

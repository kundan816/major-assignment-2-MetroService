package com.example.NammaMetro.Metroservice.service;

import com.example.NammaMetro.Metroservice.entity.Station;
import com.example.NammaMetro.Metroservice.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Optional<Station> getStationById(Long id) {
        return stationRepository.findById(id);
    }

    public Station saveStation(Station station) {
        return stationRepository.save(station);
    }
}

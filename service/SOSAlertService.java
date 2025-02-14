package com.example.NammaMetro.Metroservice.service;

import com.example.NammaMetro.Metroservice.entity.SOSAlert;
import com.example.NammaMetro.Metroservice.entity.Station;
import com.example.NammaMetro.Metroservice.entity.User;
import com.example.NammaMetro.Metroservice.repository.SOSAlertRepository;
import com.example.NammaMetro.Metroservice.repository.StationRepository;
import com.example.NammaMetro.Metroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SOSAlertService {

    @Autowired
    private SOSAlertRepository sosAlertRepository;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private UserRepository userRepository;

    public SOSAlert triggerSOS(Long userId, Long stationId, String message) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Station station = stationRepository.findById(stationId).orElseThrow(() -> new RuntimeException("Station not found"));

        SOSAlert sosAlert = new SOSAlert();
        sosAlert.setUser(user);
        sosAlert.setStation(station);
        sosAlert.setMessage(message);
        sosAlert.setAlertTime(System.currentTimeMillis());

        return sosAlertRepository.save(sosAlert);
    }
}

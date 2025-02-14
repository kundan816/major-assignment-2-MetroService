package com.example.NammaMetro.Metroservice.service;

import com.example.NammaMetro.Metroservice.dto.CheckInCheckOutDTO;
import com.example.NammaMetro.Metroservice.entity.CheckInCheckOut;
import com.example.NammaMetro.Metroservice.entity.Station;
import com.example.NammaMetro.Metroservice.entity.User;
import com.example.NammaMetro.Metroservice.repository.CheckInCheckOutRepository;
import com.example.NammaMetro.Metroservice.repository.StationRepository;
import com.example.NammaMetro.Metroservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CheckInCheckOutService {

    private final CheckInCheckOutRepository checkInCheckOutRepository;
    private final UserRepository userRepository;
    private final StationRepository stationRepository;

    private static final double BASE_FARE = 10.0; // Minimum fare
    private static final double FARE_PER_STATION = 10.0; // Additional fare per station traveled

    public CheckInCheckOutService(CheckInCheckOutRepository checkInCheckOutRepository,
                                  UserRepository userRepository,
                                  StationRepository stationRepository) {
        this.checkInCheckOutRepository = checkInCheckOutRepository;
        this.userRepository = userRepository;
        this.stationRepository = stationRepository;
    }

    @Transactional
    public CheckInCheckOutDTO checkIn(Long userId, Long stationId, String qrCode) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Station station = stationRepository.findById(stationId)
                .orElseThrow(() -> new RuntimeException("Station not found"));

        CheckInCheckOut checkIn = new CheckInCheckOut();
        checkIn.setUser(user);
        checkIn.setStation(station);
        checkIn.setQrCode(qrCode);
        checkIn.setCheckInTime(LocalDateTime.now());
        checkIn.setCheckedOut(false);

        CheckInCheckOut savedCheckIn = checkInCheckOutRepository.save(checkIn);

        return convertToDTO(savedCheckIn);
    }

    @Transactional
    public CheckInCheckOutDTO checkOut(Long userId, Long stationId) {
        List<CheckInCheckOut> activeCheckIns = checkInCheckOutRepository.findByUserIdAndCheckedOutFalse(userId);
        if (activeCheckIns.isEmpty()) {
            throw new RuntimeException("No active check-in found");
        }

        CheckInCheckOut checkOut = activeCheckIns.get(0);
        checkOut.setCheckOutTime(LocalDateTime.now());
        checkOut.setCheckedOut(true);

        // Get check-in and check-out stations
        Station checkInStation = checkOut.getStation();
        Station checkOutStation = stationRepository.findById(stationId)
                .orElseThrow(() -> new RuntimeException("Check-out station not found"));

        // Calculate fare based on the number of stations traveled
        int stationsTraveled = Math.abs(checkOutStation.getId().intValue() - checkInStation.getId().intValue());
        double fare = stationsTraveled > 0 ? BASE_FARE + (stationsTraveled * FARE_PER_STATION) : BASE_FARE;

        checkOut.setFare(fare);
        CheckInCheckOut savedCheckOut = checkInCheckOutRepository.save(checkOut);

        return convertToDTO(savedCheckOut);
    }

    private CheckInCheckOutDTO convertToDTO(CheckInCheckOut checkInCheckOut) {
        CheckInCheckOutDTO dto = new CheckInCheckOutDTO();
        dto.setUserId(checkInCheckOut.getUser().getId());
        dto.setStationId(checkInCheckOut.getStation().getId());
        dto.setCheckInTime(checkInCheckOut.getCheckInTime());
        dto.setCheckOutTime(checkInCheckOut.getCheckOutTime());
        dto.setFare(checkInCheckOut.getFare());
        return dto;
    }

    public List<CheckInCheckOutDTO> getActiveCheckIns(Long userId) {
        List<CheckInCheckOut> activeCheckIns = checkInCheckOutRepository.findByUserIdAndCheckedOutFalse(userId);

        if (activeCheckIns.isEmpty()) {
            throw new RuntimeException("No active check-in found for userId: " + userId);
        }

        return activeCheckIns.stream().map(this::convertToDTO).toList();
    }
    public List<CheckInCheckOutDTO> getTripHistory(Long userId) {
        List<CheckInCheckOut> tripHistory = checkInCheckOutRepository.findByUserId(userId);

        if (tripHistory.isEmpty()) {
            throw new RuntimeException("No trip history found for userId: " + userId);
        }

        return tripHistory.stream().map(this::convertToDTO).toList();
    }

}

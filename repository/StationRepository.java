package com.example.NammaMetro.Metroservice.repository;

import com.example.NammaMetro.Metroservice.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
}

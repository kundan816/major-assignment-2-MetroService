package com.example.NammaMetro.Metroservice.repository;

import com.example.NammaMetro.Metroservice.entity.StationManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationManagerRepository extends JpaRepository<StationManager, Long> {
}

package com.example.NammaMetro.Metroservice.repository;

import com.example.NammaMetro.Metroservice.entity.SOSAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SOSAlertRepository extends JpaRepository<SOSAlert, Long> {
}

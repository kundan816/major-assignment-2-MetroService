package com.example.NammaMetro.Metroservice.repository;

import com.example.NammaMetro.Metroservice.entity.CheckInCheckOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CheckInCheckOutRepository extends JpaRepository<CheckInCheckOut, Long> {
    List<CheckInCheckOut> findByUserIdAndCheckedOutFalse(Long userId);
    List<CheckInCheckOut> findByUserId(Long userId);

}

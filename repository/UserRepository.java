package com.example.NammaMetro.Metroservice.repository;

import com.example.NammaMetro.Metroservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

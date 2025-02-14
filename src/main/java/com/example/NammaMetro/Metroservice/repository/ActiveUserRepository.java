package com.example.NammaMetro.Metroservice.repository;

import com.example.NammaMetro.Metroservice.entity.ActiveUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveUserRepository extends CrudRepository<ActiveUser, Long> {
}

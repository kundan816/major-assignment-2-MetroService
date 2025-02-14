package com.example.NammaMetro.Metroservice.service;

import com.example.NammaMetro.Metroservice.entity.ActiveUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActiveUserService {

    private static final String ACTIVE_USERS_KEY = "active_users";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void addActiveUser(Long userId, String stationName) {
        ActiveUser activeUser = new ActiveUser(userId, stationName, System.currentTimeMillis());
        redisTemplate.opsForHash().put(ACTIVE_USERS_KEY, userId.toString(), activeUser);
    }

    public void removeActiveUser(Long userId) {
        redisTemplate.opsForHash().delete(ACTIVE_USERS_KEY, userId.toString());
    }

    public Optional<ActiveUser> getActiveUser(Long userId) {
        return Optional.ofNullable((ActiveUser) redisTemplate.opsForHash().get(ACTIVE_USERS_KEY, userId.toString()));
    }

    public List<ActiveUser> getAllActiveUsers() {
        return redisTemplate.opsForHash()
                .values(ACTIVE_USERS_KEY)
                .stream()
                .map(obj -> (ActiveUser) obj)
                .collect(Collectors.toList());
    }
}

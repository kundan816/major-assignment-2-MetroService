package com.example.NammaMetro.Metroservice.controller;

import com.example.NammaMetro.Metroservice.entity.ActiveUser;
import com.example.NammaMetro.Metroservice.service.ActiveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/metro/active-users")
public class ActiveUserController {

    @Autowired
    private ActiveUserService activeUserService;

    @PostMapping("/add/{userId}")
    public void addActiveUser(@PathVariable Long userId, @RequestParam String stationName) {
        activeUserService.addActiveUser(userId, stationName);
    }

    @DeleteMapping("/remove/{userId}")
    public void removeActiveUser(@PathVariable Long userId) {
        activeUserService.removeActiveUser(userId);
    }

    @GetMapping("/{userId}")
    public Optional<ActiveUser> getActiveUser(@PathVariable Long userId) {
        return activeUserService.getActiveUser(userId);
    }

    @GetMapping  //  New method to fetch all active users
    public List<ActiveUser> getAllActiveUsers() {
        return activeUserService.getAllActiveUsers();
    }
}

package com.example.demoPractice.controller;

import com.example.demoPractice.model.entity.Restaurant;
import com.example.demoPractice.model.entity.Room;
import com.example.demoPractice.model.request.RestaurantCreateRequest;
import com.example.demoPractice.model.request.RoomCreateRequest;
import com.example.demoPractice.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService service;

    @PostMapping
    public ResponseEntity<Room> save(@RequestBody RoomCreateRequest request) {
        return ResponseEntity.ok(service.save(request));
    }

    @GetMapping("/main")
    public ResponseEntity<?> getMainPage(@RequestParam String city) {
        return ResponseEntity.ok(service.getMainPage(city));
    }
}

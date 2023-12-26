package com.example.demoPractice.controller;

import com.example.demoPractice.model.entity.Restaurant;
import com.example.demoPractice.model.request.RestaurantRequest;
import com.example.demoPractice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor
public class RestaurantController {


    private final RestaurantService service;


    @GetMapping
    public List<Restaurant> getAll() {
        return service.getAll();
    }

    @GetMapping("/id")
    public Restaurant getById(@RequestParam Long id) {
        return service.getById(id);
    }

    @PostMapping()
    public void save(@RequestBody Restaurant restaurant) {
        service.save(restaurant);
    }

    @GetMapping("/by-capacity")
    public ResponseEntity<?> getByCapacity( @RequestParam int capacity) {
        return ResponseEntity.ok(service.getByCapacity(capacity));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody RestaurantRequest request) {
        return ResponseEntity.ok(service.update(request));
    }
}

package com.example.demoPractice.controller;

import com.example.demoPractice.model.entity.Restaurant;
import com.example.demoPractice.model.request.RestaurantCreateRequest;
import com.example.demoPractice.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public Restaurant getById(@RequestParam(required = false, defaultValue = "1L") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody RestaurantCreateRequest request) {
        return ResponseEntity.ok(service.save(request));
    }

    @GetMapping("/getMainPage")
    public ResponseEntity<?> getMainPage() {
        return ResponseEntity.ok(service.getRestaurantsMainPage());
    }


}

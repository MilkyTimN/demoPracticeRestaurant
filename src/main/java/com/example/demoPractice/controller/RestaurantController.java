package com.example.demoPractice.controller;

import com.example.demoPractice.model.entity.Restaurant;
import com.example.demoPractice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}

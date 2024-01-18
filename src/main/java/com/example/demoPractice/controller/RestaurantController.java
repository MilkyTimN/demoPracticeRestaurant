package com.example.demoPractice.controller;

import com.example.demoPractice.exception.NotFoundException;
import com.example.demoPractice.model.dto.RestaurantDto;
import com.example.demoPractice.model.entity.Restaurant;
import com.example.demoPractice.model.request.ResFulCreateRequest;
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
    public List<RestaurantDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/id")
    public ResponseEntity<?> getById(@RequestParam(required = false, defaultValue = "1L") Long id) {
        try {
            RestaurantDto restaurantDto = service.getById(id);
            return ResponseEntity.ok(restaurantDto);
        } catch (NotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody RestaurantCreateRequest request) {
        return ResponseEntity.ok(service.save(request));
    }

    @GetMapping("/getMainPage")
    public ResponseEntity<?> getMainPage() {
        return ResponseEntity.ok(service.getRestaurantsMainPage());
    }

    @PostMapping("/full/save")
    public ResponseEntity<?> saveFully(@RequestBody ResFulCreateRequest request){
        return ResponseEntity.ok(service.saveFull(request));
    }


}

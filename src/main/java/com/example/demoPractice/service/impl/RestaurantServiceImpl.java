package com.example.demoPractice.service.impl;

import com.example.demoPractice.model.entity.Restaurant;
import com.example.demoPractice.model.enums.Status;
import com.example.demoPractice.model.request.RestaurantCreateRequest;
import com.example.demoPractice.repository.RestaurantRepository;
import com.example.demoPractice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;


    @Override
    public List<Restaurant> getAll() {
       return (List<Restaurant>) repository.findAll();
    }

    @Override
    public Restaurant getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Restaurant save(RestaurantCreateRequest request) {

        Restaurant restaurant = Restaurant.builder()
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .status(Status.ACTIVE)
                .name(request.name())
                .build();

        return repository.save(restaurant);
    }
}

package com.example.demoPractice.service;

import com.example.demoPractice.model.entity.Restaurant;
import com.example.demoPractice.model.request.RestaurantRequest;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAll();

    Restaurant getById(Long id);

    void save(Restaurant restaurant);

    List<Restaurant> getByCapacity(int capacity);

    Restaurant update(RestaurantRequest request);
}

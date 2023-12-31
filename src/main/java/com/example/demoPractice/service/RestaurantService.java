package com.example.demoPractice.service;

import com.example.demoPractice.model.entity.Restaurant;
import com.example.demoPractice.model.request.RestaurantCreateRequest;
import com.example.demoPractice.model.response.RestaurantResponseMainPage;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAll();

    Restaurant getById(Long id);

    Restaurant save(RestaurantCreateRequest request);

    List<RestaurantResponseMainPage> getRestaurantsMainPage();


}

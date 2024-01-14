package com.example.demoPractice.service;

import com.example.demoPractice.model.dto.RestaurantDto;
import com.example.demoPractice.model.entity.Restaurant;
import com.example.demoPractice.model.request.RestaurantCreateRequest;
import com.example.demoPractice.model.response.RestaurantResponseMainPage;

import java.util.List;

public interface RestaurantService {

    List<RestaurantDto> getAll();

    RestaurantDto getById(Long id);

    RestaurantDto save(RestaurantCreateRequest request);

    List<RestaurantResponseMainPage> getRestaurantsMainPage();


}

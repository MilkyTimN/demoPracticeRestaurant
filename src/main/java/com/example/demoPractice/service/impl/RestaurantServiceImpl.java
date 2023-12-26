package com.example.demoPractice.service.impl;

import com.example.demoPractice.model.entity.Restaurant;
import com.example.demoPractice.model.request.RestaurantRequest;
import com.example.demoPractice.repository.RestaurantRepository;
import com.example.demoPractice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public void save(Restaurant restaurant) {
        repository.save(restaurant);
    }

    @Override
    public List<Restaurant> getByCapacity(int capacity) {
        return repository.findRestaurantByCapacity(capacity);
    }

    @Override
    public Restaurant update(RestaurantRequest request) {

        Restaurant restaurantFromDb = getById(request.getId());

        if (request.getCapacity() != null) {
            restaurantFromDb.setCapacity(request.getCapacity());
        }
        if (request.getName() != null) {
            restaurantFromDb.setName(request.getName());
        }
        if (request.getPrice() != null) {
            restaurantFromDb.setPrice(request.getPrice());
        }
        if (request.getAddress() != null) {
            restaurantFromDb.setAddress(request.getAddress());
        }
        if (request.getRating() != null) {
            restaurantFromDb.setRating(request.getRating());
        }


        return null;
    }
}

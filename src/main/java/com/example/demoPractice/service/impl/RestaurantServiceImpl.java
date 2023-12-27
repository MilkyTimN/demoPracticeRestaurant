package com.example.demoPractice.service.impl;

import com.example.demoPractice.model.entity.Restaurant;
import com.example.demoPractice.repository.RestaurantRepository;
import com.example.demoPractice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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




}

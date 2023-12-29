package com.example.demoPractice.service.impl;

import com.example.demoPractice.model.entity.Address;
import com.example.demoPractice.model.enums.Status;
import com.example.demoPractice.model.request.AddressCreateRequest;
import com.example.demoPractice.repository.AddressRepository;
import com.example.demoPractice.service.AddressService;
import com.example.demoPractice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final RestaurantService restaurantService;
    private final AddressRepository repository;

    @Override
    public Address save(AddressCreateRequest request) {

        Address address = Address.builder()
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .status(Status.ACTIVE)
                .city(request.city())
                .lon(request.lon())
                .lat(request.lat())
                .street(request.street())
                .restaurant(restaurantService.getById(request.restaurantId()))
                .build();


        return repository.save(address);
    }

    @Override
    public Address getById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}

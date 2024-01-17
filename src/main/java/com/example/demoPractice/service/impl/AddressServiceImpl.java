package com.example.demoPractice.service.impl;

import com.example.demoPractice.mapper.AddressMapper;
import com.example.demoPractice.mapper.RestaurantMapper;
import com.example.demoPractice.model.dto.RestaurantDto;
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

    private final AddressRepository repository;

    @Override
    public Address save(AddressCreateRequest request) {

        Address address = Address.builder()
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .status(Status.ACTIVE)
                .city(request.getCity())
                .lon(request.getLon())
                .lat(request.getLat())
                .street(request.getStreet())
                .restaurant(RestaurantMapper.INSTANCE.toEntity(request.getRestaurant()))
                .build();


        return repository.save(address);
    }

    @Override
    public Address getById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}

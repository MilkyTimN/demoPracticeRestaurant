package com.example.demoPractice.service;

import com.example.demoPractice.model.entity.Address;
import com.example.demoPractice.model.request.AddressCreateRequest;

public interface AddressService {

    Address save(AddressCreateRequest request);

    Address getById(Long id);
}

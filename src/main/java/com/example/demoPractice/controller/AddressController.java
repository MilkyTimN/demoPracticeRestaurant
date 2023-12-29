package com.example.demoPractice.controller;

import com.example.demoPractice.model.entity.Address;
import com.example.demoPractice.model.entity.Room;
import com.example.demoPractice.model.request.AddressCreateRequest;
import com.example.demoPractice.model.request.RoomCreateRequest;
import com.example.demoPractice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;

    @PostMapping
    public ResponseEntity<Address> save(@RequestBody AddressCreateRequest request) {
        return ResponseEntity.ok(service.save(request));
    }
}

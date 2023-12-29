package com.example.demoPractice.model.request;

import jakarta.persistence.ManyToOne;

public record AddressCreateRequest(
        String city,
        String street,
        Double lat,
        Double lon,
        Long restaurantId
) {
}

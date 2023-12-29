package com.example.demoPractice.model.request;

import com.example.demoPractice.model.entity.Restaurant;

public record RoomCreateRequest(
        Long restaurantId,
        Integer capacity,
        String name,
        Integer price
) {
}

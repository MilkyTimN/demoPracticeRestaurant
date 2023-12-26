package com.example.demoPractice.model.request;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantRequest {

    Long id;
    String name;
    String address;
    Integer capacity;
    Double rating;
    Integer price;
}

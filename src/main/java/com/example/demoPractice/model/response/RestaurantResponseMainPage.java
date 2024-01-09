package com.example.demoPractice.model.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantResponseMainPage {

    Long restaurantId;
    String restaurantName;
    Integer roomCount;
    Integer avgCapacity;
    Integer avgPrice;
}

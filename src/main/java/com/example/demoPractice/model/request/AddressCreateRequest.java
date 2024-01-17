package com.example.demoPractice.model.request;

import com.example.demoPractice.model.dto.RestaurantDto;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressCreateRequest {
        String city;
        String street;
        Double lat;
        Double lon;
        RestaurantDto restaurant;

}

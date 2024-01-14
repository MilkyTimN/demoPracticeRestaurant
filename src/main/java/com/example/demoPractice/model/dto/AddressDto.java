package com.example.demoPractice.model.dto;

import com.example.demoPractice.model.entity.Restaurant;
import com.example.demoPractice.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@ToString
public class AddressDto {

    Long id;
    LocalDateTime createdDate;
    LocalDateTime updatedDate;
    Status status;
    String city;
    String street;
    Double lat;
    Double lon;
    RestaurantDto restaurant;
}

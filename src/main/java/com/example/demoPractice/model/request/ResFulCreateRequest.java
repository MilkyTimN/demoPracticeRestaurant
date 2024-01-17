package com.example.demoPractice.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ResFulCreateRequest {

    RestaurantCreateRequest restaurantCreateRequest;
    List<RoomCreateRequest> roomCreateRequest;
    AddressCreateRequest addressCreateRequest;
}

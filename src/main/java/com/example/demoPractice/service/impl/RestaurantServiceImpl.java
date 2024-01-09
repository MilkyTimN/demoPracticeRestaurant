package com.example.demoPractice.service.impl;

import com.example.demoPractice.model.entity.Restaurant;
import com.example.demoPractice.model.enums.Status;
import com.example.demoPractice.model.request.RestaurantCreateRequest;
import com.example.demoPractice.model.response.RestaurantResponseMainPage;
import com.example.demoPractice.repository.RestaurantRepository;
import com.example.demoPractice.service.RestaurantService;
import com.example.demoPractice.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;
    private final RoomService roomService;


    @Override
    public List<Restaurant> getAll() {
       return (List<Restaurant>) repository.findAll();
    }

    @Override
    public Restaurant getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Restaurant save(RestaurantCreateRequest request) {

        Restaurant restaurant = Restaurant.builder()
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .status(Status.ACTIVE)
                .name(request.name())
                .build();

        return repository.save(restaurant);
    }

    @Override
    public List<RestaurantResponseMainPage> getRestaurantsMainPage() {

        List<Restaurant> restaurantList = repository.findAll();

        List<RestaurantResponseMainPage> restaurantResponseMainPages = new ArrayList<>();

        for (Restaurant item : restaurantList) {
            RestaurantResponseMainPage response = RestaurantResponseMainPage.builder()
                    .restaurantId(item.getId())
                    .restaurantName(item.getName())
                    .roomCount(roomService.countOfRoomsByRestaurant(item.getId()))
                    .avgCapacity(roomService.avgCapacityOfRoomsByRestaurant(item.getId()))
                    .avgPrice(roomService.avgPriceOfRoomsByRestaurant(item.getId()))
                    .build();

            restaurantResponseMainPages.add(response);
        }

        return restaurantResponseMainPages;
    }
}

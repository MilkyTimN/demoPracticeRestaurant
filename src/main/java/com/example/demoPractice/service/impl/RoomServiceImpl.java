package com.example.demoPractice.service.impl;

import com.example.demoPractice.model.entity.Room;
import com.example.demoPractice.model.enums.Status;
import com.example.demoPractice.model.request.RoomCreateRequest;
import com.example.demoPractice.repository.RoomRepository;
import com.example.demoPractice.repository.projections.MainPageResponseProjection;
import com.example.demoPractice.service.RestaurantService;
import com.example.demoPractice.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {


    private final RoomRepository repository;

    @Override
    public Room save(RoomCreateRequest request) {

//        Room room = Room.builder()
//                .createdDate(LocalDateTime.now())
//                .updatedDate(LocalDateTime.now())
//                .status(Status.ACTIVE)
//                .price(request.price())
//                .name(request.name())
//                .capacity(request.capacity())
//                .restaurant(restaurantService.getById(request.restaurantId()))
//                .build();
//
//        return repository.save(room);
        return null;
    }

    @Override
    public Room getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<MainPageResponseProjection> getMainPage(String city) {
        return repository.findRoomsByCity(city);
    }

    @Override
    public Integer countOfRoomsByRestaurant(Long restaurantId) {
        return repository.countOfRoomsByRestaurant(restaurantId);
    }

    @Override
    public Integer avgPriceOfRoomsByRestaurant(Long restaurantId) {
        return repository.avgPriceOfRoomsByRestaurant(restaurantId);
    }

    @Override
    public Integer avgCapacityOfRoomsByRestaurant(Long restaurantId) {
        return  repository.avgCapacityOfRoomsByRestaurant(restaurantId);
    }
}

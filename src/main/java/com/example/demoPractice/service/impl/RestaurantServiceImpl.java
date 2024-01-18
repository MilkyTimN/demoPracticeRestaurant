package com.example.demoPractice.service.impl;

import com.example.demoPractice.exception.EmptyListException;
import com.example.demoPractice.exception.NotFoundException;
import com.example.demoPractice.mapper.RestaurantMapper;
import com.example.demoPractice.model.dto.RestaurantDto;
import com.example.demoPractice.model.entity.Restaurant;
import com.example.demoPractice.model.entity.Room;
import com.example.demoPractice.model.enums.Status;
import com.example.demoPractice.model.request.AddressCreateRequest;
import com.example.demoPractice.model.request.ResFulCreateRequest;
import com.example.demoPractice.model.request.RestaurantCreateRequest;
import com.example.demoPractice.model.request.RoomCreateRequest;
import com.example.demoPractice.model.response.RestaurantResponseMainPage;
import com.example.demoPractice.repository.RestaurantRepository;
import com.example.demoPractice.service.AddressService;
import com.example.demoPractice.service.RestaurantService;
import com.example.demoPractice.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;
    private final RoomService roomService;
    private final AddressService addressService;


    @Override
    public List<RestaurantDto> getAll() {
        List<Restaurant> restaurantList = (List<Restaurant>) repository.findAll();
        if (restaurantList.isEmpty()) {
            throw new EmptyListException("Restaurant list is empty");
        }

       return RestaurantMapper.INSTANCE.toDtos(restaurantList);
    }

    @Override
    public RestaurantDto getById(Long id) {
        return RestaurantMapper.INSTANCE.toDto(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Restaurant with " + id + " not found")));
    }

    @Override
    public RestaurantDto save(RestaurantCreateRequest request) {

        Restaurant restaurant = Restaurant.builder()
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .status(Status.ACTIVE)
                .name(request.name())
                .build();

        restaurant = repository.save(restaurant);

        return RestaurantMapper.INSTANCE.toDto(restaurant);
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

    @Override
    public Boolean saveFull(ResFulCreateRequest request) {

        RestaurantDto restaurantDto = save(request.getRestaurantCreateRequest());

        for (RoomCreateRequest item : request.getRoomCreateRequest()) {
            item.setRestaurantDto(restaurantDto);
            roomService.save(item);
        }

        AddressCreateRequest addressCreateRequest = request.getAddressCreateRequest();
        addressCreateRequest.setRestaurant(restaurantDto);
        addressService.save(addressCreateRequest);


        return true;
    }
}

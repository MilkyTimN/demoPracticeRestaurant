package com.example.demoPractice.mapper;

import com.example.demoPractice.model.dto.RestaurantDto;
import com.example.demoPractice.model.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RestaurantMapper extends BaseMapper<Restaurant, RestaurantDto> {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
}

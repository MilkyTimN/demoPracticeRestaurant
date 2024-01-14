package com.example.demoPractice.mapper;

import com.example.demoPractice.model.dto.RoomDto;
import com.example.demoPractice.model.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper extends BaseMapper<Room, RoomDto> {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);
}

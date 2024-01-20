package com.example.demoPractice.mapper;

import com.example.demoPractice.model.dto.UserDto;
import com.example.demoPractice.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDto>{

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}

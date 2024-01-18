package com.example.demoPractice.service;

import com.example.demoPractice.model.dto.UserDto;
import com.example.demoPractice.model.request.UserCreateRequest;

public interface UserService {

    UserDto save(UserCreateRequest request);
    UserDto getById(Long id);
}

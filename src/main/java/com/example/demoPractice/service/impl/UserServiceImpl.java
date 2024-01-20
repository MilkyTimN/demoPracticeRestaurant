package com.example.demoPractice.service.impl;

import com.example.demoPractice.exception.NotFoundException;
import com.example.demoPractice.mapper.UserMapper;
import com.example.demoPractice.model.dto.UserDto;
import com.example.demoPractice.model.entity.User;
import com.example.demoPractice.model.enums.Status;
import com.example.demoPractice.model.request.UserCreateRequest;
import com.example.demoPractice.repository.UserRepository;
import com.example.demoPractice.service.UserService;
import com.example.demoPractice.utils.Language;
import com.example.demoPractice.utils.ResourceBundleLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserDto save(UserCreateRequest request) {
        User entity = User.builder()
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .status(Status.ACTIVE)
                .age(request.getAge())
                .email(request.getEmail())
                .password(request.getPassword())
                .name(request.getName())
                .build();

        return UserMapper.INSTANCE.toDto(repository.save(entity));
    }

    @Override
    public UserDto getById(Long id, int languageOrdinal) {
        Language language = Language.getLanguage(languageOrdinal);

        return UserMapper.INSTANCE.toDto(repository.findById(id)
                .orElseThrow(()
                        -> new NotFoundException(ResourceBundleLanguage.periodMessage(language, "entityNotFound"))));
    }
}

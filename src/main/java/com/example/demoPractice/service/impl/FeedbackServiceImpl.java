package com.example.demoPractice.service.impl;

import com.example.demoPractice.exception.NotFoundException;
import com.example.demoPractice.mapper.FeedbackMapper;
import com.example.demoPractice.mapper.RestaurantMapper;
import com.example.demoPractice.mapper.UserMapper;
import com.example.demoPractice.model.dto.FeedbackDto;
import com.example.demoPractice.model.entity.Feedback;
import com.example.demoPractice.model.enums.Status;
import com.example.demoPractice.model.request.FeedbackCreateRequest;
import com.example.demoPractice.repository.FeedbackRepository;
import com.example.demoPractice.service.FeedbackService;
import com.example.demoPractice.service.RestaurantService;
import com.example.demoPractice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository repository;
    private final RestaurantService restaurantService;
    private final UserService userService;

    @Override
    public FeedbackDto save(FeedbackCreateRequest request) {
        Feedback entity = Feedback.builder()
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .status(Status.ACTIVE)
                .comment(request.getComment())
                .restaurant(RestaurantMapper.INSTANCE.toEntity(restaurantService.getById(request.getRestaurantId())))
                .user(UserMapper.INSTANCE.toEntity(userService.getById(request.getUserId())))
                .build();
        return FeedbackMapper.INSTANCE.toDto(repository.save(entity));
    }

    @Override
    public FeedbackDto getById(Long id) {
        return FeedbackMapper.INSTANCE.toDto(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Отзыв с id " + id + " не найдено")));
    }

    @Override
    public List<FeedbackDto> getAllByRestaurantId(Long restaurantId) {
        return null;
    }

    @Override
    public List<FeedbackDto> getAllByUserId(Long userId) {
        return null;
    }

    @Override
    public FeedbackDto edit(String message, Integer rate, Long id) {
        return null;
    }

    @Override
    public FeedbackDto update(FeedbackDto dto) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}

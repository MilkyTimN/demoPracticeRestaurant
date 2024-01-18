package com.example.demoPractice.service;

import com.example.demoPractice.model.dto.FeedbackDto;
import com.example.demoPractice.model.entity.Feedback;
import com.example.demoPractice.model.request.FeedbackCreateRequest;

import java.util.List;

public interface FeedbackService {

    FeedbackDto save(FeedbackCreateRequest request);
    FeedbackDto getById(Long id);
    List<FeedbackDto> getAllByRestaurantId(Long restaurantId);
    List<FeedbackDto> getAllByUserId(Long userId);
    FeedbackDto edit(String message, Integer rate, Long id);
    FeedbackDto update(FeedbackDto dto);
    Boolean delete(Long id);
}

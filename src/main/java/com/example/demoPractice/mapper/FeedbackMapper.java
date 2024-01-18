package com.example.demoPractice.mapper;

import com.example.demoPractice.model.dto.FeedbackDto;
import com.example.demoPractice.model.entity.Feedback;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FeedbackMapper extends BaseMapper<Feedback, FeedbackDto>{

    FeedbackMapper INSTANCE = Mappers.getMapper(FeedbackMapper.class);
}

package com.example.demoPractice.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FeedbackCreateRequest {

    String comment;
    Long userId;
    Long restaurantId;
    Integer rate;

}

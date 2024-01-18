package com.example.demoPractice.model.dto;

import com.example.demoPractice.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class UserDto {

    Long id;
    LocalDateTime createdDate;
    LocalDateTime updatedDate;
    Status status;
    String name;
    String password;
    int age;
    String email;
}

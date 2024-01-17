package com.example.demoPractice.controller;

import com.example.demoPractice.model.request.UserCreateRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid UserCreateRequest request) {
        return ResponseEntity.ok(request);
    }

}

package com.example.demoPractice.controller;

import com.example.demoPractice.model.request.UserCreateRequest;
import com.example.demoPractice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid UserCreateRequest request) {
        return ResponseEntity.ok(request);
    }


    @GetMapping
   public ResponseEntity<?> getById(@RequestHeader int lang, @RequestParam Long id) {
      return ResponseEntity.ok(service.getById(id, lang));
    }
}

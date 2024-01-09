package com.example.demoPractice.controller;

import com.example.demoPractice.model.request.BookCreateRequest;
import com.example.demoPractice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BookCreateRequest request) {
        return ResponseEntity.ok(service.save(request));
    }
}

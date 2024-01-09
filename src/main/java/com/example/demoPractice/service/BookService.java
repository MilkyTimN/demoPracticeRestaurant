package com.example.demoPractice.service;

import com.example.demoPractice.model.entity.Book;
import com.example.demoPractice.model.request.BookCreateRequest;

public interface BookService {

    Book save(BookCreateRequest request);
}

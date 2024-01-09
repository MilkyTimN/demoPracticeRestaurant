package com.example.demoPractice.service.impl;

import com.example.demoPractice.model.entity.Book;
import com.example.demoPractice.model.enums.Status;
import com.example.demoPractice.model.request.BookCreateRequest;
import com.example.demoPractice.repository.BookRepository;
import com.example.demoPractice.service.BookService;
import com.example.demoPractice.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final RoomService roomService;

    @Override
    public Book save(BookCreateRequest request) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate bookingDate = null;
        try {
            bookingDate = LocalDate.parse(request.bookingDate(), dateFormatter);
        } catch (Exception e) {
            System.err.println(e);
        }

        if (bookingDate == null) {
            throw new RuntimeException("LocalDate Parsing error");
        }
        Book book = Book.builder()
                .status(Status.ACTIVE)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .bookingDate(bookingDate)
                .room(roomService.getById(request.roomId()))
                .build();
        return repository.save(book);
    }
}

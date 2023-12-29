package com.example.demoPractice.service;

import com.example.demoPractice.model.entity.Room;
import com.example.demoPractice.model.request.RoomCreateRequest;
import com.example.demoPractice.repository.projections.MainPageResponseProjection;

import java.util.List;

public interface RoomService {

    Room save(RoomCreateRequest request);

    Room getById(Long id);

    List<MainPageResponseProjection> getMainPage(String city);
}

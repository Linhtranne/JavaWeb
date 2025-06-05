package com.data.service;

import com.data.entity.ScreenRoom;

import java.util.List;

public interface ScreenRoomService {
    List<ScreenRoom> getAllActiveScreenRooms();

    ScreenRoom getScreenRoomById(Long id);

    void saveScreenRoom(ScreenRoom screenRoom);

    void deleteScreenRoom(Long id);
}

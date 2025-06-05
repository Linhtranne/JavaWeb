package com.data.repository;

import com.data.entity.ScreenRoom;

import java.util.List;

public interface ScreenRoomRepository {
    List<ScreenRoom> findAllActive();

    ScreenRoom findById(Long id);

    void save(ScreenRoom screenRoom);

    void delete(ScreenRoom screenRoom);
}

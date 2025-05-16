package com.data.ss9.dao;

import com.data.ss9.model.Seat;

import java.util.List;

public interface SeatDAO {
    List<Seat> getSeatsByScreenRoom(Long screenRoomId);
    List<Long> getBookedSeatsBySchedule(Long scheduleId);
}


package com.data.ss9.service;

import com.data.ss9.model.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> getSeatsByScreenRoom(Long screenRoomId);
    List<Long> getBookedSeatsBySchedule(Long scheduleId);
}

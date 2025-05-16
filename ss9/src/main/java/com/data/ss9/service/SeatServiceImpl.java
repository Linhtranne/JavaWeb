package com.data.ss9.service;

import com.data.ss9.dao.SeatDAO;
import com.data.ss9.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatDAO seatDAO;

    @Override
    public List<Seat> getSeatsByScreenRoom(Long screenRoomId) {
        return seatDAO.getSeatsByScreenRoom(screenRoomId);
    }

    @Override
    public List<Long> getBookedSeatsBySchedule(Long scheduleId) {
        return seatDAO.getBookedSeatsBySchedule(scheduleId);
    }
}

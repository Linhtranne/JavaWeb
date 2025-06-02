package com.data.service;

import com.data.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImp implements SeatService {
    @Autowired
    private SeatRepository seatRepository;
    @Override
    public boolean addSeat(int tripId, int seatNumber, String seatType) {
        return seatRepository.addSeat(tripId, seatNumber, seatType);
    }

    @Override
    public boolean updateSeat(int tripId, int seatNumber, String seatType) {
        return seatRepository.updateSeat(tripId, seatNumber, seatType);
    }

    @Override
    public boolean deleteSeat(int tripId, int seatNumber) {
        return  seatRepository.deleteSeat(tripId, seatNumber);
    }

    @Override
    public boolean isSeatAvailable(int tripId, int seatNumber) {
        return seatRepository.isSeatAvailable(tripId, seatNumber);
    }

    @Override
    public String getSeatType(int tripId, int seatNumber) {
        return seatRepository.getSeatType(tripId, seatNumber);
    }
}

package com.data.service;

import com.data.entity.ScreenRoom;
import com.data.entity.Seat;
import com.data.repository.ScreenRoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScreenRoomServiceImp implements ScreenRoomService {

    private final ScreenRoomRepository screenRoomRepository;

    public ScreenRoomServiceImp(ScreenRoomRepository screenRoomRepository) {
        this.screenRoomRepository = screenRoomRepository;
    }
    @Override
    public List<ScreenRoom> getAllActiveScreenRooms() {
        return screenRoomRepository.findAllActive();
    }
    @Override
    public ScreenRoom getScreenRoomById(Long id) {
        return screenRoomRepository.findById(id);
    }
    @Override
    public void saveScreenRoom(ScreenRoom screenRoom) {
        if (screenRoom.getSeats() == null || screenRoom.getSeats().isEmpty()) {
            List<Seat> seats = new ArrayList<>();
            for (int i = 1; i <= screenRoom.getCapacity(); i++) {
                Seat seat = new Seat();
                seat.setSeatName("A" + i);
                seat.setStatus(true);
                seat.setScreenRoom(screenRoom);
                seats.add(seat);
            }
            screenRoom.setSeats(seats);
        }
        screenRoomRepository.save(screenRoom);
    }
    @Override
    public void deleteScreenRoom(Long id) {
        ScreenRoom screenRoom = screenRoomRepository.findById(id);
        if (screenRoom != null) {
            screenRoomRepository.delete(screenRoom);
        }
    }
}
package com.data.repository;

public interface SeatRepository {
    boolean addSeat(int tripId, int seatNumber, String seatType);
    boolean updateSeat(int tripId, int seatNumber, String seatType);
    boolean deleteSeat(int tripId, int seatNumber);
    boolean isSeatAvailable(int tripId, int seatNumber);
    String getSeatType(int tripId, int seatNumber);
}

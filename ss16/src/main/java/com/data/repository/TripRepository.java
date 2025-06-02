package com.data.repository;

import com.data.model.Trip;

import java.util.List;

public interface TripRepository {
    List<Trip> getAllTrips();
    Trip getTripById(int id);
    List<Trip> searchTripByStartAndEndPoint(String start, String end);
}

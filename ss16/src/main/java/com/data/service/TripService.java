package com.data.service;

import com.data.model.Trip;

import java.util.List;

public interface TripService {
    List<Trip> getAllTrips();
    Trip getTripById(int id);
    List<Trip> searchTripByStartAndEndPoint(String start, String end);
}

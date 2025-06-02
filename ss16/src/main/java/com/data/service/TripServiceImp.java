package com.data.service;

import com.data.repository.TripRepository;
import com.data.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImp implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.getAllTrips();
    }

    @Override
    public Trip getTripById(int id) {
        return tripRepository.getTripById(id);
    }

    @Override
    public List<Trip> searchTripByStartAndEndPoint(String start, String end) {
        return tripRepository.searchTripByStartAndEndPoint(start, end);
    }
}

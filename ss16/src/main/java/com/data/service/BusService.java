package com.data.service;

import com.data.model.Bus;

import java.util.List;

public interface BusService {
    boolean addBus(Bus bus);
    Bus getBusById(int id);
    boolean updateBus(Bus bus);
    boolean deleteBus(int id);
    List<Bus> getAllBuses();
}

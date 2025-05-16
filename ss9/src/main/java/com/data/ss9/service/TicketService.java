package com.data.ss9.service;
public interface TicketService {
    void bookTicket(Long customerId, Long scheduleId, Long seatId, Double price);
}


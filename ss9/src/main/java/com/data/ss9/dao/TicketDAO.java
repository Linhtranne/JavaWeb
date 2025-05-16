package com.data.ss9.dao;


public interface TicketDAO {
    void bookTicket(Long customerId, Long scheduleId, Long seatId, Double price);
}


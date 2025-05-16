package com.data.ss9.service;

import com.data.ss9.dao.TicketDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDAO ticketDAO;

    @Override
    public void bookTicket(Long customerId, Long scheduleId, Long seatId, Double price) {
        ticketDAO.bookTicket(customerId, scheduleId, seatId, price);
    }
}

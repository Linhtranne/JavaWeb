package com.data.ss10.controller;

import com.data.ss10.model.Seat;
import com.data.ss10.model.Ticket;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BookingController {

    @GetMapping("/bookingForm")
    public String showBookingForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "/bookingForm";
    }

    @PostMapping("/bookTicket")
    public String bookTicket(@RequestParam String movieTitle,
                             @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") Date showTime,
                             @RequestParam("seats") List<String> seatNumbers,
                             Model model) {

        double totalAmount = seatNumbers.size() * 100000;

        List<Seat> seats = new ArrayList<>();
        for(String seatNum : seatNumbers) {
            seats.add(new Seat(seatNum));
        }

        Ticket ticket = new Ticket();
        ticket.setMovieTitle(movieTitle);
        ticket.setShowTime(showTime);
        ticket.setSeats(seats);
        ticket.setTotalAmount(totalAmount);

        model.addAttribute("ticket", ticket);
        return "/bookingResult";
    }
}


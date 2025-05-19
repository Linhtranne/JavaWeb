package com.data.ss10.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket {
    private String movieTitle;
    private Date showTime;
    private List<Seat> seats;
    private double totalAmount;
}

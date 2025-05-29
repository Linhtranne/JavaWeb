package com.data.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Transaction {
    private String description;
    private double amount;
    private String type;
}

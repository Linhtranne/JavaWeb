package com.data.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private int id;
    private String productName;
    private double productPrice;
    private int quantity;
    private double totalPrice;
}


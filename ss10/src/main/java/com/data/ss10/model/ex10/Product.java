package com.data.ss10.model.ex10;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;
    private String image;
}

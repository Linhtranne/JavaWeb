package com.data.ss7.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private Double price;
    private Integer stock;
    private String description;
    private String image;

}

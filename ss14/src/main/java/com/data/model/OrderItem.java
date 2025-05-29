package com.data.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class OrderItem {
    private String username;
    private String product;
    private int quantity;
}

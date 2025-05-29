package com.data.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Order {
    private String orderId;
    private String productName;
    private int quantity;
}

package com.data.model.Ex6789;

import lombok.*;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class OrderDetail {
    private int id;
    private int orderId;
    private int productId;
    private int quantity;
    private Double currentPrice;
}

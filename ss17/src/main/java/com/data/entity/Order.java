package com.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int customerId;

    @OneToMany
    private List<CartItem> listProduct;

    private String recipientName;
    private String phoneNumber;
    private String address;
    private double totalMoney;
    private String status;
}
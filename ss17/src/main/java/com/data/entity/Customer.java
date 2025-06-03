package com.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private CustomerRole role;
    @Column(nullable = false)
    private boolean status;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
}
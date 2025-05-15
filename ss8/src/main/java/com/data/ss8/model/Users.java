package com.data.ss8.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Users {
    private int id;
    private String username;
    private String password;
    private String email;
    private double balance = 10000;
}

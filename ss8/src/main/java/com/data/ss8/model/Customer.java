package com.data.ss8.model;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private int id;
    private String name;
    private String email;
    private String gender;
    private String customerType;
}

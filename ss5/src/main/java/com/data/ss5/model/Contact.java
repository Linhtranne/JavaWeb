package com.data.ss5.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}

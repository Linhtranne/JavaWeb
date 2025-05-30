package com.data.model.Ex6789;

import lombok.*;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Orders {
    private int id;
    private int userId;
    private String recipientName;
    private String address;
    private String phoneNumber;
}

package com.data.model.Ex6789;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Review {
    private int id;
    private int productId;
    private int userId;
    private int rating;
    private String comment;
}

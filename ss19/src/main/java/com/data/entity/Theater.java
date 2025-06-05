package com.data.entity;


import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "theaters")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String theaterName;

    @NotBlank
    private String address;

    @Min(value = 1)
    private Integer numberScreenRoom;

    private boolean status;

    public String getStatus() {
        return status ? "Active" : "Inactive";
    }
}
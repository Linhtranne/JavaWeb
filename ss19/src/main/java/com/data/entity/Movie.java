package com.data.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Year;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String director;

    @Min(value = 1900)
    @Max(value = 2025)
    private Integer releaseYear;

    private String genre;

    @Min(value = 1)
    private Integer duration;

    private String language;

    @Pattern(regexp = "^(http|https)://.*$")
    private String poster;

    private boolean status;

}
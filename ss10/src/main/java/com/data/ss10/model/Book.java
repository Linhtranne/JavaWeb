package com.data.ss10.model;
import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private String description;
    private MultipartFile file;
}

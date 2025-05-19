package com.data.ss10.model;
import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UploadFile {
    private MultipartFile file;
    private String description;
    private String fileUrl;
}

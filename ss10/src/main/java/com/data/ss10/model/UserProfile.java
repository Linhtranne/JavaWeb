package com.data.ss10.model;
import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserProfile {
    private String username;
    private MultipartFile avatar;
}

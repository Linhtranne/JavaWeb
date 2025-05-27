package com.data.model;
import lombok.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employees {

    private int employeeId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String avatarUrl;
    private EmployeesStatus status;
    private Date createdAt;

}


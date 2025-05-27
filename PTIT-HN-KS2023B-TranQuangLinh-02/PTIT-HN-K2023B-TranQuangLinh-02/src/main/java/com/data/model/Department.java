package com.data.model;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {
    private int departmentId;
    private String departmentName;
    private String description;
    private DepartmentStatus status;
}

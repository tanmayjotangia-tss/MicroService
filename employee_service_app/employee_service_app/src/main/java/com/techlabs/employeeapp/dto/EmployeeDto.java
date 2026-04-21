package com.techlabs.employeeapp.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class EmployeeDto {

    private Long employeeId;
    private String name;
    private Double salary;
    private Long departmentId;
}

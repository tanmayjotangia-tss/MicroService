package com.techlabs.employeeapp.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class DepartmentDto {
    private Long departmentId;
    private String departmentName;
}

package com.techlabs.employeeapp.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class EmployeeAPIResponse {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
}

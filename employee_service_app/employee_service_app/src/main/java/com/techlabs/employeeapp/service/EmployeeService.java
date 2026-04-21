package com.techlabs.employeeapp.service;

import com.techlabs.employeeapp.dto.EmployeeAPIResponse;
import com.techlabs.employeeapp.dto.EmployeeDto;


public interface EmployeeService {

    public EmployeeDto getEmployee(Long employeeId);
    public EmployeeAPIResponse getEmployeeWithDepartment(Long employeeId);
}

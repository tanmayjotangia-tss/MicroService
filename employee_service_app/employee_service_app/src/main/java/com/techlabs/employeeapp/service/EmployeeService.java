package com.techlabs.employeeapp.service;

import com.techlabs.employeeapp.dto.EmployeeAPIResponse;
import com.techlabs.employeeapp.dto.EmployeeDto;

import java.util.List;


public interface EmployeeService {

    public EmployeeDto getEmployee(Long employeeId);
    public EmployeeAPIResponse getEmployeeWithDepartment(Long employeeId);
    public EmployeeDto changeDepartment(Long employeeId, Long departmentId);
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public List<EmployeeDto> getAllEmployees();
}

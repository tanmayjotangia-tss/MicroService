package com.techlabs.department_service.service;

import com.techlabs.department_service.dto.DepartmentDto;
import com.techlabs.department_service.dto.EmployeeDto;

import java.util.List;

public interface DepartmentService {

    public DepartmentDto getDepartment(Long departmentId);
    public List<EmployeeDto> getEmployees(Long departmentId);
}

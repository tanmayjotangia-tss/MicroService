package com.techlabs.department_service.service;

import com.techlabs.department_service.dto.DepartmentDto;
import com.techlabs.department_service.dto.EmployeeDto;
import com.techlabs.department_service.entity.Department;
import com.techlabs.department_service.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;
    private final EmployeeApiClient employeeApiClient;

    @Override
    public DepartmentDto getDepartment(Long departmentId) {
        Department department=departmentRepository.findById(departmentId)
                .orElseThrow(()->new RuntimeException("ID not found: "+departmentId));

        DepartmentDto dto=new DepartmentDto();
        dto.setDepartmentId(department.getDepartmentId());
        dto.setDepartmentName(department.getDepartmentName());
        return dto;
    }

    @Override
    public List<EmployeeDto> getEmployees(Long departmentId) {

        List<EmployeeDto> employees = employeeApiClient.getAllEmployees()
                .stream()
                .filter(employeeDto -> departmentId.equals(employeeDto.getDepartmentId()))
                .toList();

        return employees;
    }
}

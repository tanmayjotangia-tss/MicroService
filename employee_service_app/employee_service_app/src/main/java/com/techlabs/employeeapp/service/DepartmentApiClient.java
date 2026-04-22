package com.techlabs.employeeapp.service;

import com.techlabs.employeeapp.dto.DepartmentDto;
import org.springframework.web.bind.annotation.GetMapping;


public interface DepartmentApiClient {

    @GetMapping("/departments/{departmentId}")
    public DepartmentDto getDepartment(Long departmentId);
}

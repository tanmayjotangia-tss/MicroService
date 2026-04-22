package com.techlabs.employeeapp.service;

import com.techlabs.employeeapp.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080/deptapp", value = "department-service")
public interface DepartmentApiClient {

    @GetMapping("/departments/{departmentId}")
    public DepartmentDto getDepartment(@PathVariable Long departmentId);
}

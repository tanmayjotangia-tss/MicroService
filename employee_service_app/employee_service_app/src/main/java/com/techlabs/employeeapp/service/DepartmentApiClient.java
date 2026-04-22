package com.techlabs.employeeapp.service;

import com.techlabs.employeeapp.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//Before Eureka
//@FeignClient(url = "http://localhost:8080", value = "department-service")

//After Eureka
@FeignClient(name = "department-service")
public interface DepartmentApiClient {

    @GetMapping("deptapp/departments/{departmentId}")
    public DepartmentDto getDepartment(@PathVariable Long departmentId);
}

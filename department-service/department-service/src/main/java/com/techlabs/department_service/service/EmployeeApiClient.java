package com.techlabs.department_service.service;

import com.techlabs.department_service.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "employee-service-app")
public interface EmployeeApiClient {

    @GetMapping("/empapp/employees")
    public List<EmployeeDto> getAllEmployees();

}

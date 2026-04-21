package com.techlabs.employeeapp.controller;

import com.techlabs.employeeapp.dto.EmployeeAPIResponse;
import com.techlabs.employeeapp.dto.EmployeeDto;
import com.techlabs.employeeapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empapp")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long employeeId)
    {
        return ResponseEntity.ok(employeeService.getEmployee(employeeId));
    }

    @GetMapping("/employees/{employeeId}/department")
    public ResponseEntity<EmployeeAPIResponse> getEmployeeWithDepartment(@PathVariable Long employeeId)
    {
        return ResponseEntity.ok(employeeService.getEmployeeWithDepartment(employeeId));
    }
}

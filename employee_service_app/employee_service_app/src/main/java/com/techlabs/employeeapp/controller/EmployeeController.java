package com.techlabs.employeeapp.controller;

import com.techlabs.employeeapp.dto.EmployeeAPIResponse;
import com.techlabs.employeeapp.dto.EmployeeDto;
import com.techlabs.employeeapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeDto> changeDepartment(@PathVariable Long employeeId,@RequestParam Long departmentId)
    {
        return ResponseEntity.ok(employeeService.changeDepartment(employeeId, departmentId));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto)
    {
        return ResponseEntity.ok(employeeService.createEmployee(employeeDto));
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees()
    {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}

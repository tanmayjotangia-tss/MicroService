package com.techlabs.department_service.controller;

import com.techlabs.department_service.config.DeptConfig;
import com.techlabs.department_service.dto.DepartmentDto;
import com.techlabs.department_service.dto.EmployeeDto;
import com.techlabs.department_service.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deptapp")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;
    private final DeptConfig deptConfig;

    @GetMapping("/departments/{departmentId}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable Long departmentId)
    {
        return ResponseEntity.ok(departmentService.getDepartment(departmentId));
    }

    @GetMapping("departments/{departmentId}/employees")
    public ResponseEntity<List<EmployeeDto>> getEmployessByDepartmentId(@PathVariable Long departmentId)
    {
        return ResponseEntity.ok(departmentService.getEmployees(departmentId));
    }

    @GetMapping("message")
    public String getMessage(){
        return deptConfig.getMessage();
    }
}

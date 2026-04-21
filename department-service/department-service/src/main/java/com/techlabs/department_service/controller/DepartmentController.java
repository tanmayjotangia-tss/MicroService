package com.techlabs.department_service.controller;

import com.techlabs.department_service.dto.DepartmentDto;
import com.techlabs.department_service.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deptapp")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/departments/{departmentId}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable Long departmentId)
    {
        return ResponseEntity.ok(departmentService.getDepartment(departmentId));
    }


}

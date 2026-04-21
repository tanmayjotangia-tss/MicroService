package com.techlabs.department_service.service;

import com.techlabs.department_service.dto.DepartmentDto;
import com.techlabs.department_service.entity.Department;
import com.techlabs.department_service.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto getDepartment(Long departmentId) {
        Department department=departmentRepository.findById(departmentId)
                .orElseThrow(()->new RuntimeException("ID not found: "+departmentId));

        DepartmentDto dto=new DepartmentDto();
        dto.setDepartmentId(department.getDepartmentId());
        dto.setDepartmentName(department.getDepartmentName());
        return dto;
    }
}

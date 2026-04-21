package com.techlabs.department_service.service;

import com.techlabs.department_service.dto.DepartmentDto;

public interface DepartmentService {

    public DepartmentDto getDepartment(Long departmentId);
}

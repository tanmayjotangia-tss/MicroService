package com.techlabs.employeeapp.repository;

import com.techlabs.employeeapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

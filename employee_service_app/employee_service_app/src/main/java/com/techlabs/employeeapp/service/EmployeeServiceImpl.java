package com.techlabs.employeeapp.service;

import com.techlabs.employeeapp.config.EmployeeConfig;
import com.techlabs.employeeapp.dto.DepartmentDto;
import com.techlabs.employeeapp.dto.EmployeeAPIResponse;
import com.techlabs.employeeapp.dto.EmployeeDto;
import com.techlabs.employeeapp.entity.Employee;
import com.techlabs.employeeapp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
//    private final RestTemplate restTemplate;
    private final WebClient webClient;

    @Override
    public EmployeeDto getEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new RuntimeException("ID not found: "+employeeId));

        EmployeeDto dto=new EmployeeDto();
        dto.setEmployeeId(employee.getEmployeeId());
        dto.setName(employee.getName());
        dto.setSalary(employee.getSalary());
        dto.setDepartmentId(employee.getDepartmentId());
        return dto;
    }

    @Override
    public EmployeeAPIResponse getEmployeeWithDepartment(Long employeeId) {
        EmployeeDto employee=getEmployee(employeeId);
//        ResponseEntity<DepartmentDto> departments= restTemplate.getForEntity("http://localhost:8080/deptapp/departments/"+ employee.getDepartmentId(),DepartmentDto.class);

        DepartmentDto departments = webClient.get()
                .uri("http://localhost:8080/deptapp/departments/"+ employee.getDepartmentId())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        EmployeeAPIResponse response=new EmployeeAPIResponse();
        response.setEmployeeDto(employee);
        response.setDepartmentDto(departments);
        return response;
    }
}

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

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
//    private final RestTemplate restTemplate;
//    private final WebClient webClient;
    private final DepartmentApiClient departmentApiClient;
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

        // RestTemplate
//        ResponseEntity<DepartmentDto> departments= restTemplate.getForEntity("http://localhost:8080/deptapp/departments/"+ employee.getDepartmentId(),DepartmentDto.class);

        // WebClient
//        DepartmentDto departments = webClient.get()
//                .uri("http://localhost:8080/deptapp/departments/"+ employee.getDepartmentId())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        // OpenFeign
        DepartmentDto departments = departmentApiClient.getDepartment(employee.getDepartmentId());

        EmployeeAPIResponse response=new EmployeeAPIResponse();
        response.setEmployeeDto(employee);
        response.setDepartmentDto(departments);
        return response;
    }

    @Override
    public EmployeeDto changeDepartment(Long employeeId, Long departmentId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new RuntimeException("ID not found: "+employeeId));

        employee.setDepartmentId(departmentId);
        employeeRepository.save(employee);
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setName(employee.getName());
        employeeDto.setSalary(employee.getSalary());
        employeeDto.setDepartmentId(employee.getDepartmentId());
        return employeeDto;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee=new Employee();
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        employee.setDepartmentId(employeeDto.getDepartmentId());
        employeeRepository.save(employee);

        EmployeeDto employeeDto1=new EmployeeDto();
        employeeDto1.setEmployeeId(employee.getEmployeeId());
        employeeDto1.setName(employee.getName());
        employeeDto1.setSalary(employee.getSalary());
        employeeDto1.setDepartmentId(employee.getDepartmentId());
        return employeeDto1;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
         List<Employee> employees = employeeRepository.findAll();
         List<EmployeeDto> employeeDtos=new ArrayList<>();
         for(Employee employee:employees){
             EmployeeDto employeeDto=new EmployeeDto();
             employeeDto.setEmployeeId(employee.getEmployeeId());
             employeeDto.setName(employee.getName());
             employeeDto.setSalary(employee.getSalary());
             employeeDto.setDepartmentId(employee.getDepartmentId());
             employeeDtos.add(employeeDto);
         }
         return employeeDtos;
    }
}

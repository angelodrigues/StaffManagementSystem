package com.angelo.employee_service.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.angelo.employee_service.dto.APIResponseDto;
import com.angelo.employee_service.dto.DepartmentDto;
import com.angelo.employee_service.dto.EmployeeDto;
import com.angelo.employee_service.entity.Employee;
import com.angelo.employee_service.repository.EmployeeRepository;
import com.angelo.employee_service.service.APIClient;
import com.angelo.employee_service.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    // private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);

        Employee savedEmployee = employeeRepository.save(employee);

        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        //---> RestTemplate
        // ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);

        // DepartmentDto departmentDto = responseEntity.getBody();
        //---> RestTemplate
        
        //---> WebClient
        // DepartmentDto departmentDto = webClient.get()
        //         .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
        //         .retrieve()
        //         .bodyToMono(DepartmentDto.class)
        //         .block();
        //---> WebClient
        
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        return new APIResponseDto(employeeDto,departmentDto);
    }
}
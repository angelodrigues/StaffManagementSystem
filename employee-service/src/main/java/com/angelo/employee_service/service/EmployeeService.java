package com.angelo.employee_service.service;

import com.angelo.employee_service.dto.EmployeeDto;

public interface EmployeeService {    
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(Long employeeId);
}
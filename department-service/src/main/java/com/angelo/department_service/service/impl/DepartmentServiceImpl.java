package com.angelo.department_service.service.impl;

import org.springframework.stereotype.Service;

import com.angelo.department_service.dto.DepartmentDto;
import com.angelo.department_service.entity.Department;
import com.angelo.department_service.repository.DepartmentRepository;
import com.angelo.department_service.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {        
        Department department = new Department(
            departmentDto.id(),
            departmentDto.departmentName(),
            departmentDto.departmentDescription(),
            departmentDto.departmentCode()
        );

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(
            savedDepartment.getId(), 
            savedDepartment.getDepartmentName(),
            savedDepartment.getDepartmentDescription(),
            savedDepartment.getDepartmentCode());

        return savedDepartmentDto;
    }

}

package com.angelo.department_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angelo.department_service.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long>{    
}
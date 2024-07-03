package com.nitienit.employee.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitienit.employee.service.dto.EmployeeDto;
import com.nitienit.employee.service.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

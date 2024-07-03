package com.nitienit.employee.service.services;

import java.util.List;

import com.nitienit.employee.service.dto.EmployeeDto;


public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeesDto);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto getEmployeeById(Long empId);
	
	EmployeeDto updateEmployee(Long empId,EmployeeDto updateEmployeeDto);
	
	void deleteEmployee(Long empId);
}

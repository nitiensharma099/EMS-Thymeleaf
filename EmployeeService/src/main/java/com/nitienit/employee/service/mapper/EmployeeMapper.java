package com.nitienit.employee.service.mapper;

import com.nitienit.employee.service.dto.EmployeeDto;
import com.nitienit.employee.service.entity.Employee;

public class EmployeeMapper {

	public EmployeeDto mapperEmployeeToDto(Employee employees) {

		EmployeeDto  employeesDto= new  EmployeeDto(employees.getEmpId(),employees.getFirstName(),
				employees.getLastName(),employees.getEmail(),
				employees.getContactNo());

		return employeesDto;
	}

	public Employee mapperDtoToEmployee(EmployeeDto employeesDto) {
		Employee employees= new  Employee(employeesDto.getEmpId(),employeesDto.getFirstName(),
				employeesDto.getLastName(),employeesDto.getEmail(),
				employeesDto.getContactNo());
		return employees;
	}


}

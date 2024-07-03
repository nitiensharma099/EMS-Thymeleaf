package com.nitienit.employee.service.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nitienit.employee.service.dto.EmployeeDto;
import com.nitienit.employee.service.entity.Employee;
import com.nitienit.employee.service.exception.ResourceNotFoundException;
import com.nitienit.employee.service.mapper.EmployeeMapper;
import com.nitienit.employee.service.repository.EmployeeRepository;
import com.nitienit.employee.service.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	

	 EmployeeRepository employeesRepository;
	 
	public EmployeeServiceImpl(EmployeeRepository employeesRepository) {
		this.employeesRepository = employeesRepository;
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeesDto) {
		

	        System.out.println("Inside Service------------------------------");
	        Employee employees= employeesRepository.save(new Employee(employeesDto.getEmpId(),employeesDto.getFirstName(),employeesDto.getLastName(),
	        		employeesDto.getEmail(),employeesDto.getContactNo()));
	        
	        
	        EmployeeDto savedEmployeesDto = new EmployeeDto(employees.getEmpId(),employees.getFirstName(),employees.getLastName(),
	        		employees.getEmail(),employees.getContactNo());

	        return savedEmployeesDto;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		System.out.println("getAllEmployee-----------");
		List<EmployeeDto> empDtoList=new ArrayList<>();
		List<Employee> employeesList=	employeesRepository.findAll();

		for(int i=0;i<employeesList.size();i++) {
			EmployeeDto empDto=new EmployeeDto();
			
			empDto.setEmpId(employeesList.get(i).getEmpId());
			empDto.setFirstName(employeesList.get(i).getFirstName());
			empDto.setLastName(employeesList.get(i).getLastName());
			empDto.setEmail(employeesList.get(i).getEmail());
			empDto.setContactNo(employeesList.get(i).getContactNo());
			empDtoList.add(empDto);
		}

		return empDtoList;
	}

	@Override
	public EmployeeDto getEmployeeById(Long empId) {
		System.out.println("getEmployee---------");
		EmployeeDto empDto=new EmployeeDto();
		
		Optional<Employee>	emp=employeesRepository.findById(empId);
		if(emp.isPresent()) {
			empDto.setEmpId(emp.get().getEmpId());
			empDto.setFirstName(emp.get().getFirstName());
			empDto.setLastName(emp.get().getLastName());
			empDto.setEmail(emp.get().getEmail());
			empDto.setContactNo(emp.get().getContactNo());
		}
		System.out.println("empDto-----------"+ empDto);
		return empDto;
	}

	@Override
	public EmployeeDto updateEmployee(Long empId, EmployeeDto updateEmployeeDto) {
	Employee employee = employeesRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with given Id :" + empId));
	
	employee.setFirstName(updateEmployeeDto.getFirstName());
	employee.setLastName(updateEmployeeDto.getLastName());
	employee.setEmail(updateEmployeeDto.getEmail());
	employee.setContactNo(updateEmployeeDto.getContactNo());
	
	Employee updateEmployeeObj=employeesRepository.save(employee);
		
		return new EmployeeDto(updateEmployeeObj.getEmpId(),updateEmployeeObj.getFirstName(),updateEmployeeObj.getLastName(),
				updateEmployeeObj.getEmail(),updateEmployeeObj.getContactNo());
	}

	@Override
	public void deleteEmployee(Long empId) {
		Employee employee = employeesRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with given Id :" + empId));
		employeesRepository.deleteById(empId);
	}

}

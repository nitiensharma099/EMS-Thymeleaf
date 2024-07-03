package com.nitienit.employee.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nitienit.employee.service.services.EmployeeService;

@Controller
public class DeleteEmployeeController {

	Logger logger= LoggerFactory.getLogger(DeleteEmployeeController.class);
	EmployeeService employeesService;
	
	
	
	public DeleteEmployeeController(EmployeeService employeesService) {
		super();
		this.employeesService = employeesService;
		
		logger.info("[DeleteEmployeeController]");
	}

	@RequestMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") Long empId){
		
		logger.info("[DeleteEmployeeController] {deleteEmployee---}");
		
		employeesService.deleteEmployee(empId);
		return "redirect:/employeeList";
	}
}

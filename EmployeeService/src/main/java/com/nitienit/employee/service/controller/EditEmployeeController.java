package com.nitienit.employee.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nitienit.employee.service.dto.EmployeeDto;
import com.nitienit.employee.service.services.EmployeeService;

@Controller
public class EditEmployeeController {

	Logger logger= LoggerFactory.getLogger(EditEmployeeController.class);
	EmployeeService employeesService;
	
	
	
	public EditEmployeeController(EmployeeService employeesService) {
		super();
		this.employeesService = employeesService;
		
		logger.info("[EditEmployeeController]");
	}

	@GetMapping("/editEmployee/{id}")
	public ModelAndView getEmployeeById(@PathVariable("id") Long empId){
		logger.info("[EditEmployeeController] {editEmployee---}");
		EmployeeDto employeeDetail=	employeesService.getEmployeeById(empId);
		return new ModelAndView("employeeEdit","employee",employeeDetail);
	}
	
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute EmployeeDto employeesDto ){
		logger.info("[EditEmployeeController] {editEmployee---} employeesDto.getEmpId()  {}",employeesDto.getEmpId());
		EmployeeDto employeeDto=	employeesService.updateEmployee(employeesDto.getEmpId(),employeesDto);
		logger.info("[EmployeeController] : {updateEmployee()}" );
		return "redirect:/employeeList";
	}

}

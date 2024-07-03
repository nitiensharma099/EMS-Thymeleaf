package com.nitienit.employee.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nitienit.employee.service.dto.EmployeeDto;
import com.nitienit.employee.service.services.EmployeeService;

@Controller
//@RequestMapping("/api/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

	Logger logger= LoggerFactory.getLogger(EmployeeController.class);


	EmployeeService employeesService;
	
	public EmployeeController(EmployeeService employeesService) {
		this.employeesService = employeesService;
		logger.info("[EmployeeController]");
	}
	
	
	@GetMapping("/")
	public String home() {
		return "home.html";
	}
	
	@GetMapping("/employeeRegistration")
	public String employeeRegistration() {
		return "employeeRegistration.html";
	}
	
	
	@GetMapping("/employeeList")
	public ModelAndView getAllEmployee(){

		List<EmployeeDto> empDtoList=	employeesService.getAllEmployees();
		
		//ModelAndView model=new ModelAndView();
		//model.setViewName("employeeList");
		//model.addObject("employee", empDtoList);
		return new ModelAndView("employeeList","employee",empDtoList);
	}

	@PostMapping("/save")
	public String saved(@ModelAttribute EmployeeDto employeesDto){

		logger.info("[EmployeeController] : {saved()}" );
		
		employeesService.createEmployee(employeesDto);
		
		return "redirect:/employeeList";
	}

}

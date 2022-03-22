package com.liam.employee.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liam.employee.service.VOs.ResponseTemplateVO;
import com.liam.employee.service.models.Employee;
import com.liam.employee.service.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employServ;
	
	
	@PostMapping("/create")
	public Employee create(@RequestBody Employee employee) {
		return employServ.create(employee);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO findEmployeeWithCompDept(@PathVariable("id") Long employeeId) {
		return employServ.getEmployeewithDeptComp(employeeId);
	}
	
	

}

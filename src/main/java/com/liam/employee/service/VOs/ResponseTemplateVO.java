package com.liam.employee.service.VOs;

import com.liam.employee.service.models.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
	
	private Employee employee;
	
	private Department department;
	
	private Company company;

}

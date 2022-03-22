package com.liam.employee.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.liam.employee.service.VOs.Company;
import com.liam.employee.service.VOs.Department;
import com.liam.employee.service.VOs.ResponseTemplateVO;
import com.liam.employee.service.models.Employee;
import com.liam.employee.service.repositories.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private EmployeeRepository employRepo;
	
	
	public Employee create(Employee employee) {
		return employRepo.save(employee);
	}
	
	
	
	public ResponseTemplateVO getEmployeewithDeptComp(Long employeeId) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		
		Employee employee = employRepo.findByEmployeeId(employeeId);
		
//		Company company = restTemplate.getForObject("http://localhost:9006/companies/" + employee.getCompanyId() , Company.class);
//		
//		Department department = restTemplate.getForObject("http://localhost:9001/departments/" + employee.getDepartmentId(), Department.class);
		
		Company company = restTemplate.getForObject("http://COMPANY-SERVICE/companies/" + employee.getCompanyId() , Company.class);
		
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + employee.getDepartmentId(), Department.class);
		
		log.info("API-Gateway & Eureka Up and Running correctly");
		
		vo.setEmployee(employee);
		
		vo.setCompany(company);
		
		vo.setDepartment(department);
		
		return vo;
		
		
	}

}

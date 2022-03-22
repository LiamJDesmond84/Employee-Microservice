package com.liam.employee.service.VOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
	
	private Long companyId;
	
	private String companyName;
	
	private String companyLocation;

}

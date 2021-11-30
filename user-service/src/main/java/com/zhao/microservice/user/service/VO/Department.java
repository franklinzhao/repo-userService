package com.zhao.microservice.user.service.VO;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
	
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Department {

	private long departmentId;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;

}

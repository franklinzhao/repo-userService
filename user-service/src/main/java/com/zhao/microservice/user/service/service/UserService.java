package com.zhao.microservice.user.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zhao.microservice.user.service.VO.Department;
import com.zhao.microservice.user.service.VO.ResponseTemplateVO;
import com.zhao.microservice.user.service.entity.User;
import com.zhao.microservice.user.service.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {

		log.info("Inside saveUser of UserService");
		return userRepository.save(user);
	}

//get the User object with department id via connection to the Microservice of Department 
	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Inside getUserWithDepartment of UserService");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		
		// URL Of actual http://localhost:9001/departments/
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
				Department.class);
		vo.setUser(user);
		vo.setDepartment(department);

		return vo;
	}

}

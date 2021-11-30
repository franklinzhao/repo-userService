package com.zhao.microservice.user.service.VO;

import com.zhao.microservice.user.service.entity.User;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
	
	private User user;
	private Department department;

}

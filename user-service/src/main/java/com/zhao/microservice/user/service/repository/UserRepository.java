package com.zhao.microservice.user.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zhao.microservice.user.service.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	User findByUserId(Long userId);


}

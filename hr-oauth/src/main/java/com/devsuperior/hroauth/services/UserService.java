package com.devsuperior.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hroauth.feignclients.UserFeignClient;
import com.devsuperior.hroauth.feignclients.dtos.UserDTO;


@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeighClient;
	
	public UserDTO findByEmail(String email) {
		UserDTO userDTO = null;
		userDTO = userFeighClient.findByEmail(email).getBody();
		if (userDTO == null) {
			logger.error("Email not found");
		}
		logger.info("Email found: "+email);
		return userDTO;
	}

}

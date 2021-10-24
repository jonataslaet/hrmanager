package com.devsuperior.hruser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hruser.controllers.dtos.UserDTO;
import com.devsuperior.hruser.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public UserDTO findById(Long id) {
		
		return new UserDTO(userRepository.findById(id).get());
	}

	public UserDTO findByEmail(String email) {
		return new UserDTO(userRepository.findByEmail(email));
	}

}

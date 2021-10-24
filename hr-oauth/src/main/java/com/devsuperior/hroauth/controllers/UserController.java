package com.devsuperior.hroauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hroauth.feignclients.dtos.UserDTO;
import com.devsuperior.hroauth.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/search")
	public ResponseEntity<UserDTO> findByEmail(@RequestParam("email") String email) {
		try {
			UserDTO UserDTO = userService.findByEmail(email);
			return ResponseEntity.ok(UserDTO);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}

package com.devsuperior.hruser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hruser.controllers.dtos.UserDTO;
import com.devsuperior.hruser.services.UserService;

@RestController
@RefreshScope
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity <UserDTO> findById(@PathVariable Long id){
		UserDTO UserDTO = userService.findById(id);
		return ResponseEntity.ok(UserDTO);
	}
	
	@GetMapping("/search")
	public ResponseEntity <UserDTO> findByEmail(@RequestParam("email") String email){
		UserDTO UserDTO = userService.findByEmail(email);
		return ResponseEntity.ok(UserDTO);
	}
}
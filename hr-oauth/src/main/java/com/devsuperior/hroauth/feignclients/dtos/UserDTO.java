package com.devsuperior.hroauth.feignclients.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.devsuperior.hroauth.entities.Role;
import com.devsuperior.hroauth.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	private String password;

	private Set<Role> roles = new HashSet<>();

	public UserDTO() {

	}

	public UserDTO(Long id, String name, String email, String password, Set<Role> roles) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.getRoles().addAll(roles);
	}
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.getRoles().addAll(user.getRoles());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

}

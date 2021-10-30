package com.helen.employees.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.helen.employees.models.User;
import com.helen.employees.services.UserService;

@RestController
public class ApiController {
	@Autowired
	private UserService uService;
	@GetMapping("/")
	public List<User> Index() {
		List<User> users = this.uService.getAll();
		return users;
	}
	@GetMapping("/{id}")
	public User Show(@PathVariable("id") Long id) {
		User user = this.uService.getOne(id);
		return user;
	}
	

}	


package com.helen.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helen.employees.models.User;
import com.helen.employees.repositories.UserRepository;

@Service
public class UserService {
@Autowired
private UserRepository uRepo;
  
	public List<User>  getAll() {
		return this.uRepo.findAll();
	}
	
	//get one
	public User getOne(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	
	//create a new
	public User create(User user) {
		return this.uRepo.save(user);
	}
}

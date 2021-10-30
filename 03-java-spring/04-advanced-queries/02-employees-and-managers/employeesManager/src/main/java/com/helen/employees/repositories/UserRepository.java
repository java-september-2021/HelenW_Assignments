package com.helen.employees.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.helen.employees.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	List<User>  findAll();
}
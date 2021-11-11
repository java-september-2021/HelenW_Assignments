package com.dojos.ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojos.ninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo,Long>{
	List<Dojo> findAll();//select all dojos 
	boolean existsByName(String name);//to check if a dojo name already exists, to make sure each dojo name is unique 
}

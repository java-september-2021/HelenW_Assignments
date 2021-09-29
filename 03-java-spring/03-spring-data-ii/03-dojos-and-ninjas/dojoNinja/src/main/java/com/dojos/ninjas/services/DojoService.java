package com.dojos.ninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojos.ninjas.models.Dojo;
import com.dojos.ninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dRepo;
	//return all dojos
		public List<Dojo> allDojos() {
			return this.dRepo.findAll();
		}
		
		//create a new dojo
		public Dojo createDojo(Dojo dojo) {
			return this.dRepo.save(dojo);
		}
		
		//retrieve a dojo
		public Dojo getOne(Long id) {
			return this.dRepo.findById(id).orElse(null);
		}
		
		//update
		public Dojo update(Dojo dojo) {
			return this.dRepo.save(dojo);
		}
		
		//Delete
		public String delete(Long id) {
			this.dRepo.deleteById(id);
			return "Dojo has been deleted";
		}
	
}

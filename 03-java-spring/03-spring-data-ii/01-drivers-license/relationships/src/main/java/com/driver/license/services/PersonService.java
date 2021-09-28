package com.driver.license.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.license.models.Person;
import com.driver.license.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository pRepo;
	//return all persons
		public List<Person> allPersons() {
			return this.pRepo.findAll();
		}
		
		//create a new person
		public Person createPerson(Person person) {
			return this.pRepo.save(person);
		}
		
		//update
		public Person updatePerson(Person person) {
			return this.pRepo.save(person);
		}
		
		//retrieve a person
		public Person getOne(Long id) {
			return this.pRepo.findById(id).orElse(null);
		}
		
		//Delete
		public String deletePerson(Long id) {
			this.pRepo.deleteById(id);
			return "Person has been deleted";
		}
}

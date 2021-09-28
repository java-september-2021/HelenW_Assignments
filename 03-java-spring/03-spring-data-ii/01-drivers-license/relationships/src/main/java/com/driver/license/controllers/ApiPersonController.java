package com.driver.license.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.driver.license.models.Person;
import com.driver.license.services.PersonService;

@RestController
@RequestMapping("/api/persons")
public class ApiPersonController {
  @Autowired
  private PersonService pService;
  //get all persons
  @GetMapping("")
  public List<Person> index() {
	  return this.pService.allPersons();
  }
  
  //create a person
  @PostMapping("/create") 
	  public Person createP(Person person) {
		  return this.pService.createPerson(person);
	  }
  
;
//display a person
@GetMapping("/{id}") 
public Person getOnePerson(@PathVariable("id") Long id) {
	return this.pService.getOne(id);
}
}

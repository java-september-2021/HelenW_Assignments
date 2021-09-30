package com.driver.license.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.driver.license.models.Person;
import com.driver.license.services.PersonService;

@Controller
public class HomePerson {
	@Autowired
	private PersonService pService;
	

	
	
	@PostMapping("/persons/create")
	public String create(@ModelAttribute("person") Person person) {
		this.pService.createPerson(person);
		return "redirect:/persons/"+person.getId();
	}
	
	@GetMapping("/persons/new")
	public String add(@ModelAttribute("person") Person person) {
		return "addNewPerson.jsp";
	}
	//display a person
	@GetMapping("/persons/{id}")
	public String display(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("person", this.pService.getOne(id));
		return "show.jsp";
	}
}

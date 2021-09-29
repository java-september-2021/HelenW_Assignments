package com.dojos.ninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dojos.ninjas.models.Dojo;
import com.dojos.ninjas.services.DojoService;

@RestController
@RequestMapping("/api/dojos")
public class DojoControllApi {
	@Autowired
	private DojoService dService;
	
	  //get all dojos
	  @GetMapping("")
	  public List<Dojo> index() {
		  return this.dService.allDojos();
	  }
	  
	  //create a dojo
	  @PostMapping("/create") 
		  public Dojo createDojo(Dojo dojo) {
			  return this.dService.createDojo(dojo);
		  }
	  

	//display a dojo
	@GetMapping("/{id}") 
	public Dojo getOneDojo(@PathVariable("id") Long id) {
		return this.dService.getOne(id);
	}

	//delete a lang
	 @DeleteMapping("/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		 return this.dService.delete(id);
	 }
	 
	 //update
	 @PutMapping("{id}/update") 
	 public Dojo update(@PathVariable("id") Long id, Dojo dojo) {
		 return this.dService.update(dojo);
	 }
}

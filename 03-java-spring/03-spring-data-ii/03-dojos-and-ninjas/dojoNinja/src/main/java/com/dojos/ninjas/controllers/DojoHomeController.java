package com.dojos.ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojos.ninjas.models.Dojo;
import com.dojos.ninjas.services.DojoService;

@Controller
public class DojoHomeController {
	@Autowired
	private DojoService dService;
	
	//index page
	@GetMapping("") 
	public String welcome() {
		return "welcome.jsp";
	}
	
	//show all dojos
		@GetMapping("/dojos") 
		public String index(Model viewModel) {
			List<Dojo> dojos = this.dService.allDojos();
			viewModel.addAttribute("dojos", dojos);
			return "index.jsp";
		}
		
		@GetMapping("/dojos/new")
		public String add(@ModelAttribute("dojo") Dojo dojo) {
			return "add.jsp";
		}
		
		@PostMapping("/dojos/create")
		public String addRecord(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
			if(result.hasErrors()) {
				return "add.jsp";
			}
			this.dService.createDojo(dojo);
			return "redirect:/dojos";
		}
		
		//display one dojo
		@GetMapping("/dojos/{id}") 
		public String getOneDojo(@PathVariable("id") Long id, Model viewModel) {
			viewModel.addAttribute("dojo", this.dService.getOne(id));
			return "show.jsp";
		}
}

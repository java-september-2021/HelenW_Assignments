package com.dojos.ninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojos.ninjas.models.Ninja;
import com.dojos.ninjas.services.DojoService;
import com.dojos.ninjas.services.NinjaService;

@Controller
public class NinjaController {
	@Autowired
	private DojoService dService;
	@Autowired
	private NinjaService nService;
	
	// localhost:8080/ninjas/new
	@GetMapping("/ninjas/new")
	public String create(@ModelAttribute("ninja") Ninja ninja, Model viewModel) {
		viewModel.addAttribute("dojos", this.dService.allDojos());
		return "/ninja/addNinja.jsp";
	}
	
	@PostMapping("/ninjas/newninja")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		Long idDojo = ninja.getDojoNinja().getId();
		if(result.hasErrors()) {
			return "/ninja/addNinja.jsp";
		}
		this.nService.create(ninja);
		return "show.jsp" ;
	}
}

package com.driver.license.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.driver.license.models.License;
import com.driver.license.models.Person;
import com.driver.license.services.LicenseService;
import com.driver.license.services.PersonService;

@Controller
public class HomeLicense {
	@Autowired

	private PersonService pService;
	private LicenseService lService;
	
	@GetMapping("/licenses/new")
	public String new(@ModelAttribute("license") License license, @Model viewModel) {
		viewModel.addAttribute("persons", this.pService.allPersons());
		return "addLicense.jsp";
	}
	
	
	
	@GetMapping("/licenses/create")
	public String create(@ModelAttribute("license") License license) {
		this.lService.createLicense(license);
		return "redirect:/persons/"+license.getPerson().getId();
	}
	
	
	
}

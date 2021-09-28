package com.driver.license.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.driver.license.models.License;

import com.driver.license.services.LicenseService;

@RestController
@RequestMapping("/api/licenses")
public class ApiLicense {
	@Autowired
	private LicenseService lService;
	 //get all licenses
	  @GetMapping("")
	  public List<License> index() {
		  return this.lService.allLicenses();
	  }
	  
	  //create a license
	  @PostMapping("/create") 
		  public License createL(License license) {
			  return this.lService.createLicense(license);
		  }
	  
	;
	//display a license
	@GetMapping("/{id}") 
	public License getOneLicense(@PathVariable("id") Long id) {
		return this.lService.getOne(id);
	}
	
}

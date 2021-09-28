package com.driver.license.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.license.models.License;

import com.driver.license.repositories.LicenseRepository;

@Service
public class LicenseService {
  @Autowired
  private LicenseRepository lRepo;
//return all licenses
		public List<License> allLicenses() {
			return this.lRepo.findAll();
		}
		
		//create a new license
		public License createLicense(License license) {
			return this.lRepo.save(license);
		}
		
		//update
		public License updateLicense(License license) {
			return this.lRepo.save(license);
		}
		
		//retrieve a license
		public License getOne(Long id) {
			return this.lRepo.findById(id).orElse(null);
		}
		
		//Delete
		public String deleteLicense(Long id) {
			this.lRepo.deleteById(id);
			return "License has been deleted";
		}
 
}

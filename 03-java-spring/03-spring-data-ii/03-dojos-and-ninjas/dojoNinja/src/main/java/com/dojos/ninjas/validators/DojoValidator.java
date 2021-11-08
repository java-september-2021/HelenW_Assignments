package com.dojos.ninjas.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.dojos.ninjas.models.Dojo;
import com.dojos.ninjas.repositories.DojoRepository;

@Component
public class DojoValidator {
	@Autowired
	//do not need implements interface Validator here because there is a validation dependency already.
	private DojoRepository dRepo;


    public boolean supports(Class<?> clazz) {
        return Dojo.class.equals(clazz);
    }
    
    public void validate(Object target, Errors errors) {
        //need type cast here
        Dojo dojo = (Dojo) target;
        
       if(dRepo.existsByName(dojo.getName())) {
    	   errors.rejectValue("name", "UniqueDojoName", "Dojo Name must be unique, please choose another one");
       }
        
        
        
        
    }	
}

package com.user.project.validators;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.user.project.models.User;
import com.user.project.repositories.UserRepository;

@Component
public class UserValidator implements Validator{
	@Autowired
	private UserRepository userRepository;
	
	 // 1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match","Password does not match!");
        }  
        
        
        if (userRepository.findByEmail(user.getEmail())!= null) {
        	errors.rejectValue("email", "Unique","Email already exists!!");
        }
    }	
}

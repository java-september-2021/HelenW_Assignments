package com.user.project.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.user.project.models.User;
import com.user.project.services.UserService;
import com.user.project.validators.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @GetMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
    		return "registrationPage.jsp";
    	}
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	this.userService.registerUser(user);
    	session.setAttribute("userId", user.getId());
    	return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
    		HttpSession session, RedirectAttributes redirectAtt) {
        // if the user is authenticated, save their user id in session
    	if (userService.authenticateUser(email, password)) {
    		session.setAttribute("userId", userService.findByEmail(email).getId());
    		return "homePage.jsp";
    		
    	}
        // else, add error messages and return the login page
    	redirectAtt.addFlashAttribute("error","Invalid email/password");
    
    	return "redirect:/login";
    }
    
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long loggedId = (Long) session.getAttribute("userId");
    	model.addAttribute("user",userService.findUserById(loggedId));
    	return "homePage.jsp";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/login";
        // invalidate session
        // redirect to login page
    }

}

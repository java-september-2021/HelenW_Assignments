package com.example.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CountController {
	@GetMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
            // Use setAttribute to initialize the count in session
			 session.setAttribute("count", 0);
        }
		else {
            // increment the count by 1 using getAttribute and setAttribute
			Integer currentVal = (Integer) session.getAttribute("count");
			session.setAttribute("count",  ++currentVal);
        }
		return "index.jsp";
	}
	
	@GetMapping("/counter")
	public String count(HttpSession session, Model model) {
		  Integer currentCount = (Integer) session.getAttribute("count");
	        model.addAttribute("countToShow", currentCount);
	        
	        return "counter.jsp";
	}
	
	@GetMapping("/reset") 
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}

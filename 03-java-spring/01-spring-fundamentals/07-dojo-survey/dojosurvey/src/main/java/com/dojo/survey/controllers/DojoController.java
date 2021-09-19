package com.dojo.survey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoController {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@PostMapping("/submit")
	public String submit(@RequestParam(value="name") String name, 
						@RequestParam(value="location") String location,
						@RequestParam(value="fav") String fav,
						@RequestParam(value="comment") String comment,
						Model model,HttpSession session) {
//		model.addAttribute("name",name);
//		model.addAttribute("location",location);
//		model.addAttribute("fav", fav);
//		model.addAttribute("comment", comment);
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("fav", fav);
		session.setAttribute("comment", comment);
		System.out.println(name);
		System.out.println(location);
		System.out.println(fav);
		System.out.println(comment);
		return "redirect:/result";
	}
	
	@GetMapping("/result") 
	public String result(HttpSession session) {
	
//		String name = (String) session.getAttribute("name");
//		String location = (String) session.getAttribute("location");
//		String fav = (String) session.getAttribute("fav");
//		String comment = (String) session.getAttribute("comment");
		return "result.jsp";
	}
	
 }

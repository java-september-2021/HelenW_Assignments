package com.example.routing.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
@RequestMapping("/dojo") 
	public String dojo() {
		return "The dojo is awesome";
	}

@RequestMapping("/dojo/{name}")
public String awesome(@PathVariable("name") String pathname) {
	System.out.println(pathname);
	if (pathname.equals("burbank")) {
		return "Burbank Dojo is located in southern California.";
	}
	else if (pathname.equals("san-jose")) {
		return "San jose dojo is the headquarters.";
	}
	else 
	{return "The dojo is awesome";}
	
}
}

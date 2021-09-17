package com.example.displayDate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("") 
	public String dashboard() {
		return "index.jsp";
	}
	
	@RequestMapping("/date") 
	public String date(Model model) {
		SimpleDateFormat dateVal = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, YYYY");
		model.addAttribute("date", dateVal.format(new java.util.Date()));
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		Date timeVal = new Date();
		model.addAttribute("time", timeVal);
	return "time.jsp";
}
}
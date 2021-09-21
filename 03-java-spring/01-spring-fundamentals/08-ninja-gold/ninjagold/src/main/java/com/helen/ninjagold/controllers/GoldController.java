package com.helen.ninjagold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
	@GetMapping("/")
	public String index(HttpSession session, Model viewModel) {
		if (session.getAttribute("totalgold") == null) {
			session.setAttribute("totalgold", 0);
		}
		ArrayList<String> acts = new ArrayList<String>();
		if (session.getAttribute("activities")==null) {
			session.setAttribute("activities", acts);
		}
		viewModel.addAttribute("totalgold", session.getAttribute("totalgold"));
		viewModel.addAttribute("actsss", session.getAttribute("activities"));
		
		
		return "index.jsp";
	}
	
	@PostMapping("/findgold") 
	public String gold(@RequestParam(value="building") String building, HttpSession session) {
		System.out.println(building);
		Random r = new Random();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd Y h:mma");
		
		ArrayList<String> activites = (ArrayList<String>)session.getAttribute("activities");
		int currentgold = 0;
		if (building.equals("farm")) {
			currentgold = r.nextInt(20 + 1 - 10) + 10;
			activites.add(String.format("You entered %s and earn %s gold %s", building,currentgold,formatter.format(now)));
			//do farm stuff
		} else if (building.equals("cave")) {
			//do cave stuff
			 currentgold = r.nextInt(10 + 1 - 5) + 5;
			 activites.add(String.format("You entered %s and earn %s gold %s", building,currentgold,formatter.format(now)));
		} else if (building.equals("house")) {
			//do house stuff
			currentgold = r.nextInt(5 + 1 - 2) + 2;
			activites.add(String.format("You entered %s and earn %s gold %s", building,currentgold,formatter.format(now)));
		} else if (building.equals("casino")) {
			//do casino stuff
			currentgold = r.nextInt(50 + 1 + 50) - 50;
			if (currentgold < 0 ) {
				activites.add(String.format("You entered %s and lose %s gold, ouch!!! %s", building,-currentgold,formatter.format(now)));
			}
			else {
				activites.add(String.format("You entered %s and earn %s gold %s", building,currentgold,formatter.format(now)));
			}
		}
		else {
			System.out.println("Not recognizing the location");
			return "redirect:/";
		}
		System.out.println(currentgold);
		System.out.println(activites);
		int tempTotalGold = (int) session.getAttribute("totalgold");
		int goldsum = tempTotalGold += currentgold;
		session.setAttribute("totalgold", goldsum);
		session.setAttribute("activities", activites);
		
		
		return "redirect:/";
	}
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}

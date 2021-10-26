package com.helen.survey.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.helen.survey.models.Survey;
import com.helen.survey.services.SurveyService;

@Controller
public class DojoHomeController {
	@Autowired
	private SurveyService sService;

	private String[] allLanguages() {
		return new String[] { "C#", "Java", "Python", "C++" };
	}

	private String[] allLocations() {
		return new String[] { "Seattle", "Dallas", "San Jose", "Chicago", "Tulsa" };
	}

	@GetMapping("/")
	public String Index(Model model, @ModelAttribute("survey") Survey survey) {
		model.addAttribute("locations", allLocations());
		model.addAttribute("languages", allLanguages());
		return "index.jsp";
	}

	@PostMapping("/result")
	public String newS(@Valid @ModelAttribute("survey") Survey survey, BindingResult result, 
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("locations", allLocations());
			model.addAttribute("languages", allLanguages());
			return "index.jsp";

		} else {

			sService.createS(survey);
			System.out.println(survey);
			return "redirect:/show/" + survey.getId();
		}
		
	}

	@GetMapping("/show/{id}")
	public String detail(Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("result", sService.getOneS(id));
		return "display.jsp";
	}
}

package com.helen.overflow.controllers;

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

import com.helen.overflow.models.Question;
import com.helen.overflow.services.QuestionService;
import com.helen.overflow.services.TagService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService qService;
	
	@Autowired
	private TagService tService;
	
	
	@GetMapping("/questions") 
	public String dashboard(Model  viewModel) {
	 viewModel.addAttribute("questions", this.qService.allQuestions());
		return "dashboard.jsp";
	}
	
	//display a blank form 
	@GetMapping("/questions/new")
	public String addNew(@ModelAttribute("question") Question question) {
		
			return "newQuestion.jsp";
	
	
	}
	
	@PostMapping("/questions/create")
	public String addNewQuestion(@Valid @ModelAttribute("question") Question quesion,
				BindingResult result, RedirectAttributes redir) {
		if (result.hasErrors()) {
			return "newQuestion.jsp";
		}
		
		return "redirect:/questions";
	}
}

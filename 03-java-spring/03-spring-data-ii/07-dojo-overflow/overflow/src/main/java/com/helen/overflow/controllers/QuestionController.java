package com.helen.overflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.helen.overflow.models.Answer;
import com.helen.overflow.models.Question;
import com.helen.overflow.models.Tag;
import com.helen.overflow.services.QuestionService;
import com.helen.overflow.services.TagService;
import com.helen.overflow.validators.QuestionValidator;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService qService;
	
	@Autowired
	private TagService tService;
	
	@Autowired
	private QuestionValidator qValidator;
	
	
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
	public String addNewQuestion(@Valid @ModelAttribute("question") Question question, 
				BindingResult result) {
		qValidator.validate(question, result);
		if (result.hasErrors()) {
			return "newQuestion.jsp";
		}
		
		Question newQ = qService.createQ(question);
		System.out.println(newQ);
		String[] taglist = question.getTempTags().split(", ");
		System.out.println(taglist.length);
		for(int i=0; i < taglist.length; i++) {
			//return a newly created tag or an old tag
			Tag newTag = this.tService.findBySubject(taglist[i]);
			System.out.println("tag has been generated");
				
			this.qService.tagToQuestion(newQ, newTag);
		}
		
		return "redirect:/questions";
	}
	
	//display one question
	@GetMapping("/questions/{id}")
	public String oneQuestion(@ModelAttribute("answer") Answer answer,@PathVariable("id") Long id, Model viewModel) {
		Question thisQuestion = qService.getOneQ(id);
		viewModel.addAttribute("question", thisQuestion);
		return "details.jsp";
	}
}

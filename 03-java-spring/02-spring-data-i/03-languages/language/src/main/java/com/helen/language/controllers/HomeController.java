package com.helen.language.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.helen.language.models.Language;
import com.helen.language.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class HomeController {
	@Autowired

	private LanguageService langService;
	
	//show all books
	@GetMapping("") 
	public String index(@ModelAttribute("language") Language language,Model viewModel) {
		List<Language> langs = this.langService.allLangs();
		viewModel.addAttribute("langs", langs);
		return "index.jsp";
	}
	
	 
    @PostMapping("")
	    //object with filled in data
	    public String createNewLang(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
	        if (result.hasErrors()) {
	            return "index.jsp";
	        } else {
	            this.langService.createLang(lang);
	            return "redirect:/languages";
	        }
	 }
	
	//display one language
	@GetMapping("/{id}") 
	public String getOneLang(@PathVariable("id") Long id,@ModelAttribute("lang") Language lang, Model viewModel) {
		viewModel.addAttribute("lang", this.langService.getOne(id));
		return "show.jsp";
	}
	
	//delete a language
	@GetMapping("/{id}/delete") 
	public String deleteLang(@PathVariable("id") Long id) {
		this.langService.deleteLang(id);
		return "redirect:/languages";
		
	}
	
	//update a language
	@GetMapping("/{id}/edit") 
	public String edit(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("language", this.langService.getOne(id));
		return "edit.jsp";
	}
	
	@PostMapping("/{id}/edit") 
	public String update(@Valid @ModelAttribute("language") Language language,BindingResult result,@PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			this.langService.updateLang(language);
			return "redirect:/languages/"+id;
		}
		
	}
}
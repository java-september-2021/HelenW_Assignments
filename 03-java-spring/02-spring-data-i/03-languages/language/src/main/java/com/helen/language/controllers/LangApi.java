package com.helen.language.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helen.language.models.Language;
import com.helen.language.services.LanguageService;

@RestController
@RequestMapping("/api/languages")
public class LangApi {
  @Autowired
  private LanguageService langService;
  
  //get all languages
  @GetMapping("")
  public List<Language> index() {
	  return this.langService.allLangs();
  }
  
  //create a lang
  @PostMapping("/create") 
	  public Language createLang(Language lang) {
		  return this.langService.createLang(lang);
	  }
  

//display a language page
@GetMapping("/{id}") 
public Language getOneLang(@PathVariable("id") Long id) {
	return this.langService.getOne(id);
}

//delete a lang
 @DeleteMapping("/{id}/delete")
public String destroy(@PathVariable("id") Long id) {
	 return this.langService.deleteLang(id);
 }
 
 //update
 @PutMapping("{id}/update") 
 public Language update(@PathVariable("id") Long id, Language lang) {
	 return this.langService.updateLang(lang);
 }
}
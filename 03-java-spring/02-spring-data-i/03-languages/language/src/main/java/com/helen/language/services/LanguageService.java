package com.helen.language.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helen.language.models.Language;
import com.helen.language.repositories.LanguageRepository;

@Service
public class LanguageService {
	@Autowired
	
	private LanguageRepository lRepo;
	//return all languages
	public List<Language> allLangs() {
		return this.lRepo.findAll();
	}
	
	//create a new language
	public Language createLang(Language lang) {
		return this.lRepo.save(lang);
	}
	
	//update
	public Language updateLang(Language lang) {
		return this.lRepo.save(lang);
	}
	
	//retrieve a language
	public Language getOne(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	//Delete
	public String deleteLang(Long id) {
		this.lRepo.deleteById(id);
		return "Language has been deleted";
	}
}

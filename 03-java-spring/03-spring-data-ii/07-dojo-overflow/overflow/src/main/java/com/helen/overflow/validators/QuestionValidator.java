package com.helen.overflow.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.helen.overflow.models.Question;

import com.helen.overflow.repositories.QuestionRepository;
import com.helen.overflow.repositories.TagRepository;

@Component
public class QuestionValidator {
	@Autowired
	private QuestionRepository qRepo;
	
	@Autowired
	private TagRepository tRepo;
	
	 public boolean supports(Class<?> clazz) {
	        return Question.class.equals(clazz);
	    }
	 
	 
	 public void validate(Object target, Errors errors) {
			Question question = (Question) target;
			String[] tags = question.getTempTags().split(", ");
			if(tags.length > 3) {
				
				errors.rejectValue("tempTags", "threeTags", "Only 3 tags are allowed per question.");
			}
			
			for (String tag: tags) {
				char[] tagChArr = tag.toCharArray();
				for (char tagCh: tagChArr) {
					//isUpperCase applied on array of character
					if (Character.isUpperCase(tagCh)) {
						errors.rejectValue("tempTags", "mustLowerCase", "Tags must be lowercased.");
					}
				}
				
			}
		}
	 
	    
}

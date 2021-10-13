package com.helen.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helen.overflow.models.Question;
import com.helen.overflow.models.Tag;
import com.helen.overflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository qRepo;
	
	//all questions
	public List<Question>  allQuestions() {
		return qRepo.findAll();
	}
	
	//create a question
	public Question createQ(Question question) {
		return this.qRepo.save(question);
	}
	
	//add tag to question
	public void tagToQuestion(Question question, String tag) {
		List<Tag> currentTags = question.getTagsForQuestion();
		currentTags.add(tag);
		this.qRepo.save(question);
	}
}

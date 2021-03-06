package com.helen.overflow.services;

import java.util.ArrayList;
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
	
	//one question
	public Question getOneQ(Long id) {
		return qRepo.findById(id).orElse(null);
	}
	
	//create a question
	public Question createQ(Question question) {
		return this.qRepo.save(question);
	}
	
	//add tag to question
	public void tagToQuestion(Question question, Tag tag) {
		//Oct 14, 2021, instructor Matt help me fix this null issue,
		//must create an empty arrayList if it is a blank one
		if (question.getTagsForQuestion() == null) {
			ArrayList<Tag> tags = new ArrayList<Tag>();
			question.setTagsForQuestion(tags);
		}

		List<Tag> currentTags = question.getTagsForQuestion();
		
		currentTags.add(tag);
		this.qRepo.save(question);
	}
}

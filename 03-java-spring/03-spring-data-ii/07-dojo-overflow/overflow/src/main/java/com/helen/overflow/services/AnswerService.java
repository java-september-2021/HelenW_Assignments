package com.helen.overflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helen.overflow.models.Answer;
import com.helen.overflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository aRepo;
	
	public Answer createR(Answer answer) {
		return this.aRepo.save(answer);
	}
}

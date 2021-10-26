package com.helen.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helen.survey.Repositories.SurveyRepository;
import com.helen.survey.models.Survey;

@Service
public class SurveyService {
@Autowired
private SurveyRepository sRepo;
    //create a survey
   public Survey createS(Survey survey) {
	   return this.sRepo.save(survey);
   }
   
   //get one
   public Survey getOneS(Long id) {
	   return this.sRepo.findById(id).orElse(null);
   }
}

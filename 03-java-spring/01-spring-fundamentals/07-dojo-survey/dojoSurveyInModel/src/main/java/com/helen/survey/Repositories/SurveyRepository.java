package com.helen.survey.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.helen.survey.models.Survey;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {
	List<Survey>  findAll();
}

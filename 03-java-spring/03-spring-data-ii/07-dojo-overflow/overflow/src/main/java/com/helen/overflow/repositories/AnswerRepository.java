package com.helen.overflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.helen.overflow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

}

package com.events.belt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.events.belt.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message,Long>{

}

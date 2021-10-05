package com.events.belt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.belt.models.Message;
import com.events.belt.repositories.MessageRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepository mRepo;
	
	//create a message
	public Message createMessage(Message message) {
		return this.mRepo.save(message);
	}
}

package com.events.belt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.belt.models.Event;
import com.events.belt.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eRepo;
	
	//create an event
	public Event createEvent(Event event) {
		return this.eRepo.save(event);
	}
	
	//edit event
	public Event editEvent(Event event) {
		return this.eRepo.save(event);
	}
	
	//retrieve one event
	public Event showEvent(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	
}

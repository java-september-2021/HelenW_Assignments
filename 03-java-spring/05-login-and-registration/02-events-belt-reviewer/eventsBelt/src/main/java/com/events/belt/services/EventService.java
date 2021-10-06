package com.events.belt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.belt.models.Event;
import com.events.belt.models.User;
import com.events.belt.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eRepo;
	
	//all events 
		public List<Event> allEvents() {
			return this.eRepo.findAll();
		}
	
	//all events in the state
	public List<Event> eventsInState(String state) {
		return this.eRepo.findByState(state);
	}
	
	//events held in other state
	public List<Event> otherEvents(String state) {
		return this.eRepo.findByStateIsNot(state);
	}
	
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
	
	//delete event
	public String deleteEvent(Long id) {
		this.eRepo.deleteById(id);
		return "this event has been deleted";
	}
	
	//join event
	public void joinEvent(Event event, User user) {
		List<User> usersWhoJoin = event.getUsersJoined();
		usersWhoJoin.add(user);
		this.eRepo.save(event);
	}
	
	
	
	//cancel event
	public void canelEvent(Event event, User user) {
		List<User> usersWhoJoin = event.getUsersJoined();
		usersWhoJoin.remove(user);
		this.eRepo.save(event);
	}
}

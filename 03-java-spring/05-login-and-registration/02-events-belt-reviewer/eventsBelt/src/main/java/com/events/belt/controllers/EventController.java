package com.events.belt.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.events.belt.models.Event;
import com.events.belt.models.Message;
import com.events.belt.models.State;
import com.events.belt.models.User;
import com.events.belt.services.EventService;
import com.events.belt.services.MessageService;
import com.events.belt.services.UserService;

@Controller
public class EventController {
	@Autowired
	private EventService eService;

	@Autowired
	private UserService uService;

	@Autowired
	private MessageService mService;
	

	

	// get all events
	@GetMapping("/events")
	public String events(@ModelAttribute("newEvent") Event event, Model viewModel, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			Long userId = (Long) session.getAttribute("userId");
			User loggedInUser = this.uService.findUserById(userId);
			List<Event> eventsInState = this.eService.eventsInState(loggedInUser.getState());
			List<Event> eventsOutState = this.eService.otherEvents(loggedInUser.getState());
//			List<Event>  events = this.eService.allEvents();
			System.out.println(loggedInUser.getState());
//			System.out.println(eventsInState);
//			System.out.println(eventsOutState);
			

			viewModel.addAttribute("eventsInState", eventsInState);
			viewModel.addAttribute("eventsOutState", eventsOutState);
			viewModel.addAttribute("states", State.states);

			viewModel.addAttribute("user", loggedInUser);
			return "events.jsp";
		}
		return "redirect:/";

	}

	// create event
	@PostMapping("/events/create")
	public String createEve(@Valid @ModelAttribute("newEvent") Event event, BindingResult result, Model viewModel,
			HttpSession session) {

		if (result.hasErrors()) {
			//by copying the same thing as above from GetMapping :/events, the content in both tables, in state drop down menu, 
			//the loggedInUser name keep displaying, or else, they won't display
			Long userId = (Long) session.getAttribute("userId");
			User loggedInUser = this.uService.findUserById(userId);
			List<Event> eventsInState = this.eService.eventsInState(loggedInUser.getState());
			List<Event> eventsOutState = this.eService.otherEvents(loggedInUser.getState());
			viewModel.addAttribute("eventsInState", eventsInState);
			viewModel.addAttribute("eventsOutState", eventsOutState);
			viewModel.addAttribute("states", State.states);

			viewModel.addAttribute("user", loggedInUser);
			
			return "events.jsp";
		} else {
			Long userId = (Long) session.getAttribute("userId");
			User loggedInUser = this.uService.findUserById(userId);
			event.setEventCreator(loggedInUser);
			eService.createEvent(event);
			return "redirect:/events";
		}

	}

	// edit event
	@GetMapping("/events/{eventId}/edit")
	public String editRecord(@ModelAttribute("event") Event event, @PathVariable("eventId") Long id,  Model viewModel,
			HttpSession session) {
		viewModel.addAttribute("userId", (Long) session.getAttribute("userId"));
		//problem
		viewModel.addAttribute("event", this.eService.showEvent(id));
		System.out.println("getting event ID");
		System.out.println(id);
		
		viewModel.addAttribute("states", State.states);
		return "editEvent.jsp";
	}

	// update event
	@PostMapping("/events/{eventId}/edit")
	public String edit(@Valid @ModelAttribute("event") Event event, BindingResult result,
			@PathVariable("eventId") Long id, Model viewModel, HttpSession session) {
		if (result.hasErrors()) {
			Event thisEvent = this.eService.showEvent(id);
//			System.out.println(id);
//			viewModel.addAttribute("event", thisEvent);
			viewModel.addAttribute("states", State.states);
			return "editEvent.jsp";
		}
		System.out.println("event ID for postMapping");
		event.setEventCreator(uService.findUserById((Long) session.getAttribute("userId")));
		System.out.println(event.getId());
		this.eService.editEvent(event);
		return "redirect:/events";
	}

	// display event
	@GetMapping("/events/{eventId}")
	public String displayEvent(@PathVariable("eventId") Long id, Model viewModel,
			@ModelAttribute("message") Message message, HttpSession session) {
		Event thisEvent = eService.showEvent(id);
		viewModel.addAttribute("event", thisEvent);
		List<Message> messagesForThisEvent = thisEvent.getMessagesForEvent();
		viewModel.addAttribute("messages", messagesForThisEvent);
//		System.out.println(messagesForThisEvent);
		return "oneEvent.jsp";
	}

	// delete event
	@GetMapping("/events/{eventId}/delete")
	public String deleteEven(@PathVariable("eventId") Long id) {
		this.eService.deleteEvent(id);
		return "redirect:/events";
	}

	// create a comment
	@PostMapping("/events/{eventId}/message")
	public String postComment(@ModelAttribute("message") Message message, @PathVariable("eventId") Long id,
			HttpSession session, Model viewModel) {
		//only logged in user can leave a message for certain event
		if (session.getAttribute("userId") != null) {
			viewModel.addAttribute("userId", (Long) session.getAttribute("userId"));
			Event thisEvent = eService.showEvent(id);
			User loggedUser = uService.findUserById((Long) session.getAttribute("userId"));
			
			//one message is posted by a logged in user for a specific event.
			message.setEventHasMessages(thisEvent);
			message.setMessageOwner(loggedUser);
			mService.createMessage(message);
			
			


			return "redirect:/events/" + thisEvent.getId();
		}
		return "redirect:/";
	}
	
	//join event
	@GetMapping("/events/{eventId}/join")
	public String join(@PathVariable("eventId") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User user = uService.findUserById(userId);
		Event thisEvent = eService.showEvent(id);
		eService.joinEvent(thisEvent, user);
		return "redirect:/events";
	}
	
	//cancel event
	@GetMapping("/events/{eventId}/cancel")
	public String cancel(@PathVariable("eventId") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User user = uService.findUserById(userId);
		Event thisEvent = eService.showEvent(id);
		eService.canelEvent(thisEvent, user);
		return "redirect:/events";
	}
	

}
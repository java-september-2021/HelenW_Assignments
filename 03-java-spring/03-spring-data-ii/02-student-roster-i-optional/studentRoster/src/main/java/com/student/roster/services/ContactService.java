package com.student.roster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.roster.models.Contact;
import com.student.roster.repositories.ContactRepository;

@Service
public class ContactService {
	@Autowired
	
	public ContactRepository cRepo;
	//get all
	
	
	public Contact createContact(Contact contact) {
		return this.cRepo.save(contact);
	}
}

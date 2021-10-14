package com.helen.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helen.overflow.models.Tag;
import com.helen.overflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tRepo;
	
	//all tags
	public List<Tag> allTags() {
		return this.tRepo.findAll();
	}
	
	//create new tag
	public Tag createT(Tag tag) {
		return this.tRepo.save(tag);
	}
	
	//to check if a tag is present	
	public boolean tagPresent(String tag) {
		return tRepo.existsBySubject(tag);
	}
	
	public Tag findBySubject(String subject) {
		Tag tagToAdd = this.tRepo.findBySubject(subject).orElse(null);
		if(tagToAdd == null) {
			tagToAdd = new Tag(subject);
			return this.tRepo.save(tagToAdd);
		}
		return tagToAdd;
	}

}

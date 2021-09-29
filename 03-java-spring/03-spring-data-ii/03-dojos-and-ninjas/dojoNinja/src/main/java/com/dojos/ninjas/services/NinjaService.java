package com.dojos.ninjas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojos.ninjas.models.Ninja;
import com.dojos.ninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository nRepo;
	public Ninja create(Ninja ninja) {
		return this.nRepo.save(ninja);
	}
}

package com.student.roster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.roster.models.Student;
import com.student.roster.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	
	public StudentRepository sRepo;
	//get all
	public List<Student> allStudents() {
		return this.sRepo.findAll();
	}
	
	public Student createStudent(Student student) {
		return this.sRepo.save(student);
	}
}

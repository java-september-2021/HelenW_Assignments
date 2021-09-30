package com.student.roster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.roster.models.Contact;
import com.student.roster.models.Student;
import com.student.roster.services.ContactService;
import com.student.roster.services.StudentService;

@Controller
public class HomeController {
  @Autowired
  public StudentService sService;
  @Autowired
  public ContactService cService;
  
  @GetMapping("/")
  public String welcome() {
	  return "welcome.jsp";
  }
  //get all students
  @GetMapping("/students")
 public String allStudents(Model viewModel) {
	 List<Student> students = this.sService.allStudents();
	 viewModel.addAttribute("students", students);
	 return "allStudents.jsp";
 }
  
  @GetMapping("/students/new")
	public String add(@ModelAttribute("student") Student student) {
		return "addstudent.jsp";
	}
 @PostMapping("/students/create")
 public String newStudent(@ModelAttribute("student") Student student) {
	 this.sService.createStudent(student);
	 return "redirect:/contact/new";
 }
 
 
  @GetMapping("/contact/new")
  public String addc(@ModelAttribute("contact") Contact contact, Model viewModel) {
	  viewModel.addAttribute("students", this.sService.allStudents());
	  return "newContact.jsp";
  }
  
  @PostMapping("/contact/create")
  public String addContact(@ModelAttribute("contact") Contact contact) {
	this.cService.createContact(contact);
	  return "redirect:/students";
  }
}

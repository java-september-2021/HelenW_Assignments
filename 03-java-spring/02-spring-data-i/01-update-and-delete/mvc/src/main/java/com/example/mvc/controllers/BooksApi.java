package com.example.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.models.Book;
import com.example.mvc.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BooksApi {
	@Autowired
	private  BookService bookService;

//	public BooksApi(BookService bookService) {
//		
//		this.bookService = bookService;
//	}
	//get all books
	 @GetMapping(" ")
	    public List<Book> index() {
	        return this.bookService.allBooks();
	    }
	//create a book
     @PostMapping("/create")
     public Book create(Book book) {
     return this.bookService.createBook(book);
     }
     
     //update a book
     @PutMapping("/{id}/update")
     public Book update(@PathVariable("id") Long id , Book book) {
     return this.bookService.updateOne(book);
     }
     
     //return a specific book
     @GetMapping("/{id}")
     public Book getOne(@PathVariable("id") Long id) {
         return this.bookService.getOneBook(id);
     }
     //delete a book
     @DeleteMapping("/{id}/delete")
     public String destroy(@PathVariable("id") Long id) {
         return this.bookService.deleteBook(id);
     }
     
    
} 
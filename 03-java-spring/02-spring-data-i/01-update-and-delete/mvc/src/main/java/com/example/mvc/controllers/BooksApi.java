package com.example.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.models.Book;
import com.example.mvc.services.BookService;

@RestController
public class BooksApi {
	@Autowired
	private  BookService bookService;

//	public BooksApi(BookService bookService) {
//		
//		this.bookService = bookService;
//	}
	//get all books
	 @GetMapping("/api/books")
	    public List<Book> index() {
	        return this.bookService.allBooks();
	    }
	//create a book
     @PostMapping("/api/books")
     public Book create(Book book) {
     return this.bookService.createBook(book);
     }
     
     //update a book
//     @PutMapping("/api/books")
//     public Book update(Book book) {
//     return this.bookService.editBook(book);
//     }
     
     //return a specific book
     @GetMapping("/api/books/{id}")
     public Book show(@PathVariable("id") Long id) {
         Book book = bookService.findBook(id);
         return book;
     }
     //delete a book
     @DeleteMapping("/api/books/{id}")
     public String destroy(@PathVariable("id") Long id) {
         return this.bookService.deleteBook(id);
     }
     
    
} 
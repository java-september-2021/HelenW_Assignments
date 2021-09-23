package com.example.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.models.Book;
import com.example.mvc.repositories.BookRepository;

@Service
public class BookService {
//inject repository
	@Autowired//same as injecting constructor
	private  BookRepository bookRepository;
	
	/*
	 * public BookService(BookRepository bookRepository) {
	 * 
	 * this.bookRepository = bookRepository; }
	 */
	
	 // returns all the books
    public List<Book> allBooks() {
        return this.bookRepository.findAll();
    }
 // creates a book
    public Book createBook(Book b) {
        return this.bookRepository.save(b);
    }
    
 // Update 
  	public Book editBook(Book book) {
  		return this.bookRepository.save(book);
  	}

    
 // retrieves a book
    public Book findBook(Long id) {
    	return this.bookRepository.findById(id).orElse(null);
    }
    
 // Delete 
 	public String deleteBook(Long id) {
 		this.bookRepository.deleteById(id);
 		return "Book has been deleted";
 	}
}	
 

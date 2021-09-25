package com.example.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mvc.models.Book;
import com.example.mvc.services.BookService;

@Controller
public class BooksController {
	@Autowired
    private BookService bookService;
    
    
    //show all books
    @GetMapping("/books")
    public String index(Model model) {
        List<Book> books = this.bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }
    //create a book
    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    @PostMapping("/books")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            this.bookService.createBook(book);
            return "redirect:/books";
        }
    }
    //show a book
    @GetMapping("/books/{id}")
	public String editRecord(@PathVariable("id") Long id, @ModelAttribute("album") Book book, Model viewModel) {
		viewModel.addAttribute("book", this.bookService.getOneBook(id));
		return "/books/show.jsp";
	}
}
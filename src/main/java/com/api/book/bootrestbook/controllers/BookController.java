package com.api.book.bootrestbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.Services.Customerservice;
import com.api.book.bootrestbook.entities.Book;

@RestController
public class BookController {
	
	@Autowired
	private Customerservice bookservice;
	//Get all customer handler
	@GetMapping("/customer")
	public List<Book> getBooks()
	{
		return this.bookservice.getAllbooks();
	}
    
	//Get single customer handler
	@GetMapping("/customer/{id}")
	public Book getBook(@PathVariable("id") int id)
	{
	 return bookservice.getbookById(id);
	}
	
	//new customer handler
	@PostMapping("/customer")
	public Book addBook(@RequestBody Book book)
	{
		Book b=this.bookservice.addBook(book);
		return b;
	}
	
	//delete customer handler
	@DeleteMapping("/customer/{bookId}")
	public void deleteBook(@PathVariable("bookId")int bookId)
	{
	   this.bookservice.deleteBook(bookId);	
	}
	
	//update customer handler
	@PutMapping("/customer/{bookId}")
     public Book updateBook(@RequestBody Book book,
    		 @PathVariable("bookId")int bookId)
     {
    	 this.bookservice.updateBook(book,bookId);
    	 return book;
     }
}

package com.api.book.bootrestbook.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;

@Component
public class Customerservice {

	private  static List<Book> list=new ArrayList<>();
	
	static {
		list.add(new Book(121,"ABC","M",28,"veg"));
		list.add(new Book(122,"XYZ","M",30,"veg"));
		list.add(new Book(123,"MNL","F",38,"nonveg"));
	}
	
	//get all customers
	public List<Book> getAllbooks()
	{
	  return list;
	}
	//get single customer by id
	public Book getbookById(int id)
	{
		Book book=null;
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	
	//adding the customer
	public Book addBook(Book b)
	{
		list.add(b);
		return b;
	}
	
	//delete the customer
	public void deleteBook(int bid)
	{
		list=list.stream().filter(book-> book.getId()!=bid).
		collect(Collectors.toList());
	}
	
	//update the customer
	public void updateBook(Book book,int bookId)
	{
		list.stream().map(b->{
			if(b.getId()==bookId)
			{
				
				b.setName(book.getName());
				b.setGender(book.getGender());
				b.setAge(book.getAge());
				b.setPreferredFood(book.getPreferredFood());
			}
			return b;
		}).collect(Collectors.toList());
	}
}

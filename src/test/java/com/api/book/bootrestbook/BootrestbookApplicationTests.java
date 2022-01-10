package com.api.book.bootrestbook;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.book.bootrestbook.Services.Customerservice;
import com.api.book.bootrestbook.controllers.BookController;
import com.api.book.bootrestbook.entities.Book;

@SpringBootTest
class BootrestbookApplicationTests {

	@Autowired
	BookController b;
	
	
	@Test
	void contextLoads() {
	}
 
	@Test
	public void testCreate() {
		
		Book b1=new Book(0, null, null, 0, null);
		b1.setId(101);
		b1.setName("Rushi");
		b1.setGender("M");
		b1.setAge(25);
		b1.setPreferredFood("Veg");
		
		
	}
	
	@Test
	public void testReadAll() {
		
		List<Book> list = b.getBooks();
		assertThat(list).size().isGreaterThan(0);
		
	}


}

package com.clpa_partners.gestion_bibliotheque_clap_partner.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clpa_partners.gestion_bibliotheque_clap_partner.dao.BookAdapterFactory;
import com.clpa_partners.gestion_bibliotheque_clap_partner.domain.Book;

@RestController
public class BookController {

	private BookAdapterFactory bookAdapterFactory;
	  @PostMapping("user")
		public void processBooktDetails(@RequestBody Book book) {
		  bookAdapterFactory.getService(book.getBookType()).addBookByType(book);
			System.out.println("Successfully Published the book = ' " + book + " ' to the RegistrationTopic");
		}
	  
	  @GetMapping("books/{bookType}")
	   	public List<Book> retreivingAllBooks(@PathVariable("bookType") String book) {
	   		return bookAdapterFactory.getService(book).findAllBooks();
	   	}
}

package com.clpa_partners.gestion_bibliotheque_clap_partner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.clpa_partners.gestion_bibliotheque_clap_partner.dao.BookAdapterService;
import com.clpa_partners.gestion_bibliotheque_clap_partner.domain.Book;

@Service("fantasy")
public class FantasyBook implements BookAdapterService<Book>{

	
	public static List<Book> DB = new ArrayList<>();
	@Override
	public int addBookByType(UUID id, Book request) {
		DB.add(new Book.BookBuilder()
				.withBookId(id)
				.withBookType("fantasy")
				.withAuthorId(request.getAuthorId())
				.withBookName(request.getBookName())
				.withBookReference(request.getBookReference())
				.withNumberOfPages(request.getNumberOfPages())
				.withTotalAvailableInStock(request.getTotalAvailableInStock())
			    .build());
		System.out.println("This is admin user registration - "  + request.toString());
		return 1;
	}

	@Override
	public List<Book> findAllBooks() {
		return DB;
	}

	@Override
	public Optional<Book> selectBookById(UUID id) {
		System.out.println("This id is : " + id);	
		return DB.stream()
				.filter(book -> book.getBookId().equals(id))
				.findFirst();
	}

	@Override
	public Optional<Book> selectBookByAuthor(String author) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int updateBookById(UUID id, Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBookById(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

}

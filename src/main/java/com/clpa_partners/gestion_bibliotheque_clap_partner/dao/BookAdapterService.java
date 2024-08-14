package com.clpa_partners.gestion_bibliotheque_clap_partner.dao;
import com.clpa_partners.gestion_bibliotheque_clap_partner.domain.Book;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookAdapterService<T> {

	int addBookByType(UUID id, Book book);
	  default int addBookByType(Book book) {
		  UUID id = UUID.randomUUID();
		return addBookByType(id, book);
	  }

  public List<Book> findAllBooks();
  public Optional <Book> selectBookById(UUID id);
  public Optional<Book> selectBookByAuthor(String author);
  public int updateBookById(UUID id, Book book);
  public int deleteBookById(UUID id);
}

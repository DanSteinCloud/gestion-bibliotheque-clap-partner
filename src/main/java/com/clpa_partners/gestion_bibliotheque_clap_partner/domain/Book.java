package com.clpa_partners.gestion_bibliotheque_clap_partner.domain;

import java.util.Set;
import java.util.UUID;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="book")
@Getter
@Setter
@Entity
public class Book {
	
	private UUID bookId;
	@NonNull
	private String bookType;
	@NonNull
	private String bookName;
	@NonNull
	private String bookReference;
	@NonNull
	private int numberOfPages;
	
	private int totalAvailableInStock;
	
	@OneToMany
	@JoinColumn(name = "bookId")
      private Set<Author> author;
	
    private Book(BookBuilder bookBuilder) {
		
	}
	
	public static class BookBuilder {
		private UUID bookId;
		@NonNull
		private String bookType;
		@NonNull
		private UUID authorId;
		@NonNull
		private String bookName;
		@NonNull
		private String bookReference;
		@NonNull
		private int numberOfPages;
		
		private int totalAvailableInStock;
     
	    // Application of Builder Design pattern
	    public BookBuilder withBookId(UUID bookId){
			  this.bookId = bookId;
			  return this;
		}
	    public BookBuilder withBookType(String bookType){
			  this.bookType = bookType;
			  return this;
		}

	    public BookBuilder withBookName(String bookName){
			  this.bookName = bookName;
			  return this;
		}
	    public BookBuilder withBookReference(String bookReference){
			  this.bookReference = bookReference;
			  return this;
		}
	    public BookBuilder withNumberOfPages(int numberOfPages){
			  this.numberOfPages = numberOfPages;
			  return this;
		}
	    public BookBuilder withTotalAvailableInStock(int totalAvailableInStock){
			  this.totalAvailableInStock = totalAvailableInStock;
			  return this;
		}
	    
	    public Book build(){  
			 Book book = new Book();
			 book.setBookId(bookId);
			 book.setBookType(bookType);
			 book.setBookName(bookName);
			 book.setBookReference(bookReference);
			 book.setNumberOfPages(numberOfPages);
			 book.setTotalAvailableInStock(totalAvailableInStock);
			 
			 return book;
			 }
		 
		 
		 }

		@Override
		public String toString() {
			return "Book [bookId=" + bookId + ", bookTyper=" + bookType + ", UserType=" + author + "]";
			
		}
}

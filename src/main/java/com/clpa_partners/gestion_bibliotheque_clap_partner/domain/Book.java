package com.clpa_partners.gestion_bibliotheque_clap_partner.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.lang.NonNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@Column(name = "bookType")
	@NonNull
	private String bookType;
	
	@Column(name = "bookName")
	@NonNull
	private String bookName;
	
	@Column(name = "bookReference")
	@NonNull
	private String bookReference;
	
	@Column(name = "numberOfPages")
	@NonNull
	private int numberOfPages;
	
	@Column(name = "totalAvailableInStock")
	private int totalAvailableInStock;
	
	@Column(name = "published")
	private boolean published;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      })
		  @JoinTable(name = "book_authors",
		        joinColumns = { @JoinColumn(name = "bookId") },
		        inverseJoinColumns = { @JoinColumn(name = "authorId") })
		  private Set<Author> authors = new HashSet<>();
	
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
		
		private boolean published;
     
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
	    
	    public BookBuilder withPublished(boolean published){
			  this.published = published;
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
			 book.setPublished(published);
			 return book;
			 }
		 
		 
		 }

		@Override
		public String toString() {
			return "Book [bookId=" + bookId + ", bookType=" + bookType + "]";
			
		}
		
		public void addAuthor(Author author) {
		    this.authors.add(author);
		    //author.getBook().add(this);
		  }
		  
		  public void removeAuthor(UUID authorId) {
		    Author author = this.authors.stream()
		    		.filter(t -> t.getAuthorId() == authorId)
		    		.findFirst().orElse(null);
		    if (author != null) {
		      this.authors.remove(author);
		      //author.getBook().remove(this);
		    }
		  }
}

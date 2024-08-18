package com.clpa_partners.gestion_bibliotheque_clap_partner.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.lang.NonNull;

import com.clpa_partners.gestion_bibliotheque_clap_partner.domain.Book.BookBuilder;
import com.clpa_partners.gestion_bibliotheque_clap_partner.entity.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="author")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {

	private UUID authorId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "authorName")
	@NonNull
	private String authorName;
	
	private Address address;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      },
		      mappedBy = "authors")
		  @JsonIgnore
		  private Set<Book> books = new HashSet<>();
  
    private Author(AuthorBuilder authorBuilder) {
		
	}
	
	public static class AuthorBuilder {
		private UUID authorId;
		
		@Column(name = "firstName")
		private String firstName;
		
		@Column(name = "lastName")
		private String lastName;
		
		@Column(name = "authorName")
		@NonNull
		private String authorName;
		
		private Address address;
   
	    // Application of Builder Design pattern
	    public BookBuilder withAuthorkId(UUID authorId){
			  this.authorId = authorId;
			  return this;
		}
	    public BookBuilder withFirstName(String firstName){
			  this.firstName = firstName;
			  return this;
		}
	    
	    public BookBuilder withLastName(String lastName){
			  this.lastName = lastName;
			  return this;
		}
	    
	    public BookBuilder withAuthorName(String authorName){
			  this.authorName = authorName;
			  return this;
		}
	    
	    public BookBuilder withAddress(String addrress){
			  this.address = address;
			  return this;
		}
	
	    
	    public Author build(){  
			 Author author = new Author();
			 author.setAuthorId(authorId);
			 author.setFirstName(firstName);
			 author.setLastName(lastName);
			 author.setAuthorName(authorName);
			 author.setAddress(address);
			 return author;
		}
		 
		 
		}

		@Override
		public String toString() {
			return "Author [authorId=" + authorId + ", LastName=" + lastName + ", FirstName=" + firstName + "]";
			
		}
		
		public Set<Book> getBooks() {
		    return books;
		  }

		public void setTutorials(Set<Book> books) {
		    this.books = books;
		  } 

}

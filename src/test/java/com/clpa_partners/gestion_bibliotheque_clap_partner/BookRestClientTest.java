package com.clpa_partners.gestion_bibliotheque_clap_partner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.clpa_partners.gestion_bibliotheque_clap_partner.dao.BookAdapterFactory;
import com.clpa_partners.gestion_bibliotheque_clap_partner.domain.Book;

@ExtendWith(MockitoExtension.class)
class BookRestClientTest {
	private BookAdapterFactory bookAdapterFactory;
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void retreiveAllBooks(){
		List <Book> DisneyBookList = bookAdapterFactory.getService("disney").findAllBooks();
		System.out.println("List of disney books : " + DisneyBookList);
		assertTrue(DisneyBookList.size()>0);
	}

}

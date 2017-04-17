package com.nosqlcoco.chaptor10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nosqlcoco.chaptor10.domain.Author;
import com.nosqlcoco.chaptor10.domain.Book;
import com.nosqlcoco.chaptor10.domain.Publisher;
import com.nosqlcoco.chaptor10.repository.AuthorHibernateRepository;
import com.nosqlcoco.chaptor10.repository.AuthorJpaRepository;
import com.nosqlcoco.chaptor10.repository.BookHibernateRepository;
import com.nosqlcoco.chaptor10.repository.BookJpaRepository;
import com.nosqlcoco.chaptor10.repository.PublisherHibernateRepository;
import com.nosqlcoco.chaptor10.repository.PublisherJpaRepository;

/**
 * springboot Hibernate测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@TestPropertySource(
		locations = {"classpath:application.properties"}
)
public class ApplicationTest {
	private static Logger logger = LoggerFactory.getLogger(ApplicationTest.class);
	@Autowired
	private BookHibernateRepository bookHibernateRepository;
	@Autowired
	private BookJpaRepository bookJpaRepository;
	
	@Autowired
	private AuthorHibernateRepository authorHibernateRepository;
	@Autowired
	private AuthorJpaRepository authorJpaRepository;
	
	@Autowired
	private PublisherHibernateRepository publisherHibernateRepository;
	@Autowired
	private PublisherJpaRepository publisherJpaRepository;
	
	@Test
	public void testChaptor10Save() {
		Author author = new Author();
		author.setName("xiaoqiang");
		author = authorJpaRepository.saveAndFlush(author);
		
		Publisher publisher = new Publisher();
		publisher.setId(String.valueOf(UUID.randomUUID()).replaceAll("-", ""));
		publisher.setName("PeKing");
		publisher = publisherJpaRepository.save(publisher);
		
		Set<Author> authors = new HashSet<>();
		authors.add(author);
		
		Book book = new Book("Mechine Learning");
		book.setAuthors(authors);
		book.setPublisher(publisher);
		
		book = bookJpaRepository.save(book);
	}
	
	@Test
	public void testChaptor10Find() {
		List<Book> books = bookHibernateRepository.findAll();
		if(null != books) {
			logger.info("book num: " + books.size());
		}
		List<Author> authors = authorHibernateRepository.findAll();
		if(null != authors) {
			logger.info("author num: " + authors.size());
		}
		List<Publisher> publisher = publisherHibernateRepository.findAll();
		if(null != publisher) {
			logger.info("publisher num: " + publisher.size());
		}
	}
}
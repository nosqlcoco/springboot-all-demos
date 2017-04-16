package com.nosqlcoco.chaptor10;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
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
	public void test01AddAuthor() {
		Author author = new Author();
		author.setName("xiaoqiang");
		authorJpaRepository.saveAndFlush(author);
	}
	
	@Test
	public void test02addPublisher() {
		Publisher publisher = new Publisher();
		publisher.setId(String.valueOf(UUID.randomUUID()).replaceAll("-", ""));
		publisher.setName("PeKing");
		publisherJpaRepository.save(publisher);
	}
	
	@Test
	public void test03AddBook() {
		Publisher publisher = publisherHibernateRepository.findById("4d7f1a01ae044c07b4e0e985c9c35f40");
		Author author = authorHibernateRepository.findById("4028808c5b773c5a015b773caf560000");
		
		Set<Author> authors = new HashSet<>();
		authors.add(author);
		
		Book book = new Book("Mechine Learning");
		book.setAuthors(authors);
		book.setPublisher(publisher);
		
		book = bookJpaRepository.save(book);
	}
}
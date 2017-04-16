package com.nosqlcoco.chaptor10.repository;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nosqlcoco.chaptor10.domain.Book;

/**
 * @author nosqlcoco
 *
 */
@Repository
@Transactional
public class BookHibernateRepository {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional(readOnly = false)
	public Serializable save(Book book) {
		return hibernateTemplate.save(book);
	}
	
	public Book findById(Long id) {
		return hibernateTemplate.get(Book.class, id);
	}
}

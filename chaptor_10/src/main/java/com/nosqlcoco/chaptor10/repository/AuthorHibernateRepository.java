package com.nosqlcoco.chaptor10.repository;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nosqlcoco.chaptor10.domain.Author;

/**
 * @author nosqlcoco
 *
 */
@Repository
@Transactional
public class AuthorHibernateRepository {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional(readOnly = false)
	public Serializable save(Author author) {
		return hibernateTemplate.save(author);
	}
	
	public Author findById(String id) {
		return hibernateTemplate.get(Author.class, id);
	}
}

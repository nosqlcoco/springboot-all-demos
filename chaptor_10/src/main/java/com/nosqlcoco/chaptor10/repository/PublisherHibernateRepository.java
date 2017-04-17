package com.nosqlcoco.chaptor10.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nosqlcoco.chaptor10.domain.Publisher;

/**
 * @author nosqlcoco
 *
 */
@Repository
@Transactional
public class PublisherHibernateRepository {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional(readOnly = false)
	public Serializable save(Publisher publisher) {
		return hibernateTemplate.save(publisher);
	}
	
	public Publisher findById(String id) {
		return hibernateTemplate.get(Publisher.class, id);
	}
	
	public List<Publisher> findAll() {
		return hibernateTemplate.findByExample(new Publisher());
	}
}

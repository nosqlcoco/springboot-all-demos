package com.nosqlcoco.chaptor13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author lenovo
 *
 */
@Service
public class StudentService {
	private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
	
	@Cacheable(value = "student")
	public Student getById(String id) {
		logger.info("First execute");
		return new Student(id, "nosqlcoco", 27);
	}
	
	@Cacheable(value = "student", key = "#student.id")
	public Student getById(Student student) {
		return student;
	}
	
	@CacheEvict(value = "student")
	public Student removeById(String id) {
		logger.info("remove student ");
		return null;
	}
}

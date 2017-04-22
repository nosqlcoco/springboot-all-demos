package com.nosqlcoco.chaptor12;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * @author nsoqlcoco
 *
 */
public interface StudentRepository extends CrudRepository<Student, String> {
	List<Student> findByName(String name);

	Page<Student> findByName(String name, Pageable page);

	List<Student> findByNameOrAge(String firstname, Integer age);
}

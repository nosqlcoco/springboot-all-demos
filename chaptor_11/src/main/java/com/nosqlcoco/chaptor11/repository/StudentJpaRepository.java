package com.nosqlcoco.chaptor11.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nosqlcoco.chaptor11.domain.Student;

/**
 * @author nosqlcoco
 *
 */
public interface StudentJpaRepository extends JpaRepository<Student, Long> {
	Student findById(Serializable id);
	
	List<Student> findByName(String name);
	
	List<Student> findByNameStartingWith(String name, Sort sort);
	
	Page<Student> findBy(Pageable pageable);
	
	List<Student> findTop2By();
	
	@Query("SELECT s From Student s")
	List<Student> findByAndSort(Sort sort);
	
	@Query("SELECT s FROM Student s where s.age = ?1")
	List<Student> findByAge(Integer age);
	
	List<Student> findByAgeLessThanEqual(Integer age);
	
	@Query("SELECT s FROM Student s where s.name = :name AND s.age = :age")
	List<Student> findByNameAndAge(@Param("name") String name, @Param("age") int age);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Student s SET s.name = :name WHERE s.id = :id")
	int update(@Param("id") Long id, @Param("name")String name);
	
	/**
	 * support after spring data jpa 1.4.0 
	 */
//	@Query("SELECT s FROM Student s WHERE s.name = :#{#student.name}")
//	List<Student> findByName(Student student);
}

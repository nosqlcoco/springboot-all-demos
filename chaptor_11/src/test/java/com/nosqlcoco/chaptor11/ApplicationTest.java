package com.nosqlcoco.chaptor11;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nosqlcoco.chaptor11.domain.Student;
import com.nosqlcoco.chaptor11.repository.StudentJpaRepository;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(locations = {"classpath:application.properties"})
public class ApplicationTest {
	@Autowired
	private StudentJpaRepository studentJpaRepository;
	
	@Test
	public void test() {
		List<Student>students = new ArrayList<Student>();
		for (int i = 10; i < 25; i++) {
			String name = "Alice_" + String.valueOf(i);
			Student s = new Student(name, i);
			students.add(s);
		}
		studentJpaRepository.deleteAll();
		studentJpaRepository.save(students);
		
		Student s1 = studentJpaRepository.findById(1L);
		assertNotNull("findById return null", s1);
		
		List<Student>s2 = studentJpaRepository.findByName("Alice_10");
		assertNotNull("Could not find student named Alice_10", s2);
		assertEquals(s2.size(), 1);
		
		List<Student> s3 = studentJpaRepository.findByNameStartingWith("Alice_1", new Sort(Direction.DESC, "age"));
		assertNotNull("Could not find name start with Alice_1", s3);
		s3.forEach((s) -> {System.out.println(s.getAge());});
		
		Page<Student> s4 = studentJpaRepository.findBy(new PageRequest(0, 5));
		assertNotNull("findBy return null", s4);
		s4.forEach((s) -> {System.out.println(s.getAge());});
		
		List<Student> s5 = studentJpaRepository.findTop2By();
		assertNotNull("findTop2By return null", s5);
		s5.forEach((s) -> {System.out.println(s.getAge());});
		
		List<Student> s6 = studentJpaRepository.findByAndSort(new Sort(Direction.ASC, "age"));
		assertNotNull("findByAndSort return null", s6);
		s6.forEach((s) -> {System.out.println(s.getAge());});
		
		List<Student> s7 = studentJpaRepository.findByAge(20);
		assertNotNull("findByAge return null", s7);
		s7.forEach((s) -> {System.out.println(s.getAge());});
		
		List<Student> s8 = studentJpaRepository.findByAgeLessThanEqual(20);
		assertNotNull("findByAgeLessThanEqual return null", s8);
		s8.forEach((s) -> {System.out.println(s.getAge());});
		
		List<Student> s9 = studentJpaRepository.findByNameAndAge("Alice_20", 20);
		assertNotNull("findByNameAndAge return null", s9);
		s9.forEach((s) -> {System.out.println(s.getAge());});
		
		int rows1 = studentJpaRepository.update(15L, "Alice_1_1");
		assertEquals(rows1, 1L);
	}
}
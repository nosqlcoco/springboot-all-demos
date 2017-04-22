package com.nosqlcoco.chaptor12;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application.properties")
public class ApplicationTest {
	@Autowired
	private StudentRepository studentRepository;
	@Test
	public void test() {
		Student s = new Student();
		s.setAge(20);
		s.setName("nosqlcoco");
		s.setId("222");
		studentRepository.save(s);
		
		Student s1 = studentRepository.findOne("222");
		System.out.println(s1.toString());
	}
}
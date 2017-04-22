package com.nosqlcoco.chaptor13;

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
	private StudentService studentService;
	@Test
	public void testCache() {
		String id  = "123";
				
		Student stu1 = studentService.getById(id);
		
		Student stu2 = studentService.getById(stu1);
		
		studentService.removeById(id);
		
		Student stu3 = studentService.getById(id);
	}
}
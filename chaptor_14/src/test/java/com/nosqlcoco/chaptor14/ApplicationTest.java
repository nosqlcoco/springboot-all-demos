package com.nosqlcoco.chaptor14;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static Logger logger = LoggerFactory.getLogger(ApplicationTest.class);
	@Autowired
	private RedisTemplateUtil redisTemplateUtil;
	
	@Test
	public void testCache() {
		
		Boolean result1 = redisTemplateUtil.add("name1", "nosqlcoco1");
		Assert.assertEquals(true, result1);
		logger.info("Add name1 result: " + result1);
		
		Boolean result2 = redisTemplateUtil.add("name2", 1000L, "nosqlcoco2");
		Assert.assertEquals(true, result2);
		logger.info("Add name2 result: " + result2);
		
		Map<String, String> names = new HashMap<String, String>();
		names.put("name3", "nosqlcoco2");
		names.put("name4", "nosqlcoco4");
		names.put("name5", "nosqlcoco6");
		
		Boolean result3 = redisTemplateUtil.add(names);
		Assert.assertEquals(true, result3);
		logger.info("Add map type  result: " + result3);
		
		Object result4 =  redisTemplateUtil.get("name1");
		Assert.assertNotNull(result4);
		logger.info("name1 is " + result4);
		
		Boolean result5 = redisTemplateUtil.update("name1", "nosqlcoco1_1");
		Assert.assertEquals(true, result5);
		logger.info("update result: " + result5);
		
		Object result6 = redisTemplateUtil.get("name1");
		logger.info("name1 is : " + String.valueOf(result6));
	}
}
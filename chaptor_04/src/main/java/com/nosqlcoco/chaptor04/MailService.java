package com.nosqlcoco.chaptor04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 使用@Component注解定义一个bean，类似的注解还有@bean,@Repository,@Service,@Controller等
 * @author nosqlcoco
 *
 */
@Component
public class MailService {
	@Autowired
	private MailConfig mailConfig;
	
	public String sendMail() {
		System.out.println("Create beans by annotation ");
		return mailConfig.getUsername();
	}
}

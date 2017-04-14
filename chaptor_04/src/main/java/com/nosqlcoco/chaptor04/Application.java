package com.nosqlcoco.chaptor04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * 创建一个Bean
 * 1. 使用注解
 * 2. 使用XML
 */
@SpringBootApplication
@PropertySource("mail.properties")
@EnableConfigurationProperties(value = {MailConfig.class})
@ImportResource("mail-beans.xml")
public class Application {
	
	@Autowired
	private MailService mailService;
	@Autowired
	private XMLMailService xmlMailService;
	
	public static void main( String[] args ) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public Boolean sendMail() {
		mailService.sendMail();
		xmlMailService.sendMail();
		return true;
	}
}

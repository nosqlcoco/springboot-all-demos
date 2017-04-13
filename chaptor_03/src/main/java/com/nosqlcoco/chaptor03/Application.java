package com.nosqlcoco.chaptor03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@PropertySource({"mail.properties"})
@EnableConfigurationProperties(value={MailConfig.class})
public class Application {
	@Value("${project.name}")
	private String projectName;
	
	@Autowired
	private MailConfig mailConfig;
	
	public static void main( String[] args ) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public String getChaptorName (){
		System.out.print("Project name is " + projectName);
		System.out.print("Mail username is " + mailConfig.getUsername());
		return projectName;
	}
}

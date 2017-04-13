package com.nosqlcoco.chaptor02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application {
	
	@Value("${project.name}")
	private String projectName;

	private static String projectDesc;
	
	/**
	 * @return the projectDesc
	 */
	
	public String getProjectDesc() {
		return projectDesc;
	}

	/**
	 * @param projectDesc the projectDesc to set
	 */
	@Value("${project.desc}")
	public void setProjectDesc(String projectDesc) {
		Application.projectDesc = projectDesc;
	}
	
	public static void main( String[] args ) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public String getChaptorName (){
		System.out.print("Project name is " + projectName);
		System.out.print("Project desc is " + projectDesc);
		return projectName;
	}
}

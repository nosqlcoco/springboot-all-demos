package com.nosqlcoco.chaptor02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * application.properties
 * 1. 是springboot默认的配置文件
 * 2. 应用启动时从classpath中查找是否有application.properties文件
 * 3. 如果没有则使用springboot提供的默认配置
 * 4. 如果有则加载开发者定义的application.properties文件，并覆盖内置的默认配置
 * 
 * 5. 使用@Value注解读取properties属性
 * 6. 但是静态属性无法直接使用@Value注解，需要对该属性生成非静态的setter/getter方法，并在setter方法上使用@Value注解
 * @author nosqlcoco
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

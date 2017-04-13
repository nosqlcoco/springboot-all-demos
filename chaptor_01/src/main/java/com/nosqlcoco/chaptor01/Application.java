package com.nosqlcoco.chaptor01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world for springboot
 * @author nosqlcoco
 * {@link http://www.nosqlcoco.com}
 */
@SpringBootApplication
public class Application {
	public static void main( String[] args ) {
		SpringApplication.run(Application.class, args);
		System.out.println("Hello world!");
	}
}

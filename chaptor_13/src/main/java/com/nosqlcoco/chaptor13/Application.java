package com.nosqlcoco.chaptor13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * springboot cache redis
 *
 */
@SpringBootApplication
@EnableCaching
public class Application {
    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

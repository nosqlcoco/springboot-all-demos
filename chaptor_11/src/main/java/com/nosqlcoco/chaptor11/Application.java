package com.nosqlcoco.chaptor11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring data jpa demo
 */
@SpringBootApplication
@EnableTransactionManagement
public class Application {
    public static void main( String[] args ) {
    	SpringApplication.run(Application.class, args);
    }
}

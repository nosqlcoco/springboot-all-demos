package com.nosqlcoco.chaptor10;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring data jap(Hibernate)
 * 使用方式：
 * 1. 继承JpaRepository
 * 2. 注入HibernateTemplate
 */
@SpringBootApplication
/* 开启事物 */
@EnableTransactionManagement
/* 扫描指定包路径下的JPA实体 */
@EntityScan(value = "com.nosqlcoco.chaptor10.domain")
public class Application {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public static void main( String[] args ) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
	    return hemf.getSessionFactory();
	}
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory);
	}
}

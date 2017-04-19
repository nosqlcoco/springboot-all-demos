package com.nosqlcoco.chaptor11.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 学生类
 * @author nosqlcoco
 *
 */
@Entity
@Table(name = "student")
public class Student extends AbstractPersistable<Long> implements Serializable {

	private static final long serialVersionUID = 2099086033917162536L;
	@Column(length = 32)
	private String name;
	
	private Integer age;

	
	/**
	 * 
	 */
	public Student() {
		super();
	}

	/**
	 * @param name
	 * @param age
	 */
	public Student(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	
}

package com.nosqlcoco.chaptor10.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 作者类，主键uuid生成
 * @author nosqlcoco
 *
 */
@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Author implements Serializable {
	
	private static final long serialVersionUID = 3943394603711023196L;

	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
	@Column(length = 32, nullable = false, unique = false)
	private String id;
	
	private String name;
	
	/**
	 * 作者和图书室多对多的关系
	 */
	@ManyToMany(mappedBy = "authors", targetEntity = Book.class, fetch = FetchType.EAGER)
	private Set<Book> books;
}

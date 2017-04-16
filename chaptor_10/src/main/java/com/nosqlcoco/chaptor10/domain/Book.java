package com.nosqlcoco.chaptor10.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 图书类，主键自增长
 * @author nosqlcoco
 *
 */
@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Book implements Serializable {

	private static final long serialVersionUID = 8830418162493201293L;
	
	@Id
	@GeneratedValue
	private Long Id;
	/**
	 * 书名
	 */
	@Column(name = "title", length = 128, nullable = false)
	private String title;
	
	/**
	 * 图书和作者是多对多关系
	 */
	@ManyToMany(targetEntity = Author.class, fetch = FetchType.EAGER)
	@JoinTable(name = "author_book", 
		joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
	private Set<Author>authors;
	
	/**
	 * 图书和出版社是多对一的关系
	 */
	@ManyToOne(targetEntity = Publisher.class, optional = true, fetch = FetchType.EAGER)
	private Publisher publisher;
	
	/**
	 * @param string
	 */
	public Book(String title) {
		this.title = title;
	}
	
}

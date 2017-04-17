package com.nosqlcoco.chaptor10.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 出版社类,主键手动生成
 * @author nosqlcoco
 *
 */
@Entity
@Table(name = "publisher")
public class Publisher {
	@Id
	@GenericGenerator(name="idGenerator", strategy="assigned")
    @GeneratedValue(generator="idGenerator")
	@Column(length = 32, nullable = false, unique = false)
	private String id;
	
	/**
	 * 出版社名称
	 */
	private String name;
	
	/**
	 * 出版社和图书是多对一的关系
	 */
	@OneToMany(mappedBy = "publisher", targetEntity = Book.class, fetch = FetchType.LAZY)
	private Set<Book> books = new HashSet<Book>();
	
	/**
	 * 
	 */
	public Publisher() {
		super();
	}
	
	/**
	 * @param id
	 * @param name
	 * @param books
	 */
	public Publisher(String id, String name, Set<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.books = books;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the books
	 */
	public Set<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
}

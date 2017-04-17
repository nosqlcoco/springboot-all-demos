package com.nosqlcoco.chaptor10.domain;

import java.io.Serializable;
import java.util.HashSet;
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

/**
 * 图书类，主键自增长
 * @author nosqlcoco
 *
 */
@Entity
@Table(name = "book")
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
	@ManyToMany(targetEntity = Author.class, fetch = FetchType.LAZY)
	@JoinTable(name = "author_book", 
		joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
	private Set<Author>authors = new HashSet<Author>();
	
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
	
	/**
	 * 
	 */
	public Book() {
		super();
	}

	/**
	 * @param id
	 * @param title
	 * @param authors
	 * @param publisher
	 */
	public Book(Long id, String title, Set<Author> authors, Publisher publisher) {
		super();
		Id = id;
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		Id = id;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the authors
	 */
	public Set<Author> getAuthors() {
		return authors;
	}


	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}


	/**
	 * @return the publisher
	 */
	public Publisher getPublisher() {
		return publisher;
	}


	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
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
		Book other = (Book) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
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
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
}

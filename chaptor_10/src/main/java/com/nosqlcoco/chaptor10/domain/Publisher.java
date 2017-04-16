package com.nosqlcoco.chaptor10.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 出版社类,主键手动生成
 * @author nosqlcoco
 *
 */
@Entity
@Table(name = "publisher")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
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
	@OneToMany(mappedBy = "publisher", targetEntity = Book.class, fetch = FetchType.EAGER)
	private Set<Book> books;
}

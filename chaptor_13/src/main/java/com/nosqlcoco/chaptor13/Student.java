package com.nosqlcoco.chaptor13;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author nosqlcoco
 *
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
@RedisHash("students")
@NoArgsConstructor
@ToString
public class Student implements Serializable {

	private static final long serialVersionUID = -327291956444858680L;
	
	private @Id String id;
	
	private @Indexed String name;
	
	private @Indexed Integer age;
	
	
}

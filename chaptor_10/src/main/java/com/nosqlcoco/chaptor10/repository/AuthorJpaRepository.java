package com.nosqlcoco.chaptor10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nosqlcoco.chaptor10.domain.Author;

/**
 * @author nosqlcoco
 *
 */
@Repository
public interface AuthorJpaRepository extends JpaRepository<Author, String> {

}

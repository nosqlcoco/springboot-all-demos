package com.nosqlcoco.chaptor10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nosqlcoco.chaptor10.domain.Publisher;

/**
 * @author nosqlcoco
 *
 */
@Repository
public interface PublisherJpaRepository extends JpaRepository<Publisher, String> {

}

package io.duru.projects.sterling.repository;

import io.duru.projects.sterling.model.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * created by dduru on 07/10/2018
 */
@Repository
public interface FAQRepository extends JpaRepository<FAQ, Long> {

    Optional<FAQ> findByQuestion(String question);

}
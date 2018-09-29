package io.duru.projects.sterling.repository;

import io.duru.projects.sterling.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * created by dduru on 26/09/2018
 */
@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    Optional<State> findByName(String name);

    Optional<State> findByNameContaining(String name);

}
package io.duru.projects.sterling.repository;

import io.duru.projects.sterling.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created by dduru on 26/09/2018
 */
@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {



}
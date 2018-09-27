package io.duru.projects.sterling.repository;

import io.duru.projects.sterling.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * created by dduru on 26/09/2018
 */
@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {


    Optional<Partner> findByName(String name);


}
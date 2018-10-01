package io.duru.projects.sterling.repository;

import io.duru.projects.sterling.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by dduru on 26/09/2018
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByAddressContaining(String key);

    List<Location> findByState_NameContaining(String key);



}
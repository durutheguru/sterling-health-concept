package io.duru.projects.sterling.repository;

import io.duru.projects.sterling.model.SalesItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by dduru on 26/09/2018
 */
@Repository
public interface SalesItemRepository extends JpaRepository<SalesItem, Long> {


    List<SalesItem> findByDescriptionContaining(String key);

}
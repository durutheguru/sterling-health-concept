package io.duru.projects.sterling.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class Country extends BaseEntity {

    @NotEmpty(message = "Country Name is required")
    @Column(nullable = false, length = 100)
    @Size(max = 100, message = "Country Name is required")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
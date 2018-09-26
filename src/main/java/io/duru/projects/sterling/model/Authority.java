package io.duru.projects.sterling.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class Authority extends BaseEntity {

    @NotEmpty(message = "Authority Name is required")
    @Column(nullable = false, length = 200)
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
package io.duru.projects.sterling.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class State extends BaseEntity {

    @NotEmpty(message = "State Name is required")
    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Country country;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
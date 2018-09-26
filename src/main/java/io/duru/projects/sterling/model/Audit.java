package io.duru.projects.sterling.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class Audit extends BaseEntity {

    @NotEmpty
    @Column(nullable = false, length = 50)
    private String ip;

    @NotEmpty
    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String serialData;


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialData() {
        return serialData;
    }

    public void setSerialData(String serialData) {
        this.serialData = serialData;
    }


}
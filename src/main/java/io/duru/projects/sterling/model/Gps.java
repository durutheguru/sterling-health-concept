package io.duru.projects.sterling.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class Gps extends BaseEntity {

    @Column(nullable = false)
    @NotNull(message = "Longitude is required")
    private Double longitude;

    @Column(nullable = false)
    @NotNull(message = "Latitude is required")
    private Double latitude;


    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }


}
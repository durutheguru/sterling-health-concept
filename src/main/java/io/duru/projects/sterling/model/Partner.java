package io.duru.projects.sterling.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class Partner extends BaseEntity {

    @NotEmpty(message = "Partner Name is required")
    @Column(nullable = false, length = 200)
    @Size(max = 200, message = "Partner Name is too long")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "Primary Location is required")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "location_id")
    private Location primaryLocation;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "profile_id")
    private PartnerProfile partnerProfile;

    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    @JsonIgnore
    @OneToMany(mappedBy = "partner")
    private List<Advertisement> advertisements;

    @JsonIgnore
    @OneToMany(mappedBy = "partner")
    private List<SalesItem> salesItems;

    @JsonIgnore
    @OneToMany(mappedBy = "partner")
    private List<Service> services;

    @JsonIgnore
    @OneToMany(mappedBy = "partner")
    private List<Location> locations;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getPrimaryLocation() {
        return primaryLocation;
    }

    public void setPrimaryLocation(Location primaryLocation) {
        this.primaryLocation = primaryLocation;
        if (this.primaryLocation != null) {
            this.primaryLocation.setPartner(this);
        }
    }

    public PartnerProfile getPartnerProfile() {
        return partnerProfile;
    }

    public void setPartnerProfile(PartnerProfile partnerProfile) {
        this.partnerProfile = partnerProfile;
        if (this.partnerProfile != null) {
            this.partnerProfile.setPartner(this);
        }
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public Partner setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
        return this;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public List<SalesItem> getSalesItems() {
        return salesItems;
    }

    public void setSalesItems(List<SalesItem> salesItems) {
        this.salesItems = salesItems;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

}
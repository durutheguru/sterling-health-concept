package io.duru.projects.sterling.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class Service extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "partner_id")
    private Partner partner;

    @NotEmpty(message = "Service Description is required")
    @Column(nullable = false, length = 200)
    @Size(max = 200, message = "Service Description is too long")
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceType serviceType;


    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }


}
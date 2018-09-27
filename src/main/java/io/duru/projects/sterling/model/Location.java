package io.duru.projects.sterling.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class Location extends BaseEntity {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;

    @NotEmpty(message = "Location address is required")
    @Column(nullable = false, length = 200)
    @Size(max = 200, message = "Address is too long")
    private String address;

    @Column(length = 100)
    @Size(max = 100, message = "Location Email is too long")
    private String email;

    @Column(length = 30)
    @Size(max = 30, message = "Phone Number is too long")
    private String phoneNumber1;

    @Column(length = 30)
    @Size(max = 30, message = "Phone Number is too long")
    private String phoneNumber2;

    @OneToOne(cascade = CascadeType.ALL)
    private Gps gps;

    @NotNull(message = "Location State is required")
    @ManyToOne
    @JoinColumn(nullable = false)
    private State state;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public Gps getGps() {
        return gps;
    }

    public void setGps(Gps gps) {
        this.gps = gps;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}
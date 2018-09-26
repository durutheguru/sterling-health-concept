package io.duru.projects.sterling.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class AppUserAuthority extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "app_user_id")
    private AppUser appUser;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "authority_id")
    private Authority authority;


    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }


}
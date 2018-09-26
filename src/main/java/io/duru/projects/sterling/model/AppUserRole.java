package io.duru.projects.sterling.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class AppUserRole extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "app_user_id")
    private AppUser appUser;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "role_id")
    private Role role;


    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
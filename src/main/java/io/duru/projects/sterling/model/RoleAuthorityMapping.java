package io.duru.projects.sterling.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class RoleAuthorityMapping extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "role_id")
    private Role role;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "authority_id")
    private Authority authority;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }


}
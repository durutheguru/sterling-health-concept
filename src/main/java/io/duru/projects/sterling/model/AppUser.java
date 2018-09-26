package io.duru.projects.sterling.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class AppUser extends BaseEntity {

    @NotEmpty(message = "Username is required")
    @Column(nullable = false, length = 100)
    @Size(max = 100, message = "Username is too long")
    private String username;

    @NotEmpty(message = "Password is required")
    @Column(nullable = false, length = 250)
    private String password;

    @NotEmpty(message = "First Name is required")
    @Column(nullable = false, length = 50)
    @Size(max = 50, message = "First Name is too long")
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @NotEmpty(message = "Email is required")
    @Column(nullable = false, length = 100)
    @Size(max = 100, message = "Email is too long")
    private String email;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
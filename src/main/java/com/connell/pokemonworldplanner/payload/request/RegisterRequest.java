package com.connell.pokemonworldplanner.payload.request;

import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

public class RegisterRequest {
    @NotBlank(message = "Username is mandatory.")
    private String username;

    @NotBlank(message = "Password is mandatory.")
    private String password;

    @Email(message = "Valid email is mandatory.")
    private String email;

    @NotBlank(message = "First name is mandatory.")
    private String firstName;

    @NotBlank(message = "Last name is mandatory.")
    private String lastName;

    @DBRef
    private Set<String> roles = new HashSet<>();

    /**
     * Returns the username from the request.
     *
     * @return a String containing the username in the request
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Returns the password from the request.
     *
     * @return a String containing the username in the request
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Returns the customer email address.
     *
     * @return customer's email address.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Returns the customer's first name.
     *
     * @return customer first name.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the customer's last name.
     *
     * @return customer last name.
     */
    public String getLastName() {
        return this.lastName;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}

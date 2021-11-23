package com.connell.pokemonworldplanner.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @DBRef
    private Set<Role> roles = new HashSet<>();

    /**
     * Constructor
     */
    public User(String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns UserID
     */
    public String getId() {
        return id;
    }

    /**
     * returns user first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets user first name
     */
    public void setFirstName(String name) {
        this.firstName = name;
    }

    /**
     * returns user last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets user last name
     */
    public void setLastName(String name) {
        this.lastName = name;
    }

    /**
     * Sets userID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets userName
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns user Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets user Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns user password
     */
    public String getPassword() {
        return password;
    }

    //Sets user password
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the roles of the user
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Sets roles for a user
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("username='" + username + "'")
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("roles=" + roles)
                .toString();
    }
}

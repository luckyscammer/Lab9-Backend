package com.example.lab9.entity;

import jakarta.persistence.*;

/**
 * Represents an admin entity in the system.
 * Admins have a unique ID, username, and password.
 */
@Entity
@Table(name = "admins")
public class Admin {

    /**
     * The unique identifier for the admin.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The username of the admin.
     */
    private String username;

    /**
     * The password of the admin.
     */
    private String password;

    public Admin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}

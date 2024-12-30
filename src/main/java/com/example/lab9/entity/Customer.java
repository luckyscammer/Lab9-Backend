package com.example.lab9.entity;

import jakarta.persistence.*;
import java.util.List;

/**
 * Represents a customer entity in the system.
 * Customers have a unique ID, username, email, and associated orders.
 */
@Entity
@Table(name = "customers")
public class Customer {

    /**
     * The unique identifier for the customer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The username of the customer.
     */
    private String username;

    /**
     * The email address of the customer.
     */
    private String email;

    /**
     * The list of orders associated with the customer.
     */
    @ManyToMany
    @JoinTable(
            name = "customers_orders",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Order> orders;

    public Customer() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

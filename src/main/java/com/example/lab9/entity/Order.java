package com.example.lab9.entity;

import jakarta.persistence.*;
import java.util.List;

/**
 * Represents an order entity in the system.
 * Orders have a unique ID, title, description, category, status, and associated customers.
 */
@Entity
@Table(name = "orders")
public class Order {

    /**
     * Enum representing the status of an order.
     */
    public enum OrderStatus {
        PENDING,
        PROCESSING,
        COMPLETED,
        CANCELLED
    }

    /**
     * The unique identifier for the order.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The title of the order.
     */
    private String title;

    /**
     * A description of the order.
     */
    private String description;

    /**
     * The category of the order.
     */
    private String category;

    /**
     * The current status of the order. Defaults to "PENDING".
     */
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

    /**
     * The list of customers associated with the order.
     */
    @ManyToMany(mappedBy = "orders")
    private List<Customer> customers;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}

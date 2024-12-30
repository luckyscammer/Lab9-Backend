package com.example.lab9.entity;

import jakarta.persistence.*;

/**
 * Represents an employee entity in the system.
 * Employees have a unique ID, name, surname, company, and email.
 */
@Entity
@Table(name = "employees")
public class Employee {

    /**
     * The unique identifier for the employee.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the employee.
     */
    private String name;

    /**
     * The surname of the employee.
     */
    private String surname;

    /**
     * The company the employee works for.
     */
    private String company;

    /**
     * The email address of the employee.
     */
    private String email;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

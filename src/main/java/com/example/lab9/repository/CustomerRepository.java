package com.example.lab9.repository;

import com.example.lab9.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Customer} entities.
 * Provides CRUD operations for customers in the database.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

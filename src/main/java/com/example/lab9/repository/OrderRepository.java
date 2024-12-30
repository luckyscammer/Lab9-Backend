package com.example.lab9.repository;

import com.example.lab9.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Order} entities.
 * Provides CRUD operations for orders in the database.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

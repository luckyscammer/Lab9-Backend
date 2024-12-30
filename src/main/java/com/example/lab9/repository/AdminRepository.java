package com.example.lab9.repository;

import com.example.lab9.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Admin} entities.
 * Provides CRUD operations for admins in the database.
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}

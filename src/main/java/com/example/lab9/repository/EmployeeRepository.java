package com.example.lab9.repository;

import com.example.lab9.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Employee} entities.
 * Provides CRUD operations for employees in the database.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

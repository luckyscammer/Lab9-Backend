package com.example.lab9.controller;

import com.example.lab9.entity.Employee;
import com.example.lab9.entity.Order;
import com.example.lab9.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for managing {@link Employee} entities and associated operations.
 * Provides endpoints for CRUD operations on employees and managing orders created or updated by employees.
 */
@RestController
@RequestMapping("/lab9/employees")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Constructs an {@link EmployeeController} with the specified service.
     *
     * @param employeeService the service for managing employees
     */
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Retrieves all employees.
     *
     * @return a {@link ResponseEntity} containing the list of all employees
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param id the ID of the employee
     * @return a {@link ResponseEntity} containing the employee or an error message
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            return ResponseEntity.ok(employee);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with ID: " + id);
        }
    }

    /**
     * Creates a new employee.
     *
     * @param employee the employee to create
     * @return a {@link ResponseEntity} with a success message and the employee ID
     */
    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.ok("Employee created successfully with ID: " + createdEmployee.getId());
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param id the ID of the employee to delete
     * @return a {@link ResponseEntity} with a success or error message
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.ok("Employee with ID: " + id + " deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with ID: " + id);
        }
    }

    /**
     * Adds a new order.
     *
     * @param order the order to add
     * @return a {@link ResponseEntity} with a success message or an error
     */
    @PostMapping("/create/order")
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        try {
            employeeService.addOrder(order);
            return ResponseEntity.ok("Order created successfully with ID: " + order.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create order: " + e.getMessage());
        }
    }

    /**
     * Updates an existing order.
     *
     * @param id           the ID of the order to update
     * @param updatedOrder the updated order data
     * @return a {@link ResponseEntity} with a success message or an error
     */
    @PutMapping("/update/order/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        try {
            employeeService.updateOrder(id, updatedOrder);
            return ResponseEntity.ok("Order updated successfully with ID: " + id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + id);
        }
    }

    /**
     * Confirms an order by setting its status to {@code COMPLETED}.
     *
     * @param id the ID of the order to confirm
     * @return a {@link ResponseEntity} with a success message or an error
     */
    @PutMapping("/confirm/order/{id}")
    public ResponseEntity<String> confirmOrder(@PathVariable Long id) {
        try {
            employeeService.confirmOrder(id);
            return ResponseEntity.ok("Order with ID: " + id + " confirmed successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + id);
        }
    }
}

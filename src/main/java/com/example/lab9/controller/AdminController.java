package com.example.lab9.controller;

import com.example.lab9.entity.Admin;
import com.example.lab9.entity.Customer;
import com.example.lab9.entity.Employee;
import com.example.lab9.entity.Order;
import com.example.lab9.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for managing {@link Admin} entities and related operations.
 * Provides endpoints for CRUD operations on admins and managing customers, employees, and orders.
 */
@RestController
@RequestMapping("/lab9/admins")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

    private final AdminService adminService;

    /**
     * Constructs an {@link AdminController} with the specified service.
     *
     * @param adminService the service for managing admins
     */
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * Retrieves all admins.
     *
     * @return a {@link ResponseEntity} containing the list of all admins
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    /**
     * Retrieves an admin by their ID.
     *
     * @param id the ID of the admin
     * @return a {@link ResponseEntity} containing the admin or an error message
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getAdminById(@PathVariable Long id) {
        try {
            Admin admin = adminService.getAdminById(id);
            return ResponseEntity.ok(admin);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found with ID: " + id);
        }
    }

    /**
     * Creates a new admin.
     *
     * @param admin the admin to create
     * @return a {@link ResponseEntity} with a success message and the admin ID
     */
    @PostMapping("/create")
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.createAdmin(admin);
        return ResponseEntity.ok("Admin created successfully with ID: " + createdAdmin.getId());
    }

    /**
     * Deletes an admin by their ID.
     *
     * @param id the ID of the admin to delete
     * @return a {@link ResponseEntity} with a success or error message
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        try {
            adminService.deleteAdmin(id);
            return ResponseEntity.ok("Admin with ID: " + id + " deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found with ID: " + id);
        }
    }

    /**
     * Deletes a customer by their ID.
     *
     * @param id the ID of the customer to delete
     * @return a {@link ResponseEntity} with a success or error message
     */
    @DeleteMapping("/delete/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        try {
            adminService.deleteCustomer(id);
            return ResponseEntity.ok("Customer with ID: " + id + " deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with ID: " + id);
        }
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param id the ID of the employee to delete
     * @return a {@link ResponseEntity} with a success or error message
     */
    @DeleteMapping("/delete/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        try {
            adminService.deleteEmployee(id);
            return ResponseEntity.ok("Employee with ID: " + id + " deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with ID: " + id);
        }
    }

    /**
     * Deletes an order by its ID.
     *
     * @param id the ID of the order to delete
     * @return a {@link ResponseEntity} with a success or error message
     */
    @DeleteMapping("/delete/order/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        try {
            adminService.deleteOrder(id);
            return ResponseEntity.ok("Order with ID: " + id + " deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + id);
        }
    }

    /**
     * Creates a new customer.
     *
     * @param customer the customer to create
     * @return a {@link ResponseEntity} with a success message or an error
     */
    @PostMapping("/create/customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        try {
            adminService.createCustomer(customer);
            return ResponseEntity.ok("Customer created successfully with ID: " + customer.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create customer: " + e.getMessage());
        }
    }

    /**
     * Creates a new employee.
     *
     * @param employee the employee to create
     * @return a {@link ResponseEntity} with a success message or an error
     */
    @PostMapping("/create/employee")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        try {
            adminService.createEmployee(employee);
            return ResponseEntity.ok("Employee created successfully with ID: " + employee.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create employee: " + e.getMessage());
        }
    }

    /**
     * Creates a new order.
     *
     * @param order the order to create
     * @return a {@link ResponseEntity} with a success message or an error
     */
    @PostMapping("/create/order")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        try {
            adminService.createOrder(order);
            return ResponseEntity.ok("Order created successfully with ID: " + order.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create order: " + e.getMessage());
        }
    }
}

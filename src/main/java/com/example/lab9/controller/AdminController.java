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

@RestController
@RequestMapping("/lab9/admins")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getAdminById(@PathVariable Long id) {
        try {
            Admin admin = adminService.getAdminById(id);
            return ResponseEntity.ok(admin);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found with ID: " + id);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.createAdmin(admin);
        return ResponseEntity.ok("Admin created successfully with ID: " + createdAdmin.getId());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        try {
            adminService.deleteAdmin(id);
            return ResponseEntity.ok("Admin with ID: " + id + " deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found with ID: " + id);
        }
    }

    @DeleteMapping("/delete/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        try {
            adminService.deleteCustomer(id);
            return ResponseEntity.ok("Customer with ID: " + id + " deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with ID: " + id);
        }
    }

    @DeleteMapping("/delete/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        try {
            adminService.deleteEmployee(id);
            return ResponseEntity.ok("Employee with ID: " + id + " deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with ID: " + id);
        }
    }

    @DeleteMapping("/delete/order/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        try {
            adminService.deleteOrder(id);
            return ResponseEntity.ok("Order with ID: " + id + " deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + id);
        }
    }

    @PostMapping("/create/customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        try {
            adminService.createCustomer(customer);
            return ResponseEntity.ok("Customer created successfully with ID: " + customer.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create customer: " + e.getMessage());
        }
    }

    @PostMapping("/create/employee")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        try {
            adminService.createEmployee(employee);
            return ResponseEntity.ok("Employee created successfully with ID: " + employee.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create employee: " + e.getMessage());
        }
    }

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
package com.example.lab9.controller;

import com.example.lab9.entity.Customer;
import com.example.lab9.entity.Order;
import com.example.lab9.service.CustomerService;
import com.example.lab9.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for managing {@link Customer} entities and related operations.
 * Provides endpoints for CRUD operations on customers and managing their orders.
 */
@RestController
@RequestMapping("/lab9/customers")
@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {

    private final CustomerService customerService;
    private final OrderService orderService;

    /**
     * Constructs a {@link CustomerController} with the specified services.
     *
     * @param customerService the service for managing customers
     * @param orderService    the service for managing orders
     */
    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    /**
     * Retrieves all customers.
     *
     * @return a {@link ResponseEntity} containing the list of all customers
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    /**
     * Retrieves a customer by their ID.
     *
     * @param id the ID of the customer
     * @return a {@link ResponseEntity} containing the customer or an error message
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            Customer customer = customerService.getCustomerById(id);
            return ResponseEntity.ok(customer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + id);
        }
    }

    /**
     * Creates a new customer.
     *
     * @param customer the customer to create
     * @return a {@link ResponseEntity} with a success message and the customer ID
     */
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody Customer customer) {
        Customer createdUser = customerService.createCustomer(customer);
        return ResponseEntity.ok("User created successfully with ID: " + createdUser.getId());
    }

    /**
     * Deletes a customer by their ID.
     *
     * @param id the ID of the customer to delete
     * @return a {@link ResponseEntity} with a success or error message
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.ok("User with ID: " + id + " deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + id);
        }
    }

    /**
     * Marks an order as "PROCESSING" for a customer.
     *
     * @param orderId the ID of the order to update
     * @return a {@link ResponseEntity} with a success or error message
     */
    @PutMapping("/takeOrder/{orderId}")
    public ResponseEntity<String> takeOrder(@PathVariable Long orderId) {
        try {
            Order updatedOrder = orderService.updateOrderStatus(orderId, Order.OrderStatus.PROCESSING);
            return ResponseEntity.ok("Order with ID: " + updatedOrder.getId() + " is now being processed.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order with ID: " + orderId + " not found.");
        }
    }
}

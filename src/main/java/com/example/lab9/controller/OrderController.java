package com.example.lab9.controller;

import com.example.lab9.entity.Order;
import com.example.lab9.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for managing {@link Order} entities.
 * Provides endpoints for CRUD operations and status updates on orders.
 */
@RestController
@RequestMapping("/lab9/orders")
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {

    private final OrderService orderService;

    /**
     * Constructs an {@link OrderController} with the specified service.
     *
     * @param orderService the service for managing orders
     */
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Retrieves all orders.
     *
     * @return a {@link ResponseEntity} containing the list of all orders
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    /**
     * Retrieves an order by its ID.
     *
     * @param id the ID of the order
     * @return a {@link ResponseEntity} containing the order or an error message
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        try {
            Order order = orderService.getOrderById(id);
            return ResponseEntity.ok(order);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + id);
        }
    }

    /**
     * Creates a new order.
     *
     * @param order the order to create
     * @return a {@link ResponseEntity} with a success message and the order ID
     */
    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok("Order created successfully with ID: " + createdOrder.getId());
    }

    /**
     * Deletes an order by its ID.
     *
     * @param id the ID of the order to delete
     * @return a {@link ResponseEntity} with a success or error message
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        try {
            orderService.deleteOrder(id);
            return ResponseEntity.ok("Order with ID: " + id + " deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + id);
        }
    }
}

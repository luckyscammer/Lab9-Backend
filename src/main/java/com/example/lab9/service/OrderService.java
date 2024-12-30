package com.example.lab9.service;

import com.example.lab9.entity.Order;
import com.example.lab9.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for managing {@link Order} entities.
 * Provides business logic for creating, retrieving, updating, and deleting orders.
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    /**
     * Constructs an {@link OrderService} with the specified repository.
     *
     * @param orderRepository the repository for managing orders
     */
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Creates a new order.
     *
     * @param order the order to create
     * @return the created order
     */
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    /**
     * Retrieves an order by its ID.
     *
     * @param id the ID of the order
     * @return the order with the specified ID
     * @throws RuntimeException if no order is found with the specified ID
     */
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    /**
     * Retrieves all orders.
     *
     * @return a list of all orders
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Deletes an order by its ID.
     *
     * @param id the ID of the order to delete
     * @throws RuntimeException if no order is found with the specified ID
     */
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found");
        }
        orderRepository.deleteById(id);
    }

    /**
     * Updates the status of an existing order.
     *
     * @param orderId   the ID of the order to update
     * @param newStatus the new status to set for the order
     * @return the updated order
     * @throws RuntimeException if no order is found with the specified ID
     */
    public Order updateOrderStatus(Long orderId, Order.OrderStatus newStatus) {
        Order order = getOrderById(orderId);
        order.setStatus(newStatus);
        return orderRepository.save(order);
    }
}

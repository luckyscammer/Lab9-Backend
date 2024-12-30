package com.example.lab9.service;

import com.example.lab9.entity.Employee;
import com.example.lab9.entity.Order;
import com.example.lab9.repository.EmployeeRepository;
import com.example.lab9.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for managing {@link Employee} entities and associated {@link Order} entities.
 * Provides business logic for creating, retrieving, updating, and deleting employees and orders.
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final OrderRepository orderRepository;

    /**
     * Constructs an {@link EmployeeService} with the specified repositories.
     *
     * @param employeeRepository the repository for managing employees
     * @param orderRepository    the repository for managing orders
     */
    public EmployeeService(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        this.employeeRepository = employeeRepository;
        this.orderRepository = orderRepository;
    }

    /**
     * Creates a new employee.
     *
     * @param employee the employee to create
     * @return the created employee
     */
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param id the ID of the employee
     * @return the employee with the specified ID
     * @throws RuntimeException if no employee is found with the specified ID
     */
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    /**
     * Retrieves all employees.
     *
     * @return a list of all employees
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param id the ID of the employee to delete
     * @throws RuntimeException if no employee is found with the specified ID
     */
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }
        employeeRepository.deleteById(id);
    }

    /**
     * Adds a new order.
     *
     * @param order the order to add
     */
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    /**
     * Updates an existing order.
     *
     * @param id           the ID of the order to update
     * @param updatedOrder the updated order data
     * @throws RuntimeException if no order is found with the specified ID
     */
    public void updateOrder(Long id, Order updatedOrder) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setTitle(updatedOrder.getTitle());
        order.setDescription(updatedOrder.getDescription());
        order.setCategory(updatedOrder.getCategory());
        order.setStatus(updatedOrder.getStatus());

        orderRepository.save(order);
    }

    /**
     * Confirms an order by setting its status to {@code COMPLETED}.
     *
     * @param id the ID of the order to confirm
     * @throws RuntimeException if no order is found with the specified ID
     */
    public void confirmOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(Order.OrderStatus.COMPLETED);
        orderRepository.save(order);
    }
}

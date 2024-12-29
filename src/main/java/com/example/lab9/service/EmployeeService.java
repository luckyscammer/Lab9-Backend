package com.example.lab9.service;

import com.example.lab9.entity.Employee;
import com.example.lab9.entity.Order;
import com.example.lab9.repository.EmployeeRepository;
import com.example.lab9.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final OrderRepository orderRepository;

    public EmployeeService(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        this.employeeRepository = employeeRepository;
        this.orderRepository = orderRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }
        employeeRepository.deleteById(id);
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public void updateOrder(Long id, Order updatedOrder) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setTitle(updatedOrder.getTitle());
        order.setDescription(updatedOrder.getDescription());
        order.setCategory(updatedOrder.getCategory());
        order.setStatus(updatedOrder.getStatus());

        orderRepository.save(order);
    }

    public void confirmOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(Order.OrderStatus.COMPLETED);
        orderRepository.save(order);
    }
}

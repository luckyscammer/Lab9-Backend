package com.example.lab9.service;

import com.example.lab9.entity.Admin;
import com.example.lab9.entity.Customer;
import com.example.lab9.entity.Employee;
import com.example.lab9.entity.Order;
import com.example.lab9.repository.AdminRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for managing {@link Admin} entities and related operations.
 * Provides business logic for creating, retrieving, deleting admins, and managing associated entities like customers, employees, and orders.
 */
@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final OrderService orderService;

    /**
     * Constructs an {@link AdminService} with the specified repositories and services.
     *
     * @param adminRepository the repository for managing admins
     * @param customerService the service for managing customers
     * @param employeeService the service for managing employees
     * @param orderService    the service for managing orders
     */
    public AdminService(AdminRepository adminRepository, CustomerService customerService, EmployeeService employeeService, OrderService orderService) {
        this.adminRepository = adminRepository;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.orderService = orderService;
    }

    /**
     * Creates a new admin.
     *
     * @param admin the admin to create
     * @return the created admin
     */
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    /**
     * Retrieves an admin by their ID.
     *
     * @param id the ID of the admin
     * @return the admin with the specified ID
     * @throws RuntimeException if no admin is found with the specified ID
     */
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    /**
     * Retrieves all admins.
     *
     * @return a list of all admins
     */
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    /**
     * Deletes an admin by their ID.
     *
     * @param id the ID of the admin to delete
     */
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    /**
     * Deletes a customer by their ID.
     *
     * @param customerId the ID of the customer to delete
     */
    public void deleteCustomer(Long customerId) {
        customerService.deleteCustomer(customerId);
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param employeeId the ID of the employee to delete
     */
    public void deleteEmployee(Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    /**
     * Deletes an order by its ID.
     *
     * @param orderId the ID of the order to delete
     */
    public void deleteOrder(Long orderId) {
        orderService.deleteOrder(orderId);
    }

    /**
     * Creates a new customer.
     *
     * @param customer the customer to create
     */
    public void createCustomer(Customer customer) {
        customerService.createCustomer(customer);
    }

    /**
     * Creates a new employee.
     *
     * @param employee the employee to create
     */
    public void createEmployee(Employee employee) {
        employeeService.createEmployee(employee);
    }

    /**
     * Creates a new order.
     *
     * @param order the order to create
     */
    public void createOrder(Order order) {
        orderService.createOrder(order);
    }
}

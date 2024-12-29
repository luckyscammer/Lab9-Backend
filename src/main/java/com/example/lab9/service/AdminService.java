package com.example.lab9.service;

import com.example.lab9.entity.Admin;
import com.example.lab9.entity.Customer;
import com.example.lab9.entity.Employee;
import com.example.lab9.entity.Order;
import com.example.lab9.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final OrderService orderService;

    public AdminService(AdminRepository adminRepository, CustomerService customerService, EmployeeService employeeService, OrderService orderService) {
        this.adminRepository = adminRepository;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.orderService = orderService;
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    public void deleteCustomer(Long customerId) {
        customerService.deleteCustomer(customerId);
    }

    public void deleteEmployee(Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    public void deleteOrder(Long orderId) {
        orderService.deleteOrder(orderId);
    }

    public void createCustomer(Customer customer) {
        customerService.createCustomer(customer);
    }

    public void createEmployee(Employee employee) {
        employeeService.createEmployee(employee);
    }

    public void createOrder(Order order) {
        orderService.createOrder(order);
    }
}

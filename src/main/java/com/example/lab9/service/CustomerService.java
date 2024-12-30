package com.example.lab9.service;

import com.example.lab9.entity.Customer;
import com.example.lab9.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for managing {@link Customer} entities.
 * Provides business logic for creating, retrieving, and deleting customers.
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    /**
     * Constructs a {@link CustomerService} with the specified repository.
     *
     * @param customerRepository the repository for managing customers
     */
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Creates a new customer.
     *
     * @param customer the customer to create
     * @return the created customer
     */
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Retrieves a customer by their ID.
     *
     * @param id the ID of the customer
     * @return the customer with the specified ID
     * @throws RuntimeException if no customer is found with the specified ID
     */
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    /**
     * Retrieves all customers.
     *
     * @return a list of all customers
     */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Deletes a customer by their ID.
     *
     * @param id the ID of the customer to delete
     * @throws RuntimeException if no customer is found with the specified ID
     */
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }
        customerRepository.deleteById(id);
    }
}

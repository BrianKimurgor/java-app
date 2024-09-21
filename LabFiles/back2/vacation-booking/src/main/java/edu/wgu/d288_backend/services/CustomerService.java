package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer saveCustomer(Customer customer);
    void deleteCustomer(Long id);
}

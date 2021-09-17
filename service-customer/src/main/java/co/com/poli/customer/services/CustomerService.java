package co.com.poli.customer.services;

import co.com.poli.customer.entities.Customer;

import java.util.List;

public interface CustomerService {

    void save(Customer customer);
    void delete(Customer customer);
    List<Customer> findAll();
    Customer findById(Long id);
    Customer findByNumberId(String numberID);
}

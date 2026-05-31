package com.cargotracking.cargotrackingsystem.service;

import com.cargotracking.cargotrackingsystem.entity.Customer;
import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);
    Customer getById(Long id);
    List<Customer> getAll();
    Customer update(Long id, Customer customer);
    void delete(Long id);
    Customer getByEmail(String email);
    List<Customer> getByCity(String city);
}
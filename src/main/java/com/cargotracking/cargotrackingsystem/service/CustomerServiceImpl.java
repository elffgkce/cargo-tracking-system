package com.cargotracking.cargotrackingsystem.service;

import com.cargotracking.cargotrackingsystem.entity.Customer;
import com.cargotracking.cargotrackingsystem.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer existing = getById(id);
        existing.setFirstName(customer.getFirstName());
        existing.setLastName(customer.getLastName());
        existing.setEmail(customer.getEmail());
        existing.setPhone(customer.getPhone());
        existing.setAddress(customer.getAddress());
        existing.setCity(customer.getCity());
        existing.setCountry(customer.getCountry());
        return customerRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer getByEmail(String email) {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Customer not found with email: " + email));
    }

    @Override
    public List<Customer> getByCity(String city) {
        return customerRepository.findByCity(city);
    }
}
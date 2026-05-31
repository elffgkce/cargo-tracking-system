package com.cargotracking.cargotrackingsystem.repository;

import com.cargotracking.cargotrackingsystem.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByCustomerId(Long customerId);

    List<Address> findByCity(String city);

    List<Address> findByCustomerIdAndIsDefault(Long customerId, boolean isDefault);
}
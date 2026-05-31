package com.cargotracking.cargotrackingsystem.repository;

import com.cargotracking.cargotrackingsystem.entity.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Long> {

    Optional<Carrier> findByName(String name);

    List<Carrier> findByActive(boolean active);
}
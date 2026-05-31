package com.cargotracking.cargotrackingsystem.repository;

import com.cargotracking.cargotrackingsystem.entity.Shipment;
import com.cargotracking.cargotrackingsystem.entity.ShipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    Optional<Shipment> findByTrackingNumber(String trackingNumber);

    List<Shipment> findByCustomerId(Long customerId);

    List<Shipment> findByStatus(ShipmentStatus status);

    List<Shipment> findByOriginCity(String originCity);

    List<Shipment> findByDestinationCity(String destinationCity);

    List<Shipment> findByCustomerIdAndStatus(Long customerId, ShipmentStatus status);

    List<Shipment> findByCarrierId(Long carrierId);
}
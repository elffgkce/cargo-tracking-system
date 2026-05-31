package com.cargotracking.cargotrackingsystem.service;

import com.cargotracking.cargotrackingsystem.entity.Shipment;
import com.cargotracking.cargotrackingsystem.entity.ShipmentStatus;
import java.util.List;

public interface ShipmentService {

    Shipment save(Shipment shipment);
    Shipment getById(Long id);
    List<Shipment> getAll();
    Shipment update(Long id, Shipment shipment);
    void delete(Long id);
    Shipment getByTrackingNumber(String trackingNumber);
    List<Shipment> getByCustomerId(Long customerId);
    List<Shipment> getByStatus(ShipmentStatus status);
    Shipment updateStatus(Long id, ShipmentStatus status);
}
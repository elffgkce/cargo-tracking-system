package com.cargotracking.cargotrackingsystem.service;

import com.cargotracking.cargotrackingsystem.entity.Shipment;
import com.cargotracking.cargotrackingsystem.entity.ShipmentStatus;
import com.cargotracking.cargotrackingsystem.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    @Override
    @Transactional
    public Shipment save(Shipment shipment) {
        shipment.setTrackingNumber(UUID.randomUUID().toString().substring(0, 10).toUpperCase());
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment getById(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found with id: " + id));
    }

    @Override
    public List<Shipment> getAll() {
        return shipmentRepository.findAll();
    }

    @Override
    @Transactional
    public Shipment update(Long id, Shipment shipment) {
        Shipment existing = getById(id);
        existing.setOriginAddress(shipment.getOriginAddress());
        existing.setOriginCity(shipment.getOriginCity());
        existing.setDestinationAddress(shipment.getDestinationAddress());
        existing.setDestinationCity(shipment.getDestinationCity());
        existing.setStatus(shipment.getStatus());
        existing.setEstimatedDeliveryDate(shipment.getEstimatedDeliveryDate());
        return shipmentRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        shipmentRepository.deleteById(id);
    }

    @Override
    public Shipment getByTrackingNumber(String trackingNumber) {
        return shipmentRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new RuntimeException("Shipment not found with tracking number: " + trackingNumber));
    }

    @Override
    public List<Shipment> getByCustomerId(Long customerId) {
        return shipmentRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Shipment> getByStatus(ShipmentStatus status) {
        return shipmentRepository.findByStatus(status);
    }

    @Override
    @Transactional
    public Shipment updateStatus(Long id, ShipmentStatus status) {
        Shipment shipment = getById(id);
        shipment.setStatus(status);
        return shipmentRepository.save(shipment);
    }
}
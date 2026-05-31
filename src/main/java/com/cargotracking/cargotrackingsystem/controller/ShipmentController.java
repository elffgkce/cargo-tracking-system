package com.cargotracking.cargotrackingsystem.controller;

import com.cargotracking.cargotrackingsystem.entity.Shipment;
import com.cargotracking.cargotrackingsystem.entity.ShipmentStatus;
import com.cargotracking.cargotrackingsystem.service.ShipmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shipments")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentService shipmentService;

    @GetMapping
    public ResponseEntity<List<Shipment>> getAll() {
        return ResponseEntity.ok(shipmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipment> getById(@PathVariable Long id) {
        return ResponseEntity.ok(shipmentService.getById(id));
    }

    @GetMapping("/tracking/{trackingNumber}")
    public ResponseEntity<Shipment> getByTrackingNumber(@PathVariable String trackingNumber) {
        return ResponseEntity.ok(shipmentService.getByTrackingNumber(trackingNumber));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Shipment>> getByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(shipmentService.getByCustomerId(customerId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Shipment>> getByStatus(@PathVariable ShipmentStatus status) {
        return ResponseEntity.ok(shipmentService.getByStatus(status));
    }

    @PostMapping
    public ResponseEntity<Shipment> save(@Valid @RequestBody Shipment shipment) {
        return ResponseEntity.ok(shipmentService.save(shipment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shipment> update(@PathVariable Long id, @Valid @RequestBody Shipment shipment) {
        return ResponseEntity.ok(shipmentService.update(id, shipment));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Shipment> updateStatus(@PathVariable Long id, @RequestParam ShipmentStatus status) {
        return ResponseEntity.ok(shipmentService.updateStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        shipmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
package com.cargotracking.cargotrackingsystem.controller;

import com.cargotracking.cargotrackingsystem.entity.TrackingEvent;
import com.cargotracking.cargotrackingsystem.service.TrackingEventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tracking-events")
@RequiredArgsConstructor
public class TrackingEventController {

    private final TrackingEventService trackingEventService;

    @GetMapping
    public ResponseEntity<List<TrackingEvent>> getAll() {
        return ResponseEntity.ok(trackingEventService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackingEvent> getById(@PathVariable Long id) {
        return ResponseEntity.ok(trackingEventService.getById(id));
    }

    @GetMapping("/shipment/{shipmentId}")
    public ResponseEntity<List<TrackingEvent>> getByShipmentId(@PathVariable Long shipmentId) {
        return ResponseEntity.ok(trackingEventService.getByShipmentId(shipmentId));
    }

    @GetMapping("/shipment/{shipmentId}/history")
    public ResponseEntity<List<TrackingEvent>> getShipmentHistory(@PathVariable Long shipmentId) {
        return ResponseEntity.ok(trackingEventService.getByShipmentIdOrderByEventTimeDesc(shipmentId));
    }

    @PostMapping
    public ResponseEntity<TrackingEvent> save(@Valid @RequestBody TrackingEvent trackingEvent) {
        return ResponseEntity.ok(trackingEventService.save(trackingEvent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trackingEventService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
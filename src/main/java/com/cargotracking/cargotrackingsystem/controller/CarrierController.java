package com.cargotracking.cargotrackingsystem.controller;

import com.cargotracking.cargotrackingsystem.entity.Carrier;
import com.cargotracking.cargotrackingsystem.service.CarrierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/carriers")
@RequiredArgsConstructor
public class CarrierController {

    private final CarrierService carrierService;

    @GetMapping
    public ResponseEntity<List<Carrier>> getAll() {
        return ResponseEntity.ok(carrierService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrier> getById(@PathVariable Long id) {
        return ResponseEntity.ok(carrierService.getById(id));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Carrier>> getActiveCarriers() {
        return ResponseEntity.ok(carrierService.getActiveCarriers());
    }

    @PostMapping
    public ResponseEntity<Carrier> save(@Valid @RequestBody Carrier carrier) {
        return ResponseEntity.ok(carrierService.save(carrier));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrier> update(@PathVariable Long id, @Valid @RequestBody Carrier carrier) {
        return ResponseEntity.ok(carrierService.update(id, carrier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carrierService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
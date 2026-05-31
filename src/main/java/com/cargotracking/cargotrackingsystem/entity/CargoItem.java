package com.cargotracking.cargotrackingsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cargo_items")
@Data
public class CargoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shipment_id", nullable = false)
    private Shipment shipment;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private Double width;

    @Column(nullable = false)
    private Double height;

    @Column(nullable = false)
    private Double length;

    private Integer quantity;
}
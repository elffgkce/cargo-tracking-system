package com.cargotracking.cargotrackingsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "carriers")
@Data
public class Carrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String contactPerson;

    private boolean active = true;
}
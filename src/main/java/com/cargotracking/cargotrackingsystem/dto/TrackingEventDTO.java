package com.cargotracking.cargotrackingsystem.dto;

import com.cargotracking.cargotrackingsystem.entity.ShipmentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TrackingEventDTO {

    @NotNull(message = "Shipment ID cannot be null")
    private Long shipmentId;

    @NotBlank(message = "Location cannot be blank")
    private String location;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Status cannot be null")
    private ShipmentStatus status;
}
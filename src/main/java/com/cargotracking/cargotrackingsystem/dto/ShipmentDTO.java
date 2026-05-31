package com.cargotracking.cargotrackingsystem.dto;

import com.cargotracking.cargotrackingsystem.entity.ShipmentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ShipmentDTO {

    @NotNull(message = "Customer ID cannot be null")
    private Long customerId;

    @NotNull(message = "Carrier ID cannot be null")
    private Long carrierId;

    @NotBlank(message = "Origin address cannot be blank")
    private String originAddress;

    @NotBlank(message = "Origin city cannot be blank")
    private String originCity;

    @NotBlank(message = "Destination address cannot be blank")
    private String destinationAddress;

    @NotBlank(message = "Destination city cannot be blank")
    private String destinationCity;

    private ShipmentStatus status;
}
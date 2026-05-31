package com.cargotracking.cargotrackingsystem.dto;

import com.cargotracking.cargotrackingsystem.entity.PaymentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentDTO {

    @NotNull(message = "Shipment ID cannot be null")
    private Long shipmentId;

    @NotNull(message = "Amount cannot be null")
    private Double amount;

    @NotNull(message = "Payment status cannot be null")
    private PaymentStatus status;

    @NotBlank(message = "Payment method cannot be blank")
    private String paymentMethod;
}
package com.cargotracking.cargotrackingsystem.service;

import com.cargotracking.cargotrackingsystem.entity.Payment;
import com.cargotracking.cargotrackingsystem.entity.PaymentStatus;
import java.util.List;

public interface PaymentService {

    Payment save(Payment payment);
    Payment getById(Long id);
    List<Payment> getAll();
    Payment update(Long id, Payment payment);
    void delete(Long id);
    Payment getByShipmentId(Long shipmentId);
    List<Payment> getByStatus(PaymentStatus status);
}
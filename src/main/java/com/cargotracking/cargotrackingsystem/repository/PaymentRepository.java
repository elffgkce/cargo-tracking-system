package com.cargotracking.cargotrackingsystem.repository;

import com.cargotracking.cargotrackingsystem.entity.Payment;
import com.cargotracking.cargotrackingsystem.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByShipmentId(Long shipmentId);

    List<Payment> findByStatus(PaymentStatus status);

    List<Payment> findByPaymentMethod(String paymentMethod);
}
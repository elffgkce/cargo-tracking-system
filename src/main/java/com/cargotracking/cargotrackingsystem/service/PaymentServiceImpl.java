package com.cargotracking.cargotrackingsystem.service;

import com.cargotracking.cargotrackingsystem.entity.Payment;
import com.cargotracking.cargotrackingsystem.entity.PaymentStatus;
import com.cargotracking.cargotrackingsystem.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public Payment save(Payment payment) {
        payment.setStatus(PaymentStatus.PENDING);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    @Transactional
    public Payment update(Long id, Payment payment) {
        Payment existing = getById(id);
        existing.setAmount(payment.getAmount());
        existing.setStatus(payment.getStatus());
        existing.setPaymentMethod(payment.getPaymentMethod());
        return paymentRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public Payment getByShipmentId(Long shipmentId) {
        return paymentRepository.findByShipmentId(shipmentId)
                .orElseThrow(() -> new RuntimeException("Payment not found for shipment id: " + shipmentId));
    }

    @Override
    public List<Payment> getByStatus(PaymentStatus status) {
        return paymentRepository.findByStatus(status);
    }
}
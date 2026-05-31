package com.cargotracking.cargotrackingsystem.service;

import com.cargotracking.cargotrackingsystem.entity.Carrier;
import com.cargotracking.cargotrackingsystem.repository.CarrierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarrierServiceImpl implements CarrierService {

    private final CarrierRepository carrierRepository;

    @Override
    @Transactional
    public Carrier save(Carrier carrier) {
        return carrierRepository.save(carrier);
    }

    @Override
    public Carrier getById(Long id) {
        return carrierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrier not found with id: " + id));
    }

    @Override
    public List<Carrier> getAll() {
        return carrierRepository.findAll();
    }

    @Override
    @Transactional
    public Carrier update(Long id, Carrier carrier) {
        Carrier existing = getById(id);
        existing.setName(carrier.getName());
        existing.setPhone(carrier.getPhone());
        existing.setEmail(carrier.getEmail());
        existing.setContactPerson(carrier.getContactPerson());
        existing.setActive(carrier.isActive());
        return carrierRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        carrierRepository.deleteById(id);
    }

    @Override
    public List<Carrier> getActiveCarriers() {
        return carrierRepository.findByActive(true);
    }
}
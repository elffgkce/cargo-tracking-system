package com.cargotracking.cargotrackingsystem.service;

import com.cargotracking.cargotrackingsystem.entity.Carrier;
import java.util.List;

public interface CarrierService {

    Carrier save(Carrier carrier);
    Carrier getById(Long id);
    List<Carrier> getAll();
    Carrier update(Long id, Carrier carrier);
    void delete(Long id);
    List<Carrier> getActiveCarriers();
}
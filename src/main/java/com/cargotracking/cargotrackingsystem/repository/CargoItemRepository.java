package com.cargotracking.cargotrackingsystem.repository;

import com.cargotracking.cargotrackingsystem.entity.CargoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CargoItemRepository extends JpaRepository<CargoItem, Long> {

    List<CargoItem> findByShipmentId(Long shipmentId);

    List<CargoItem> findByWeightGreaterThan(Double weight);
}
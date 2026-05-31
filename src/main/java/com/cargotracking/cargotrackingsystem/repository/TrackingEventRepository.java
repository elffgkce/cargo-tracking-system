package com.cargotracking.cargotrackingsystem.repository;

import com.cargotracking.cargotrackingsystem.entity.TrackingEvent;
import com.cargotracking.cargotrackingsystem.entity.ShipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrackingEventRepository extends JpaRepository<TrackingEvent, Long> {

    List<TrackingEvent> findByShipmentId(Long shipmentId);

    List<TrackingEvent> findByStatus(ShipmentStatus status);

    List<TrackingEvent> findByLocation(String location);

    List<TrackingEvent> findByShipmentIdOrderByEventTimeDesc(Long shipmentId);
}
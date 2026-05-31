package com.cargotracking.cargotrackingsystem.service;

import com.cargotracking.cargotrackingsystem.entity.TrackingEvent;
import java.util.List;

public interface TrackingEventService {

    TrackingEvent save(TrackingEvent trackingEvent);
    TrackingEvent getById(Long id);
    List<TrackingEvent> getAll();
    void delete(Long id);
    List<TrackingEvent> getByShipmentId(Long shipmentId);
    List<TrackingEvent> getByShipmentIdOrderByEventTimeDesc(Long shipmentId);
}
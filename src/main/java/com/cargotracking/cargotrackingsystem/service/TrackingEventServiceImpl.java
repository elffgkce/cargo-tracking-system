package com.cargotracking.cargotrackingsystem.service;

import com.cargotracking.cargotrackingsystem.entity.TrackingEvent;
import com.cargotracking.cargotrackingsystem.repository.TrackingEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackingEventServiceImpl implements TrackingEventService {

    private final TrackingEventRepository trackingEventRepository;

    @Override
    @Transactional
    public TrackingEvent save(TrackingEvent trackingEvent) {
        return trackingEventRepository.save(trackingEvent);
    }

    @Override
    public TrackingEvent getById(Long id) {
        return trackingEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TrackingEvent not found with id: " + id));
    }

    @Override
    public List<TrackingEvent> getAll() {
        return trackingEventRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        trackingEventRepository.deleteById(id);
    }

    @Override
    public List<TrackingEvent> getByShipmentId(Long shipmentId) {
        return trackingEventRepository.findByShipmentId(shipmentId);
    }

    @Override
    public List<TrackingEvent> getByShipmentIdOrderByEventTimeDesc(Long shipmentId) {
        return trackingEventRepository.findByShipmentIdOrderByEventTimeDesc(shipmentId);
    }
}
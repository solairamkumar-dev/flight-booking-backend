package com.booking.flight.service;

import com.booking.flight.entity.FlightStatus;
import com.booking.flight.repository.FlightStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightStatusService {

    private final FlightStatusRepository repository;

    public List<FlightStatus> getAllStatus(int page, int size)
    {
        Pageable pageable = PageRequest.of(page,size);
        return repository.findAll(pageable).getContent();
    }

    public String addStatus(List<FlightStatus> status) {
        repository.saveAll(status);
        return "Flight status added successfully!";
    }

    public FlightStatus getFlightStatus(Long id) {
        return repository.findById(id).orElse(null);
    }

    public String updateStatus(FlightStatus flightStatus) {
        repository.save(flightStatus);
        String flightNumber = getFlightStatus(flightStatus.getId()).getFlight().getFlightNumber();
        return "Flight status updated successfully for "+flightNumber;
    }
}

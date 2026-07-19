package com.booking.flight.service;

import com.booking.flight.entity.Airport;
import com.booking.flight.repository.AirportDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportDetailsService {

    private final AirportDetailsRepository repository;

    public List<Airport> getAllAirports() {
        return repository.findAll();
    }


    public String addAirports(List<Airport> airports) {
        repository.saveAll(airports);
        return "Airports added successfully!";
    }
}

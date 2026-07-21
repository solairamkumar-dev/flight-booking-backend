package com.booking.flight.service;

import com.booking.flight.entity.Airport;
import com.booking.flight.repository.AirportDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportDetailsService {

    private final AirportDetailsRepository repository;

    public List<Airport> getAllAirports(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return repository.findAll(pageable).getContent();
    }


    public String addAirports(List<Airport> airports) {
        repository.saveAll(airports);
        return "Airports added successfully!";
    }

    public String deleteAirportDetail(Airport airport) {
        repository.delete(airport);
        return "Airport "+airport.getAirportName()+" delete successfully!";
    }

    public String updateAirportDetail(Airport airport) {
        repository.save(airport);
        return "Airport details for "+airport.getAirportName()+" is updated successfully!";
    }

    public Airport getAirportDetail(Long id) {
        return repository.findAirportById(id);
    }

}

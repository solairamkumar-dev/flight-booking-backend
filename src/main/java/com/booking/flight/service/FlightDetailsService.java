package com.booking.flight.service;

import com.booking.flight.entity.Flight;
import com.booking.flight.mapper.FlightDetailsMapper;
import com.booking.flight.dto.FlightDetailsResponse;
import com.booking.flight.repository.FlightDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FlightDetailsService {
    private final FlightDetailsRepository repository;
    private final FlightDetailsMapper mapper;

    public List<FlightDetailsResponse> getFlightDetails(int page, int size, String sorting) {
        log.info("Fetching all flight Details");
        Pageable pageable = PageRequest.of(page, size, Sort.by(sorting));
        return mapper.toDto(repository.findAll(pageable).getContent());
    }

    @Cacheable(value = "flights" , key="#id")
    public FlightDetailsResponse getFlightDetail(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public String addNewFlight(List<Flight> flights) {
        repository.saveAll(flights);
        return "New Flights Added Successfully!";
    }

    @CacheEvict(value = "flights" , key = "#flight.id")
    public String deleteFlight(Flight flight) {
        repository.delete(flight);
        return "Flight "+flight.getFlightNumber()+" deleted successfully!";
    }

    @CachePut(value = "flights" , key = "#flight.id")
    public String updateFlight(Flight flight) {
        repository.save(flight);
        return "Flight details are updated for flight number "+flight.getFlightNumber();
    }

}

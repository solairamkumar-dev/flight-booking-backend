package com.booking.flight.service;

import com.booking.flight.mapper.FlightDetailsMapper;
import com.booking.flight.dto.FlightDetailsResponse;
import com.booking.flight.repository.FlightDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FlightDetailsService {
    private final FlightDetailsRepository repository;
    private final FlightDetailsMapper mapper;

    public List<FlightDetailsResponse> getFlightDetails() {
        log.info("Fetching all flight Details");
        return mapper.toDto(repository.findAll());
    }

}

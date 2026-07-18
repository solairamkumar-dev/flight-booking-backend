package com.booking.flight.controller;

import com.booking.flight.dto.FlightDetailsResponse;
import com.booking.flight.service.FlightDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class FlightDetailsController {

    private final FlightDetailsService service;

    @GetMapping("/flights")
    public ResponseEntity<List<FlightDetailsResponse>> getFlightDetails(){
        return ResponseEntity.ok(service.getFlightDetails());
    }

}

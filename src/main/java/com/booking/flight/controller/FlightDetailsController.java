package com.booking.flight.controller;

import com.booking.flight.dto.FlightDetailsResponse;
import com.booking.flight.entity.Flight;
import com.booking.flight.service.FlightDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class FlightDetailsController {

    private final FlightDetailsService service;

    @GetMapping("/flights")
    public ResponseEntity<List<FlightDetailsResponse>> getFlightDetails(
            @RequestParam(defaultValue = "0") int page ,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "flightName") String sorting){
        return ResponseEntity.ok(service.getFlightDetails(page,size,sorting));
    }

    @PostMapping("/flights")
    public ResponseEntity<String> addNewFlight(@RequestBody List<Flight> flights) {
        String response = service.addNewFlight(flights);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/flights")
    public ResponseEntity<String> deleteFlight(@RequestBody Flight flight) {
        String response = service.deleteFlight(flight);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/flights")
    public ResponseEntity<String> updateFlight(@RequestBody Flight flight) {
        String response = service.updateFlight(flight);
        return ResponseEntity.ok(response);
    }

}

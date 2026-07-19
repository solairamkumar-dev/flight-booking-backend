package com.booking.flight.controller;

import com.booking.flight.entity.Airport;
import com.booking.flight.service.AirportDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class AirportDetailsController {

    private final AirportDetailsService service;
    @GetMapping("/airports")
    public ResponseEntity<List<Airport>> getAllAirports() {
      return ResponseEntity.ok(service.getAllAirports());
    }

    @PostMapping("/airports")
    public ResponseEntity<String> addAirports(@RequestBody List<Airport> airports) {
        return ResponseEntity.ok(service.addAirports(airports));
    }

    @DeleteMapping("/airports")
    public ResponseEntity<String> deleteAirport(@RequestBody Airport airport) {
        return ResponseEntity.ok(service.deleteAirportDetail(airport));
    }

    @PutMapping("/airports")
    public ResponseEntity<String> updateAirportDetail(@RequestBody Airport airport) {
        return ResponseEntity.ok(service.updateAirportDetail(airport));
    }

    @GetMapping("/airports/{id}")
    public ResponseEntity<Airport> findAirport(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAirportDetail(id));
    }

}

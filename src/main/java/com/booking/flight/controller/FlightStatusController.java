package com.booking.flight.controller;

import com.booking.flight.entity.FlightStatus;
import com.booking.flight.service.FlightStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class FlightStatusController {

    private final FlightStatusService service;

    @GetMapping("/flightstatus")
    public ResponseEntity<List<FlightStatus>> getAllStatus(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "5") int size){
        return ResponseEntity.ok(service.getAllStatus(page,size));
    }

    @PostMapping("/flightstatus")
    public ResponseEntity<String> addStatus(@RequestBody List<FlightStatus> statusList) {
        return ResponseEntity.ok(service.addStatus(statusList));
    }

    @PutMapping("/flightstatus")
    public ResponseEntity<String> updateStatus(@RequestBody FlightStatus flightStatus) {
        return ResponseEntity.ok(service.updateStatus(flightStatus));
    }


}

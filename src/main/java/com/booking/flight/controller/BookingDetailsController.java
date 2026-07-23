package com.booking.flight.controller;

import com.booking.flight.entity.BookingDetail;
import com.booking.flight.service.BookingDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class BookingDetailsController {

    private final BookingDetailsService service;

    @PostMapping("/booking")
    public ResponseEntity<String> addBooking(@RequestBody BookingDetail bookingDetail) {
        System.out.println(bookingDetail);
        return ResponseEntity.ok(service.addBooking(bookingDetail));
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<BookingDetail> getBooking(@PathVariable Long id) {
        return ResponseEntity.ok(service.findBooking(id));
    }

}

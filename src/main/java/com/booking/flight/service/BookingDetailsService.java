package com.booking.flight.service;

import com.booking.flight.entity.BookingDetail;
import com.booking.flight.repository.BookingDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingDetailsService {

    private final BookingDetailRepository repository;

    public String addBooking(BookingDetail bookingDetail) {
        BookingDetail detail = bookingDetail;
        detail.getPassengerDetailList()
                .forEach(x -> x.setBookingDetail(bookingDetail));
        repository.save(detail);
        return "Booking done successfully!";
    }

    public BookingDetail findBooking(Long id) {
        return repository.findById(id).orElse(null);
    }
}

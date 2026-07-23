package com.booking.flight.repository;

import com.booking.flight.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailRepository extends JpaRepository<BookingDetail , Long> {
}

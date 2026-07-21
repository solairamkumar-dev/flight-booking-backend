package com.booking.flight.repository;

import com.booking.flight.entity.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightStatusRepository extends JpaRepository<FlightStatus, Long> {
}

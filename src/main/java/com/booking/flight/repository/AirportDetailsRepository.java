package com.booking.flight.repository;

import com.booking.flight.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportDetailsRepository extends JpaRepository<Airport , Long> {
}

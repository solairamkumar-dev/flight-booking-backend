package com.booking.flight.integration.service;

import com.booking.flight.entity.Airport;
import com.booking.flight.repository.AirportDetailsRepository;
import com.booking.flight.service.AirportDetailsService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
@Transactional
@ActiveProfiles("local")
public class AirportDetailsServiceIntegrationTest {

    @Autowired
    private AirportDetailsService service;

    @Autowired
    private AirportDetailsRepository repository;


    @Test
    void fetchAllAirports() {
        int page = 0;
        int size = 10;
        String sort = "airportCode";
        List<Airport> airports = service.getAllAirports( page,size, sort);

        assertNotNull(airports);
        assertTrue(airports.size()>5);
        assertTrue(
                airports.stream()
                        .anyMatch(x -> "DEL".equals(x.getAirportCode()))
        );
    }

    @Test
    void fetchAirport() {
        Airport airport = service.getAirportDetail(2L);
        assertEquals("BOM", airport.getAirportCode());
    }

}

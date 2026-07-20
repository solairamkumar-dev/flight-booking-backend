package com.booking.flight.unit.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.booking.flight.entity.Airport;
import com.booking.flight.repository.AirportDetailsRepository;
import com.booking.flight.service.AirportDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AirportDetailsServiceTest {

    @Mock
    private AirportDetailsRepository repository;

    @InjectMocks
    private AirportDetailsService service;

    @Test
    void returnAllAirports() {
        Airport airport1 = new Airport();
        airport1.setAirportCode("MAA");
        airport1.setAirportName("Chennai International Airport");

        Airport airport2 = new Airport();
        airport2.setAirportCode("DEL");
        airport2.setAirportName("Indira Gandhi International Airport");

        List<Airport> airports = List.of(airport1, airport2);

        when(repository.findAll()).thenReturn(airports);

        List<Airport> result = service.getAllAirports();

    assertNotNull(result);
    assertEquals(2, result.size());
    assertTrue(
            result.stream().anyMatch(x -> "DEL".equals(x.getAirportCode()))
    );
    }
}

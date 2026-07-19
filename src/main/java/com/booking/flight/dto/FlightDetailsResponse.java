package com.booking.flight.dto;

import jakarta.validation.constraints.NotBlank;

public record FlightDetailsResponse(
        Long id,
        String flightNumber,
        String flightName,
        String flightModel
) {

}

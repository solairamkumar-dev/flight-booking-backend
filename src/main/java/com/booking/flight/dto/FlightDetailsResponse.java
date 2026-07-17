package com.booking.flight.dto;

import jakarta.validation.constraints.NotBlank;

public record FlightDetailsResponse(
        String flightNumber,
        String flightName,
        String flightModel
) {

}

package com.booking.flight.mapper;

import com.booking.flight.dto.FlightDetailsResponse;
import com.booking.flight.entity.Flight;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightDetailsMapper {
    FlightDetailsResponse toDto(Flight flight);
    List<FlightDetailsResponse> toDto(List<Flight> flight);
}

package com.booking.flight.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flight")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_number", nullable = false, unique = true)
    private String flightNumber;

    @Column(name = "flight_name", nullable = false)
    private String flightName;

    @Column(name = "flight_model", nullable = false)
    private String flightModel;

    @Column(name = "year_of_making")
    private String yearOfMaking;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "flight" , cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<FlightStatus> statusList = new ArrayList<>();
}

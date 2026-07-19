package com.booking.flight.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "airport")
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "airport_code", nullable = false, unique = true)
    private String airportCode;

    @Column(name = "airport_name" , nullable = false)
    private String airportName;

    @Column(name = "location_detail" , nullable = false)
    private String locationDetail;

}

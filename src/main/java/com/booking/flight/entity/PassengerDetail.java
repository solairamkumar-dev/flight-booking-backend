package com.booking.flight.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "passenger")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "bookingDetail")
public class PassengerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "government_id")
    @Size(min = 12, max = 12, message = "Government ID is not valid, Please enter the 12 digit ID")
    private String governmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", nullable = false)
    @JsonBackReference
    private BookingDetail bookingDetail;
}

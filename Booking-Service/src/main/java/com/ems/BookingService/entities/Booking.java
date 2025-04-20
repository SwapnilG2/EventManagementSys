package com.ems.BookingService.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;   // From User Service
    private Long eventId;  // From Event Service

    private Date bookingDate;
    private int seatsBooked;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        CONFIRMED,
        CANCELLED,
        PENDING
    }

}

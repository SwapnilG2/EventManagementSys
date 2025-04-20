package com.ems.BookingService.dto;

import lombok.Data;

@Data
public class BookingResponse{
    private Long bookingId;
    private User user;
    private Event event;
    private String status;
}

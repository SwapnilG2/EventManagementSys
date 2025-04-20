package com.ems.BookingService.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Event {
	private Long id;
	private String name;
	private String location;
	private Date date;
	private int availableSeats;
}

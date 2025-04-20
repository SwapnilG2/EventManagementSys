package com.ems.BookingService.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.BookingService.dto.BookingResponse;
import com.ems.BookingService.entities.Booking;
import com.ems.BookingService.services.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
		return ResponseEntity.ok(bookingService.createBooking(booking));
	}

	@GetMapping
	public ResponseEntity<List<Booking>> getAllBookings() {
		return ResponseEntity.ok(bookingService.getAllBookings());
	}

	@PostMapping("/create")
	public BookingResponse createBooking(@RequestParam Long userId, @RequestParam Long eventId,
			@RequestParam Booking.Status status) {
		return bookingService.bookEvent(userId, eventId, status);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
		Optional<Booking> booking = bookingService.getBookingById(id);
		return booking.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable Long userId) {
		return ResponseEntity.ok(bookingService.getBookingsByUserId(userId));
	}

	@GetMapping("/event/{eventId}")
	public ResponseEntity<List<Booking>> getBookingsByEventId(@PathVariable Long eventId) {
		return ResponseEntity.ok(bookingService.getBookingsByEventId(eventId));
	}

	@PutMapping("/cancel/{id}")
	public ResponseEntity<Void> cancelBooking(@PathVariable Long id) {
		bookingService.cancelBooking(id);
		return ResponseEntity.noContent().build();
	}
}

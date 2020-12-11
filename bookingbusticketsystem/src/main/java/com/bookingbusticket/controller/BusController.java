package com.bookingbusticket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingbusticket.service.BusService;

@RestController
@RequestMapping("${unsecure.user.context.path}/bus")
public class BusController {
	private Logger logger = LoggerFactory.getLogger(BusController.class);
	@Autowired
	BusService busService;
	
	@GetMapping()
	public ResponseEntity<?> findByTripId()
	{
		try {
			return ResponseEntity.ok(busService.findAll());
		} catch (Exception e) {
			logger.error("Error findByTripId >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	@GetMapping("/trip")
	public ResponseEntity<?> findByTripId(@RequestParam("id") Integer tripId) {
		try {
			return ResponseEntity.ok(busService.findByTripId(tripId));
		} catch (Exception e) {
			logger.error("Error findByTripId >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}

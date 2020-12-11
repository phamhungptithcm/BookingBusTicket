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

import com.bookingbusticket.service.TripService;

@RestController
@RequestMapping("${unsecure.user.context.path}/trip")
public class TripController {
	private Logger logger = LoggerFactory.getLogger(TripController.class);
	@Autowired
	TripService tripService;

	@GetMapping
	public ResponseEntity<?> findByRouteId(@RequestParam("routeId") Integer id) {
		try {
			return ResponseEntity.ok(tripService.findByRouteId(id));
		} catch (Exception e) {
			logger.error("Error findTripByRouteId >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/bybus")
	public ResponseEntity<?> findByBusId(@RequestParam("id") Integer id) {
		try {
			return ResponseEntity.ok(tripService.findByBusId(id));
		} catch (Exception e) {
			logger.error("Error findTripByBusId >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}

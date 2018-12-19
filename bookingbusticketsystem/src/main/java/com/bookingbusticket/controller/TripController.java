package com.bookingbusticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingbusticket.entity.Trip;
import com.bookingbusticket.service.TripService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/user/trip")
public class TripController {
	@Autowired
	TripService tripService;
	
	@GetMapping
	public Iterable<Trip> findByRouteId(@RequestParam("routeId") Integer id)
	{
		return tripService.findByRouteId(id);
	}
	
	@GetMapping("/bybus")
	public Trip findByBusId(@RequestParam("id") Integer id) {
		return tripService.findByBusId(id);
	}
}

package com.bookingbusticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingbusticket.entity.Bus;
import com.bookingbusticket.service.BusService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/user/bus")
public class BusController {
	
	@Autowired
	BusService busService;
	
	@GetMapping()
	public Iterable<Bus> findByTripId()
	{
		return busService.findAll();
	}
	@GetMapping("/trip")
	public Bus findByTripId(@RequestParam("id") Integer tripId) {
		return busService.findByTripId(tripId);
	}
}

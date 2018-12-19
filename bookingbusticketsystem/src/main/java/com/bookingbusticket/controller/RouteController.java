package com.bookingbusticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingbusticket.entity.Route;
import com.bookingbusticket.service.RouteService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/user/route")
public class RouteController {
	@Autowired
	RouteService routeService;
	
	@GetMapping
	public Iterable<Route> findRoute(){
		return routeService.findAll();
	}
	@GetMapping("/route")
	public Route findById(@RequestParam("id") Integer id) {
		return routeService.finfById(id);
	}
	@GetMapping("/fromandto")
	public Route findById(@RequestParam("from") Integer from, @RequestParam("to") Integer to)
	{
		return routeService.findByFromAndTo(from, to);
	}
	
}

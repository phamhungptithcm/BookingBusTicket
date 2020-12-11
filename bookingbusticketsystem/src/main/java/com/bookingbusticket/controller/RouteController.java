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

import com.bookingbusticket.service.RouteService;

@RestController
@RequestMapping("${unsecure.user.context.path}/route")
public class RouteController {
	
	private Logger logger = LoggerFactory.getLogger(RouteController.class);
	
	@Autowired
	RouteService routeService;
	
	@GetMapping
	public ResponseEntity<?> findRoute(){
		try {
			return ResponseEntity.ok(routeService.findAll());
		} catch (Exception e) {
			logger.error("Error findRoute >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	@GetMapping("/route")
	public ResponseEntity<?> findById(@RequestParam("id") Integer id) {
		try {
			return ResponseEntity.ok(routeService.finfById(id));
		} catch (Exception e) {
			logger.error("Error findRouteById >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	@GetMapping("/fromandto")
	public ResponseEntity<?> findById(@RequestParam("from") Integer from, @RequestParam("to") Integer to)
	{
		try {
			return ResponseEntity.ok(routeService.findByFromAndTo(from, to));
		} catch (Exception e) {
			logger.error("Error findRouteById >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
}

package com.bookingbusticket.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingbusticket.repository.TicketDetailRepository;
import com.bookingbusticket.service.TicketDetailService;
import com.bookingbusticket.service.TicketService;

@RestController
@RequestMapping("${unsecure.user.context.path}/ticket")
public class TicketController {
	
	private Logger logger = LoggerFactory.getLogger(TicketController.class);
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	TicketDetailService ticketDetailService;
	@Autowired
	TicketDetailRepository t;
	
	@GetMapping
	public ResponseEntity<?> findById(@RequestParam("id") Integer id) {
		try {
			return ResponseEntity.ok(ticketService.finfById(id));
		} catch (Exception e) {
			logger.error("Error findTicketById >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	@GetMapping("/bus")
	public ResponseEntity<?> findByBusId(@RequestParam("id") Integer busId, @RequestParam("date") String date)
	{
		Date df = null;
		try {
			df = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			return ResponseEntity.ok(ticketService.findByBusId(df,busId));
		} catch (Exception e) {
			logger.error("Error findTicketByBusId >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}

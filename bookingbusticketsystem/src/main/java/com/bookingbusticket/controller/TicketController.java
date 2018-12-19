package com.bookingbusticket.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingbusticket.entity.Ticket;
import com.bookingbusticket.entity.TicketDetail;
import com.bookingbusticket.helper.TicketAndStatus;
import com.bookingbusticket.repository.TicketDetailRepository;
import com.bookingbusticket.service.TicketDetailService;
import com.bookingbusticket.service.TicketService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/user/ticket")
public class TicketController {
	@Autowired
	TicketService ticketService;
	
	@Autowired
	TicketDetailService ticketDetailService;
	@Autowired
	TicketDetailRepository t;
	
	@GetMapping
	public Ticket findById(@RequestParam("id") Integer id) {
		return ticketService.finfById(id);
	}
	@GetMapping("/bus")
	public List<TicketAndStatus> findByBusId(@RequestParam("id") Integer busId, @RequestParam("date") String date)
	{
		Date df = null;
		try {
			df = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticketService.findByBusId(df,busId);
	}
}

package com.bookingbusticket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookingbusticket.entity.Order;
import com.bookingbusticket.entity.TicketDetail;
import com.bookingbusticket.helper.OrderData;
import com.bookingbusticket.service.OrderService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/user/order")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@GetMapping
	public Iterable<Order> findAll(){
		return orderService.findAll();
	}
	
	@PostMapping("/checkout")
	public Order checkout(@RequestBody OrderData orderData) {
		Iterable<TicketDetail> ls = orderData.getTicketDetails();
		Order order = orderData.getOrder();
		for (TicketDetail ticketDetail : ls) {
			System.out.println(ticketDetail.getDepartureDate());
		}
		return orderService.purchase(order, ls);
	}
}

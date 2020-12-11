package com.bookingbusticket.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookingbusticket.entity.Order;
import com.bookingbusticket.entity.TicketDetail;
import com.bookingbusticket.helper.OrderData;
import com.bookingbusticket.service.OrderService;

@RestController
@RequestMapping("${unsecure.user.context.path}/order")
public class OrderController {
	private Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	OrderService orderService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		try {
			return ResponseEntity.ok(orderService.findAll());
		} catch (Exception e) {
			logger.error("Error findAllOrders >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PostMapping("/checkout")
	public ResponseEntity<?> checkout(@RequestBody OrderData orderData) {
		
		try {
			Iterable<TicketDetail> ls = orderData.getTicketDetails();
			Order order = orderData.getOrder();
			return ResponseEntity.ok(orderService.purchase(order, ls));
		} catch (Exception e) {
			logger.error("Error checkout >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}

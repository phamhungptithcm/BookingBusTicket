package com.bookingbusticket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingbusticket.entity.TicketDetail;
import com.bookingbusticket.entity.User;
import com.bookingbusticket.helper.Login;
import com.bookingbusticket.helper.Mailer;
import com.bookingbusticket.service.TicketDetailService;
import com.bookingbusticket.service.UserService;

@RestController
@RequestMapping("${unsecure.user.context.path}/manage")
public class AccountController {
	
	private Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	TicketDetailService ticketDetailService;

	@Autowired
	Mailer mailer;

	@GetMapping("/ticket/viewall")
	public ResponseEntity<?> getAllTicket(@RequestParam("id") Integer userId) {
		try {
			return ResponseEntity.ok(ticketDetailService.findByUserId(userId));
		} catch (Exception e) {
			logger.error("Error getAllTicket >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/ticket/cancel")
	public ResponseEntity<?> getTicketCancel(@RequestParam("id") Integer id) {
		try {
			return ResponseEntity.ok(ticketDetailService.findByUserIdAndDate(id));
		} catch (Exception e) {
			logger.error("Error getTicketCancel >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PutMapping("/ticketdetail/update")
	public ResponseEntity<?> cancelTicket(@RequestBody TicketDetail entity) {
		try {
			return ResponseEntity.ok(ticketDetailService.update(entity));
		} catch (Exception e) {
			logger.error("Error cancelTicket >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login account) {
		try {
			return ResponseEntity.ok(userService.login(account));
		} catch (Exception e) {
			logger.error("Error login >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) {
		try {
			return ResponseEntity.ok(userService.register(user));
		} catch (Exception e) {
			logger.error("Error register >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody User user) {
		try {
			return ResponseEntity.ok(userService.update(user));
		} catch (Exception e) {
			logger.error("Error update >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PutMapping("/forgot")
	public ResponseEntity<?> forgot(@RequestParam("email") String email, @RequestParam("username") String username) {
		try {
			return ResponseEntity.ok(userService.forgotPassword(email, username));
		} catch (Exception e) {
			logger.error("Error forgot >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
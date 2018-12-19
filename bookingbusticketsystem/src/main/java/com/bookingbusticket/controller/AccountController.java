package com.bookingbusticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/user/manage")
public class AccountController {
	@Autowired
	UserService userService;
	@Autowired
	TicketDetailService ticketDetailService;
	
	@Autowired
	Mailer mailer;
	
	@GetMapping("/ticket/viewall")
	public List<TicketDetail> getAllTicket(@RequestParam("id") Integer userId){
		return ticketDetailService.findByUserId(userId);
	}
	@GetMapping("/ticket/cancel")
	public Iterable<TicketDetail> getTicketCancel(@RequestParam("id") Integer id){
		return ticketDetailService.findByUserIdAndDate(id);
	}
	@PutMapping("/ticketdetail/update")
	public TicketDetail cancelTicket(@RequestBody TicketDetail entity) {
		return ticketDetailService.update(entity);
	}
	@PostMapping("/login")
	public User login(@RequestBody Login account) {
		return userService.login(account);
	}
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.register(user);
	}
	@PutMapping("/update")
	public User update(@RequestBody User user) {
		return userService.update(user);
	}
	@PutMapping("/forgot")
	public Boolean forgot(@RequestParam("email") String email, @RequestParam("username") String username) {
		return userService.forgotPassword(email,username);
	}
}
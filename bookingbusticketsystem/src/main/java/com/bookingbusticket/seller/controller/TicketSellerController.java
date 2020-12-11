package com.bookingbusticket.seller.controller;


import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingbusticket.entity.Order;
import com.bookingbusticket.entity.TicketDetail;
import com.bookingbusticket.service.BusService;
import com.bookingbusticket.service.OrderService;
import com.bookingbusticket.service.ProvinceService;
import com.bookingbusticket.service.RouteService;
import com.bookingbusticket.service.TicketDetailService;
import com.bookingbusticket.service.TicketService;
import com.bookingbusticket.service.TripService;
import com.bookingbusticket.service.UserService;


@RestController
@RequestMapping("${secure.staff.context.path}")
public class TicketSellerController {
	
	private Logger logger = LoggerFactory.getLogger(TicketSellerController.class);
	
	@Autowired
	private BusService busService;
	
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private TripService tripService;
	
	@Autowired
	private TicketDetailService ticketDetailService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/tickets")
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(ticketService.findAll());
		} catch (Exception e) {
			logger.error("Error findAll >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	
	@GetMapping("/booked")
	public ResponseEntity<?>  getAllBookedTickets() {
		try {
			return ResponseEntity.ok(ticketDetailService.findByStatus(true));
		} catch (Exception e) {
			logger.error("Error getAllBookedTickets >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	
	
	@GetMapping("/available")
	public ResponseEntity<?>  available() {
		try {
			return ResponseEntity.ok(ticketService.findAllAvailableTicketOrSeat());
		} catch (Exception e) {
			logger.error("Error available >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	
	@GetMapping("/routes")
	public ResponseEntity<?>  findAllRoutes(){
		try {
			return ResponseEntity.ok(routeService.findAll());
		} catch (Exception e) {
			logger.error("Error findAllRoutes >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/provinces")
	public ResponseEntity<?>  findAllProvinces(){
		try {
			return ResponseEntity.ok(provinceService.findAll());
		} catch (Exception e) {
			logger.error("Error findAllProvinces >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/provinces/provinceFrom={id}")
	public ResponseEntity<?>  findAllRemainingProvinces(@PathVariable("id") Integer id){
		try {
			return ResponseEntity.ok(provinceService.findRemainingProvinces(id));
		} catch (Exception e) {
			logger.error("Error findAllRemainingProvinces >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	@GetMapping("/route")
	public ResponseEntity<?>  findRouteId(@RequestParam("fId")Integer fId,@RequestParam("tId")Integer tId){
		try {
			return ResponseEntity.ok(routeService.findRouteId(fId, tId));
		} catch (Exception e) {
			logger.error("Error findRouteId >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/depart")
	public ResponseEntity<?>  findTripByRouteId(@RequestParam("id")Integer id) {
		try {
			return ResponseEntity.ok(tripService.findTripByRouteId(id));
		} catch (Exception e) {
			logger.error("Error findTripByRouteId >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/tripId")
	public ResponseEntity<?>  getTripId(@RequestParam("dTime")String dTime,@RequestParam("id")Integer id){
		try {
			return ResponseEntity.ok( tripService.getTripId(dTime, id));
		} catch (Exception e) {
			logger.error("Error getTripId >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/booked/busId={id}")
	public ResponseEntity<?>  getAllTicketDetails(@PathVariable("id") Integer id){
		try {
			return ResponseEntity.ok(ticketDetailService.getAllTicketDetails(id));
		} catch (Exception e) {
			logger.error("Error getAllTicketDetails >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/buses")
	public ResponseEntity<?>  findAllBuses(){
		try {
			return ResponseEntity.ok(busService.findAll());
		} catch (Exception e) {
			logger.error("Error findAllBuses >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	

	@GetMapping("/booked/name")
	public ResponseEntity<?>  findByLastName(@RequestParam("name")String name,int page, int size){
		try {
			return ResponseEntity.ok(ticketDetailService.findByName(page,size,name));
		} catch (Exception e) {
			logger.error("Error findByLastName >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/trip")
	public ResponseEntity<?>  findByRouteId(@RequestParam("id")Integer id){
		try {
			return ResponseEntity.ok(tripService.findTripByRouteId(id));
		} catch (Exception e) {
			logger.error("Error findByRouteId >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/booked/dd")
	public ResponseEntity<?>  findTicketDetailByDepartureDate(@RequestParam("departure-date")Date date){
		try {
			return ResponseEntity.ok(ticketDetailService.findTicketDetailByDepartureDate(date));
		} catch (Exception e) {
			logger.error("Error findTicketDetailByDepartureDate >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	@GetMapping("/tickets/bus")
	public ResponseEntity<?>  findByBusId(@RequestParam("id")Integer id) {
		try {
			return ResponseEntity.ok(ticketService.findByBusId(id));
		} catch (Exception e) {
			logger.error("Error findByBusId >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/tickets/date")
	public ResponseEntity<?>  findTicketByDate(@RequestParam("date")Date date,@RequestParam("bId")Integer id) {
		try {
			return ResponseEntity.ok(ticketService.findByDate(date,id));
		} catch (Exception e) {
			logger.error("Error findTicketByDate >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PostMapping("/booked/create")
	public void createTicketDetail(@RequestBody TicketDetail d) {
		 try {
			ticketDetailService.save(d);
		} catch (Exception e) {
			logger.error("Error createTicketDetail >> " + e.getMessage(), e);
		}
	}
	
	@PutMapping("/booked/delete")
	public ResponseEntity<?>  deleteTicketDetail(@RequestBody TicketDetail ticketDetail) {
		try {
			return ResponseEntity.ok(ticketDetailService.update(ticketDetail));
		} catch (Exception e) {
			logger.error("Error deleteTicketDetail >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/tickets/count")
	public ResponseEntity<?>  getTicketQuantity() {
		try {
			return ResponseEntity.ok(ticketService.getTicketQuantity());
		} catch (Exception e) {
			logger.error("Error getTicketQuantity >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/booked/count")
	public ResponseEntity<?>  getTicketDetailQuantity() {
		try {
			return ResponseEntity.ok(ticketDetailService.getTicketDetailQuantity());
		} catch (Exception e) {
			logger.error("Error getTicketDetailQuantity >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PutMapping("/booked/update")
	public void updateTicketDetail(@RequestParam("lastName")String lastName,@RequestParam("firstName")String firstName,@RequestParam("id")int id) {
		try {
			ticketDetailService.updateTicketDetailInfoById(firstName, lastName, id);
		} catch (Exception e) {
			logger.error("Error updateTicketDetail >> " + e.getMessage(), e);
		}
	}
	
	@GetMapping("/booked/page")
	public ResponseEntity<?>  getAllBookedByPage(int page,int size,boolean status) {
		try {
			return ResponseEntity.ok(ticketDetailService.findAllByStatus(page,size,true));
		} catch (Exception e) {
			logger.error("Error getAllBookedByPage >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	@GetMapping("/booked/page-bus")
	public ResponseEntity<?>  getAllBookedByPageAndBusId(int page,int size,int busId) {
		try {
			return ResponseEntity.ok(ticketDetailService.getByPageAndBusId(page, size, busId));
		} catch (Exception e) {
			logger.error("Error getAllBookedByPageAndBusId >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/booked/pagenbus")
	public ResponseEntity<?>  findByDepartureDateAndTicketBusBusId(Date date, Integer bId){
		try {
			return ResponseEntity.ok(ticketDetailService.findByDepartureDateAndTicketBusBusId(date, bId));
		} catch (Exception e) {
			logger.error("Error findByDepartureDateAndTicketBusBusId >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PostMapping("/order/create")
	public ResponseEntity<?>  saveOrder(@RequestBody Order order){
		try {
			return ResponseEntity.ok(orderService.save(order));
		} catch (Exception e) {
			logger.error("Error saveOrder >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PutMapping("/booked/delete/dni")
	public void deleteBookedTicket(Date date, int ticketId) {
		 try {
			ticketDetailService.deleteByDepartureDateAndTicketTicketId(date, ticketId);
		} catch (Exception e) {
			logger.error("Error deleteBookedTicket >> " + e.getMessage(), e);
		}
	}
	
	
	
	@GetMapping("/booked/userbyname")
	public ResponseEntity<?> findUserByUserName(String username) {
		 try {
			return ResponseEntity.ok(userService.findById(username));
		} catch (Exception e) {
			logger.error("Error findUserByUserName >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}


package com.bookingbusticket.seller.controller;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingbusticket.entity.Bus;
import com.bookingbusticket.entity.Order;
import com.bookingbusticket.entity.Province;
import com.bookingbusticket.entity.Route;
import com.bookingbusticket.entity.Ticket;
import com.bookingbusticket.entity.TicketDetail;
import com.bookingbusticket.entity.Trip;
import com.bookingbusticket.entity.User;
import com.bookingbusticket.service.BusService;
import com.bookingbusticket.service.OrderService;
import com.bookingbusticket.service.ProvinceService;
import com.bookingbusticket.service.RouteService;
import com.bookingbusticket.service.TicketDetailService;
import com.bookingbusticket.service.TicketService;
import com.bookingbusticket.service.TripService;
import com.bookingbusticket.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/staff")
public class TicketSellerController {
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
	public List<Ticket> abc() {
		return ticketService.findAll();
	}
	
//	@GetMapping("/booked")
//	public List<TicketDetail> getAllBookedTickets() {
//		return ticketDetailService.findAll();
//	}

	
	@GetMapping("/booked")
	public List<TicketDetail> getAllBookedTickets() {
		return ticketDetailService.findByStatus(true);
	}
	
	
	
	@GetMapping("/available")
	public Iterable<Ticket> sad() {
		return ticketService.findAllAvailableTicketOrSeat();
	}

	
	@GetMapping("/routes")
	public List<Route> findAllRoutes(){
		return routeService.findAll();
	}
	
	@GetMapping("/provinces")
	public List<Province> findAllProvinces(){
		return provinceService.findAll();
	}
	
	@GetMapping("/provinces/provinceFrom={id}")
	public Iterable<Province> findAllRemainingProvinces(@PathVariable("id") Integer id){
		return provinceService.findRemainingProvinces(id);
	}
	@GetMapping("/route")
	public Route findRouteId(@RequestParam("fId")Integer fId,@RequestParam("tId")Integer tId){
		return routeService.findRouteId(fId, tId);
	}
	
	@GetMapping("/depart")
	public Iterable<Trip> findTripByRouteId(@RequestParam("id")Integer id) {
		return tripService.findTripByRouteId(id);
	}
	
	@GetMapping("/tripId")
	public Integer getTripId(@RequestParam("dTime")String dTime,@RequestParam("id")Integer id){
		return tripService.getTripId(dTime, id);
	}
	
	@GetMapping("/booked/busId={id}")
	public Iterable<TicketDetail> getAllTicketDetails(@PathVariable("id") Integer id){
		return ticketDetailService.getAllTicketDetails(id);
	}
	
	@GetMapping("/buses")
	public List<Bus> findAllBuses(){
		return busService.findAll();
	}
	

	@GetMapping("/booked/name")
	public Iterable<TicketDetail> findByLastName(@RequestParam("name")String name,int page, int size){
		return ticketDetailService.findByName(page,size,name);
	}
	
	@GetMapping("/trip")
	public Iterable<Trip> findByRouteId(@RequestParam("id")Integer id){
		return tripService.findTripByRouteId(id);
	}
	
	@GetMapping("/booked/dd")
	public Iterable<TicketDetail> findTicketDetailByDepartureDate(@RequestParam("departure-date")Date date){
		return ticketDetailService.findTicketDetailByDepartureDate(date);
	}
	@GetMapping("/tickets/bus")
	public Iterable<Ticket> findByBusId(@RequestParam("id")Integer id) {
		return ticketService.findByBusId(id);
	}
	
	@GetMapping("/tickets/date")
	public Iterable<Ticket> findTicketByDate(@RequestParam("date")Date date,@RequestParam("bId")Integer id) {
		return ticketService.findByDate(date,id);
	}
	
	@PostMapping("/booked/create")
	public void createTicketDetail(@RequestBody TicketDetail d) {
		 ticketDetailService.save(d);
	}
	
	@PutMapping("/booked/delete")
	public TicketDetail deleteTicketDetail(@RequestBody TicketDetail ticketDetail) {
		return ticketDetailService.update(ticketDetail);
	}
	
	@GetMapping("/tickets/count")
	public int getTicketQuantity() {
		return ticketService.getTicketQuantity();
	}
	
	@GetMapping("/booked/count")
	public int getTicketDetailQuantity() {
		return ticketDetailService.getTicketDetailQuantity();
	}
	
	@PutMapping("/booked/update")
	public void updateTicketDetail(@RequestParam("lastName")String lastName,@RequestParam("firstName")String firstName,@RequestParam("id")int id) {
		ticketDetailService.updateTicketDetailInfoById(firstName, lastName, id);
	}
	
	@GetMapping("/booked/page")
	public Page<TicketDetail> getAllBookedByPage(int page,int size,boolean status) {
		return ticketDetailService.findAllByStatus(page,size,true);
	}
	@GetMapping("/booked/page-bus")
	public Page<TicketDetail> getAllBookedByPageAndBusId(int page,int size,int busId) {
		return ticketDetailService.getByPageAndBusId(page, size, busId);
	}
	
	@GetMapping("/booked/pagenbus")
	public List<TicketDetail> findByDepartureDateAndTicketBusBusId(Date date, Integer bId){
		return ticketDetailService.findByDepartureDateAndTicketBusBusId(date, bId);
	}
	
	@PostMapping("/order/create")
	public Order saveOrder(@RequestBody Order order){
		return orderService.save(order);
	}
	
	@PutMapping("/booked/delete/dni")
	public void deleteBookedTicket(Date date, int ticketId) {
		 ticketDetailService.deleteByDepartureDateAndTicketTicketId(date, ticketId);
	}
	
	
	
	@GetMapping("/booked/userbyname")
	public User findUserByUserName(String username) {
		 return userService.findById(username);
	}
}


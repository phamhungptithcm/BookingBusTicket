package com.bookingbusticket.service;

import java.util.Date;
import java.util.List;

import com.bookingbusticket.entity.Ticket;
import com.bookingbusticket.helper.TicketAndStatus;

public interface TicketService {
	public List<Ticket> findAll()  throws Exception;

	public Ticket finfById(Integer id)  throws Exception;

	public List<TicketAndStatus> findByBusId(Date date, Integer busId)  throws Exception;

	public Iterable<Ticket> findByBusId(Integer busId)  throws Exception;

	public Iterable<Ticket> findAllAvailableTicketOrSeat()  throws Exception;

	public Iterable<Ticket> findByDate(Date date, Integer id)  throws Exception;

	// Get Ticket Quantity
	public int getTicketQuantity()  throws Exception;
}

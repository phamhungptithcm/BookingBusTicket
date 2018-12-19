package com.bookingbusticket.service;

import java.util.Date;
import java.util.List;

import com.bookingbusticket.entity.Ticket;
import com.bookingbusticket.helper.TicketAndStatus;

public interface TicketService {
	public Ticket save(Ticket entity);

	public void delete(Integer id);

	public Ticket update(Ticket entity);

	public List<Ticket> findAll();

	public Ticket finfById(Integer id);

	public List<TicketAndStatus> findByBusId(Date date, Integer busId);

	public Iterable<Ticket> findByBusId(Integer busId);

	public Iterable<Ticket> findAllAvailableTicketOrSeat();

	public Iterable<Ticket> findByDate(Date date, Integer id);

	// Get Ticket Quantity
	public int getTicketQuantity();
}

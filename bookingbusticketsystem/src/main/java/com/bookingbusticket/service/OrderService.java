package com.bookingbusticket.service;

import java.util.List;

import com.bookingbusticket.entity.Order;
import com.bookingbusticket.entity.TicketDetail;

public interface OrderService {
	public Order save(Order entity) throws Exception;

	public List<Order> findAll() throws Exception;
	
	public Order purchase(Order order, Iterable<TicketDetail> ls) throws Exception;
}

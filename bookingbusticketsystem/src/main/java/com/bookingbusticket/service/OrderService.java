package com.bookingbusticket.service;

import java.util.List;

import com.bookingbusticket.entity.Order;
import com.bookingbusticket.entity.TicketDetail;

public interface OrderService {
	public Order save(Order entity);

	public void delete(Integer id);

	public Order update(Order entity);

	public List<Order> findAll();

	public Order finfById(Integer id);
	
	public Order purchase(Order order, Iterable<TicketDetail> ls);
}

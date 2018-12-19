package com.bookingbusticket.service;

import java.util.List;

import com.bookingbusticket.entity.OrderStatus;

public interface OrderStatusService {
	public OrderStatus save(OrderStatus entity);

	public void delete(Integer id);

	public OrderStatus update(OrderStatus entity);

	public List<OrderStatus> findAll();

	public OrderStatus finfById(Integer id);
}

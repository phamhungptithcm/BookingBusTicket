package com.bookingbusticket.service;

import java.util.List;

import com.bookingbusticket.entity.Bus;

public interface BusService {
	public Bus save(Bus entity);

	public void delete(Integer id);

	public Bus update(Bus entity);

	public List<Bus> findAll();

	public Bus finfById(Integer id);

	public Bus findByTripId(Integer tripId);
}

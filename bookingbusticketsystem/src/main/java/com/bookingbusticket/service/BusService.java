package com.bookingbusticket.service;

import java.util.List;

import com.bookingbusticket.entity.Bus;

public interface BusService {

	public List<Bus> findAll() throws Exception;

	public Bus findByTripId(Integer tripId) throws Exception;
}

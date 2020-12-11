package com.bookingbusticket.service;

import java.util.List;

import com.bookingbusticket.entity.Trip;

public interface TripService {
	
	public List<Trip> findByRouteId(Integer id) throws Exception;
	
	public Trip findByBusId(Integer id) throws Exception;

	
	public Iterable<Trip> findTripByRouteId(Integer id) throws Exception;
	
	public Integer getTripId(String dTime,Integer id) throws Exception;
}

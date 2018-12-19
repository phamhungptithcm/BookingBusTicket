package com.bookingbusticket.service;

import java.util.List;

import com.bookingbusticket.entity.Trip;

public interface TripService {
	public Trip save(Trip entity);

	public void delete(Integer id);

	public Trip update(Trip entity);

	public List<Trip> findAll();

	public Trip finfById(Integer id);
	
	public List<Trip> findByRouteId(Integer id);
	
	public Trip findByBusId(Integer id);
	

	
	public Iterable<Trip> findTripByRouteId(Integer id);
	
	public Integer getTripId(String dTime,Integer id);
}

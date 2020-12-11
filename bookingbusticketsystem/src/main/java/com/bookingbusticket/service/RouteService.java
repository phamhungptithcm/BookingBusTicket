package com.bookingbusticket.service;

import java.util.List;

import com.bookingbusticket.entity.Route;

public interface RouteService {
	public List<Route> findAll() throws Exception;

	public Route finfById(Integer id) throws Exception;
	
	public Route findByFromAndTo(Integer from, Integer to) throws Exception;
	
	public Route findRouteId(Integer fId,Integer tId) throws Exception;
	
}

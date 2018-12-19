package com.bookingbusticket.service;

import java.util.List;

import com.bookingbusticket.entity.Province;
import com.bookingbusticket.entity.Route;

public interface RouteService {
	public Route save(Route entity);

	public void delete(Integer id);

	public Route update(Route entity);

	public List<Route> findAll();

	public Route finfById(Integer id);
	public Route findByFromAndTo(Integer from, Integer to);
	
	

	
	public Route findRouteId(Integer fId,Integer tId);
	
}

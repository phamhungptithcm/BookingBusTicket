package com.bookingbusticket.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingbusticket.entity.Route;
import com.bookingbusticket.repository.RouteRepository;
import com.bookingbusticket.service.RouteService;

@Service
public class RouteServiceImp implements RouteService{
	
	@Autowired
	RouteRepository routeRepository;
		
	@Override
	public List<Route> findAll() {
		return routeRepository.findAll();
	}

	@Override
	public Route finfById(Integer id) {
		Route r = routeRepository.findById(id).get();
		if(r != null) {
			return r;
		}
		return null;
	}

	@Override
	public Route findByFromAndTo(Integer from, Integer to) {
		return routeRepository.findByFromAndTo(from, to);
	}

	@Override
	public Route findRouteId(Integer fId, Integer tId) {
		return routeRepository.findRouteId(fId, tId);
	}

}

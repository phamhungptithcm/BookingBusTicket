package com.bookingbusticket.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingbusticket.entity.Province;
import com.bookingbusticket.entity.Route;
import com.bookingbusticket.repository.RouteRepository;
import com.bookingbusticket.service.RouteService;

@Service
public class RouteServiceImp implements RouteService{
	
	@Autowired
	RouteRepository routeRepository;
		
	@Override
	public Route save(Route entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Route update(Route entity) {
		// TODO Auto-generated method stub
		return null;
	}

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
		// TODO Auto-generated method stub
		return routeRepository.findByFromAndTo(from, to);
	}

	@Override
	public Route findRouteId(Integer fId, Integer tId) {
		// TODO Auto-generated method stub
		return routeRepository.findRouteId(fId, tId);
	}

}

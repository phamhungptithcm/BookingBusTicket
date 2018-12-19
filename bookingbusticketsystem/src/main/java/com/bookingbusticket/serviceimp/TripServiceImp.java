package com.bookingbusticket.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingbusticket.entity.Trip;
import com.bookingbusticket.repository.TripRepository;
import com.bookingbusticket.service.TripService;

@Service
public class TripServiceImp  implements TripService{
	@Autowired
	TripRepository tripRepository;
	@Override
	public Trip save(Trip entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Trip update(Trip entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trip> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trip finfById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trip> findByRouteId(Integer id) {
		return tripRepository.findByRouteRouteId(id);
	}

	@Override
	public Trip findByBusId(Integer id) {
		// TODO Auto-generated method stub
		return tripRepository.findByBus_BusId(id);
	}

	

	@Override
	public Iterable<Trip> findTripByRouteId(Integer id) {
		// TODO Auto-generated method stub
		return tripRepository.getTrips(id);
	}

	@Override
	public Integer getTripId(String dTime, Integer id) {
		// TODO Auto-generated method stub
		return tripRepository.findTripIdByDepartureTimeAndRouteRouteId(dTime, id);
	}

}

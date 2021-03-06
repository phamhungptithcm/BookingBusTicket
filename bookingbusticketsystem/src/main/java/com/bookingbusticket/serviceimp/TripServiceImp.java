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
	public List<Trip> findByRouteId(Integer id) {
		return tripRepository.findByRouteRouteId(id);
	}

	@Override
	public Trip findByBusId(Integer id) {
		return tripRepository.findByBus_BusId(id);
	}

	

	@Override
	public Iterable<Trip> findTripByRouteId(Integer id) {
		return tripRepository.getTrips(id);
	}

	@Override
	public Integer getTripId(String dTime, Integer id) {
		return tripRepository.findTripIdByDepartureTimeAndRouteRouteId(dTime, id);
	}

}

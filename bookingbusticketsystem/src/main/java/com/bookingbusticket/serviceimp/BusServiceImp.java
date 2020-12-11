package com.bookingbusticket.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingbusticket.entity.Bus;
import com.bookingbusticket.repository.BusRepository;
import com.bookingbusticket.service.BusService;

@Service
public class BusServiceImp implements BusService{
	
	@Autowired
	BusRepository busRepository;
	

	@Override
	public List<Bus> findAll() {
		return busRepository.findAll();
	}

	@Override
	public Bus findByTripId(Integer tripId) {
		return busRepository.findByTripId(tripId);
	}

}

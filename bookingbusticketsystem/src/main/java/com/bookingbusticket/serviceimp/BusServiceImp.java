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
	public Bus save(Bus entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bus update(Bus entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bus> findAll() {
		// TODO Auto-generated method stub
		return busRepository.findAll();
	}

	@Override
	public Bus finfById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bus findByTripId(Integer tripId) {
		// TODO Auto-generated method stub
		return busRepository.findByTripId(tripId);
	}

}

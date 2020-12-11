package com.bookingbusticket.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingbusticket.entity.OrderStatus;
import com.bookingbusticket.repository.OrderStatusRepository;
import com.bookingbusticket.service.OrderStatusService;

@Service
public class OrderStatusServiceImp implements OrderStatusService{
	@Autowired
	OrderStatusRepository orderStatusRepository;
	
	@Override
	public OrderStatus finfById(Integer id) {
		return orderStatusRepository.findById(id).get();
	}

}

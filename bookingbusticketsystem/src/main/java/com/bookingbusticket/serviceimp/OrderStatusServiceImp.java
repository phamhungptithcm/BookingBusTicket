package com.bookingbusticket.serviceimp;

import java.util.List;

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
	public OrderStatus save(OrderStatus entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderStatus update(OrderStatus entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderStatus> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderStatus finfById(Integer id) {
		// TODO Auto-generated method stub
		return orderStatusRepository.findById(id).get();
	}

}

package com.bookingbusticket.serviceimp;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingbusticket.entity.Order;
import com.bookingbusticket.entity.TicketDetail;
import com.bookingbusticket.repository.OrderRepository;
import com.bookingbusticket.service.OrderService;
import com.bookingbusticket.service.OrderStatusService;
import com.bookingbusticket.service.TicketDetailService;

@Service
@Transactional
public class OrderServiceImp implements OrderService{
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	TicketDetailService ticketDetailService;
	@Autowired
	OrderStatusService orderStatusService;
	
	@Override
	public Order save(Order entity) {
		// TODO Auto-generated method stub
		return orderRepository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order update(Order entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public Order finfById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order purchase(Order o, Iterable<TicketDetail> ls) {
		Order order = new Order();
		order.setAmount(o.getAmount());
		order.setOrderDate(new Date());
		order.setLastUpdate(new Date());
		order.setOrderStatus(orderStatusService.finfById(3));
		order.setUser(o.getUser());
		this.save(order);
		for (TicketDetail tD : ls) {
			TicketDetail ticketDetail = new TicketDetail();
			ticketDetail.setFirstName(tD.getFirstName());
			ticketDetail.setDepartureDate(tD.getDepartureDate());
			ticketDetail.setLastName(tD.getLastName());
			ticketDetail.setAge(tD.getAge());
			ticketDetail.setNumSeat(tD.getNumSeat());
			ticketDetail.setGender(tD.getGender());
			ticketDetail.setTicket(tD.getTicket());
			ticketDetail.setOrder(order);
			ticketDetail.setLastUpdate(new Date());
			ticketDetail.setStatus(true);
			ticketDetailService.save(ticketDetail);
		}
		return order;
	}

}

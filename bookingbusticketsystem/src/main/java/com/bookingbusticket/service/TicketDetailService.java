package com.bookingbusticket.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.bookingbusticket.entity.TicketDetail;

public interface TicketDetailService {
	public TicketDetail save(TicketDetail entity);

	public void delete(Integer id);

	public TicketDetail update(TicketDetail entity);

	public List<TicketDetail> findAll();

	public TicketDetail finfById(Integer id);

	public List<TicketDetail> findByUserId(Integer userId);

	public List<TicketDetail> findByUserIdAndDate(Integer userId);

	public List<TicketDetail> findByDepartureDateAndBusId(Date date, Integer busId);

	public void deleteByDepartureDateAndTicketTicketId(Date date, int id);

	public Iterable<TicketDetail> getAllTicketDetails(Integer id);

	public Page<TicketDetail> findByLastName(String name);

	public Iterable<TicketDetail> findTicketDetailByDepartureDate(Date date);

	public int getTicketDetailQuantity();

	public Page<TicketDetail> getByPage(int page, int size);

	public Page<TicketDetail> getByPageAndBusId(int page, int size, int busId);

	public void updateTicketDetailInfoById(String firstName, String lastName, int ticketDetailId);

	public List<TicketDetail> findByDepartureDateAndTicketBusBusId(Date date, Integer busId);

	public Page<TicketDetail> findByName(int page, int size, String name);

	public List<TicketDetail> findByStatus(boolean b);
	
	public Page<TicketDetail> findAllByStatus(int page,int size,boolean status);

	public void updateStatusByDepartureDateAndTicketId(Date date, int ticketId);
	
	public List<TicketDetail> findByStatusAndDepartureDate(boolean status, Date date);
	
	public TicketDetail findByDepartureDateAndTicketTicketId(Date date, int ticketId);
}

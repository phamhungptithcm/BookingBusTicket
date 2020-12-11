package com.bookingbusticket.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.bookingbusticket.entity.TicketDetail;

public interface TicketDetailService {
	public TicketDetail save(TicketDetail entity)  throws Exception;

	public void delete(Integer id)  throws Exception;

	public TicketDetail update(TicketDetail entity)  throws Exception;

	public List<TicketDetail> findAll()  throws Exception;

	public TicketDetail finfById(Integer id)  throws Exception;

	public List<TicketDetail> findByUserId(Integer userId)  throws Exception;

	public List<TicketDetail> findByUserIdAndDate(Integer userId)  throws Exception;

	public List<TicketDetail> findByDepartureDateAndBusId(Date date, Integer busId)  throws Exception;

	public void deleteByDepartureDateAndTicketTicketId(Date date, int id)  throws Exception;

	public Iterable<TicketDetail> getAllTicketDetails(Integer id)  throws Exception;

	public Iterable<TicketDetail> findTicketDetailByDepartureDate(Date date)  throws Exception;

	public int getTicketDetailQuantity()  throws Exception;

	public Page<TicketDetail> getByPage(int page, int size) throws Exception;

	public Page<TicketDetail> getByPageAndBusId(int page, int size, int busId) throws Exception;

	public void updateTicketDetailInfoById(String firstName, String lastName, int ticketDetailId) throws Exception;

	public List<TicketDetail> findByDepartureDateAndTicketBusBusId(Date date, Integer busId) throws Exception;

	public Page<TicketDetail> findByName(int page, int size, String name) throws Exception;

	public List<TicketDetail> findByStatus(boolean b) throws Exception;
	
	public Page<TicketDetail> findAllByStatus(int page,int size,boolean status) throws Exception;

	public void updateStatusByDepartureDateAndTicketId(Date date, int ticketId) throws Exception;
	
	public List<TicketDetail> findByStatusAndDepartureDate(boolean status, Date date) throws Exception;
	
	public TicketDetail findByDepartureDateAndTicketTicketId(Date date, int ticketId) throws Exception;
}

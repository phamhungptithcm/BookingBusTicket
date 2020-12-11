package com.bookingbusticket.serviceimp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bookingbusticket.entity.Ticket;
import com.bookingbusticket.entity.TicketDetail;
import com.bookingbusticket.repository.TicketDetailRepository;
import com.bookingbusticket.repository.TicketRepository;
import com.bookingbusticket.service.TicketDetailService;

@Service
@Transactional
public class TicketDetailServiceImp implements TicketDetailService{
	@Autowired
	private TicketDetailRepository ticketDetailRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public TicketDetail save(TicketDetail entity) {
		return ticketDetailRepository.save(entity);
	}

	@Override
	public void delete(Integer id) {
	}

	@Override
	public TicketDetail update(TicketDetail entity) {
		return ticketDetailRepository.save(entity);
	}

	@Override
	public List<TicketDetail> findAll() {
		return null;
	}
	@Override
	public TicketDetail finfById(Integer id) {
		return ticketDetailRepository.findById(id).get();
	}

	@Override
	public List<TicketDetail> findByUserId(Integer userId) {
		return ticketDetailRepository.findByOrderUserUserId(userId);
	}

	@Override
	public List<TicketDetail> findByUserIdAndDate(Integer userId) {
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
		 Date now = new Date();
		return ticketDetailRepository.findByUserId(userId, df.format(now));
	}

	@Override
	public List<TicketDetail> findByDepartureDateAndBusId(Date date, Integer busId) {
		return ticketDetailRepository.findByDepartureDateAndTicketBusBusIdOrderByDepartureDateAsc(date, busId);
	}

	@Override
	public void deleteByDepartureDateAndTicketTicketId(Date date, int id) {
		ticketDetailRepository.deleteByDepartureDateAndTicketTicketId(date, id);
		Ticket ticket = ticketRepository.findById(id).get();
		ticket.setTicketStatus(true);
		ticketRepository.save(ticket);
	}

	@Override
	public Iterable<TicketDetail> getAllTicketDetails(Integer id) {
		return ticketDetailRepository.findAllByTicketBusBusId(id);
	}

	@Override
	public Page<TicketDetail> findByLastName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<TicketDetail> findTicketDetailByDepartureDate(Date date) {
		return ticketDetailRepository.findAllByDepartureDate(date);
	}

	@Override
	public int getTicketDetailQuantity() {
		return ticketDetailRepository.getTicketDetailQuantity();
	}

	@Override
	public Page<TicketDetail> getByPage(int page, int size) {
		Sort sort = null;
		sort=Sort.by("ticketDetailId").ascending();
		Pageable pageable = PageRequest.of(page, size, sort);

		
		return ticketDetailRepository.findAll(pageable);
	}

	@Override
	public Page<TicketDetail> getByPageAndBusId(int page, int size, int busId) {
		Sort sort = null;
		sort=Sort.by("ticket.bus.busId").descending();
		Pageable pageable = PageRequest.of(page, size, sort);
		if(busId==0) {
			return ticketDetailRepository.findAll(pageable);
		}
		return ticketDetailRepository.findByTicketBusBusId(pageable, busId);
	}

	@Override
	public void updateTicketDetailInfoById(String firstName, String lastName, int ticketDetailId) {
		TicketDetail ticketDetail = ticketDetailRepository.findById(ticketDetailId).get();
		ticketDetail.setFirstName(firstName);
		ticketDetail.setLastName(lastName);
		ticketDetailRepository.save(ticketDetail);
	}

	@Override
	public List<TicketDetail> findByDepartureDateAndTicketBusBusId(Date date, Integer busId) {
		return ticketDetailRepository.findByDepartureDateAndTicketBusBusId(date, busId);
	}

	@Override
	public Page<TicketDetail> findByName(int page, int size, String name) {
		Pageable p= PageRequest.of(page, size);
		return ticketDetailRepository.findByName(p, name);
	}
	@Override
	public Page<TicketDetail> findAllByStatus(int page, int size, boolean status) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page, size);
		return ticketDetailRepository.findAllByStatus(pageable,true);
	}
	@Override
	public List<TicketDetail> findByStatus(boolean status) {
		// TODO Auto-generated method stub
		return ticketDetailRepository.findByStatus(true);
	}

	@Override
	public void updateStatusByDepartureDateAndTicketId(Date date, int ticketId) {
		// TODO Auto-generated method stub
	TicketDetail ticketDetail = ticketDetailRepository.findByDepartureDateAndTicketTicketId(date, ticketId);
	System.out.println(ticketDetail.getDepartureDate());
	System.out.println(ticketDetail.getTicket().getTicketId());
	if(ticketDetail!=null) {
	
		ticketDetail.setStatus(false);
	
		ticketDetailRepository.save(ticketDetail);
		}	
	}

	@Override
	public List<TicketDetail> findByStatusAndDepartureDate(boolean status, Date date) {
		// TODO Auto-generated method stub
		return ticketDetailRepository.findByStatusAndDepartureDate(status, date);
	}

	@Override
	public TicketDetail findByDepartureDateAndTicketTicketId(Date date, int ticketId) {
		// TODO Auto-generated method stub
		return ticketDetailRepository.findByDepartureDateAndTicketTicketId(date, ticketId);
	}

}

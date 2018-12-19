package com.bookingbusticket.serviceimp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookingbusticket.entity.Ticket;
import com.bookingbusticket.entity.TicketDetail;
import com.bookingbusticket.helper.TicketAndStatus;
import com.bookingbusticket.repository.TicketDetailRepository;
import com.bookingbusticket.repository.TicketRepository;
import com.bookingbusticket.service.TicketService;

@Service
@Transactional
public class TicketServiceImp implements TicketService {
	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private TicketDetailRepository ticketDetailRepository;

	@Override
	public List<Ticket> findAll() {

		return ticketRepository.findAll();
	}

	@Override
	public Ticket save(Ticket entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Ticket update(Ticket entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket finfById(Integer id) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(id).get();
	}

	@Override
	public List<TicketAndStatus> findByBusId(Date date, Integer busId) {
		// TODO Auto-generated method stub
		List<TicketAndStatus> ls = new ArrayList<>();
		Iterable<Ticket> lsTickets = ticketRepository.findByBusBusId(busId);
		Iterable<TicketDetail> lsTicketDetails = ticketDetailRepository
				.findByDepartureDateAndTicketBusBusIdAndStatus(date, busId, true);
		TicketAndStatus ts = null;
		boolean check = true;
		for (Ticket t : lsTickets) {
			for (TicketDetail tD : lsTicketDetails) {
				if (t.getTicketId().equals(tD.getTicket().getTicketId())) {
					ts = new TicketAndStatus(t, false);
					ls.add(ts);
					check = false;
					break;
				}
			}
			if (check == true) {
				ts = new TicketAndStatus(t, true);
				ls.add(ts);
			}
			check = true;
		}
		return ls;
	}

	@Override
	public Iterable<Ticket> findByBusId(Integer busId) {
		// TODO Auto-generated method stub
		return ticketRepository.findByBusBusId(busId);
	}

	@Override
	public Iterable<Ticket> findAllAvailableTicketOrSeat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Ticket> findByDate(Date date, Integer id) {
		List<Ticket> listTicket = (List<Ticket>) ticketRepository.findByBusBusId(id);
		List<TicketDetail> listTicketDetailByDate = (List<TicketDetail>) ticketDetailRepository
				.findAllByDepartureDate(date);

		for (int i = 0; i < listTicket.size(); i++) {
			if (listTicketDetailByDate.size() == 0) {
				listTicket.get(i).setTicketStatus(true);
				ticketRepository.save(listTicket.get(i));
				System.out.println("null");

			} else {
				for (int j = 0; j < listTicketDetailByDate.size(); j++) {

					if (listTicket.get(i).getTicketId() == listTicketDetailByDate.get(j).getTicket().getTicketId()) {
						System.out.println(listTicket.get(i).getTicketId() + "       JHDSJKDHSJDHS     "
								+ listTicketDetailByDate.get(j).getTicket().getTicketId());
						listTicket.get(i).setTicketStatus(false);
						ticketRepository.save(listTicket.get(i));
						System.out.println("false");

					}

				}
			}
		}
		return listTicket;
	}

	@Override
	public int getTicketQuantity() {
		return ticketRepository.getTicketQuantity();
	}

}

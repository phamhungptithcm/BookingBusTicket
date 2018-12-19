package com.bookingbusticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookingbusticket.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	public List<Ticket> findByBusBusId(Integer busId);

	@Query("Select t From  Ticket  t Where t.ticketStatus=true")
	public Iterable<Ticket> findAvailableSeat();

	@Query("select count(t.ticketId)  from Ticket t")
	public int getTicketQuantity();
}

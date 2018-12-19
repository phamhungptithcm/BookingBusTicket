package com.bookingbusticket.helper;

import com.bookingbusticket.entity.Ticket;

public class TicketAndStatus {
	private Ticket ticket;
	private Boolean stt;
	
	
	public TicketAndStatus() {
		super();
	}
	public TicketAndStatus(Ticket ticket, Boolean stt) {
		super();
		this.ticket = ticket;
		this.stt = stt;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTickets(Ticket ticket) {
		this.ticket = ticket;
	}
	public Boolean getStt() {
		return stt;
	}
	public void setStt(Boolean stt) {
		this.stt = stt;
	}
	
	
}

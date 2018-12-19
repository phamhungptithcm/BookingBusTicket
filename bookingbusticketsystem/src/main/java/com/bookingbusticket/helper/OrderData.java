package com.bookingbusticket.helper;

import java.util.List;

import com.bookingbusticket.entity.Order;
import com.bookingbusticket.entity.TicketDetail;

public class OrderData {
	private Order order;
	private List<TicketDetail> ticketDetails;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<TicketDetail> getTicketDetails() {
		return ticketDetails;
	}
	public void setTicketDetails(List<TicketDetail> ticketDetails) {
		this.ticketDetails = ticketDetails;
	}
}

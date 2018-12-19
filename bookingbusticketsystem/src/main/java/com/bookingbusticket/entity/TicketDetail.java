package com.bookingbusticket.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ticketdetails")
public class TicketDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_Detail_Id")
	Integer ticketDetailId;
	@JsonFormat(pattern = "dd/MM/yyyy", timezone="Asia/Ho_Chi_Minh") 
	@Temporal(TemporalType.DATE)
	@Column(name = "departure_Date")
	Date departureDate;
	@Column(name = "last_Name")
	String lastName;
	@Column(name = "first_Name")
	String firstName;
	@Column(name = "gender")
	Boolean gender;
	@Column(name = "age")
	Integer age;
	@Column(name = "num_Seat")
	Integer numSeat;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "last_Update")
	Date lastUpdate;
	@Column(name ="status")
	Boolean status;

	@ManyToOne(optional = false)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "ticketId")
	Ticket ticket;
	
	@ManyToOne(optional = false)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "orderId")
	Order order;

	public Integer getTicketDetailId() {
		return ticketDetailId;
	}

	public void setTicketDetailId(Integer ticketDetailId) {
		this.ticketDetailId = ticketDetailId;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getNumSeat() {
		return numSeat;
	}

	public void setNumSeat(Integer numSeat) {
		this.numSeat = numSeat;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}

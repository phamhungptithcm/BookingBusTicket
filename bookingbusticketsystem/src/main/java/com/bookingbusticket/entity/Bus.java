package com.bookingbusticket.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="bus")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="bus_Id")
	Integer busId;
	@Column(name="bus_Name")
	String busName;
	@Column(name="num_Seat")
	Integer numSeat;
	@Column(name="bus_License_Plate")
	String busLicensePlate;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="last_Update")
	Date lastUpdate;
	
	
	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public Integer getNumSeat() {
		return numSeat;
	}

	public void setNumSeat(Integer numSeat) {
		this.numSeat = numSeat;
	}

	public String getBusLicensePlate() {
		return busLicensePlate;
	}

	public void setBusLicensePlate(String busLicensePlate) {
		this.busLicensePlate = busLicensePlate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}

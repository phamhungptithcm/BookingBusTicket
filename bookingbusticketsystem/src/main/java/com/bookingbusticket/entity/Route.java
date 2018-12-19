package com.bookingbusticket.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="routes")
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="route_Id")
	Integer routeId;
	@Column(name="route_Status")
	Boolean routeStatus;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="last_Update")
	Date lastUpdate;
	
	@ManyToOne(optional=false)
//	@Column(name="route_From")
	@JoinColumn(name="routeFrom")
	Province provinceFrom;
	

	@ManyToOne(optional=false)
//	@Column(name="route_To")
	@JoinColumn(name="routeTo")
	Province provinceTo;
	
	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Boolean getRouteStatus() {
		return routeStatus;
	}

	public void setRouteStatus(Boolean routeStatus) {
		this.routeStatus = routeStatus;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Province getProvinceFrom() {
		return provinceFrom;
	}

	public void setProvinceFrom(Province provinceFrom) {
		this.provinceFrom = provinceFrom;
	}

	public Province getProvinceTo() {
		return provinceTo;
	}

	public void setProvinceTo(Province provinceTo) {
		this.provinceTo = provinceTo;
	}
}
